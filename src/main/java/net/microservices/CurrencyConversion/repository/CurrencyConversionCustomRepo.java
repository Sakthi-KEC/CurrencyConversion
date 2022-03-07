package net.microservices.CurrencyConversion.repository;

import net.microservices.CurrencyConversion.models.CurrencyConversion;
import reactor.core.publisher.Flux;

public interface CurrencyConversionCustomRepo
{
    Flux<CurrencyConversion> findByProperties(String conversionKey,
                                                    String conversionName,
                                                    Integer conversionFactor,
                                                    String createdBy,
                                                    String createdDate);
}
