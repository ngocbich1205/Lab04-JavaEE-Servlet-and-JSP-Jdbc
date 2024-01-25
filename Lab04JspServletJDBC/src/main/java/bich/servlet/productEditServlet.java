package bich.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bich.utils.ProductUtils;
import bich.beans.Product;
import bich.conn.ConnectionUtils;


@WebServlet("/productEdit")
public class productEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public productEditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
		//code đọc dữ liệu sửa ở đây
		//Lấy dữ liệu mã sản phẩm từ request
		String code = (String) request.getParameter("code");
		if(code == null || code == "") {
			errorString="Bạn chưa chọn sản phẩm cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		Product product = null;
		errorString = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			product = ProductUtils.findProduct(conn, code);
			if(product==null) {
				errorString = "Không tìm thấy sản phẩm có mã" + code;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		//Khi có lỗi
		if(errorString != null || product == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//lay du lieu tren form
		String code = (String) request.getParameter("code");
		String name = (String) request.getParameter("name");
		String priceStr = (String) request.getParameter("price");
		float price = 0;
		try {
			price = Float.parseFloat(priceStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		Product product = new Product (code, name, price);
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			ProductUtils.updateProduct(conn, product);
			response.sendRedirect(request.getContextPath() + "/productList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
