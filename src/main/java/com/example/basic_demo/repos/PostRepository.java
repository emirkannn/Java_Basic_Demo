package com.example.basic_demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic_demo.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long userId);

}
