package net.microservices.CurrencyConversion.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "currencyConversion")
public class CurrencyConversion
{
    @Id
    private String id;

    private String conversionKey;
    private String conversionName;
    private Integer conversionFactor;
    private Boolean status;
    private String createdBy;
    private String createdDate;
    private Boolean saved;

}