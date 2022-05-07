package com.zensar.olxapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxapplication.entity.UserInformation;

public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {

}
