package com.hiego.encurtador.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Urls {

    public Urls() {
    }

    public Urls(String id, String shortUrl, String originalUrl, int clicks) {
        this.id = id;
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
        this.clicks = clicks;
    }

    @Id
    private String id;
    private String shortUrl;
    private String originalUrl;
    private int clicks;

    @Override
    public String toString() {
        return "Urls{" +
                "id=" + id +
                ", shortUrl='" + shortUrl + '\'' +
                ", originalUrl='" + originalUrl + '\'' +
                ", clicks=" + clicks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Urls urls = (Urls) o;
        return clicks == urls.clicks && Objects.equals(id, urls.id) && Objects.equals(shortUrl, urls.shortUrl) && Objects.equals(originalUrl, urls.originalUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortUrl, originalUrl, clicks);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }
}
