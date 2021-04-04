package com.nts.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.constants.ConstData;
import com.nts.constants.TypeList;
import com.nts.jdbc.dao.TodoDao;
import com.nts.jdbc.dto.TodoDto;

/**
 * 할 일 상태 변경
 * 
 * @author : donggun.chung
 * @version : 1.0 최신
 * @since : 2019. 7. 9.
 */
@WebServlet("/TodoUpdate")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request, response
	 * @return
	 * @exception ServletException, IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(ConstData.CONTENT_PLAIN);

		String strId = request.getParameter("id");
		String type = request.getParameter("type");
		boolean isTodo = TypeList.TODO.isEquals(type);
		long id = 0L;
		
		TodoDao todoDao = new TodoDao();
		
		try {
			id = Long.parseLong(strId);
		} catch (NumberFormatException exception) {
			response.getWriter().print(ConstData.FAIL);
			response.sendRedirect("/main.jsp");
		}

		TodoDto todoDto = new TodoDto();
		todoDto.setId(id);
		todoDto.setType(isTodo ? TypeList.DOING.getType() : TypeList.DONE.getType());

		int updateCount = todoDao.updateTodo(todoDto);

		if (updateCount < 1) {
			response.getWriter().print(ConstData.FAIL);
			response.sendRedirect("/main.jsp");
		}
		
		response.getWriter().print(ConstData.SUCCESS);
	}

}