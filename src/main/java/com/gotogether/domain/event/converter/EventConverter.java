package com.gotogether.domain.event.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.gotogether.domain.event.dto.request.EventRequestDTO;
import com.gotogether.domain.event.dto.response.EventDetailResponseDTO;
import com.gotogether.domain.event.entity.Event;
import com.gotogether.domain.hostchannel.entity.HostChannel;
import com.gotogether.domain.referencelink.entity.ReferenceLink;

public class EventConverter {

	public static Event of(EventRequestDTO request, HostChannel hostChannel) {
		return Event.builder()
			.title(request.getTitle())
			.description(request.getDescription())
			.startDate(request.getStartDateTime())
			.endDate(request.getEndDateTime())
			.bannerImageUrl(request.getBannerImageUrl())
			.location(request.getLocation())
			.onlineType(request.getOnlineType())
			.category(request.getCategory())
			.hostEmail(request.getHostEmail())
			.hostPhoneNumber(request.getHostPhoneNumber())
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
