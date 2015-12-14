package com.catalyst.springboot.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.daos.EmployeeDao;
import com.catalyst.springboot.entities.Employee;
/**
 * This implementation is used to store information about employees in a List. 
 * Information stored is not persisted to any form of permanent storage.
 * @author Ernest
 *
 */

public class EmployeeDaoImpl implements EmployeeDao {

	private List<Employee> employees = new ArrayList<>();
	private Integer nextId = 1;
	
	@Override
	public void add(Employee employee) {
		employee.setEmployeeId(nextId);
		nextId++;
		employees.add(employee);
		
	}
	
	@Override
	public void update(Employee employee) {
		Integer index = employees.indexOf(employee);
		employees.set(index, employee);
	}
	
	
	@Override
	public List<Employee> getAllEmployees() { 
		return employees;
	}
	
	@Override
	public Employee getByEmployeeId(Integer employeeId) {
		for(Employee e : employees){
			if(e.getEmployeeId().equals(employeeId)){
				return e;
			}
		}
		return null;
	}

	@Override
	public void delete(Integer employeeId) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		 
		employees.remove(employee);
		
	}
	
	
	
}
