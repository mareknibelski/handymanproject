package pl.coderslab.handyman.service;

import pl.coderslab.handyman.entity.Handyman;
import pl.coderslab.handyman.entity.Role;
import pl.coderslab.handyman.entity.User;
import pl.coderslab.handyman.repository.HandymanRepository;
import pl.coderslab.handyman.repository.RoleRepository;
import pl.coderslab.handyman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    private HandymanRepository handymanRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

//    public User saveAdmin(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setActive(1);
//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//        return userRepository.save(user);
//    }
//
//    public Handyman findHandymanByEmail(String email) {
//        return handymanRepository.findByEmail(email);
//    }
//
//    public Handyman saveHandyman(Handyman handyman) {
//        handyman.setPassword(bCryptPasswordEncoder.encode(handyman.getPassword()));
//        handyman.setActive(1);
//        Role handymanRole = roleRepository.findByRole("HANDYMAN");
//        handyman.setRoles(new HashSet<Role>(Arrays.asList(handymanRole)));
//        return handymanRepository.save(handyman);
//    }

}