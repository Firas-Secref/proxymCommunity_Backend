package com.proxymcommunity.proxymCommunity.repository;

import com.proxymcommunity.proxymCommunity.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

    @Query(value = "select * from Likes where post_Id = ?1", nativeQuery = true)
    List<Likes> getAlByPost_Id(Long id);

    @Transactional
    @Modifying
    @Query(value = "delete from Likes l where l.liker_Id=:likerId and l.post_Id=:postId", nativeQuery = true)
    int deleteLik(@Param("likerId") Long likerId,@Param("postId") Long postId);

}
