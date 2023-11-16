package com.squad.carsrental.offer.application;

import com.squad.carsrental.offer.domain.command.CreateOfferCommand;
import com.squad.carsrental.offer.domain.command.UpdateOfferCommand;
import com.squad.carsrental.offer.domain.dto.OfferDto;
import com.squad.carsrental.offer.domain.entity.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
interface OfferMapper {

    OfferDto toDto(Offer offer);

    Offer toEntity(CreateOfferCommand command);

    Offer toEntity(@MappingTarget Offer offer, UpdateOfferCommand command);
}
