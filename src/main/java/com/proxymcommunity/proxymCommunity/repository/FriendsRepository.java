package com.proxymcommunity.proxymCommunity.repository;

import com.proxymcommunity.proxymCommunity.entity.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {

}
