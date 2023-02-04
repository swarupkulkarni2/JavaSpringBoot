package com.jrp.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.pma.dao_Repository.Employeerepository;
import com.jrp.pma.dao_Repository.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	

	@Autowired
	Employeerepository emprepo;
	
	
	@GetMapping("/")
	public String displayhome(Model model) {
		List<Project> project = proRepo.findAll();
		model.addAttribute("projectskey",project);
		
		List<Employee> employee = emprepo.findAll();
		model.addAttribute("employee", employee);
		
		return "homeMain";
	}
	


}
