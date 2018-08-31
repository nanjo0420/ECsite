package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware{

	private String  item_transaction_id;
	private String 	total_price;
	private String  total_count;
	private String  user_master_id;
	private String  pay;
	public Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException{
		buyItemCompleteDAO.buyItemInfo(session.get("item_transaction_id").toString(),
					session.get("total_price").toString(),
					session.get("total_count").toString(),
					session.get("user_master_id").toString(),
					session.get("pay").toString());

		String result = SUCCESS;

		return result;
	}

	public String getItem_transaction_id(){
		return item_transaction_id;
	}

	public void setItem_transaction_id(String item_transaction_id){
		this.item_transaction_id = item_transaction_id;
	}

	public String getTotal_price(){
		return total_price;
	}

	public void setTotal_price(String total_price){
		this.total_price = total_price;
	}

	public String getTotal_count(){
		return total_count;
	}

	public void setTotal_count(String total_count){
		this.total_count = total_count;
	}

	public String getUser_master_id(){
		return user_master_id;
	}

	public void setUser_master_id(String user_master_id){
		this.user_master_id = user_master_id;
	}

	public String getPay(){
		return pay;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
