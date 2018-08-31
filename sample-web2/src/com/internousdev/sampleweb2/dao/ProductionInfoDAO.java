package com.internousdev.sampleweb2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sampleweb2.dto.ProductionInfoDTO;
import com.internousdev.sampleweb2.util.DBConnector;

public class ProductionInfoDAO {

	public List<ProductionInfoDTO> getProductInfoList(){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductionInfoDTO> productInfoDtoList = new ArrayList<ProductionInfoDTO>();
		String sql = "select * from product_info2";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductionInfoDTO productionInfoDto = new ProductionInfoDTO();
				productionInfoDto.setId(resultSet.getInt("id"));
				productionInfoDto.setProductId(resultSet.getInt("product_id"));
				productionInfoDto.setProductName(resultSet.getString("product_name"));
				productionInfoDto.setProductNameKana(resultSet.getString("product_name_kana"));
				productionInfoDto.setProductDescription(resultSet.getString("product_description"));
				productionInfoDto.setCategoryId(resultSet.getInt("category_id"));
				productionInfoDto.setPrice(resultSet.getInt("price"));
				productionInfoDto.setImageFilePath(resultSet.getString("image_file_path"));
				productionInfoDto.setImageFileName(resultSet.getString("image_file_name"));
				productionInfoDto.setReleaseDate(resultSet.getDate("release_date"));
				productionInfoDto.setReleaseCompany(resultSet.getString("release_company"));
				productionInfoDto.setStatus(resultSet.getInt("status"));
				productionInfoDto.setRegistDate(resultSet.getDate("regist_date"));
				productionInfoDto.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productionInfoDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	public ProductionInfoDTO getProductInfo(int productId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ProductionInfoDTO productInfoDTO = new ProductionInfoDTO();
		String sql = "select * from product_info2 where product_id=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDTO;
	}

	//追加
	public int insertProduct(int productId, String productName, String productNameKana, String productDescription, int categoryId, String price,
			 			String imageFilePath, String imageFileName, String releaseDate, String releaseCompany,
			 			String registDate, String updateDate){
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		int count = 0;
		String sql = "insert into product_info2(product_id, product_name, product_name_kana, product_description, category_id, price,"
				+ " image_file_path, image_file_name, release_date, release_company, regist_date, update_date)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setString(2, productName);
			ps.setString(3, productNameKana);
			ps.setString(4, productDescription);
			ps.setInt(5, categoryId);
			ps.setString(6, price);
			ps.setString(7, imageFilePath);
			ps.setString(8, imageFileName);
			ps.setString(9, releaseDate);
			ps.setString(10, releaseCompany);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	public int delete(int productId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "delete from product_info2 where product_id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			count = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}


	//ここまで

	public List<ProductionInfoDTO> getProductInfoListByCategoryId(int categoryId, int productId, int limitOffset,
			 int limitRowCount){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductionInfoDTO> productInfoDtoList = new ArrayList<ProductionInfoDTO>();
		String sql = "select * from product_info2 where category_id=? and product_id not in(?) order by rand() limit ?,?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, limitOffset);
			preparedStatement.setInt(4, limitRowCount);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductionInfoDTO productInfoDTO = new ProductionInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	public List<ProductionInfoDTO> getProductInfoListAll(String[] keywordsList){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductionInfoDTO> productInfoDtoList = new ArrayList<ProductionInfoDTO>();
		String sql = "select * from product_info2 where";
		boolean initializeFlag = true;
		for(String keyword : keywordsList){
			if(initializeFlag){
				sql += " (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag = false;
			}else{
				sql += " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductionInfoDTO productInfoDTO = new ProductionInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	public List<ProductionInfoDTO> getProductInfoListbyKeywords(String[] keywordsList, String categoryId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductionInfoDTO> productInfoDtoList = new ArrayList<ProductionInfoDTO>();
		String sql = "select * from product_info2 where";
		boolean initializeFlag = true;
		for (String keyword : keywordsList){
			if(initializeFlag){
				sql += " category_id=" + categoryId + " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag = false;
			}else{
				sql += " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductionInfoDTO productInfoDTO = new ProductionInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDtoList;
	}
}
