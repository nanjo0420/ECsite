package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.InquiryCompleteDAO;
import com.internousdev.sampleweb2.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoInquiryAdminAction extends ActionSupport implements SessionAware{

	private List<InquiryDTO> inquiryDtoList = new ArrayList<InquiryDTO>();
	public Map<String, Object> session;

	public String exetcute(){

		InquiryCompleteDAO inquiryDao = new InquiryCompleteDAO();
		inquiryDtoList = inquiryDao.select();
		session.put("inquiryDtoList", inquiryDtoList);

		return SUCCESS;
	}

	public List<InquiryDTO> getInquiryDtoList(){
		return inquiryDtoList;
	}

	public void setInquiryDtoList(List<InquiryDTO> inquiryDtoList){
		this.inquiryDtoList = inquiryDtoList;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}