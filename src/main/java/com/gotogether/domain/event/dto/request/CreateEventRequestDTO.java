package com.gotogether.domain.event.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gotogether.domain.event.entity.Category;
import com.gotogether.domain.event.entity.OnlineType;

import lombok.Getter;

@Getter
public class CreateEventRequestDTO {
	@JsonProperty("hostChannelId")
	private Long hostChannelId;

	@JsonProperty("title")
	private String title;

	@JsonProperty("startDateTime")
	private LocalDateTime startDateTime;

	@JsonProperty("endDateTime")
	private LocalDateTime endDateTime;

	@JsonProperty("bannerImageUrl")
	private String bannerImageUrl;

	@JsonProperty("description")
	private String description;

	@JsonProperty("referenceLinks")
	private Map<String, String> referenceLinks;

	@JsonProperty("onlineType")
	private OnlineType onlineType;

	@JsonProperty("location")
	private String location;

	@JsonProperty("category")
	private Category category;

	@JsonProperty("hashtags")
	private List<String> hashtags;

	@JsonProperty("hostEmail")
	private String hostEmail;

	@JsonProperty("hostPhoneNumber")
	private String hostPhoneNumber;
}