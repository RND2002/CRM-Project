package com.crm.crmApp.repository;

import com.crm.crmApp.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long> {

}
