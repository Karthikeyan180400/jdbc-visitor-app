package com.ty.visitor.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitor.dto.VisitorDto;

public class VisitorSaveDriver {

	public static void main(String[] args) {
		ArrayList<VisitorDto> list = new ArrayList<VisitorDto>();
        VisitorDto dto1 = new VisitorDto();
        dto1.setId(10);
        dto1.setName("karthi");
        dto1.setEmail("karthi@mail.com");
        dto1.setPhone(111111);
        dto1.setAge(22);
        dto1.setGender("male");
        dto1.setDob("18-apr-00");
        dto1.setVisitDateTime(LocalDateTime.now());
        
        list.add(dto1);
        
        VisitorDto dto2 = new VisitorDto();
        dto2.setId(11);
        dto2.setName("peter");
        dto2.setEmail("peter@mail.com");
        dto2.setPhone(222222);
        dto2.setAge(22);
        dto2.setGender("male");
        dto2.setDob("20-dec-00");
        dto2.setVisitDateTime(LocalDateTime.now());
        
        list.add(dto2);
        
        VisitorDto dto3 = new VisitorDto();
        dto3.setId(12);
        dto3.setName("nishanth");
        dto3.setEmail("nishu@mail.com");
        dto3.setPhone(333333);
        dto3.setAge(23);
        dto3.setGender("male");
        dto3.setDob("21-june-00");
        dto3.setVisitDateTime(LocalDateTime.now());
        
        list.add(dto3);
        
        VisitorDao visitorDao = new VisitorDao();
        int[] res = visitorDao.saveVisitor(list);
        
        if(res != null) System.out.println("Data inserted");
        else System.out.println("Data is not inserted");
        
	}

}
