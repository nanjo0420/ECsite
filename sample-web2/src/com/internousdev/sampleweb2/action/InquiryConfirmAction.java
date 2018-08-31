package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryConfirmAction extends ActionSupport implements SessionAware{

	private String name;
	private String email;
	private String body;
	private Map<String, Object> session;

	private List<String> nameErrorMessageList = new ArrayList<String>();
	private List<String> emailErrorMessageList = new ArrayList<String>();
	private List<String> bodyErrorMessageList = new ArrayList<String>();

	public String execute(){
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();
		nameErrorMessageList = inputChecker.doCheck("名前", name, 2, 16, true, true, true, true, false, true, false);
		emailErrorMessageList = inputChecker.doCheck("メールアドレス", email, 14, 32, true, false, false, true, true, false, false);
		bodyErrorMessageList = inputChecker.doCheck("入力内容", body, 10, 200, true, true, true, true, true, true, true);
		if(nameErrorMessageList.size()==0
		&& bodyErrorMessageList.size()==0){
			result = SUCCESS;
		}else{
			session.put("nameErrorMessageList", nameErrorMessageList);
			session.put("emailErrorMessageList", emailErrorMessageList);
			session.put("bodyErrorMessageList", bodyErrorMessageList);
			result = ERROR;
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

	public List<String> getNameErrorMessageList(){
		return nameErrorMessageList;
	}

	public void setNameErrorMessageList(List<String> nameErrorMessageList){
		this.nameErrorMessageList = nameErrorMessageList;
	}

	public List<String> getEmailErrorMessageList(){
		return emailErrorMessageList;
	}

	public void setEmailErrorMessageList(List<String> emailErrorMessageList){
		this.emailErrorMessageList = emailErrorMessageList;
	}

	public List<String> getBodyErrorMessageList(){
		return bodyErrorMessageList;
	}

	public void setBodyErrorMessageList(List<String> bodyErrorMessageList){
		this.bodyErrorMessageList = bodyErrorMessageList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
