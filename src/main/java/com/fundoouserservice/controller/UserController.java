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
	
	@GetMapping("getuser/{id}")
	public ResponseEntity<ResponceStructure<UserResponse>> getUserById(@PathVariable UUID id)
	{
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

	



}
