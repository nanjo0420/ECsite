package com.internousdev.ecsite.dto;

public class BuyItemSelectDTO {

	private String itemName;
	private String itemPrice;
	private int id;

	public String getItemName(){
		return itemName;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}
}
