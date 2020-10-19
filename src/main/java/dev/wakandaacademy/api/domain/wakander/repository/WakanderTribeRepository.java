package dev.wakandaacademy.api.domain.wakander.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;

public interface WakanderTribeRepository extends JpaRepository<WakanderTribe,Long> {

	@Query(name = "WakanderTribe.listUnlockedTribes")
    List<WakanderTribe> listUnlockedTribes(@Param("wakanderCode") String wakanderCode);
    
    @Query(name = "WakanderTribe.findWakanderByCodeAndTribeByCode")
	Optional<WakanderTribe> findWakanderByCodeAndTribeByCode(@Param("wakanderCode") String wakanderCode, @Param("tribeCode") String tribeCode);
    
}
