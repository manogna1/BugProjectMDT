package com.hexaware.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.entity.Project;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	IProjectRepository projectRepository;

	@Override
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Optional<Project> getProject(long id) {
		return projectRepository.findById(id);
	}

	@Override
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}
	
	@Override
	public void delete(Long id) {
		projectRepository.deleteById(id);
	}
	
	@Override
	public void update(Long id,Project project){
		System.out.println(project);
		Optional<Project> existRequest=projectRepository.findById(id);
		Project updateRequest= existRequest.get();
		updateRequest= project;
		updateRequest.setId(id);
		projectRepository.save(updateRequest);
		System.out.println("Updated!!");
	}
}
