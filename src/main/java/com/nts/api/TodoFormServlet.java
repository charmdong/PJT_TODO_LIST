package com.nts.api;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * todoForm.jsp로 포워딩
 * 
 * @author : donggun.chung
 * @version : 1.0 최신
 * @since : 2019. 7. 8.
 */
@WebServlet("/TodoForm")
public class TodoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param requset, response
	 * @return
	 * @exception ServletException, IOException
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/todoForm.jsp");
		requestDispatcher.forward(request, response);
	}
}
