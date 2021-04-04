package com.nts.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nts.constants.ConstData;
import com.nts.jdbc.dto.TodoDto;

/**
 * 할 일 관리
 * 
 * @author : donggun.chung
 * @version : 1.0 최신
 * @since : 2019. 7. 8.
 */
public class TodoDao {
	/**
	 * @param 
	 * @return 
	 * @exception
	 */
	public TodoDao() {
		try {
			Class.forName(ConstData.DRIVER_PATH);
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * @param todo 
	 * @return 등록 횟수 
	 * @exception
	 */
	public int addTodo(TodoDto todo) {
		int insertCount = 0;

		try (Connection connection = DriverManager.getConnection(ConstData.DB_URL, ConstData.DB_USER,
				ConstData.DB_PASSWD);
				PreparedStatement preparedStatement = connection.prepareStatement(ConstData.INSERT)) {
			preparedStatement.setString(1, todo.getName());
			preparedStatement.setInt(2, todo.getSequence());
			preparedStatement.setString(3, todo.getTitle());

			insertCount = preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return insertCount;
	}

	/**
	 * @param 
	 * @return todoList 
	 * @exception
	 */
	public List<TodoDto> getTodos() {
		List<TodoDto> todoList = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(ConstData.DB_URL, ConstData.DB_USER,
				ConstData.DB_PASSWD);
				PreparedStatement preparedStatement = connection.prepareStatement(ConstData.SELECT);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				int sequence = resultSet.getInt("sequence");
				String title = resultSet.getString("title");
				String type = resultSet.getString("type");
				String regDate = resultSet.getString("regdate");
				
				TodoDto todoDto = new TodoDto();
				todoDto.setId(id);
				todoDto.setName(name);
				todoDto.setSequence(sequence);
				todoDto.setTitle(title);
				todoDto.setType(type);
				todoDto.setRegdate(regDate);

				todoList.add(todoDto);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return todoList;
	}

	/**
	 * @param todo 
	 * @return 업데이트 횟수
	 * @exception
	 */
	public int updateTodo(TodoDto todo) {
		int updateCount = 0;

		try (Connection connection = DriverManager.getConnection(ConstData.DB_URL, ConstData.DB_USER,
				ConstData.DB_PASSWD);
				PreparedStatement preparedStatement = connection.prepareStatement(ConstData.UPDATE)) {
			preparedStatement.setString(1, todo.getType());
			preparedStatement.setLong(2, todo.getId());

			updateCount = preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return updateCount;
	}
}
