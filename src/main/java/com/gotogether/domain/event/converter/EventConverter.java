package com.gotogether.domain.event.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.gotogether.domain.event.dto.request.CreateEventRequestDTO;
import com.gotogether.domain.event.dto.response.EventDetailResponseDTO;
import com.gotogether.domain.event.entity.Event;
import com.gotogether.domain.hostchannel.entity.HostChannel;
import com.gotogether.domain.referencelink.entity.ReferenceLink;

public class EventConverter {

	public static Event of(CreateEventRequestDTO createEventRequestDTO, HostChannel hostChannel) {
		return Event.builder()
			.title(createEventRequestDTO.getTitle())
			.description(createEventRequestDTO.getDescription())
			.startDate(createEventRequestDTO.getStartDateTime())
			.endDate(createEventRequestDTO.getEndDateTime())
			.bannerImageUrl(createEventRequestDTO.getBannerImageUrl())
			.location(createEventRequestDTO.getLocation())
			.onlineType(createEventRequestDTO.getOnlineType())
			.category(createEventRequestDTO.getCategory())
			.hostEmail(createEventRequestDTO.getHostEmail())
			.hostPhoneNumber(createEventRequestDTO.getHostPhoneNumber())
			.hostChannel(hostChannel)
			.build();
	}

	public static EventDetailResponseDTO toEventDetailResponseDTO(Event event, HostChannel hostChannel) {
		List<String> links = event.getReferenceLinks().stream()
			.map(ReferenceLink::getToGoUrl)
			.collect(Collectors.toList());

		long ticketCount = event.getTickets().stream()
			.filter(ticket -> !ticket.isDeleted())
			.count();

		return EventDetailResponseDTO.builder()
			.id(event.getId())
			.bannerImageUrl(event.getBannerImageUrl())
			.title(event.getTitle())
			.participantCount((int)ticketCount)
			.startDate(event.getStartDate())
			.endDate(event.getEndDate())
			.location(event.getLocation())
			.description(event.getDescription())
			.hostChannelName(hostChannel.getName())
			.hostChannelDescription(hostChannel.getDescription())
			.hostEmail(event.getHostEmail())
			.hostPhoneNumber(event.getHostPhoneNumber())
			.referenceLinks(links)
			.build();
	}
}
