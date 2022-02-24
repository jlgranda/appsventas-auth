package org.jlgranda.appsventas.user.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.jlgranda.appsventas.security.UserService;
import org.jlgranda.appsventas.user.repository.UserRepository;
import java.util.List;
import org.jlgranda.appsventas.domain.Subject;
import org.jlgranda.appsventas.domain.UsersRoles;
import org.jlgranda.appsventas.domain.UsersRolesPK;

/**
 * Mock implementation.
 * 
 * @author vladimir.stankovic
 *
 * Aug 4, 2016
 */
@Service
public class DatabaseUserService implements UserService {
    private final UserRepository userRepository;
    
    @Autowired
    public DatabaseUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public Optional<Subject> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    //TODO extraer los roles desde el sistema
    @Override
    public List<UsersRoles> getRoles(Long userId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        UsersRoles role = new UsersRoles();
        role.setUsersRolesPK(new UsersRolesPK("jlgranda81@gmail.com", "USER"));
        List<UsersRoles> roles = new ArrayList<>();
        roles.add(role);
        return roles;
    }

}
