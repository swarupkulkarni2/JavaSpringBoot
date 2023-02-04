package com.jrp.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrp.pma.dao_Repository.Employeerepository;
import com.jrp.pma.entities.Employee;


@Controller
@RequestMapping("/Employees")
public class EmployeeController {
	
	@Autowired
	Employeerepository emprepo;
	
	@GetMapping
	public String DisplayEmployees(Model model) {
		List<Employee> employee=emprepo.findAll();
		model.addAttribute("employee", employee);
		return "employee-list";
	}
	
	@GetMapping("/emp")
	public String EmployeePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "EmployeePrj";
	}
	
	@PostMapping("/empsave")
	public String saveEmployee(Model model, Employee employee) {
		emprepo.save(employee);
		return "redirect:/EmpHome";
	}
	
}
