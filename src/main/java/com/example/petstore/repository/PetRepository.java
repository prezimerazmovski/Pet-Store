package com.example.petstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.Pets;

@Repository
public interface PetRepository extends JpaRepository<Pets, Long> {
}
