package com.venkat.service;


import com.venkat.dto.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyExchangeTransformer {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeTransformer.class);

    public CurrencyExchange transform(CurrencyExchange currencyExchange) {
        currencyExchange.setConversionMultiple(currencyExchange.getConversionMultiple().multiply(new BigDecimal(2)));
        logger.info("Transforming currency exchange {}", currencyExchange.getConversionMultiple());
        return currencyExchange;
    }
}
