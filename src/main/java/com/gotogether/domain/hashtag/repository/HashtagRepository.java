package com.gotogether.domain.hashtag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotogether.domain.hashtag.entity.Hashtag;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

}
