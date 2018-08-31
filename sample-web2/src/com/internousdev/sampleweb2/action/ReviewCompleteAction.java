package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.ReviewDAO;
import com.internousdev.sampleweb2.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewCompleteAction extends ActionSupport implements SessionAware{

	private int productId;
	private String star;
	private String title;
	private String name;
	private String body;

	List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		ReviewDAO dao = new ReviewDAO();
		int count =dao.insert(productId, star,  title, name, body);
		if(count > 0){
		result = SUCCESS;
		}
		return result;
	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId = productId;
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

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
