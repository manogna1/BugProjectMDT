package com.hexaware.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.hexaware.entity.BugRequest;

@FeignClient(name="email-service")
public interface EmailClient {
	@PostMapping("/email")
	void sendUpdate(BugRequest bug);
}
