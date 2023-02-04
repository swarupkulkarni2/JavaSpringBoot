package com.jrp.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.pma.dao_Repository.ProjectRepository;
import com.jrp.pma.entities.Project;

@Controller
public class HomeMainController {
	
	@Autowired
	ProjectRepository proRepo;
	
	
	@GetMapping("/Home")
	public String displayhome(Model model) {
		List<Project> project = proRepo.findAll();
		model.addAttribute("projectskey",project);
		return "Home";
	}



}
