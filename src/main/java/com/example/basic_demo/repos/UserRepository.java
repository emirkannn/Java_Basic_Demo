package com.example.basic_demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic_demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
