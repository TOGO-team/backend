package com.gotogether.domain.event.service;

import com.gotogether.domain.event.dto.request.EventRequestDTO;
import com.gotogether.domain.event.dto.response.EventDetailResponseDTO;
import com.gotogether.domain.event.entity.Event;

public interface EventService {
	Event createEvent(EventRequestDTO request);

	EventDetailResponseDTO getDetailEvent(Long eventId);

	void deleteEvent(Long eventId);
}
