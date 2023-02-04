package com.jrp.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.pma.dao_Repository.Employeerepository;
import com.jrp.pma.entities.Employee;

@Controller
public class EmpHomeController
{
	@Autowired
	Employeerepository emprepo;
	
	@GetMapping("/EmpHome")
	public String showEmp(Model model) {
		List<Employee> employee = emprepo.findAll();
		model.addAttribute("employee", employee);
		return "EmpHome";
	}

}
