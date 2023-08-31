package com.internationalsaas.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internationalsaas.customers.pojo.CustomerPOJO;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerPOJO, Long>{

}
