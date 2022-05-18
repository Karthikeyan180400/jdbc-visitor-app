package com.ty.visitor.controller;

import com.ty.visitor.dao.UserDao;

public class UserValidateDriver {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		boolean res = userDao.validateUser("karthi@mail.com","12345");
		if(res) {
			System.out.println("Validate User");
		} else {
			System.out.println("mail or password is incorrect");
		}

	}
	
}
