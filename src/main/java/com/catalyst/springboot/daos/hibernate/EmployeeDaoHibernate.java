package com.catalyst.springboot.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.daos.EmployeeDao;
import com.catalyst.springboot.entities.Employee;

@Component
@Transactional
public class EmployeeDaoHibernate implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void add(Employee employee) {
		em.persist(employee);
	}

	@Override
	public void update(Employee employee) {
		em.merge(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return em.
				createQuery("SELECT e FROM Employee e", Employee.class).
				getResultList();
	}

	@Override
	public Employee getByEmployeeId(Integer employeeId) {
		return em
				//sets specific parameter to protect from SQL injection, matching by field rather than blind string concatenation
				.createQuery("SELECT e FROM Employee e WHERE e.employeeId = :id", Employee.class)
				.setParameter("id", employeeId)
				.getSingleResult();
	}

	@Override
	public void delete(Integer employeeId) {
		Employee employee = getByEmployeeId(employeeId);
		em.remove(employee);

	}

}
