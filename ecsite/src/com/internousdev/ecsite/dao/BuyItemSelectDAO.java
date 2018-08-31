package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemSelectDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemSelectDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private BuyItemSelectDTO buyItemSelectDTO = new BuyItemSelectDTO();


	public BuyItemSelectDTO getItemSelectInfo(){
		String sql = "SELECT id, item_name, item_price FROM item_info_transaction4";

		try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();

				while(resultSet.next()){
					buyItemSelectDTO.setId(resultSet.getInt("id"));
					buyItemSelectDTO.setItemName(resultSet.getString("item_name"));
					buyItemSelectDTO.setItemPrice(resultSet.getString("item_price"));
				}

		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemSelectDTO;
	}

	public BuyItemSelectDTO getBuyItemSelectDTO(){
		return buyItemSelectDTO;
	}
}
