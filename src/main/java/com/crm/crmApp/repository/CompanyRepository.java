package com.crm.crmApp.repository;


import com.crm.crmApp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}