package com.jrp.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.dao_Repository.Employeerepository;
import com.jrp.pma.dao_Repository.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired 
	ProjectRepository proRep;
	
	@Autowired
	Employeerepository emprepo;
	
	@GetMapping
	public String DisplayProjects(Model model) {
		List<Project> project=proRep.findAll();
		model.addAttribute("project",project);
		return "list-projects";
	}
	
	@GetMapping("/new")
	public String home(Model model) { //Model --> used to transfer data between the view and controller of the Spring MVC application
		Project project = new Project();
		List<Employee> employee = emprepo.findAll();
		model.addAttribute("allEmployees",employee);
		model.addAttribute("project",project); // To bind data
		return "new-project";
	}
	
	@PostMapping("/save")
	public String CreateProject(Project project,@RequestParam List<Long> employees, Model model) {
		proRep.save(project);
		Iterable<Employee> choosenEmployee = emprepo.findAllById(employees);
		for(Employee emp : choosenEmployee) {
			emp.setProject(project);
			emprepo.save(emp);
		}
		return "redirect:/Home"; // redirect to prevent from duplicate entries 
	}
}
