package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employe {
    @Id
	private Integer EmployeId;
	private String Name;
	private String Address;
	private Integer MonileNumber;
	
	public Employe(Integer employeId, String name, String address, Integer monileNumber) {
		super();
		EmployeId = employeId;
		Name = name;
		Address = address;
		MonileNumber = monileNumber;
	}

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmployeId() {
		return EmployeId;
	}

	public void setEmployeId(Integer employeId) {
		EmployeId = employeId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Integer getMonileNumber() {
		return MonileNumber;
	}

	public void setMonileNumber(Integer monileNumber) {
		MonileNumber = monileNumber;
	}
	
	
}
