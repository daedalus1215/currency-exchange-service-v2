package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange byFromAndTo = currencyExchangeRepository.findByFromAndTo(from, to);
        if (byFromAndTo == null) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }
        byFromAndTo.setEnvironment(environment.getProperty("server.port"));
        return byFromAndTo;
    }
}
