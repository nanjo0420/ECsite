package com.internousdev.sampleweb2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class InquiryAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	public String execute(){
		session.put("nameErrorMessageList", "");
		session.put("emailErrorMessageList", "");
		session.put("bodyErrorMessageList", "");
		return SUCCESS;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
