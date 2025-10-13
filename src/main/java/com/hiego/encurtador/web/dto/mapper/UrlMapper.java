package com.hiego.encurtador.web.dto.mapper;

import com.hiego.encurtador.core.entity.Urls;
import com.hiego.encurtador.web.dto.UrlResponseDto;

public class UrlMapper {

    public static UrlResponseDto toDto(Urls url){
        UrlResponseDto dto = new UrlResponseDto();
        dto.setOriginalUrl(url.getOriginalUrl());
        dto.setShortUrl(url.getShortUrl());

        return dto;
    }
}
