package com.gotogether.domain.event.service;

import com.gotogether.domain.event.dto.request.CreateEventRequestDTO;

public interface EventService {
	void createEvent(CreateEventRequestDTO createEventRequestDTO, Long userId);
}
