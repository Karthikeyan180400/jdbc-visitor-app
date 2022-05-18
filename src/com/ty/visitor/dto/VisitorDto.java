package com.ty.visitor.dto;

import java.time.LocalDateTime;

public class VisitorDto {
	int id;
	String name;
	String email;
	long phone;
	int age;
	String gender;
	String dob;
	LocalDateTime visitDateTime;
	
	
	
	@Override
	public String toString() {
		return "Visitor [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + ", visitDateTime=" + visitDateTime + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public LocalDateTime getVisitrDateTime() {
		return visitDateTime;
	}
	public void setVisitDateTime(LocalDateTime localDateTime) {
		this.visitDateTime = localDateTime;
	}
	
	

}
