package net.microservices.CurrencyConversion.services;

import net.microservices.CurrencyConversion.dto.CurrencyConversionDto;
import net.microservices.CurrencyConversion.exception.CustomException;
import net.microservices.CurrencyConversion.repository.CurrencyConversionCustomRepo;
import net.microservices.CurrencyConversion.repository.CurrencyConversionRepository;
import net.microservices.CurrencyConversion.Apputils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CurrencyConversionService
{
    @Autowired
    private CurrencyConversionRepository repository;
    @Autowired
    private CurrencyConversionCustomRepo customRepo;


    // Adding currency conversion into repo
    public Mono<CurrencyConversionDto> addCurrencyConversion(Mono<CurrencyConversionDto> currency)
    {
        return currency.map(AppUtils::DtoToEntity)
                .flatMap(repository::insert).map(AppUtils::EntityToDto);
    }

    // Editing the currency conversion by updating old record and inserting the new record
    public Mono<CurrencyConversionDto> editCurrencyConverison(Mono<CurrencyConversionDto> currency, String id)
    {
        Mono<CurrencyConversionDto> r = repository.findById(id).map(AppUtils::EntityToDto);

        repository.findById(id)
                .flatMap(p -> r.map(AppUtils::DtoToEntity))
                .doOnNext(e -> e.setStatus(false))
                .flatMap(repository::save)
                .map(AppUtils::EntityToDto).subscribe();

        return currency.map(AppUtils::DtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtils::EntityToDto);
    }

    // Updating the Saved Status for the searched currency converison
    public Mono<CurrencyConversionDto> addSearchedCurrencyConverison(Mono<CurrencyConversionDto> currency)
    {
        return  currency.map(AppUtils::DtoToEntity)
                .flatMap(repository::save)
                .map(AppUtils::EntityToDto);
    }

    // getting all active currency conversion
    public Flux<CurrencyConversionDto> getAllCurrencyConversion()
    {
        return repository
                .findByStatus(true)
                .map(AppUtils::EntityToDto);
    }

    // Getting currency conversion by dynamic search
    public Flux<CurrencyConversionDto> getCurrencyConverisonByDynamicSearch(String conversionKey, String conversionName, Integer conversionFactor, String createdBy, String createdDate)
    {
        return customRepo
                .findByProperties(conversionKey,conversionName,conversionFactor,createdBy,createdDate)
                .filter(a->a.getStatus()==true)
                .map(AppUtils::EntityToDto);
    }

    // Getting all saved conversionKey
    public Mono<List<String>> getAllSavedConversionKey()
    {
        return repository
                .findAll()
                .filter(a->a.getSaved()==true)
                .filter(a->a.getStatus()==true)
                .map(AppUtils::EntityToDto)
                .map(a->a.getConversionKey())
                .distinct()
                .collect(Collectors.toList());
    }

    // Getting Currency Conversion by using conversionKey
    public Flux<CurrencyConversionDto> getSavedCurrencyByConversionKey(String key)
    {
        return repository.findByconversionKeyIgnoreCase(key)
                .filter(a->a.getStatus()==true)
                .filter(a->a.getSaved()==true)
                .map(AppUtils::EntityToDto)
                .switchIfEmpty(Mono.defer(()->Mono.error(new CustomException("Conversion Key Not Found"))));
    }

}