package com.crm.crmApp.repository;

import com.crm.crmApp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
