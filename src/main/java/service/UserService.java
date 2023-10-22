package service;

import com.crm.crmApp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    User findByEmail(String email);

    void saveUser(User user);

    List<User> findAll();

    List<User> findBySuperVisor(User user);

    Double maxContractValue(User user);
}
