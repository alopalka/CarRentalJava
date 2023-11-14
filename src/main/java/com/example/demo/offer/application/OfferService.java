package com.example.demo.offer.application;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class OfferService {

    private final OfferRepository offerRepository;
}