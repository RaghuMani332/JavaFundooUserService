package com.fundoouserservice.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fundoouserservice.dao.UserDao;
import com.fundoouserservice.entity.User;
import com.fundoouserservice.exception.DuplicateEntryException;
import com.fundoouserservice.exception.UserNotFoundException;
import com.fundoouserservice.requestdto.UserRequest;
import com.fundoouserservice.responcedto.UserResponse;
import com.fundoouserservice.service.UserService;
import com.fundoouserservice.util.ResponceStructure;

import jakarta.validation.Valid;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public ResponseEntity<ResponceStructure<UserResponse>> addUser(UserRequest request) {
		User user = mapToEntity(request);
		try
		{
			user = dao.save(user);
		}
		catch (DataIntegrityViolationException e) {
			System.out.println(e.getMessage());
				throw new DuplicateEntryException("the given mail id is already present");
		}
		
		return mapToResponseEntity(mapToUserResponse(user), "User Added successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponceStructure<UserResponse>> getUserById(UUID id) {
		
		User user = dao.findById(id).orElseThrow(() -> new UserNotFoundException("user not found by the given id please provide a valid one"));
		return mapToResponseEntity(mapToUserResponse(user), "User fetched successfully", HttpStatus.OK);

		
	}

	@Override
	public ResponseEntity<ResponceStructure<UserResponse>> updateUser(UUID id, @Valid UserRequest request) {
		User entity = dao.findById(id).orElseThrow(() -> new UserNotFoundException("user not found by the given id please provide a valid one"));
		User user = mapToEntity(request);
		user.setId(id);
		try
		{
			user = dao.save(user);
		}
		catch (Exception e) {
				throw new DuplicateEntryException("the given mail id is already present");
		}
		return mapToResponseEntity(mapToUserResponse(user), "User updated successfully", HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ResponceStructure<Boolean>> deleteUser(UUID id) {
		User user = dao.findById(id).orElseThrow(() -> new UserNotFoundException("user not found by the given id please provide a valid one"));
		dao.delete(user);
		return mapToResponseEntity(true, "user deleted successfully", HttpStatus.OK);
	}
	
	private User mapToEntity(UserRequest request)
	{
		return User.builder().UserName(request.getUserName())
							 .password(request.getPassword())
							 .email(request.getEmail())
							 .build();
	}
	
	private UserResponse mapToUserResponse(User user)
	{
		return UserResponse.builder()
									.id(user.getId())
									.userName(user.getUserName())
									.email(user.getEmail())
									.build();
	}
	
	private <T> ResponseEntity<ResponceStructure<T>> mapToResponseEntity(T data,String message , HttpStatus status)
	{
		ResponceStructure<T> structure = new ResponceStructure<>();
		structure.setData(data);
		structure.setMessage(message);
		structure.setStatus(status.value());
		
		return new ResponseEntity<ResponceStructure<T>>(structure,status);
		
		
	}

}
