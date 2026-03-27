package com.partition.repository;

import com.partition.entity.UserInactive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInactiveRepository extends JpaRepository<UserInactive, Long> {
}
