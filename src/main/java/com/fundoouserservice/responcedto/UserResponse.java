package com.fundoouserservice.responcedto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserResponse {

	private UUID id;
	private String userName;
	private String email;
	
}
