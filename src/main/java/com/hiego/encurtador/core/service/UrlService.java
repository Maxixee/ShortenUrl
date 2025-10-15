package com.hiego.encurtador.core.service;

import com.hiego.encurtador.core.entity.Urls;
import com.hiego.encurtador.core.repository.UrlRepository;
import com.hiego.encurtador.core.repository.projections.UrlProjection;
import com.hiego.encurtador.web.dto.UrlRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Urls shortenUrl(UrlRequestDto dto, HttpServletRequest servletRequest){
        String id;
        do{
            id = RandomStringUtils.randomAlphanumeric(5,10);
        }while (repository.existsById(id));

        var redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", id);

        return repository.save(new Urls(id, redirectUrl, dto.getUrl(), 0));
    }

    @Transactional(readOnly = true)
    public boolean urlExistsById(String id){
        return repository.existsById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Urls> getUrlById(String id){
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<UrlProjection> getAll(Pageable pageable) {
        return repository.findAllPageable(pageable);
    }

    @Transactional
    public void incrementClicks(String id) {
        Urls url = getUrlById(id).orElseThrow(() -> new RuntimeException("URL not found"));
        url.setClicks(url.getClicks() + 1);
    }
}
