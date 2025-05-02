package com.example.petstore.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petstore.model.ActionResult;
import com.example.petstore.model.HistoryLog;
import com.example.petstore.model.PetType;
import com.example.petstore.model.Pets;
import com.example.petstore.model.User;
import com.example.petstore.repository.HistoryLogRepository;
import com.example.petstore.repository.PetRepository;
import com.example.petstore.repository.UsersRepository;

@Service
public class PetService {
	@Autowired
	private HistoryLogRepository historyLogRepository;
	@Autowired
	private PetRepository petRepository;
	@Autowired
	private UsersRepository userRepository;
	Pets pet;

	public void succesfullyBuyPet(HistoryLog history) {

	}

	public Pets getRandomPet(Pets pet) {
		int count = Long.valueOf(petRepository.count()).intValue();

		if (count > 0) {
			Random r = new Random();

			List<Pets> pets = StreamSupport.stream(petRepository.findAll().spliterator(), false)
					.collect(Collectors.toList());

			return pets.get(r.nextInt(count));
		} else {
			throw new IllegalStateException("No quotes found.");
		}
	}

	public List<Pets> createPets() {
		return petRepository.saveAll(
				List.of(new Pets(1L, "Mars", 4, "very nice dog", LocalDate.of(2023, Month.APRIL, 5), PetType.DOG),
						new Pets(2L, "Leo", 4, "very nice dog", LocalDate.of(2022, Month.OCTOBER, 8), PetType.DOG),
						new Pets(3L, "Max", 2, "very nice dog", LocalDate.of(2019, Month.FEBRUARY, 11), PetType.DOG),
						new Pets(4L, "Lea", 0, "its good cat", LocalDate.of(2021, Month.AUGUST, 12), PetType.CAT),
						new Pets(5L, "Tom", 0, "its good cat", LocalDate.of(2020, Month.DECEMBER, 22), PetType.CAT),
						new Pets(6L, "Arf", 7, "very nice dog", LocalDate.of(2020, Month.MAY, 23), PetType.DOG),
						new Pets(7L, "Lea", 0, "its good cat", LocalDate.of(2019, Month.MARCH, 17), PetType.CAT),
						new Pets(8L, "Dzeki", 3, "very nice dog", LocalDate.of(2018, Month.APRIL, 27), PetType.DOG),
						new Pets(9L, "Iris", 0, "its good cat", LocalDate.of(2022, Month.APRIL, 2), PetType.CAT),
						new Pets(10L, "Archi", 3, "very nice dog", LocalDate.of(2024, Month.JULY, 1), PetType.DOG),
						new Pets(11L, "Shele", 0, "its good cat", LocalDate.of(2020, Month.JUNE, 9), PetType.CAT),
						new Pets(12L, "Cooper", 6, "very nice dog", LocalDate.of(2021, Month.JANUARY, 18), PetType.DOG),
						new Pets(13L, "Lark", 8, "very nice dog", LocalDate.of(2018, Month.NOVEMBER, 25), PetType.DOG),
						new Pets(14L, "Levi", 7, "very nice dog", LocalDate.of(2019, Month.SEPTEMBER, 10), PetType.DOG),
						new Pets(15L, "John", 0, "its good cat", LocalDate.of(2021, Month.AUGUST, 3), PetType.CAT),
						new Pets(16L, "Jackson", 0, "its good cat", LocalDate.of(2020, Month.MARCH, 21), PetType.CAT),
						new Pets(17L, "Bella", 2, "very nice dog", LocalDate.of(2019, Month.DECEMBER, 20), PetType.DOG),
						new Pets(18L, "Tobey", 4, "very nice dog", LocalDate.of(2023, Month.JULY, 29), PetType.DOG),
						new Pets(19L, "Lina", 0, "its good cat", LocalDate.of(2022, Month.MAY, 30), PetType.CAT),
						new Pets(20L, "Kobe", 4, "very nice dog", LocalDate.of(2020, Month.JANUARY, 11), PetType.DOG)

				));
	}

	public void buy() {
		List<User> listOfUsers = userRepository.findAll();
		for (User user : listOfUsers) {
			Pets randomPet = getRandomPet(pet);

			if (user.getBudget() > randomPet.getPrice() && randomPet.getOwner() == null) {
				randomPet.setOwner(user.getId());
				user.setBudget(user.getBudget() - randomPet.getPrice());

				petRepository.save(randomPet);
				userRepository.save(user);
				createHistoryLog(user.getId(), randomPet.getId(), user.getId(), randomPet.getPrice(),
						ActionResult.SUCCESFULL, user.getBudget());
				checkPetType(randomPet, user.getFirstName());
			} else {
				createHistoryLog(user.getId(), randomPet.getId(), user.getId(), randomPet.getPrice(),
						ActionResult.UNSUCCESFULL, user.getBudget());
			}
		}

	}

	private void checkPetType(Pets randomPet, String firstName) {
		if (randomPet.getType() == PetType.CAT) {
			System.out.println("Meow,cat" + " " + randomPet.getName() + " " + "has owner" + " " + firstName);
		} else if (randomPet.getType() == PetType.DOG) {
			System.out.println("Wow,dog" + " " + randomPet.getName() + " " + "has owner" + " " + firstName);
		}

	}

	private void createHistoryLog(Long id, Long petId, Long userId, int price, ActionResult actionResult,
			double budget) {
		HistoryLog history = new HistoryLog(id, LocalDate.now(), petId, userId, price, actionResult, budget);
		historyLogRepository.save(history);
	}

	public List<Pets> listOfPets() {
		return petRepository.findAll();
	}
}
