package com.ty.visitor.controller;

import com.ty.visitor.dao.UserDao;

public class UserUpdateDriver {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		int res = userDao.updateUser("karthi1@mail.com", 100);
		
		if(res != 0) System.out.println("Updated");
		else System.out.println("Not updated");
	}

}
