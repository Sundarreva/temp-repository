package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tweetapp.DBConnection;
import com.tweetapp.exception.CustomException;
import com.tweetapp.model.Register;

public class UserRegistrationDao {

	public boolean addUser(Register user) throws CustomException {

		boolean state = false;
		try {
			String query = "SELECT * from user_details where us_email_id = ?";
			Connection dbConnection = DBConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, user.getEmailId());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				System.out.println("User Exist");
			} else {
				query = "INSERT into user_details VALUES(?, ?, ?, ?, ?, ?)";
				preparedStatement = dbConnection.prepareStatement(query);
				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
				preparedStatement.setString(3, user.getGender());
				preparedStatement.setString(4, user.getEmailId());
				preparedStatement.setString(5, user.getDob());
				preparedStatement.setString(6, user.getPassword());
				int count = preparedStatement.executeUpdate();
				state = count >= 1;
				DBConnection.disconnect(dbConnection);
			}
		} catch (Exception e) {
			throw new CustomException("Error");
		}
		return state;
	}
}
