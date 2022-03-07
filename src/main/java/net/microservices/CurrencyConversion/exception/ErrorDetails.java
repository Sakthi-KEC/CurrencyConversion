package net.microservices.CurrencyConversion.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails
{
    private String errorMessage;
    private String Details;
}

