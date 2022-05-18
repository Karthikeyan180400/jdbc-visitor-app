package com.ty.visitor.controller;

import com.ty.visitor.dao.UserDao;

public class UserDeleteDriver {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		int res = userDao.deleteUser(104);
		if(res != 0)System.out.println("Deleted");
		else System.out.println("User not Found");

	}

}
