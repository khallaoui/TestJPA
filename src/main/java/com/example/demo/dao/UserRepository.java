package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer>{
	AppUser findByLogin (String login);
}
