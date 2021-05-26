package com.hexaware.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.hexaware.entity.BugRequest;

@FeignClient(name="EmailService")
public interface EmailClient {
	@PostMapping("/email")
	void sendUpdate(BugRequest bug);
}
