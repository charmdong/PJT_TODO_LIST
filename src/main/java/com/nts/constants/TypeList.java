package com.nts.constants;

/**
 * type 관리 
 * 
 * @author : donggun.chung
 * @version : 1.0 최신
 * @since : 2019. 7. 16.
 */
public enum TypeList {
	TODO("TODO"), DOING("DOING"), DONE("DONE");

	private String type;

	TypeList(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	public boolean isEquals(String str) {
		return this.type.equals(str);
	}
}
