package com.crm.crmApp.repository;


import java.util.List;

import com.crm.crmApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findBySupervisor(User user);

}
