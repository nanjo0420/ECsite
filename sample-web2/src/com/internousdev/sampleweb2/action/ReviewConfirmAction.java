package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewConfirmAction extends ActionSupport implements SessionAware{

	private String star;
	private String title;
	private String name;
	private String body;
	private Map<String, Object> session;

	private List<String> starErrorMessageList = new ArrayList<String>();
	private List<String> titleErrorMessageList = new ArrayList<String>();
	private List<String> nameErrorMessageList = new ArrayList<String>();
	private List<String> bodyErrorMessageList = new ArrayList<String>();

	public String execute(){
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();
		//starErrorMessageList = inputChecker.doCheck("評価", star, 1, 5, true, true, true, true, true, true, true);
		titleErrorMessageList = inputChecker.doCheck("タイトル", title, 2, 16, true, true, true, true, true, true, true);
		nameErrorMessageList = inputChecker.doCheck("名前", name, 2, 16, true, true, true, true, true, true, true);
		bodyErrorMessageList = inputChecker.doCheck("入力内容", body, 10, 200, true, true, true, true, true, true, true);
		if(nameErrorMessageList.size()==0
		&& bodyErrorMessageList.size()==0){
			result = SUCCESS;
		}else{
			//session.put("starErrormessageList", starErrorMessageList);
			session.put("titleErrorMessageList", titleErrorMessageList);
			session.put("nameErrorMessageList", nameErrorMessageList);
			session.put("bodyErrorMessageList", bodyErrorMessageList);
			result = ERROR;
		}
		return result;
	}

	public String getStar(){
		return star;
	}

	public void setStar(String star){
		this.star = star;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getBody(){
		return body;
	}

	public void setBody(String body){
		this.body = body;
	}

	public List<String> getStarErrorMessageList(){
		return starErrorMessageList;
	}

	public void setStarErrorMessageList(List<String> starErrorMessageList){
		this.starErrorMessageList = starErrorMessageList;
	}

	public List<String> getTitleErrorMessageList(){
		return titleErrorMessageList;
	}

	public void setTitleErrorMessageList(List<String> titleErrorMessageList){
		this.titleErrorMessageList = titleErrorMessageList;
	}

	public List<String> getNameErrorMessageList(){
		return nameErrorMessageList;
	}

	public void setNameErrorMessageList(List<String> nameErrorMessageList){
		this.nameErrorMessageList = nameErrorMessageList;
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
