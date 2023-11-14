package com.example.demo.offer.application;

import com.example.demo.offer.domain.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

interface OfferRepository extends JpaRepository<Long, Offer> {
}