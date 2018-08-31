package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.ReviewDAO;
import com.internousdev.sampleweb2.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoReviewAdminAction extends ActionSupport implements SessionAware{

	private List<ReviewDTO> reviewDtoList = new ArrayList<ReviewDTO>();
	public Map<String, Object> session;

	public String exetcute(){

		String result = ERROR;
		ReviewDAO dao = new ReviewDAO();
		reviewDtoList = dao.getReviewDtoList();
		session.put("reviewDtoList", reviewDtoList);
		result = SUCCESS;
		return result;
	}


	public List<ReviewDTO> getReviewDtoList(){
		return reviewDtoList;
	}

	public void setReviewDtoList(List<ReviewDTO> reviewDtoList){
		this.reviewDtoList = reviewDtoList;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}