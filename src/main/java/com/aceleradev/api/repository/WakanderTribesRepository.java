package com.aceleradev.api.repository;

import com.aceleradev.api.domain.model.WakanderTribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WakanderTribesRepository extends JpaRepository<WakanderTribe,Long> {

    @Query("SELECT wktribe.tribe FROM WakanderTribe wktribe join wktribe.wakander wk WHERE wk.code=:wakanderCode")
    List<WakanderTribe> listUnlockedTribes(@Param("wakanderCode") String wakanderCode);

}
