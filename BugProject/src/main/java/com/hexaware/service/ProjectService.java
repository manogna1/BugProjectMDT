package com.hexaware.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexaware.entity.BugRequest;
import com.hexaware.entity.Project;

@Service
public interface ProjectService {
	Project createProject(Project project);

	Optional<Project> getProject(long id);

	List<Project> getProjects();
	void delete(Long id);
	void update(Long id,Project project);

}
