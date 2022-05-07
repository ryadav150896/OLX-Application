package com.zensar.olxadvertiseapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxadvertiseapplication.entity.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

}
