package com.catalyst.springboot.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer employeeId;
	private String firstname;
	private String lastname;
	private Integer age;  
	private Boolean isActive;
	
	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public Boolean isActive() {
		return isActive;
	}
	
	
 
	
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(employeeId);
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee)){
			return false;
		}
		Employee employee = (Employee) obj;
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.employeeId, employee.employeeId);
		return builder.isEquals();
		
	}
 
}
