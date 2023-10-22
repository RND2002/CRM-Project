package com.crm.crmApp.repository;

import com.crm.crmApp.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

}
