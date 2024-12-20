package com.fundoouserservice.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoouserservice.entity.User;

public interface UserDao extends JpaRepository<User, UUID>{

	Optional<User> findByEmail(String username);


}
