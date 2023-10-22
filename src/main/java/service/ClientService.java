package service;

import com.crm.crmApp.entity.Client;
import com.crm.crmApp.entity.User;

import java.util.List;

public interface ClientService {

    Client findById(Long id);

    Client findByName(String name);

    List<Client> findAll();

    List<String> getStatusList();

    void deleteClient(Long id);
    Long saveClientWithLoggedUser(Client client);

    Long saveClient(Client client);

    List<Client> findByUser(User user);

}
