package com.harsh.urlShortener.repository;

import com.harsh.urlShortener.model.Url;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UrlRepository {
    private Map<String, Url> urls = new HashMap<>();

    public void save(Url url) {
        urls.put(url.getShortCode(), url);
    }

    public Url findByShortCode(String shortCode) {
        return urls.get(shortCode);
    }
}
