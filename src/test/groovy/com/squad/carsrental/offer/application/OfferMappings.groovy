package com.squad.carsrental.offer.application

import com.squad.carsrental.offer.domain.entity.Offer
import spock.lang.Specification
import spock.lang.Subject

class OfferMappings extends Specification {

    OfferRepository offerRepository = Mock()

    OfferMapper offerMapper = new OfferMapperImpl()

    @Subject
    OfferService offerService = new OfferService(offerRepository, offerMapper)

    def "should map correctly from entity to dto"() {
        given:
        def offerEntity = OfferFaker.offerEntity()
        offerRepository.findById(_ as Long) >> Optional.of(offerEntity)

        when:
        def offerDto = offerService.findById(1L)

        then:
        offerDto.description() == offerEntity.getDescription()
        offerDto.price() == offerEntity.getPrice()
    }

    def "should map correctly from create command to dto"() {
        given:
        def createOfferCommand = OfferFaker.createOfferCommand()
        def offerEntity = OfferFaker.offerEntity(createOfferCommand.getDescription(), createOfferCommand.getPrice())
        offerRepository.save(_ as Offer) >> offerEntity

        when:
        def offerDto = offerService.save(createOfferCommand)

        then:
        offerDto.description() == offerEntity.getDescription()
        offerDto.price() == offerEntity.getPrice()
    }

    def "should map correctly from update command to dto"() {
        given:
        def updateOfferCommand = OfferFaker.updateOfferCommand()
        def offerEntity = OfferFaker.offerEntity("test", BigDecimal.ONE)
        def offerUpdatedEntity = OfferFaker.offerEntity(updateOfferCommand.getId(), updateOfferCommand.getDescription(), updateOfferCommand.getPrice())
        offerRepository.findById(_ as Long) >> Optional.of(offerEntity)
        offerRepository.saveAndFlush(_ as Offer) >> offerUpdatedEntity

        when:
        def offerDto = offerService.update(updateOfferCommand)

        then:
        offerDto.id() == updateOfferCommand.getId()
        offerDto.description() == updateOfferCommand.getDescription()
        offerDto.price() == updateOfferCommand.getPrice()
    }
}