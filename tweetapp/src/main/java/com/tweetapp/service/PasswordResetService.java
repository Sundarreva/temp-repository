package com.tweetapp.service;

import java.util.Scanner;
import com.tweetapp.dao.PasswordResetDao;
import com.tweetapp.exception.CustomException;

public class PasswordResetService {
	Scanner scanner = new Scanner(System.in);

	public void passwordReset(String username, String password) {
		PasswordResetDao passwordReset = new PasswordResetDao();
		try {
			if (passwordReset.passwordVerify(username, password)) {
				System.out.print("Enter password:");
				String password = scanner.nextLine();
				if (passwordReset.resetPassword(username, password)) {
					System.out.println("Password Resetted");
				} else {
					System.out.println("Failed");
				}

			} else {
				System.out.println("Incorrect");
			}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}

}
