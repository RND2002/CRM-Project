package service;

import com.crm.crmApp.entity.Role;
import com.crm.crmApp.entity.User;
import com.crm.crmApp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findBySuperVisor(User user) {
        return userRepository.findBySupervisor(user);
    }

    @Override
    public Double maxContractValue(User user) {
        Set<Role> roles=user.getRoles();
        Double max=0.00;
        for(Role role:roles){
            if(max<role.getMaxContractValue()){
                max= role.getMaxContractValue();;
            }
        }
        return max;
    }
}
