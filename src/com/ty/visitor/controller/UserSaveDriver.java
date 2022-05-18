package com.ty.visitor.controller;

import java.util.ArrayList;

import com.ty.visitor.dao.UserDao;
import com.ty.visitor.dto.UserDto;

public class UserSaveDriver {

	public static void main(String[] args) {

		ArrayList<UserDto> list = new ArrayList<UserDto>();
		UserDto dto1 = new UserDto();
		dto1.setId(100);
		dto1.setName("Karthi");
		dto1.setEmail("karthi@mail.com");
		dto1.setPhone(809889);
		dto1.setPassword("1234");
		dto1.setRole("Software Engineer");

		list.add(dto1);

		UserDto dto2 = new UserDto();
		dto2.setId(101);
		dto2.setName("Peter");
		dto2.setEmail("peter@mail.com");
		dto2.setPhone(787878);
		dto2.setPassword("12345");
		dto2.setRole("Full Stack Developer");

		list.add(dto2);

		UserDto dto3 = new UserDto();
		dto3.setId(102);
		dto3.setName("Nishanth");
		dto3.setEmail("nishu@mail,com");
		dto3.setPhone(121212);
		dto3.setPassword("123456");
		dto3.setRole("Developer");

		list.add(dto3);
		
		UserDto dto4 = new UserDto();
		dto4.setId(103);
		dto4.setName("Eeshawaran");
		dto4.setEmail("eesh@mail.com");
		dto4.setPhone(131313);
		dto4.setPassword("1234567");
		dto4.setRole("Software developer");
		
		list.add(dto4);
	
		
		UserDao userDao = new UserDao();
		int[] res = userDao.saveUser(list);
		
		if(res != null) {
			System.out.println("Data inserted");
		} else {
			System.out.println("Data is not inserted");
		}
		
		

	}

}
