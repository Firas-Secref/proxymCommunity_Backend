package com.proxymcommunity.proxymCommunity.repository;

import com.proxymcommunity.proxymCommunity.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Developer findDeveloperByUsername(String username);
    Developer findDeveloperById(Long id);

}
