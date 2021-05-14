package com.tweetapp;

import java.util.Scanner;

import com.tweetapp.service.LoginService;
import com.tweetapp.service.UserRegistrationService;
import com.tweetapp.service.ForgotPasswordService;

public class App {
	public static void main(String[] args) {
	    
		Scanner scanner = new Scanner(System.in);
		System.out.println("MENU");
		System.out.println("1. REGISTER");
		System.out.println("2. LOGIN");
		System.out.println("3. FORGOT PASSWORD");
		System.out.println("Enter your choice: ");
		
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			UserRegistrationService registration = new UserRegistrationService();
			registration.getUserRegistrationDetails();
			break;
		case "2":
			LoginService login = new LoginService();
			login.userLogin();
			break;
		case "3":
			ForgotPasswordService forgotpassword = new ForgotPasswordService();
			forgotpassword.forgotPassword();
			break;
		default:
			System.out.print("Enter a valid choice");
			main(args);
		}
	}
}