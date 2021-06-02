package com.hexaware.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.entity.Project;

public interface IProjectRepository extends JpaRepository<Project, Long> {

}
