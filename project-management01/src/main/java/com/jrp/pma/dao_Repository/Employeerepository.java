package com.jrp.pma.dao_Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;


public interface Employeerepository extends CrudRepository<Employee, Long> {
	
	@Override
	public List<Employee> findAll();

}
