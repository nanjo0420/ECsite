package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.ProductionInfoDAO;
import com.internousdev.sampleweb2.dao.ReviewDAO;
import com.internousdev.sampleweb2.dto.MCategoryDTO;
import com.internousdev.sampleweb2.dto.ProductionInfoDTO;
import com.internousdev.sampleweb2.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware{
	private int productId;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductionInfoDTO> productInfoDtoList = new ArrayList<ProductionInfoDTO>();
	private String categoryId;
	private Map<String, Object> session;

	List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();

	public String execute(){
		String result = ERROR;
		ProductionInfoDAO productInfoDAO = new ProductionInfoDAO();
		ProductionInfoDTO productInfoDTO = new ProductionInfoDTO();
		productInfoDTO = productInfoDAO.getProductInfo(productId);
		session.put("id", productInfoDTO.getId());
		session.put("productId", productInfoDTO.getProductId());
		session.put("productName", productInfoDTO.getProductName());
		session.put("productNameKana", productInfoDTO.getProductNameKana());
		session.put("imageFilePath", productInfoDTO.getImageFilePath());
		session.put("imageFileName", productInfoDTO.getImageFileName());
		session.put("price", productInfoDTO.getPrice());

		session.put("releaseCompany", productInfoDTO.getReleaseCompany());
		session.put("releaseDate", productInfoDTO.getReleaseDate());
		session.put("productDescription", productInfoDTO.getProductDescription());
		List<Integer> productCountList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		session.put("productCountList", productCountList);
		productInfoDtoList = productInfoDAO.getProductInfoListByCategoryId(productInfoDTO.getCategoryId(), productInfoDTO.getProductId(), 0, 3);
		Iterator<ProductionInfoDTO> iterator = productInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			productCountList = null;
		}
		if(!productInfoDtoList.isEmpty() || productCountList==null){
			session.put("productInfoDtoList", productInfoDtoList);
			result = SUCCESS;
		}

		//レビューを表示させます
		ReviewDAO dao = new ReviewDAO();
		reviewDTOList = dao.select(productId);
		session.put("reviewDTOList", reviewDTOList);
		result = SUCCESS;
		return result;
	}

	public List<MCategoryDTO> getmCategoryDtoList(){
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList){
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public List<ProductionInfoDTO> getProductInfoDtoList(){
		return productInfoDtoList;
	}

	public void setProductInfoDtoList(List<ProductionInfoDTO> productInfoDtoList){
		this.productInfoDtoList = productInfoDtoList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
