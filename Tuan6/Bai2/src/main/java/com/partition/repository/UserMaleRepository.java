package com.partition.repository;

import com.partition.entity.UserMale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMaleRepository extends JpaRepository<UserMale, Long> {
}
