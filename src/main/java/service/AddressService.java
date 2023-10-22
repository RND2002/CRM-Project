package service;

import com.crm.crmApp.entity.Address;
import com.crm.crmApp.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<String> getCitiesList(){
        List<Address> addresses=addressRepository.findAll();
        Set<String> cities=new HashSet<String>();
        for(Address address:addresses){
            cities.add(address.getCity());
        }
        List<String> cityList=new ArrayList<>(cities);
        return cityList;
    }
}
