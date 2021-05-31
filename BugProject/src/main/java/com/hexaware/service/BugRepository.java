package com.hexaware.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.entity.BugRequest;
@Repository
public interface BugRepository extends JpaRepository<BugRequest, Long>{

}
