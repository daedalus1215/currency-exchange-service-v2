package com.in28minutes.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "default", fallbackMethod = "  hardcodedResponse")
//    @CircuitBreaker(name="default", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "default") // 10s => 1000 calls to the sample api
    @Bulkhead(name="sample-api")
    public String sampleApi() throws Exception {
        logger.info("Sample Api call received");
        final ResponseEntity<String> forEntity = new RestTemplate()
                .getForEntity("http://localhost-not-going-to-work", String.class);
        return "simple-api";
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}
