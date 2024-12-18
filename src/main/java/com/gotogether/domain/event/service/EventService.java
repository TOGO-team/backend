package com.gotogether.domain.event.service;

import com.gotogether.domain.event.dto.request.CreateEventRequestDTO;
import com.gotogether.domain.event.dto.response.EventDetailResponseDTO;

public interface EventService {
	void createEvent(CreateEventRequestDTO createEventRequestDTO, Long userId);

	EventDetailResponseDTO getDetailEvent(Long eventId);
}
