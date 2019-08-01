package com.yash.springbootdemo.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class StudentDto {
	@NotNull
	private Integer rollNo;
	
	@NotNull
	@Length(min=1, max=10)
	private String name;
	
	@NotNull
	private String address;
	public Integer getRollNo() {
		return rollNo;
	}
	
	@Override
	public String toString() {
		return "StudentDto [rollNo=" + rollNo + ", name=" + name + ", address=" + address + "]";
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
