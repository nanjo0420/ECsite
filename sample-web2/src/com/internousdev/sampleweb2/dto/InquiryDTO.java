package com.internousdev.sampleweb2.dto;

import java.util.Date;

public class InquiryDTO {

	private int id;
	private String name;
	private String email;
	private String body;
	private Date registDate;
	private Date updateDate;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getBody(){
		return body;
	}

	public void setBody(String body){
		this.body = body;
	}

	public Date getRegistDate(){
		return registDate;
	}

	public void setRegistDate(Date registDate){
		this.registDate = registDate;
	}

	public Date getUpDate(){
		return updateDate;
	}

	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
}
