package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.tweetapp.DBConnection;
import com.tweetapp.exception.CustomException;

public class ForgotPasswordDao {

    public boolean forgotPasswordDao(String email, String password) throws CustomException {
        boolean returnState = false;
        try {
            String query = "SELECT * from user_details WHERE us_email_id=?";
            Connection dbConnection = DBConnection.getConnection();
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String updateQuery = "UPDATE user_details SET us_password =? WHERE us_email_id =?";
                preparedStatement = dbConnection.prepareStatement(updateQuery);
                preparedStatement.setString(1, password);
                preparedStatement.setString(2, email);
                int count = preparedStatement.executeUpdate();
                returnState = count >= 1;
            } else {
                returnState = false;
            }
            DBConnection.disconnect(dbConnection);
        } catch (Exception e) {
        	throw new CustomException("Error");
        }
        return returnState;
    }
}
