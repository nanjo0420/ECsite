package com.internousdev.sampleweb2.dto;

import java.util.Date;

public class ReviewDTO {

	private int id;
	private int productId;
	private String star;
	private String title;
	private String name;
	private String body;
	private Date registDate;
	private Date updateDate;


	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getProdctId(){
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

	public Date getRegistDate(){
		return registDate;
	}

	public void setRegistDate(Date registDate){
		this.registDate = registDate;
	}

	public Date getUpDate(){
		return updateDate;
	}

	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}

	/*public String getProductName(){
		return productName;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductNameKana(){
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana){
		this.productNameKana = productNameKana;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public String getImageFileName(){
		return imageFileName;
	}

	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}

	public String getImageFileNamePath(){
		return imageFileNamePath;
	}

	public void setImageFileNamePath(String imageFileNamePath){
		this.imageFileNamePath = imageFileNamePath;
	}

	public String getReleaseCompany(){
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany = releaseCompany;
	}

	public Date getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate){
		this.registDate = releaseDate;
	}*/
}

