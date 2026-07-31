package com.harsh.urlShortener.controller;

import com.harsh.urlShortener.dto.CreateShortUrlRequest;
import com.harsh.urlShortener.dto.CreateShortUrlResponse;
import com.harsh.urlShortener.service.UrlService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public CreateShortUrlResponse createShortUrl(
            @RequestBody CreateShortUrlRequest request) {

        return urlService.createShortUrl(request);
    }
}
