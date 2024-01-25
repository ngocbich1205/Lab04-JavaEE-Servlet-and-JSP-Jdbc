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


@WebServlet("/ProductCreateServlet")
public class ProductCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductCreateServlet() {
        super();
    }
    //Hiển thị trang thêm mới sản phẩm
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
		dispatcher.forward(request, response);
	}
	//khi người dùng nhấn nút ghi (submit)
	//phương thức doPost sẽ được gọi
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//Lấy dữ liệu trên form
		String code = (String) request.getParameter("code");
		String name = (String) request.getParameter("name");
		String priceStr = (String) request.getParameter("price");
		float price = 0;
		try {
			price = Float.parseFloat(priceStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		Product product = new Product(code, name, price);
		
		//Kiểm tra code ít nhất 1 ký tự [a-zA-Z_0-9]
		String regex = "\\w+";
		if (code == null || !code.matches(regex)) {
			errorString = "Product Code invalid!";
		}
		
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			ProductUtils.insertProduct(conn, product);
			response.sendRedirect(request.getContextPath() + "/productList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
