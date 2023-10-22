package com.crm.crmApp.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.crm.crmApp.entity.Client;
import com.crm.crmApp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByTimeAfter(LocalDateTime dateTime);
    List<Event> findByTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Event> findByClient(Client client);

}
