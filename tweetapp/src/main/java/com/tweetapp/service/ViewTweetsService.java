package com.tweetapp.service;

import java.util.ArrayList;
import java.util.HashSet;
import com.tweetapp.dao.ViewTweetsDao;
import com.tweetapp.exception.CustomException;
import com.tweetapp.model.Tweet;

public class ViewTweetsService {

	public ArrayList<Tweet> getUserTweets(String username) {
		ViewTweetsDao viewTweet = new ViewTweetsDao();
		ArrayList<Tweet> tweets = null;
		try {
			tweets = viewTweet.getUserTweets(username);
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
		return tweets;
	}

	public ArrayList<Tweet> getAllUserTweets() {
		ViewTweetsDao viewTweet = new ViewTweetsDao();
		ArrayList<Tweet> tweets = null;
		try {
			tweets = viewTweet.getAllUserTweets();
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
		return tweets;
	}

	public HashSet<String> getUserList() {
		ViewTweetsDao viewTweet = new ViewTweetsDao();
		HashSet<String> users = null;
		try {
			users = viewTweet.getUserList();
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
		return users;
	}
}