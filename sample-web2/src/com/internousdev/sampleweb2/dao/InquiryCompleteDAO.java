package com.internousdev.sampleweb2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sampleweb2.dto.InquiryDTO;
import com.internousdev.sampleweb2.util.DBConnector;

public class InquiryCompleteDAO {

	public List<InquiryDTO> select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();
		String sql="select * from inquiry";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				InquiryDTO dto = new InquiryDTO();
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setBody(rs.getString("body"));
				inquiryDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return inquiryDTOList;
	}

	public int insert(String name, String email, String body){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "insert into inquiry(name, email, body, regist_date, update_date) values(?, ?, ?, now(), '0000-01-01')";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  name);
			ps.setString(2, email);
			ps.setString(3, body);
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

	public int delete(int id){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "delete from inquiry where id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
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
