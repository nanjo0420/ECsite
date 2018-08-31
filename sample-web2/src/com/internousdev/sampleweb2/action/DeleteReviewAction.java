package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.ReviewDAO;
import com.internousdev.sampleweb2.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteReviewAction extends ActionSupport implements SessionAware{

	private int productId;
	List<ReviewDTO> reviewDtoList = new ArrayList<ReviewDTO>();
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		ReviewDAO dao = new ReviewDAO();
		int count = dao.delete(productId);
		if(count > 0){
			reviewDtoList = dao.select(productId);
			session.put("reviewDtoList", reviewDtoList);
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
	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
