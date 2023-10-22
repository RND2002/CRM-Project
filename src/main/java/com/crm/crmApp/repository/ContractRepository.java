package com.crm.crmApp.repository;

import java.util.List;

import com.crm.crmApp.entity.Client;
import com.crm.crmApp.entity.Contract;
import com.crm.crmApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByClient(Client client);
    List<Contract> findByAcceptedBy(User user);

}

