package com.gotogether.domain.event.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gotogether.domain.event.dto.request.CreateEventRequestDTO;
import com.gotogether.domain.event.dto.response.EventDetailResponseDTO;
import com.gotogether.domain.event.service.EventService;
import com.gotogether.global.apipayload.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/events")
public class EventController {

	private final EventService eventService;

	@PostMapping
	public ApiResponse<?> createEvent(@RequestBody CreateEventRequestDTO dto,
		@RequestParam("userId") Long userId) {
		eventService.createEvent(dto, userId);
		return ApiResponse.onSuccessCreated("이벤트 생성 성공");
	}

	@GetMapping("{eventId}")
	public ApiResponse<EventDetailResponseDTO> getDetailEvent(@PathVariable Long eventId) {
		return ApiResponse.onSuccess(eventService.getDetailEvent(eventId));
	}

	@DeleteMapping("{eventId}")
	public ApiResponse<?> deleteEvent(@PathVariable Long eventId) {
		eventService.deleteEvent(eventId);
		return ApiResponse.onSuccess("이벤트 삭제 성공");
	}
}
