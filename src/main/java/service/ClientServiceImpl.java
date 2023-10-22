package service;

import com.crm.crmApp.security.AuthenticationFacade;
import com.crm.crmApp.entity.Client;
import com.crm.crmApp.entity.User;
import com.crm.crmApp.repository.AddressRepository;
import com.crm.crmApp.repository.ClientRepository;
import com.crm.crmApp.repository.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ClientServiceImpl implements ClientService{

    @Autowired
    private AuthenticationFacade authenticationFacade;

    private final ClientRepository clientRepository;
    private final ContactPersonRepository contactPersonRepository;
    private final AddressRepository addressRepository;

    public ClientServiceImpl(ClientRepository clientRepository,
                             ContactPersonRepository contactPersonRepository, AddressRepository addressRepository) {
        this.clientRepository = clientRepository;
        this.contactPersonRepository = contactPersonRepository;
        this.addressRepository = addressRepository;
    }
    @Override
    public Client findById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public Client findByName(String name) {
        return clientRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<String> getStatusList() {
        List<String> statusList= Arrays.asList("lead","clinet","lost");
        return statusList;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public Long saveClientWithLoggedUser(Client client) {
        User user=authenticationFacade.getAuthenticatedUser();
        client.setUser(user);
        client.setCreated(LocalDateTime.now());
        clientRepository.save(client);
        return client.getId();
    }

    @Override
    public Long saveClient(Client client) {
        client.setCreated(LocalDateTime.now());
        clientRepository.save(client);
        return client.getId();

    }

    @Override
    public List<Client> findByUser(User user) {
        return clientRepository.findByUser(user);
    }
}
