package com.crm.crmApp.repository;


import com.crm.crmApp.entity.Event;
import com.crm.crmApp.entity.Notification;
import com.crm.crmApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Notification findFirstByEventOrderByCreatedDesc(Event event);
    List<Notification> findByEvent(Event event);
    List<Notification> findByUser(User user);

}
