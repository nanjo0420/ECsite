package com.internousdev.sampleweb2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sampleweb2.dto.ReviewDTO;
import com.internousdev.sampleweb2.util.DBConnector;

public class ReviewDAO {

	public List<ReviewDTO> getReviewDtoList(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ReviewDTO> reviewDtoList = new ArrayList<ReviewDTO>();
		String sql = "select * from review";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ReviewDTO reviewDto = new ReviewDTO();
				reviewDto.setId(rs.getInt("id"));
				reviewDto.setProductId(rs.getInt("product_id"));
				reviewDto.setStar(rs.getString("star"));
				reviewDto.setTitle(rs.getString("title"));
				reviewDto.setName(rs.getString("name"));
				reviewDto.setBody(rs.getString("body"));
				reviewDtoList.add(reviewDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reviewDtoList;
	}

	public List<ReviewDTO> select(int productId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();
		String sql="select"
				+ " rw.id as id,"/*ID*/
				+ " pi.product_id as product_id,"/*商品ID*/
				+ " pi.product_name as product_name,"/*商品名*/
				+ " pi.product_name_kana as product_name_kana,"/*商品名かな*/
				+ " pi.product_description as product_description,"/*商品詳細*/
				+ " pi.category_id as category_id,"/*カテゴリID*/
				+ " pi.price,"/*価格*/
				+ " pi.image_file_name as image_file_name,"/*画像ファイル名*/
				+ " pi.image_file_path as image_file_path,"/*画像ファイルパス*/
				+ " pi.release_company,"/*発売会社名*/
				+ " pi.release_date,"/*発売年月日*/
				+ " rw.star as star,"/*評価*/
				+ " rw.title as title,"/*タイトル*/
				+ " rw.name as name,"/*名前*/
				+ " rw.body as body,"/*レビュー内容*/
				+ " rw.regist_date as regist_date,"/*登録日*/
				+ " rw.update_date as update_date"/*更新日*/
				+ " FROM product_info2 as pi"
				+ " LEFT JOIN review as rw"
				+ " ON rw.product_id = pi.product_id"
				+ " WHERE pi.product_id = ?"
				+ " ORDER BY regist_date DESC";


		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ReviewDTO dto = new ReviewDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setStar(rs.getString("star"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setBody(rs.getString("body"));
				reviewDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reviewDTOList;
	}

	public int insert(int productId, String star, String title, String name, String body){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "insert into review(product_id, star, title, name, body, regist_date, update_date) values (?, ?, ?, ?, ?, now(), '0000-01-01')";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setString(2, star);
			ps.setString(3, title);
			ps.setString(4, name);
			ps.setString(5, body);
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
		String sql = "delete from review where product_id=?";

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

}
