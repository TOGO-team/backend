package com.gotogether.domain.hostchannel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gotogether.domain.hostchannel.entity.HostChannel;

@Repository
public interface HostChannelRepository extends JpaRepository<HostChannel, Long> {
	Optional<HostChannel> findByIdAndIsDeletedFalse(Long hostChannelId);

}
