package com.example.petstore.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pets")
public class Pets {
	@Id
	private Long id;
	@JoinColumn(name = "owner_id", referencedColumnName = "id", table = "users")
	private Long owner;
	@Column
	private String name;
	@Column
	private int rating;
	@Column
	private String description;
	@Column
	private LocalDate dateOfBirth;
	@Column
	private int price;
	@Enumerated(EnumType.STRING)
	@Column
	private PetType type;

	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

	@PrePersist
	public void onPrePersist() {
		int years = LocalDate.now().getYear() - dateOfBirth.getYear();
		switch (type) {
		case DOG:
			this.setPrice((years * 1) + (getRating() * 1));
			break;
		case CAT:
			this.setPrice(years * 1);
			break;
		default:
			System.out.println("--");
		}

	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;

	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public Pets() {

	}

	public Pets(Long id, String name, int rating, String description, LocalDate dateOfBirth, PetType type) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.description = description;
		this.dateOfBirth = dateOfBirth;


		this.type = type;
	}

	@Override
	public String toString() {
		return "Pets [id=" + id + ", name=" + name + ", rating=" + rating + ", description=" + description
				+ ", dateOfBirth=" + dateOfBirth + ", price=" + price + ", type=" + type + "]";
	}
}


