package com.proxymcommunity.proxymCommunity.repository;

import com.proxymcommunity.proxymCommunity.entity.Publication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

    List<Publication> findByDeveloper_Id(Long id, Sort by);
}
