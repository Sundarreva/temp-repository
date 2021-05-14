package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.dao.PostTweetDao;
import com.tweetapp.exception.CustomException;
import com.tweetapp.model.Tweet;

public class PostTweetService {

	Scanner scanner = new Scanner(System.in);

	public void postTweet(String userName) {
		System.out.println("--- POST TWEET ---");
		System.out.print("Enter Tweet:");
		String tweet = scanner.nextLine();
		if(tweet.isEmpty()) {
			System.out.println("Failed");
			MenuService menu = new MenuService();
			menu.getMenuList(userName);
		} else {
			Tweet tweetobj = new Tweet();
			tweetobj.setTweet(tweet);
			tweetobj.setUserName(userName);
			PostTweetDao postTweet = new PostTweetDao();
			try {
				if (postTweet.postTweet(tweetobj)) {
					System.out.println("Success");
					MenuService menu = new MenuService();
					menu.getMenuList(userName);
				} else {
					System.out.println("Failed");
				}
			} catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println();
	}
}