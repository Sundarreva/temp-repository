package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tweetapp.DBConnection;
import com.tweetapp.exception.CustomException;
import com.tweetapp.model.Tweet;

public class PostTweetDao {

	public boolean postTweet(Tweet tweet) throws CustomException {

		boolean returnState = false;
		try {
			String query = "INSERT into tweet_details VALUES(?,?)";
			Connection dbConnection = DBConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, tweet.getUserName());
			preparedStatement.setString(2, tweet.getTweet());
			int count = preparedStatement.executeUpdate();
			returnState = count >= 1;
			DBConnection.disconnect(dbConnection);
		} catch (Exception e) {
			throw new CustomException("Error");
		}
		return returnState;
	}
}
