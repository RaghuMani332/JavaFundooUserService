package com.fundoouserservice.service;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.fundoouserservice.requestdto.UserRequest;
import com.fundoouserservice.responcedto.UserResponse;
import com.fundoouserservice.util.ResponceStructure;

import jakarta.validation.Valid;

public interface UserService {

	ResponseEntity<ResponceStructure<UserResponse>> addUser(@Valid UserRequest request);

	ResponseEntity<ResponceStructure<UserResponse>> getUserById(UUID id);

	ResponseEntity<ResponceStructure<UserResponse>> updateUser(UUID id, @Valid UserRequest request);

	ResponseEntity<ResponceStructure<Boolean>> deleteUser(UUID id);

}
