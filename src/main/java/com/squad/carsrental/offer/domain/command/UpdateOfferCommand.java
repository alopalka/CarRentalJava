package com.squad.carsrental.offer.domain.command;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateOfferCommand {

    @NotNull(message = "ID_NOT_NULL")
    private Long id;

    @NotBlank(message = "DESCRIPTION_NOT_NULL")
    @Size(min = 15, max = 20000, message = "DESCRIPTION_WRONG_SIZE")
    private String description;

    @DecimalMin(value = "0.0", message = "PRICE_LESS_THEN_ONE")
    private BigDecimal price;
}