package net.microservices.CurrencyConversion.repository;

import net.microservices.CurrencyConversion.models.CurrencyConversion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface CurrencyConversionRepository extends ReactiveMongoRepository<CurrencyConversion,String>
{
    Flux<CurrencyConversion> findByconversionKeyIgnoreCase(String key);
    Flux<CurrencyConversion> findByStatus(boolean b);
}
