package com.example.petstore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.petstore.model.PetType;
import com.example.petstore.model.Pets;
import com.example.petstore.repository.PetRepository;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {
	@Mock
	private PetRepository petRepository;
	@InjectMocks
	private Pets pet;
	@InjectMocks
	private PetService petService;

	@Test
	public void createPetTest() {
		petService.createPets();
		ArgumentCaptor<List> petsCaptor = ArgumentCaptor.forClass(List.class);
		verify(petRepository, times(1)).saveAll(petsCaptor.capture());
		List<Pets> petsList = petsCaptor.getValue();
		Pets firstPetName = petsList.get(0);
		Pets lastPetName = petsList.get(19);
		assertFalse(petsList.isEmpty());
		assertEquals("Mars", firstPetName.getName());
		assertEquals("Kobe", lastPetName.getName());
		assertEquals(20, petsList.size());

	}

	@Test
	public void listOfPetTest() {
		Pets pet1 = new Pets(1L, "Mars", 4, "very nice dog", LocalDate.of(2023, Month.APRIL, 5), PetType.DOG);
		Pets pet2 = new Pets(2L, "Leo", 4, "very nice dog", LocalDate.of(2022, Month.OCTOBER, 8), PetType.DOG);
		given(petRepository.findAll()).willReturn(List.of(pet1, pet2));
		List<Pets> pets = petService.listOfPets();
		Pets firstPet = pets.get(0);
		assertThat(pets).isNotNull();
		assertThat(pets.size()).isGreaterThan(1);
		assertEquals("Mars", firstPet.getName());
	}

}
