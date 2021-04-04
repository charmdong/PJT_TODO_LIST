package com.nts.api;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.constants.TypeList;
import com.nts.jdbc.dao.TodoDao;
import com.nts.jdbc.dto.TodoDto;

/**
 * 할 일 포워딩 
 * 
 * @author : donggun.chung
 * @version : 1.0.0
 * @since : 2019. 7. 16.
 */
@WebServlet("/displayTable")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request, response
	 * @return
	 * @exception ServletException, IOException
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoDao todoDao = new TodoDao();
		List<TodoDto> totalList = todoDao.getTodos();
		List<TodoDto> todoList = totalList.stream().filter(n -> TypeList.TODO.isEquals(n.getType()))
				.collect(Collectors.toList());
		List<TodoDto> doingList = totalList.stream().filter(n -> TypeList.DOING.isEquals(n.getType()))
				.collect(Collectors.toList());
		List<TodoDto> doneList = totalList.stream().filter(n -> TypeList.DONE.isEquals(n.getType()))
				.collect(Collectors.toList());

		request.setAttribute("todoList", todoList);
		request.setAttribute("doingList", doingList);
		request.setAttribute("doneList", doneList);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
		requestDispatcher.forward(request, response);
	}

}