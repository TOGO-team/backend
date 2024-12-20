package com.gotogether.domain.event.service;

import com.gotogether.domain.event.dto.request.CreateEventRequestDTO;
import com.gotogether.domain.event.dto.response.EventDetailResponseDTO;
import com.gotogether.domain.event.entity.Event;

public interface EventService {
	Event createEvent(CreateEventRequestDTO createEventRequestDTO);

	EventDetailResponseDTO getDetailEvent(Long eventId);

	void deleteEvent(Long eventId);
}
