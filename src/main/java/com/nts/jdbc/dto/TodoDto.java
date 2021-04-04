package com.nts.jdbc.dto;

/**
 * 할 일 관련 정보 저장
 * 
 * @author : donggun.chung
 * @version : 1.0 최신
 * @since : 2019. 7. 8.
 */
public class TodoDto {
	private Long id;
	private String name;
	private String regDate;
	private Integer sequence;
	private String title;
	private String type;

	public TodoDto(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegdate() {
		return regDate;
	}

	public void setRegdate(String regDate) {
		this.regDate = regDate;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", name=" + name + ", regDate=" + regDate + ", sequence=" + sequence + ", title="
				+ title + ", type=" + type + "]";
	}

}
