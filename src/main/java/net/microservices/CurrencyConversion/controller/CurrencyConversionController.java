package net.microservices.CurrencyConversion.controller;


import net.microservices.CurrencyConversion.dto.CurrencyConversionDto;
import net.microservices.CurrencyConversion.services.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/currencyconversion")
public class CurrencyConversionController
{
    @Autowired
    private CurrencyConversionService service;


    @PostMapping()
    public Mono<CurrencyConversionDto> addCurrencyConversion(@RequestBody Mono<CurrencyConversionDto> currency)
    {
        return service.addCurrencyConversion(currency);
    }

    @PutMapping("/edit/{id}")
    public Mono<CurrencyConversionDto> editCurrencyConverison(@RequestBody Mono<CurrencyConversionDto> currency, @PathVariable String id)
    {
        return service.editCurrencyConverison(currency,id);
    }

    @PutMapping("/savedsearch")
    public Mono<CurrencyConversionDto> addSearchedCurrencyConverison(@RequestBody Mono<CurrencyConversionDto> currency)
    {
        return service.addSearchedCurrencyConverison(currency);
    }

    @GetMapping()
    public Flux<CurrencyConversionDto> getAllCurrencyConversion()
    {
        return service.getAllCurrencyConversion();
    }

    @GetMapping("/search")
    public Flux<CurrencyConversionDto> getCurrencyConverisonByDynamicSearch(@RequestParam(required = false) String conversionKey,
                                                                            @RequestParam(required = false) String conversionName,
                                                                            @RequestParam(required = false) Integer conversionFactor,
                                                                            @RequestParam(required = false) String createdBy,
                                                                            @RequestParam(required = false) String createdDate)
    {
        return service.getCurrencyConverisonByDynamicSearch(conversionKey,conversionName,conversionFactor,createdBy,createdDate);
    }

    @GetMapping("/savedsearch/keys")
    public Mono<List<String>> getAllSavedConversionKey()
    {
        return service.getAllSavedConversionKey();
    }

    @GetMapping("/key/{key}")
    public Flux<CurrencyConversionDto> getSavedUnNumberByUnGroupCode(@PathVariable String key)
    {
        return service.getSavedCurrencyByConversionKey(key);
    }

}