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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.entity.BugRequest;
import com.hexaware.service.BugService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
public class BugController {
	@Autowired
	BugService bugService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/bug/{id}")
	public Optional<BugRequest> getBug(@PathVariable Long id) throws Exception {
		System.out.println("get bug called");
		System.out.println("bug id"+id);
		return bugService.getBug(id);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/bug")
	public List<BugRequest> getAllBug() throws Exception {
		System.out.println("get all bugs called");
		List<BugRequest> allBugs = bugService.getAll();
		System.out.println(allBugs.get(0).toString());
		return allBugs;

	}
	@RequestMapping(method = RequestMethod.POST, value = "/bug")
	@ApiOperation(consumes = "application/json", value = "create Bug")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Long createNewBug(@Valid @RequestBody BugRequest bugRequest) throws Exception {
		bugService.create(bugRequest);
		return bugRequest.getId();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/bug/{id}")
	public Long updateBug(@RequestBody BugRequest bugRequest, @PathVariable Long id) throws Exception {
		System.out.println("update bug called");
		System.out.println(bugRequest.toString());
		bugService.update(id,bugRequest);
		return bugRequest.getId();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/bug/{id}")
	public void deleteBug(@PathVariable Long id) throws Exception {
		System.out.println("delete bug called");
		bugService.delete(id);

	}
}
