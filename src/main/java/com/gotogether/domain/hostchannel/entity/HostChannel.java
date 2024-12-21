package com.gotogether.domain.hostchannel.entity;

import java.util.List;

import com.gotogether.domain.channelorganizer.entity.ChannelOrganizer;
import com.gotogether.domain.event.entity.Event;
import com.gotogether.global.common.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "host_channel")
public class HostChannel extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "profile_image_url", nullable = false)
	private String profileImageUrl;

	@OneToMany(mappedBy = "hostChannel", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Event> events;

	@OneToMany(mappedBy = "hostChannel", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<ChannelOrganizer> channelOrganizers;

	@Builder
	public HostChannel(String name, String email, String description, String profileImageUrl) {
		this.name = name;
		this.email = email;
		this.description = description;
		this.profileImageUrl = profileImageUrl;
	}
}
