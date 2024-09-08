package com.example.basic_demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.basic_demo.entities.User;
import com.example.basic_demo.repos.UserRepository;

@Service // repoya bağlanacak katman
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> kullaniciGetir() {
		return userRepository.findAll();
	}

	public User yeniKullaniciOlustur(User newUser) {
		return userRepository.save(newUser);
	}

	public User birKullaniciGetir(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User birKullaniciGuncelle(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) { //Obje varsa
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}else {
			return null;
		}
	}

	public void birKullaniciSil(Long userId) {
		userRepository.deleteById(userId);
		
	}

}
