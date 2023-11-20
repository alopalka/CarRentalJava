package com.squad.carsrental.offer.application;

import com.squad.carsrental.advice.EntityNotFoundException;
import com.squad.carsrental.offer.domain.command.CreateOfferCommand;
import com.squad.carsrental.offer.domain.command.UpdateOfferCommand;
import com.squad.carsrental.offer.domain.dto.OfferDto;
import com.squad.carsrental.offer.domain.entity.Offer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class OfferService {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;

    @Transactional(readOnly = true)
    public Page<OfferDto> findAll(Pageable pageable) {
        return offerRepository.findAll(pageable)
                .map(offerMapper::toDto);
    }

    @Transactional(readOnly = true)
    public OfferDto findById(Long id) {

        return offerRepository.findById(id)
                .map(offerMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(Offer.class.getSimpleName(), id));
    }

    OfferDto save(CreateOfferCommand command) {
        var offerEntity = offerMapper.toEntity(command);
        var savedOffer = offerRepository.save(offerEntity);
        return offerMapper.toDto(savedOffer);
    }

    @Transactional
    public OfferDto update(UpdateOfferCommand command) {
        var offerToUpdate = offerRepository.findById(command.getId())
                .map(offer -> offerMapper.toEntity(offer, command))
                .orElseThrow(() -> new EntityNotFoundException(Offer.class.getSimpleName(), command.getId()));
        return offerMapper.toDto(offerRepository.saveAndFlush(offerToUpdate));
    }

    void deleteOffer(Long offerId) {
        offerRepository.deleteById(offerId);
    }

}