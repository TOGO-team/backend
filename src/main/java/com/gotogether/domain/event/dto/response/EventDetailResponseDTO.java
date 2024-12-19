package com.gotogether.domain.event.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.gotogether.domain.event.entity.Event;
import com.gotogether.domain.hostchannel.entity.HostChannel;
import com.gotogether.domain.referencelink.entity.ReferenceLink;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EventDetailResponseDTO {
	private Long id;
	private String bannerImageUrl;
	private String title;
	private int participantCount;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String location;
	private String description;
	private String hostChannelName;
	private String hostChannelDescription;
	private String hostEmail;
	private String hostPhoneNumber;
	private List<String> referenceLinks;

	public static EventDetailResponseDTO fromEntity(Event event, HostChannel hostChannel) {
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