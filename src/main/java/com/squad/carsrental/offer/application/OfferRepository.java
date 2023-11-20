package com.squad.carsrental.offer.application;

import com.squad.carsrental.offer.domain.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

interface OfferRepository extends JpaRepository<Offer, Long> {
}