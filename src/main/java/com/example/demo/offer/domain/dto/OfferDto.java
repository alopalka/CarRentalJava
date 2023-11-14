package com.example.demo.offer.domain.dto;

import java.math.BigDecimal;

public record OfferDto(Long id, String description, BigDecimal price) {
}