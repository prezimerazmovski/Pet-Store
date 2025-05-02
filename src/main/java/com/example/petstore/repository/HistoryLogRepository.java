package com.example.petstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.ActionResult;
import com.example.petstore.model.HistoryLog;

@Repository
public interface HistoryLogRepository extends JpaRepository<HistoryLog, Long> {
	 
	Long countByActionResult(ActionResult actionResult);
}
	

