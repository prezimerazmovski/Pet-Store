package com.example.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.model.HistoryLogRecord;
import com.example.petstore.model.Pets;
import com.example.petstore.model.User;
import com.example.petstore.service.HistoryLogService;
import com.example.petstore.service.PetService;
import com.example.petstore.service.UserService;

@RestController
@RequestMapping
public class PetStoreController {
	@Autowired
	private UserService userService;
	@Autowired
	private PetService petService;
	@Autowired
	private HistoryLogService historyLogService;

	@PostMapping(path = "create-users")
	public List<User> createUsers() {
		return userService.createUsers();
	}

	@PostMapping(path = "create-pets")
	public List<Pets> createPets() {
		return petService.createPets();
	}

	@PostMapping(path = "buy")
	public void buyPets() {
		petService.buy();
	}

	@GetMapping(path = "list-users")
	public List<User> listOfUsers() {
		return userService.listOfUsers();
	}

	@GetMapping(path = "list-pets")
	public List<Pets> listOfPets() {
		return petService.listOfPets();
	}

	@GetMapping(path = "history-log")
	public HistoryLogRecord historyLog() {
		return historyLogService.historyLog();
	}

}
