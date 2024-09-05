package com.lostandfound.OPtranspo.Support;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@SuppressWarnings("unused")
@Entity
@Table(name = "Entities")
public class Entities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer empId;
	
	private String email;
	
	private String password;
	
	private String userRole;
	
	public Entities() {
		
	}
	
	public Entities(int empId, String email, String password, String userRole) {
		super();
		this.empId = empId;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}
	public int getEmpID() {
		return empId;
	}
	public void setEmpID(int empID) {
		this.empId = empID;
	} 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "Entities [empID=" + empId + ", email=" + email + ", password=" + password + ", userRole=" + userRole
				+ "]";
	}
	
	
}
