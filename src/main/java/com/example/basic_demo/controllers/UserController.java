package com.example.basic_demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic_demo.entities.User;
import com.example.basic_demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> tumKullanicilariGetir(){
		return userService.kullaniciGetir();
	}
	
	@PostMapping
	public User kullaniciOlustur(@RequestBody User newUser) {
		return userService.yeniKullaniciOlustur(newUser);
	}
	
	@GetMapping("/{userId}")
	public User kullaniciGetir(@PathVariable Long userId) {
		return userService.birKullaniciGetir(userId);
	}
	
	@PutMapping("/{userId}")
	public User kullaniciGuncelle(@PathVariable Long userId,@RequestBody User newUser) {
		 return userService.birKullaniciGuncelle(userId, newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void silinecekKullanici(@PathVariable Long userId) {
		userService.birKullaniciSil(userId);
	}
}
