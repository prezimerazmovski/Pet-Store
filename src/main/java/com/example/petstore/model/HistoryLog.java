package com.example.petstore.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table()
public class HistoryLog {
	@Id
	private Long id;
	@Column(name = "dateOfExecution")
	private LocalDate dateOfExecution;
	@Column
	private Long petId;
	@Column
	private Long userId;
	@Column(name = "petprice")
	private int petPrice;

	@Enumerated(EnumType.STRING)
	@Column(name = "actionResult")
	private ActionResult actionResult;
	@Column

	private double budget;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDateOfExecution() {
		return dateOfExecution;
	}
	public void setDateOfExecution(LocalDate dateOfExecution) {
		this.dateOfExecution = dateOfExecution;
	}
	public Long getPetId() {
		return petId;
	}
	public void setPetId(Long petId) {
		this.petId = petId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getPetPrice() {
		return petPrice;
	}
	public void setPetPrice(int petPrice) {
		this.petPrice = petPrice;
	}

	public ActionResult getActionResult() {
		return actionResult;
	}

	public void setActionResult(ActionResult actionResult) {
		this.actionResult = actionResult;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public HistoryLog(Long id, LocalDate dateOfExecution, Long petId, Long userId, int petPrice,
			ActionResult actionResult, double budget) {
		super();
		this.id = id;
		this.dateOfExecution = dateOfExecution;
		this.petId = petId;
		this.userId = userId;
		this.petPrice = petPrice;
		this.actionResult = actionResult;
		this.budget = budget;
	}

	public HistoryLog() {
	}

	@Override
	public String toString() {
		return "HistoryLog [id=" + id + ", dateOfExecution=" + dateOfExecution + ", petId=" + petId + ", userId="
				+ userId + ", petPrice=" + petPrice + ", actionResult=" + actionResult + ", budget=" + budget + "]";
	}

}
