package bich.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bich.dao.ProductUtils;
import bich.entity.Department;
import bich.utils.ConnectionUtils;



public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	//     response.getWriter().append("Served at: ").append(request.getContextPath());
	    Connection conn=null;
	    String errorString = null;
	    List<Department> list = null;
	    try {
	        conn = ConnectionUtils.getMSSQLConnection();
	        
	        try {
	            list = ProductUtils.queryProduct(conn);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        // Store info in request attribute, before forward to views
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("department", list);
	
	        // Forward to /WEB-INF/views/productListView.jsp
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/departmenttList.jsp");
	        dispatcher.forward(request, response);
	    } catch (SQLException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	        errorString = e1.getMessage();
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/departmenttList.jsp");
	        request.setAttribute("errorString", errorString);
	        dispatcher.forward(request, response);
	    } catch (ClassNotFoundException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    }
	
	}
}