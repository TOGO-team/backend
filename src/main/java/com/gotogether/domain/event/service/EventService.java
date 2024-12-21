package com.gotogether.domain.event.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gotogether.domain.event.dto.request.EventRequestDTO;
import com.gotogether.domain.event.dto.response.EventDetailResponseDTO;
import com.gotogether.domain.event.dto.response.EventListResponseDTO;
import com.gotogether.domain.event.entity.Event;

public interface EventService {
	Event createEvent(EventRequestDTO request);

	EventDetailResponseDTO getDetailEvent(Long eventId);

	Event updateEvent(Long eventId, EventRequestDTO request);

	void deleteEvent(Long eventId);

	Page<EventListResponseDTO> getEventsByTag(String tags, Pageable pageable);
}
