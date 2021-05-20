package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
public class UserController {
	@ResponseStatus(code=HttpStatus.CREATED)
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public void createUser(@RequestBody User user) {
		System.out.println("post method called"+ user.getName());
		System.out.println( user.getName()+" is "+ user.getAge()+"yrs old" + user.getAddress());

	}
}
