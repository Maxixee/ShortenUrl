package com.hiego.encurtador.core.repository;

import com.hiego.encurtador.core.entity.Urls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlsRepository extends JpaRepository<Urls, String> {
}
