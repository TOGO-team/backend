package com.gotogether.domain.event.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gotogether.domain.event.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	Optional<Event> findByIdAndIsDeletedFalse(Long eventId);

	@Query("SELECT e FROM Event e WHERE e.endDate >= CURRENT_TIMESTAMP ORDER BY e.endDate ASC")
	Page<Event> findDeadlineEvents(Pageable pageable);

	@Query("SELECT e FROM Event e WHERE e.endDate >= CURRENT_TIMESTAMP ORDER BY e.createdAt DESC")
	Page<Event> findCurrentEvents(Pageable pageable);

	@Query("SELECT e FROM Event e LEFT JOIN e.tickets t ON t.isDeleted = false GROUP BY e ORDER BY COUNT(t) DESC")
	Page<Event> findPopularEvents(Pageable pageable);
}
