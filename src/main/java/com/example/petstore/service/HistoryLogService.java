package com.example.petstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petstore.model.ActionResult;
import com.example.petstore.model.HistoryLogRecord;
import com.example.petstore.repository.HistoryLogRepository;

@Service
public class HistoryLogService {
	@Autowired
	private HistoryLogRepository historyLogRepository;


	public HistoryLogRecord historyLog() {
		return new HistoryLogRecord(historyLogRepository.countByActionResult(ActionResult.SUCCESFULL),
				historyLogRepository.countByActionResult(ActionResult.UNSUCCESFULL));
	}
}
