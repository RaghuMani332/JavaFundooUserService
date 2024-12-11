package com.fundoouserservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundoouserservice.requestdto.UserRequest;
import com.fundoouserservice.responcedto.UserResponse;
import com.fundoouserservice.service.UserService;
import com.fundoouserservice.util.ResponceStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService service;
	
	
	@PostMapping("adduser")
	public ResponseEntity<ResponceStructure<UserResponse>> addUser(@RequestBody @Valid UserRequest request)
	{
		return service.addUser(request);
	}
//	static int i=0;
	@GetMapping("getuser/{id}")
	public ResponseEntity<ResponceStructure<UserResponse>> getUserById(@PathVariable UUID id)
	{
//		if(i==3)
//		{
//			System.exit(3);
//		}
//		i++;
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(i);
		return service.getUserById(id);
	}
	
	@PutMapping("updateuser/{id}")
	public ResponseEntity<ResponceStructure<UserResponse>> updateUser(@PathVariable UUID id,@RequestBody @Valid UserRequest request)
	{
		return service.updateUser(id,request);
	}
	
	@DeleteMapping("deleteuser/{id}")
	public ResponseEntity<ResponceStructure<Boolean>> deleteUser(@PathVariable UUID id)
	{
		return service.deleteUser(id);
	}

	@PutMapping("login")
	public ResponseEntity<ResponceStructure<UserResponse>> login(@RequestParam String userName, @RequestParam String password) {
		return service.login(userName,password);
	}
	



}
