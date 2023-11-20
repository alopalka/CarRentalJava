package com.squad.carsrental.offer.application

import com.squad.carsrental.offer.domain.command.CreateOfferCommand
import com.squad.carsrental.offer.domain.command.UpdateOfferCommand
import com.squad.carsrental.offer.domain.entity.Offer

class OfferFaker {

    static def offerEntity() {
        return Offer.builder()
                .description("OfferTest")
                .price(BigDecimal.TEN)
                .build()
    }

    static def offerEntity(String description, BigDecimal price) {
        return Offer.builder()
                .description(description)
                .price(price)
                .build()
    }

    static def offerEntity(Long id, String description, BigDecimal price) {
        def offer = offerEntity(description, price)
        offer.setId(id)
        return offer
    }

    static def createOfferCommand() {
        def createOfferCommand = new CreateOfferCommand()
        createOfferCommand.setDescription("CreateOfferCommand")
        createOfferCommand.setPrice(BigDecimal.TEN)
        return createOfferCommand
    }

    static def updateOfferCommand() {
        def updateOfferCommand = new UpdateOfferCommand()
        updateOfferCommand.setId(1L)
        updateOfferCommand.setDescription("UpdateOfferCommand")
        updateOfferCommand.setPrice(BigDecimal.TEN)
        return updateOfferCommand
    }
}