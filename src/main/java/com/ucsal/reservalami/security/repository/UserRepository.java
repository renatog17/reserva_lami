package com.ucsal.reservalami.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.ucsal.reservalami.security.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	UserDetails findByLogin(String login);
}
