package com.hiego.encurtador.web.controller;

import com.hiego.encurtador.core.repository.projections.UrlProjection;
import com.hiego.encurtador.core.service.UrlService;
import com.hiego.encurtador.web.dto.PageableDto;
import com.hiego.encurtador.web.dto.UrlRequestDto;
import com.hiego.encurtador.web.dto.UrlResponseDto;
import com.hiego.encurtador.web.dto.mapper.PageableMapper;
import com.hiego.encurtador.web.dto.mapper.UrlMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    //encurta a url
    @PostMapping("/shorten-url")
    public ResponseEntity<UrlResponseDto> shortenUrl(@RequestBody UrlRequestDto dto,
                                                     HttpServletRequest servletRequest){

        return ResponseEntity.ok(UrlMapper.toDto(service.shortenUrl(dto, servletRequest)));
    }

    //Faz com que a url encontrada redirecione para a pag desejada
    @GetMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") String id){
        if(service.urlExistsById(id)){
            var url = service.getUrlById(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(url.get().getOriginalUrl()));

            service.incrementClicks(id);

            return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/links")
    public ResponseEntity<PageableDto> getAll(@PageableDefault(size = 5) Pageable pageable) {
        Page<UrlProjection> urls = service.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(urls));
    }

}
