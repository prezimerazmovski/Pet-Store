package com.example.petstore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.petstore.model.User;
import com.example.petstore.repository.UsersRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private UsersRepository userRepository;
	@InjectMocks
	private UserService userService;
	@InjectMocks
	private User user;

	@Test
	public void createUserTest() {
		userService.createUsers();

		ArgumentCaptor<List> usersCaptor = ArgumentCaptor.forClass(List.class);
		verify(userRepository, times(1)).saveAll(usersCaptor.capture());
		List<User> usersList = usersCaptor.getValue();

		assertFalse(usersList.isEmpty());
		assertEquals(10, usersList.size());

		User firstUser = usersList.get(0);
		User fifthUser = usersList.get(4);
		assertEquals("Dean", firstUser.getFirstName());
		assertEquals("Andrej", fifthUser.getFirstName());
	}

	@Test
	public void lisOfUsersTest() {

		User user1 = new User(2L, "Marko", "Stojkovski", "markostojkovski@gmail.com",
				Math.floor(Math.random() * 10) + 4);
		User user2 = new User(4L, "Filip", "Ivanovski", "filipivanovski@gmail.com", Math.floor(Math.random() * 10) + 4);
		given(userRepository.findAll()).willReturn(List.of(user1, user2));

		List<User> users = userService.listOfUsers();
		assertThat(users).isNotNull();
		assertThat(users.size()).isGreaterThan(1);
		User firstUser = users.get(0);
		assertEquals("Marko", firstUser.getFirstName());




	}
}
