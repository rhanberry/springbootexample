package com.catalyst.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.daos.EmployeeDao;
import com.catalyst.springboot.entities.Employee;
import com.catalyst.springboot.services.EmployeeService;
import com.catalyst.springboot.services.InvalidInputException; 
/**
 * Basic EmployeeService implementation that utilizes an EmployeeDao for persistent storage.
 * @author Ernest
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {


	
	@Autowired
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> getEmployees(Boolean active) {
 
		List<Employee> employees = employeeDao.getAllEmployees(); 
				if(active != null){
					//return employeeDao.getAllEmployees().stream().filter(t-> t.isActive() == active);
					List<Employee> activeEmployees = new ArrayList<>();
					for(Employee e : employees){
						if(e.isActive().equals(active)){
							activeEmployees.add(e);
						}
					}
					return activeEmployees;
				}
				
		return employees;
	}

	@Override
	public void add(Employee employee) { 
		employeeDao.add(employee);
		
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public Employee getByEmployeeId(Integer employeeId) throws InvalidInputException {
		if(employeeId == null || employeeId < 0){
			throw new InvalidInputException("EmployeeId.NullOrNegative");
		}
		return employeeDao.getByEmployeeId(employeeId);
	}

	
	@Override
	public void delete(Integer employeeId) {
		employeeDao.delete(employeeId);
		
	}



}
