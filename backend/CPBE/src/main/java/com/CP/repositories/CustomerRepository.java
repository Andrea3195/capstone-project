package com.CP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CP.entities.Customer;

public interface CustomerRepository extends JpaRepository <Customer, Long> {

}
