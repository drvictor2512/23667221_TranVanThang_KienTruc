package com.partition.repository;

import com.partition.entity.UserSuspended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSuspendedRepository extends JpaRepository<UserSuspended, Long> {
}
