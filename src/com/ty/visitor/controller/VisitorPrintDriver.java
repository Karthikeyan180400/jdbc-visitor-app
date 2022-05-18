package com.ty.visitor.controller;

import com.ty.visitor.dao.VisitorDao;

public class VisitorPrintDriver {

	public static void main(String[] args) {
		
		VisitorDao visitorDao = new VisitorDao();
		//System.out.println(visitorDao.getVisitorById(10));
		//System.out.println(visitorDao.getAllVisitorByDate("15-may-22 | 10.10am"));
		System.out.println(visitorDao.getAllVisitorByAgeRange(22));

	}

}
