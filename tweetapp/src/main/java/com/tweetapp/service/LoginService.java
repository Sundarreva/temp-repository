package com.tweetapp.service;

import java.util.Scanner;
import com.tweetapp.dao.LoginDao;
import com.tweetapp.exception.CustomException;

public class LoginService {

	Scanner scanner = new Scanner(System.in);

	public void userLogin() {
		System.out.println("--- LOGIN ---");
		System.out.print("Enter your Email ID:");
		String userName = scanner.nextLine();
		System.out.print("Enter your password:");
		String password = scanner.nextLine();
		LoginDao loginDao = new LoginDao();
		try {
			if (loginDao.userLogin(userName, password)) {
				MenuService menu = new MenuService();
				menu.getMenuList(userName);

			} else {
				System.out.println("Incorrect Password");
				userLogin();
			}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}
}
