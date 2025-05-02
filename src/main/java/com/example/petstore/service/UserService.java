package com.example.petstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petstore.model.User;
import com.example.petstore.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	private UsersRepository userRepository;

	public List<User> createUsers() {
		return userRepository.saveAll(List.of(
				new User(1L, "Dean", "Razmovski", "deanrazmovski@gmail.com", Math.floor(Math.random() * 10) + 4),
				new User(2L, "Marko", "Stojkovski", "markostojkovski@gmail.com", Math.floor(Math.random() * 10) + 4),
				new User(3L, "Stefan", "Stefanovski", "stefanstefanovski@gmail.com",
						Math.floor(Math.random() * 10) + 4),
				new User(4L, "Filip", "Ivanovski", "filipivanovski@gmail.com", Math.floor(Math.random() * 10) + 4),
				new User(5L, "Andrej", "Talevski", "andrejtalevski@gmail.com", Math.floor(Math.random() * 10) + 4),
				new User(6L, "Ivan", "Ivanovski", "ivanivanovski@gmail.com", Math.floor(Math.random() * 10) + 4),
				new User(7L, "Igor", "Ristevski", "igorristevski@gmail.com", Math.floor(Math.random() * 10) + 4),
				new User(8L, "Petar", "Pavlovski", "petarpavlovsk@gmail.com", Math.floor(Math.random() * 10) + 4),
				new User(9L, "Martin", "Trajkovski", "martintrajkovski@gmail.com", Math.floor(Math.random() * 10) + 4),
				new User(10L, "Marjan", "Stojkovski", "marjanstojkovski@gmail.com", Math.floor(Math.random() * 10) + 4)
		));
	}

	public List<User> listOfUsers() {
		return userRepository.findAll();
	}


}





