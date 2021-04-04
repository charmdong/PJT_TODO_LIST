package com.nts.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.constants.ConstData;
import com.nts.jdbc.dao.TodoDao;
import com.nts.jdbc.dto.TodoDto;

/**
 * 할 일 등록
 * 
 * @author : donggun.chung
 * @version : 1.0 최신
 * @since : 2019. 7. 8.
 */
@WebServlet("/TodoAdd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request, response
	 * @return
	 * @exception ServletException, IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(ConstData.CHARSET_UTF8);
		response.setContentType(ConstData.CONTENT_PLAIN);

		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String strSequence = request.getParameter("sequence");
		int sequence = 0;
		TodoDao todoDao = new TodoDao();

		try {
			sequence = Integer.parseInt(strSequence);
		} catch (NumberFormatException exception) {
			response.sendError(ConstData.HTTP_CLIENT_ERROR, "숫자로 변환할 수 없는 데이터가 입력되었습니다.");
		}

		TodoDto todoDto = new TodoDto();
		todoDto.setName(name);
		todoDto.setTitle(title);
		todoDto.setSequence(sequence);

		int insertCount = todoDao.addTodo(todoDto);

		if (insertCount < 1) {
			response.sendError(ConstData.HTTP_SERVER_ERROR, "새로운 할 일 등록에 실패했습니다.");
		}

		response.sendRedirect("displayTable");
	}

}