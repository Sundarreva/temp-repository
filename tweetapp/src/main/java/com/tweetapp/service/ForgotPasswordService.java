package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.dao.ForgotPasswordDao;
import com.tweetapp.exception.CustomException;

public class ForgotPasswordService {

	Scanner scanner = new Scanner(System.in);

	public void forgotPassword() {
		System.out.println("--- FORGOT PASSWORD ---");
		System.out.print("Enter UserName:");
		String userName = scanner.nextLine();
		System.out.print("Enter New password:");
		String password = scanner.nextLine();
		ForgotPasswordDao forgotPassword = new ForgotPasswordDao();
		try {
			if (forgotPassword.forgotPassword(userName, password)) {
				System.out.println("Password Changed");
				LoginService login = new LoginService();
				login.userLogin();
			} else {
				System.out.println("Error");
			}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}
}