package com.dk.tasks.persistence.repo;

import com.dk.tasks.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

    @Query(value = "select c from CustomerEntity c where c.taxCode = :taxCode OR c.phone = :phone")
    Optional<CustomerEntity> findByTaxCodeOrPhone(String taxCode, String phone);
}
