package com.squad.carsrental.offer.application;

import com.squad.carsrental.offer.domain.command.CreateOfferCommand;
import com.squad.carsrental.offer.domain.command.UpdateOfferCommand;
import com.squad.carsrental.offer.domain.dto.OfferDto;
import com.squad.carsrental.offer.web.OfferApi;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class OfferControllerApi implements OfferApi {

    private final OfferService offerService;

    @Override
    public Page<OfferDto> findAll(@PageableDefault Pageable pageable) {
        return offerService.findAll(pageable);
    }

    @Override
    public OfferDto findById(Long offerId) {
        return offerService.findById(offerId);
    }

    @Override
    public OfferDto saveOffer(CreateOfferCommand command) {
        return offerService.save(command);
    }

    @Override
    public OfferDto updateOffer(UpdateOfferCommand command) {
        return offerService.update(command);
    }

    @Override
    public void deleteOffer(Long offerId) {
        offerService.deleteOffer(offerId);
    }
}