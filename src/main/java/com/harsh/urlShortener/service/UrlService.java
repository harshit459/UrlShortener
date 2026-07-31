package com.harsh.urlShortener.service;

import com.harsh.urlShortener.dto.CreateShortUrlRequest;
import com.harsh.urlShortener.dto.CreateShortUrlResponse;
import com.harsh.urlShortener.model.Url;
import com.harsh.urlShortener.repository.UrlRepository;
import com.harsh.urlShortener.util.Base62Encoder;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private final UrlRepository repository;
    private final Base62Encoder encoder;

    private long idCounter = 1;

    public UrlService(UrlRepository repository,
                      Base62Encoder encoder) {

        this.repository = repository;
        this.encoder = encoder;
    }

    public CreateShortUrlResponse createShortUrl(CreateShortUrlRequest request) {

        long id = idCounter++;

        String shortCode = encoder.encode(id);

        Url url = new Url(
                id,
                request.getOriginalUrl(),
                shortCode
        );

        repository.save(url);

        return new CreateShortUrlResponse(
                "http://localhost:8080/" + shortCode
        );
    }
}
