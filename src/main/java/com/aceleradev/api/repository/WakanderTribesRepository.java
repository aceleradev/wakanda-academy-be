package com.aceleradev.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aceleradev.api.domain.model.WakanderTribe;

public interface WakanderTribesRepository extends JpaRepository<WakanderTribe,Long> {

    @Query("SELECT wktribe FROM WakanderTribe wktribe join wktribe.wakander wk WHERE wk.code=:wakanderCode")
    List<WakanderTribe> listUnlockedTribes(@Param("wakanderCode") String wakanderCode);
    
    @Query("SELECT wktribe FROM WakanderTribe AS wktribe JOIN wktribe.wakander AS wk JOIN wktribe.wakanderTribeSkills wkts"
    		+ "JOIN wkts.wakanderTribeSkillLessons wktsl "
    		+ "WHERE wk.code =:wakanderCode AND wkts.id =:tribeCode AND wktsl.id = :tribeCode")
	Optional<WakanderTribe> findWakanderByCodeAndTribeByCode(@Param("wakanderCode") String wakanderCode, @Param("tribeCode") String tribeCode);
    
    

    
}
