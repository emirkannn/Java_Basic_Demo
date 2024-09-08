package com.example.basic_demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.basic_demo.entities.Post;
import com.example.basic_demo.entities.User;
import com.example.basic_demo.repos.PostRepository;
import com.example.basic_demo.requests.PostCreateRequest;
import com.example.basic_demo.requests.PostUpdateRequest;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserService userService;
	
	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<Post> paylasimlariGetir(Optional<Long> userId) {
		if (userId.isPresent()) {
			return postRepository.findByUserId(userId.get());
		}
		return postRepository.findAll();
	}


	public Post birGonderiGetir(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post birGonderiOlustur(PostCreateRequest newPostRequest) {
		User user = userService.birKullaniciGetir(newPostRequest.getUserId());
		if(user ==null) // kullanıcı yoksa gönderi oluşturulamaz
			return null;
		Post toSavePost = new Post();
		toSavePost.setId(newPostRequest.getId());
		toSavePost.setText(newPostRequest.getText());
		toSavePost.setTitle(newPostRequest.getTitle());
		toSavePost.setUser(user);
		return postRepository.save(toSavePost);
	}

	public Post secilenGonderiGuncelle(Long postId) {
		
		return null;
	}

	public void birGonderiSil(Long postId) {
		postRepository.deleteById(postId);
		
	}

	public Post secilenGonderiGuncelle(Long postId, PostUpdateRequest updatePostRequest) {
		Optional<Post> post = postRepository.findById(postId);
		if (post.isPresent()) {
			Post toUpdatePost = post.get();
			toUpdatePost.setText(updatePostRequest.getText());
			toUpdatePost.setTitle(updatePostRequest.getTitle());
			postRepository.save(toUpdatePost);
			return toUpdatePost;
		}
		return null;
	}

}
