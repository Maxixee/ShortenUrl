package com.hiego.encurtador.core.repository.projections;

public interface UrlProjection {

    String getShortUrl();
    String getOriginalUrl();
    int getClicks();
}
