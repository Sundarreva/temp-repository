package com.tweetapp.service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tweetapp.dao.UserRegistrationDao;
import com.tweetapp.exception.CustomException;
import com.tweetapp.model.Register;

public class UserRegistrationService {

	Scanner scanner = new Scanner(System.in);

	public void getUserRegistrationDetails() {
		System.out.println("--- USER REGISTRATION ---");
		System.out.print("Enter Firstname:");
		String firstName = scanner.nextLine();
		System.out.print("Enter LastName:");
		String lastName = scanner.nextLine();
		System.out.print("Enter Gender:");
		String gender = scanner.nextLine();
		System.out.print("Enter your DOB:");
		String dob = scanner.nextLine();
		System.out.print("Enter Email:");
		String emailId = scanner.nextLine();
		System.out.print("Enter Password:");
		String password = scanner.nextLine();

		if (firstName != null && !firstName.isEmpty() && gender != null && !gender.isEmpty() && emailId != null
				&& !emailId.isEmpty() && password != null && !password.isEmpty()) {
			String arr[] = null;
			String dobString = null;
			if (!dob.isEmpty()) {
				if (dob != null  && dob.length() == 10) {
					arr = dob.split("-");
					if (arr[0].length() == 2 && arr[1].length() == 2 && arr[2].length() == 4) {
						dobString = arr[2] + "-" + arr[1] + "-" + arr[0];
					}
				} else {
					System.out.println("Failed");
					getUserRegistrationDetails();
				}
			}

			Register register = new Register(firstName, lastName, gender, dobString, emailId, password);
			UserRegistrationDao userRegister = new UserRegistrationDao();
			try {
				if (userRegister.addUser(register)) {
					System.out.println("Success");
					LoginService login = new LoginService();
					login.login();
				} else {
					System.out.println("Email Exist");
					getUserRegistrationDetails();
				}
			} catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Failed");
			getUserRegistrationDetails();
		}
	}
}