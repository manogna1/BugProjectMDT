package com.hexaware.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.entity.Project;
import com.hexaware.service.ProjectService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/project/{id}")
	public Optional<Project> getproject(@PathVariable Long id) throws Exception {
		System.out.println("get project called");
		System.out.println("project id" + id);
		return projectService.getProject(id);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/project")
	public List<Project> getAllproject() throws Exception {
		System.out.println("get all projects called");
		List<Project> allprojects = projectService.getProjects();
		// System.out.println(allprojects.get(0).toString());
		return allprojects;

	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/project")
	@ApiOperation(consumes = "application/json", value = "create project")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Long createNewproject(@Valid @RequestBody Project project) throws Exception {
		projectService.createProject(project);
		return project.getId();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, value = "/project/{id}")
	public Long updateproject(@RequestBody Project project, @PathVariable Long id) throws Exception {
		System.out.println("update project called");
		System.out.println(project.toString());
		projectService.update(id, project);
		return project.getId();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, value = "/project/{id}")
	public void deleteproject(@PathVariable Long id) throws Exception {
		System.out.println("delete project called");
		projectService.delete(id);

	}
}
