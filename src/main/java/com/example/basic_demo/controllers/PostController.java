package com.example.basic_demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic_demo.entities.Post;
import com.example.basic_demo.requests.PostCreateRequest;
import com.example.basic_demo.requests.PostUpdateRequest;
import com.example.basic_demo.services.PostService;


@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	public List<Post> tumPaylasimlariGetir(@RequestParam Optional<Long> userId){
		return postService.paylasimlariGetir(userId);
	}
	
	@PostMapping
	public Post gonderiOlustur(@RequestBody PostCreateRequest newPostRequest) {
		return postService.birGonderiOlustur(newPostRequest);
	}
	
	@GetMapping("/{postId}")
	public Post gonderiGetir(@PathVariable Long postId) {
		return postService.birGonderiGetir(postId);
	}
	
	@PutMapping("/{postId}")
	public Post gonderiGuncelle(@PathVariable Long postId,@RequestBody PostUpdateRequest updatePostRequest) {
		return postService.secilenGonderiGuncelle(postId,updatePostRequest);
	}
	
	@DeleteMapping("/{postId}")
	public void silinecekGonderi(@PathVariable Long postId) {
		postService.birGonderiSil(postId);
	}
}
