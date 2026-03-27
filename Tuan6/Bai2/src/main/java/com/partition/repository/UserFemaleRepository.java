package com.partition.repository;

import com.partition.entity.UserFemale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFemaleRepository extends JpaRepository<UserFemale, Long> {
}
