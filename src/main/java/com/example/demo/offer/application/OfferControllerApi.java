package com.example.demo.offer.application;

import com.example.demo.offer.domain.command.CreateOfferCommand;
import com.example.demo.offer.domain.command.UpdateOfferCommand;
import com.example.demo.offer.domain.dto.OfferDto;
import com.example.demo.offer.web.OfferApi;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class OfferControllerApi implements OfferApi {

    private final OfferService offerService;

    @Override
    public Page<OfferDto> findAll(Pageable pageable) {
        throw new NotImplementedException();
    }

    @Override
    public OfferDto findById(Long offerId) {
        throw new NotImplementedException();
    }

    @Override
    public OfferDto saveOffer(CreateOfferCommand command) {
        throw new NotImplementedException();
    }

    @Override
    public OfferDto updateOffer(UpdateOfferCommand command) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteOffer(Long offerId) {
        throw new NotImplementedException();
    }
}