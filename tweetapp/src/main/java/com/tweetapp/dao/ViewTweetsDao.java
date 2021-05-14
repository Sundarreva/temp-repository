package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;

import com.tweetapp.DBConnection;
import com.tweetapp.exception.CustomException;
import com.tweetapp.model.Tweet;

public class ViewTweetsDao {

	public ArrayList<Tweet> getUserTweets(String userName) throws CustomException {

		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		try {
			String query = "SELECT * from tweet_details WHERE tweet_user=?";
			Connection dbConnection = DBConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Tweet tweet = new Tweet();
				tweet.setTweet(rs.getString(2));
				tweet.setUserName(rs.getString(1));
				tweets.add(tweet);
			}
			DBConnection.disconnect(dbConnection);
		} catch (Exception e) {
			throw new CustomException("Error");
		}
		return tweets;
	}

	public ArrayList<Tweet> getAllUserTweets() throws CustomException {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		try {
			String query = "SELECT * from tweet_details";
			Connection dbConnection = DBConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Tweet tweet = new Tweet();
				tweet.setTweet(rs.getString(2));
				tweet.setUserName(rs.getString(1));
				tweets.add(tweet);
			}
			DBConnection.disconnect(dbConnection);
		} catch (Exception e) {
			throw new CustomException("Error");
		}
		return tweets;
	}

	public HashSet<String> getUserList() throws CustomException {
		HashSet<String> users = new HashSet<String>();
		try {
			String query = "SELECT * from user_details";
			Connection dbConnection = DBConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				users.add(rs.getString(4));
			}
			DBConnection.disconnect(dbConnection);
		} catch (Exception e) {
			throw new CustomException("Error");
		}
		return users;
	}
}
