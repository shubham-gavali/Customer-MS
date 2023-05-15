package com.infosys.infytel.CustMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.infytel.CustMS.Entity.Customer;

public interface CustRepo extends JpaRepository<Customer, Long>{

	Customer findByPassword(String password);
}
