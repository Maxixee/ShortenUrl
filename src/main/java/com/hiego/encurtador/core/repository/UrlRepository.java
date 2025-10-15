package com.hiego.encurtador.core.repository;

import com.hiego.encurtador.core.entity.Urls;
import com.hiego.encurtador.core.repository.projections.UrlProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Urls, String> {

    @Query("select u from Urls u")
    Page<UrlProjection> findAllPageable(Pageable pageable);
}
