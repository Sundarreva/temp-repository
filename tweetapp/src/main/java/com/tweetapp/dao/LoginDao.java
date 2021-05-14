package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tweetapp.DBConnection;
import com.tweetapp.exception.CustomException;

public class LoginDao {

	public boolean userLogin(String email, String password) throws CustomException {

		boolean state = false;
		try {
			String query = "SELECT * from user_details WHERE us_email_id=? and us_password=?";
			Connection dbConnection = DBConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				state = true;
			} else {
				state = false;
			}
			DBConnection.disconnect(dbConnection);
		} catch (Exception e) {
			throw new CustomException("Error");
		}
		return state;
	}
}
