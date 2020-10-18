package dev.wakandaacademy.api.domain.wakander.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.api.domain.wakander.model.WakanderWeeklyPerformace;

@Repository
public interface WakanderWeeklyPerformaceRepository extends JpaRepository<WakanderWeeklyPerformace, Long>{
	
	@Query("SELECT per FROM WakanderWeeklyPerformace per "
			+ " JOIN FETCH per.wakander w "
			+ " WHERE w.code = ?1 "
			+ " AND per.startDate = (SELECT MAX(p.startDate) FROM WakanderWeeklyPerformace p WHERE p.wakander.code = ?1)")
	Optional<WakanderWeeklyPerformace> findCurrentWakanderWeeklyPerfomance(String wakanderCode);
	
}
