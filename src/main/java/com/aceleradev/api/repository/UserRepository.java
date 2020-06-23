package com.aceleradev.api.repository;

import com.aceleradev.api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
