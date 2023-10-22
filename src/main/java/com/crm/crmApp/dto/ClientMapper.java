package com.crm.crmApp.dto;

import com.crm.crmApp.entity.Address;
import com.crm.crmApp.entity.Client;
import com.crm.crmApp.entity.ContactPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.ClientService;
import service.UserService;

@Component
public class ClientMapper {


     UserService userService;


     ClientService clientService;



    public ClientDto toDto(Client client){
        ClientDto clientDto=new ClientDto();
        clientDto.setName(client.getName());
        clientDto.setStatus(client.getStatus());
        clientDto.setNip(client.getNip());
        clientDto.setContactFirstName(client.getContactPerson().getFirstname());
        clientDto.setContactLastName(client.getContactPerson().getLastname());
        clientDto.setContactEmail(client.getContactPerson().getEmail());
        clientDto.setContactPhone(client.getContactPerson().getPhone());
        clientDto.setCountry(client.getAddress().getCountry());
        clientDto.setRegion(client.getAddress().getRegion());
        clientDto.setCity(client.getAddress().getCity());
        clientDto.setStreet(client.getAddress().getStreet());
        clientDto.setPostCode(client.getAddress().getPostcode());
        clientDto.setUserEmail(client.getUser().getEmail());

        return clientDto;
    }


    public Client toEntity(ClientDto clientDto) {
        Client client = new Client();

        client.setName(clientDto.getName());
        client.setStatus(clientDto.getStatus());
        client.setNip(clientDto.getNip());
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setFirstname(clientDto.getContactFirstName());
        contactPerson.setLastname(clientDto.getContactLastName());
        contactPerson.setEmail(clientDto.getContactEmail());
        contactPerson.setPhone(clientDto.getContactPhone());
        client.setContactPerson(contactPerson);
        Address address = new Address();
        address.setCountry(clientDto.getCountry());
        address.setRegion(clientDto.getRegion());
        address.setCity(clientDto.getCity());
        address.setStreet(clientDto.getStreet());
        address.setPostcode(clientDto.getPostCode());
        client.setAddress(address);

        try {
            client.setUser(userService.findByEmail(clientDto.getUserEmail()));
        } catch (NullPointerException e) {
            e.getMessage();
            e.printStackTrace();
        }

        return client;
    }
}
