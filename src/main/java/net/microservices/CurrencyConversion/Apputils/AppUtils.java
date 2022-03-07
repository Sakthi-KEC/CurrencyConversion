package net.microservices.CurrencyConversion.Apputils;


import net.microservices.CurrencyConversion.dto.CurrencyConversionDto;
import net.microservices.CurrencyConversion.models.CurrencyConversion;
import org.springframework.beans.BeanUtils;


public class AppUtils
{
    public static CurrencyConversionDto EntityToDto(CurrencyConversion currencyConversion)
    {
        CurrencyConversionDto currencyConversionDto=new CurrencyConversionDto();
        BeanUtils.copyProperties(currencyConversion,currencyConversionDto);
        return currencyConversionDto;
    }
    public static CurrencyConversion DtoToEntity(CurrencyConversionDto currencyConversionDto)
    {
        CurrencyConversion currencyConversion = new CurrencyConversion();
        BeanUtils.copyProperties(currencyConversionDto,currencyConversion);
        return currencyConversion;
    }
}

