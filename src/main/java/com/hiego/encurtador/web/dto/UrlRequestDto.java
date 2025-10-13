package com.hiego.encurtador.web.dto;

public class UrlRequestDto {

    public UrlRequestDto() {
    }

    public UrlRequestDto(String url) {
        this.url = url;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
