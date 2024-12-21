package com.gotogether.domain.event.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EventListResponseDTO {
	private Long id;
	private String bannerImageUrl;
	private String title;
	private String hostChannelName;
	private LocalDateTime startDate;
	private String location;
	private List<String> hashtags;
}
