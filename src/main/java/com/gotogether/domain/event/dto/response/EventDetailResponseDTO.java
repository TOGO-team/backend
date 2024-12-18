package com.gotogether.domain.event.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.gotogether.domain.event.entity.Event;
import com.gotogether.domain.referencelink.entity.ReferenceLink;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EventDetailResponseDTO {
	private Long id;
	private String bannerImageUrl;
	private String title;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String location;
	private String description;
	private List<String> referenceLinks;

	public static EventDetailResponseDTO fromEntity(Event event) {
		List<String> links = event.getReferenceLinks().stream()
			.map(ReferenceLink::getToGoUrl)
			.collect(Collectors.toList());

		return EventDetailResponseDTO.builder()
			.id(event.getId())
			.bannerImageUrl(event.getBannerImageUrl())
			.title(event.getTitle())
			.startDate(event.getStartDate())
			.endDate(event.getEndDate())
			.location(event.getLocation())
			.description(event.getDescription())
			.referenceLinks(links)
			.build();
	}
}
