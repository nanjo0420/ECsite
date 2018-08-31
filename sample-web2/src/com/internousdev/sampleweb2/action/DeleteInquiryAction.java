package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.InquiryCompleteDAO;
import com.internousdev.sampleweb2.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteInquiryAction extends ActionSupport implements SessionAware{

	private int  id;
	List<InquiryDTO> inquiryDtoList = new ArrayList<InquiryDTO>();
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		InquiryCompleteDAO dao = new InquiryCompleteDAO();
		int count = dao.delete(id);
		if(count > 0){
			inquiryDtoList = dao.select();
			session.put("inquiryDtoList", inquiryDtoList);
			result = SUCCESS;
		}
		return result;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}
	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
