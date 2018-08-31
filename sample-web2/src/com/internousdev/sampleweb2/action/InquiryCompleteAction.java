package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.InquiryCompleteDAO;
import com.internousdev.sampleweb2.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryCompleteAction extends ActionSupport implements SessionAware{

	private String name;
	private String email;
	private String body;

	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		InquiryCompleteDAO dao = new InquiryCompleteDAO();
		int count = dao.insert(name, email, body);
		if(count > 0){
			inquiryDTOList = dao.select();
			session.put("inquiryDTOList", inquiryDTOList);
		result=SUCCESS;
		}
		return result;
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

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
