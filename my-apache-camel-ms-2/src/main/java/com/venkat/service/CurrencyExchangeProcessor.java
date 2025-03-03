package com.venkat.service;


import com.venkat.dto.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeProcessor {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeProcessor.class);

    public void process(CurrencyExchange currencyExchange) {
        logger.info("Processing currency exchange {}", currencyExchange.getConversionMultiple());
    }
}
