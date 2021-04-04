package com.nts.constants;

/**
 * 상수 관리
 * 
 * @author : donggun.chung
 * @version : 1.0 최신
 * @since : 2019. 7. 8.
 */
public final class ConstData {
	public static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "";
	public static final String DB_USER = "";
	public static final String DB_PASSWD = " ";

	public static final String SELECT = "SELECT id, name, DATE_FORMAT(regdate,'%Y.%m.%d') as regdate, sequence, title, type FROM todo;";
	public static final String INSERT = "INSERT INTO todo(name, sequence, title) VALUES(?, ?, ?);";
	public static final String UPDATE = "UPDATE todo SET type = ? WHERE id = ?;";

	public static final String CHARSET_UTF8 = "UTF-8";
	public static final String CONTENT_PLAIN = "text/plain;";

	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	
	public static final int HTTP_SUCCESS = 200;
	public static final int HTTP_CLIENT_ERROR = 400;
	public static final int HTTP_SERVER_ERROR = 500;

	private ConstData() {
		// 메소드 내부에서의 인스턴스 생성 방지
		throw new AssertionError();
	}
}
