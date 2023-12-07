package com.make.your.hands.dirty.common.repository;

// UserRepository.java
import com.make.your.hands.dirty.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

