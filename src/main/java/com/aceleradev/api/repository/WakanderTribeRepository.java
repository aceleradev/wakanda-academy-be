package com.aceleradev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceleradev.api.domain.model.WakanderTribe;
import com.aceleradev.api.domain.model.ids.WakanderTribeId;

public interface WakanderTribeRepository extends JpaRepository<WakanderTribe,WakanderTribeId> {
}
