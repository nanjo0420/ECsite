package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;


public class AddProductConfirmAction extends ActionSupport implements SessionAware{

	private int id;
	private int productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private String price;
	private String imageFilePath;
	private String imageFileName;
	private String releaseDate;
	private String releaseCompany;
	private int status;
	private Date registDate;
	private Date updateDate;

	private Map<String, Object> session;

	private List<String> productNameErrorMessageList = new ArrayList<String>();
	private List<String> productNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> productDescriptionErrorMessageList = new ArrayList<String>();
	private List<String> priceErrorMessageList = new ArrayList<String>();
	private List<String> releaseDateErrorMessageList = new ArrayList<String>();
	private List<String> releaseCompanyErrorMessageList = new ArrayList<String>();

	public String execute(){
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();
		productNameErrorMessageList = inputChecker.doCheck("商品名", productName, 1, 30, true, true, true, true, true, true, true);
		productNameKanaErrorMessageList = inputChecker.doCheck("商品名かな", productNameKana, 1, 40, false, false, true, false, false, false, false);
		productDescriptionErrorMessageList = inputChecker.doCheck("詳細", productDescription, 10, 200, true, true, true, true, true, true, true);
		priceErrorMessageList = inputChecker.doCheck("価格", price, 1, 10, false, false, false, true, false, false, false);
		releaseDateErrorMessageList = inputChecker.doCheck("発売年月日", releaseDate, 4, 20, true, true, false, true, false, false, false);
		releaseCompanyErrorMessageList = inputChecker.doCheck("発売会社名", releaseCompany, 2, 20, true, true, true, true, true, true, false);
		if(productNameErrorMessageList.size()==0
		&& productNameKanaErrorMessageList.size()==0
		&& productDescriptionErrorMessageList.size()==0
		&& priceErrorMessageList.size()==0
		&& releaseDateErrorMessageList.size()==0
		&& releaseCompanyErrorMessageList.size()==0){
			result = SUCCESS;
		}else{
			session.put("productNameErrorMessageList", productNameErrorMessageList);
			session.put("productNameKanaErrorMessageList", productNameKanaErrorMessageList);
			session.put("productDescriptionErrorMessageList", productDescriptionErrorMessageList);
			session.put("priceErrorMessageList", priceErrorMessageList);
			session.put("releaseDateErrorMessageList", releaseDateErrorMessageList);
			session.put("releaseCompanyErrorMessageList", releaseCompanyErrorMessageList);
			result = ERROR;
		}
		return result;
	}

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	public String getProductName(){
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
	public String getPrice(){
		return price;
	}
	public void setPrice(String price){
		this.price = price;
	}
	public String getImageFilePath(){
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath){
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName(){
		return imageFileName;
	}
	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}
	public String getReleaseDate(){
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}
	public String getReleaseCompany(){
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany = releaseCompany;
	}
	public int getStatus(){
		return status;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public Date getRegistDate(){
		return registDate;
	}
	public void setRegistDate(Date registDate){
		this.registDate = registDate;
	}
	public Date getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public List<String> getProductNameErrorMessageList(){
		return productNameErrorMessageList;
	}

	public void setProductNameErrorMessageList(List<String> productNameErrorMessageList){
		this.productNameErrorMessageList = productNameErrorMessageList;
	}

	public List<String> getProductNameKanaErrorMessageList(){
		return productNameKanaErrorMessageList;
	}

	public void setProductNamekanaErrorMessageList(List<String> productNameKanaErrorMessageList){
		this.productNameKanaErrorMessageList = productNameKanaErrorMessageList;
	}

	public List<String> getProductDescriptionErrorMessageList(){
		return productDescriptionErrorMessageList;
	}

	public void setProductDescriptionErrorMessageList(List<String> productDescriptionErrorMessageList){
		this.productDescriptionErrorMessageList = productDescriptionErrorMessageList;
	}

	public List<String> getPriceErrorMessageList(){
		return priceErrorMessageList;
	}

	public void setPriceErrorMessageList(List<String> priceErrorMessageList){
		this.priceErrorMessageList = priceErrorMessageList;
	}

	public List<String> getReleaseDateErrorMessageList(){
		return releaseDateErrorMessageList;
	}

	public void setReleaseDateErrorMessageList(List<String> releaseDateErrorMessageList){
		this.releaseDateErrorMessageList = releaseDateErrorMessageList;
	}

	public List<String> getReleaseCompanyErrorMessageList(){
		return releaseCompanyErrorMessageList;
	}

	public void setReleaseCompanyErrorMessageList(List<String> releaseCompanyErrorMessageList){
		this.releaseCompanyErrorMessageList = releaseCompanyErrorMessageList;
	}
}
