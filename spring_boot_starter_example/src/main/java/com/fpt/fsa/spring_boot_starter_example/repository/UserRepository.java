package com.fpt.fsa.spring_boot_starter_example.repository;

import com.fpt.fsa.spring_boot_starter_example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
