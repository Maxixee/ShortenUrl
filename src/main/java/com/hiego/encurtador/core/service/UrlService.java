package com.hiego.encurtador.core.service;

import com.hiego.encurtador.core.entity.Urls;
import com.hiego.encurtador.core.repository.UrlsRepository;
import com.hiego.encurtador.web.dto.UrlRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class UrlService {

    private final UrlsRepository repository;

    public UrlService(UrlsRepository repository) {
        this.repository = repository;
    }

    /*static String shortURL(int n) {
        // Map to store 62 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuffer shorturl = new StringBuffer();

        // Convert given integer id to a base 62 number
        while (n > 0) {
            // use above map to store actual character
            // in short url
            shorturl.append(map[n % 62]);
            n = n / 62;
        }

        // Reverse shortURL to complete base conversion
        return shorturl.reverse().toString();
    }*/

    public Urls shortenUrl(UrlRequestDto dto, HttpServletRequest servletRequest){
        String id;
        do{
            id = RandomStringUtils.randomAlphanumeric(5,10);
        }while (repository.existsById(id));

        var redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", id);

        return repository.save(new Urls(id, redirectUrl, dto.getUrl(), 0));
    }

    public boolean urlExistsById(String id){
        return repository.existsById(id);
    }

    public Optional<Urls> getUrlById(String id){
        return repository.findById(id);
    }
}
