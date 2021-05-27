package com.hexaware.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.controller.EmailClient;
import com.hexaware.entity.BugRequest;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BugService {
	@Autowired
	BugRepository bugRepository;
	@Autowired
	EmailClient emailClient;
	@Transactional(rollbackOn = Exception.class, dontRollbackOn = { ArithmeticException.class,
			IllegalArgumentException.class })
	@HystrixCommand(fallbackMethod="fallback")
	public void create(BugRequest bugRequest) throws Exception {
		System.out.println(bugRequest);
//		childMethod(bugRequest);
		bugRepository.save(bugRequest);
		emailClient.sendUpdate(bugRequest);
//		throw new Exception();
	}
	
	public void fallback(BugRequest bugRequest) {
		System.out.println("fallback called...");
	}
	public void update(Long id,BugRequest bugRequest) throws Exception {
		System.out.println(bugRequest);
		Optional<BugRequest> existRequest=bugRepository.findById(id);
		BugRequest updateRequest=existRequest.get();
		updateRequest= bugRequest;
		updateRequest.setId(id);
		bugRepository.save(updateRequest);
		System.out.println("Updated!!");
		
	}
	public List<BugRequest> getAll() throws Exception {
		List<BugRequest> allBugs= bugRepository.findAll();
		return allBugs;	
	}
	public Optional<BugRequest> getBug(Long id) throws Exception {
		Optional<BugRequest> allBugs= bugRepository.findById(id);
		return allBugs;	
	}
	public void delete(Long id) throws Exception {
		bugRepository.deleteById(id);
	}

}
