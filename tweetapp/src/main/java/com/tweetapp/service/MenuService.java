package com.tweetapp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;
import com.tweetapp.App;
import com.tweetapp.model.Tweet;

public class MenuService {

	Scanner scanner = new Scanner(System.in);

	public void getMenuList(String username) {

		System.out.println("--- MENU ---");
		System.out.println("1. Post tweet");
		System.out.println("2. View my tweets");
		System.out.println("3. View all tweets");
		System.out.println("4. View all Users");
		System.out.println("5. Reset Password");
		System.out.println("6. Logout");
		System.out.print("Enter choice:");
		String choice = scanner.nextLine();

		ViewTweetsService viewTweets = new ViewTweetsService();
		
		switch (choice) {
		
		case "1":
			PostTweetService postTweet = new PostTweetService();
			postTweet.postTweet(username);
			break;
			
		case "2":
			ArrayList<Tweet> tweets = viewTweets.getUserTweets(username);
			if (tweets.isEmpty()) {
				System.out.println("No Tweets");
				getMenuList(username);
			} else {
				for (int i = 0; i < tweets.size(); i++) {
					System.out.println("" + tweets.get(i).getTweet() + " ");
				}
				getMenuList(username);
			}
			break;
			
		case "3":
			ArrayList<Tweet> allTweets = viewTweets.getAllUserTweets();
			if (allTweets.isEmpty()) {
				System.out.println("No Tweets");
				getMenuList(username);
			} else {
				for (int i = 0; i < allTweets.size(); i++) {
					System.out.println(username + ": " + allTweets.get(i).getTweet());
				}
				getMenuList(username);
			}
			break;
			
		case "4":
			HashSet<String> users = viewTweets.getUserList();
			if (users.isEmpty()) {
				System.out.println("No User");
				getMenuList(username);
			} else {
				System.out.println("--- ALL USERS ---");
				Iterator<String> i = users.iterator();
				while (i.hasNext())
					System.out.println(i.next());
				getMenuList(username);
			}
			break;
			
		case "5":
			PasswordResetService reset = new PasswordResetService();
			System.out.print("Enter Old password:");
			String oldPwd = scanner.nextLine();
			reset.passwordReset(username, oldPwd);
			getMenuList(username);
			break;
			
		case "6":
			System.out.println("Logged out");
			App.main(null);
			break;
			
		default:
			System.out.println("Enter correct Option");
			getMenuList(username);
		}
	}
}