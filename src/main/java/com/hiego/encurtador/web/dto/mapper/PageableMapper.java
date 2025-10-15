package com.hiego.encurtador.web.dto.mapper;

import com.hiego.encurtador.web.dto.PageableDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

public class PageableMapper {

    public PageableMapper() {
    }

    public static PageableDto toDto(Page page) {
        return new ModelMapper().map(page, PageableDto.class);
    }
}
