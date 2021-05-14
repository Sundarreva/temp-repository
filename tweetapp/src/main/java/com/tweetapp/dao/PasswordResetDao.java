package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tweetapp.DBConnection;
import com.tweetapp.exception.CustomException;

public class PasswordResetDao {

	public boolean passwordVerify(String username, String password) throws CustomException {
		boolean result = false;
		try {
			String query = "SELECT * from user_details WHERE us_email_id=? AND us_password=?";
			Connection dbConnection = DBConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				result = true;
			}
			DBConnection.disconnect(dbConnection);
		} catch (Exception e) {
			throw new CustomException("Error");
		}
		return result;

	}

	public boolean resetPassword(String username, String newPassword) throws CustomException {
		boolean state = false;
		try {
			String query = "UPDATE user_details SET us_password =? WHERE us_email_id =?";
			Connection dbConnection = DBConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, username);
			int count = preparedStatement.executeUpdate();
			state = count >= 1;
			DBConnection.disconnect(dbConnection);
		} catch (Exception e) {
			throw new CustomException("Error");
		}
		return state;
	}
}
