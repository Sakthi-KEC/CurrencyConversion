package net.microservices.CurrencyConversion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyConversionDto
{
    private String id;
    private String conversionKey;
    private String conversionName;
    private Integer conversionFactor;
    private Boolean status;
    private String createdBy;
    private String createdDate;
    private Boolean saved;
}