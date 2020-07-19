package com.aceleradev.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aceleradev.api.domain.model.WakanderTribe;

public interface WakanderTribeRepository extends JpaRepository<WakanderTribe,Long> {

    @Query("SELECT wktribe FROM WakanderTribe wktribe join wktribe.wakander wk WHERE wk.code=:wakanderCode")
    List<WakanderTribe> listUnlockedTribes(@Param("wakanderCode") String wakanderCode);

}
