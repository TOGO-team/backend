package com.togoteam.gotogether.domain.user.entity;

import com.togoteam.gotogether.global.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@Column(name = "email", nullable = false)
	private String email;
}