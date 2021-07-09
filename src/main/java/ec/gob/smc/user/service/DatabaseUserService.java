package ec.gob.smc.user.service;

import ec.gob.smc.domain.PrivilegioPerfil;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.smc.domain.User;
import ec.gob.smc.security.UserService;
import ec.gob.smc.user.repository.PrivilegioPerfilRepository;
import ec.gob.smc.user.repository.UserRepository;
import java.util.List;

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
    private final PrivilegioPerfilRepository privilegioPerfilRepository;
    
    @Autowired
    public DatabaseUserService(UserRepository userRepository,
            PrivilegioPerfilRepository privilegioPerfilRepository) {
        this.userRepository = userRepository;
        this.privilegioPerfilRepository = privilegioPerfilRepository;
    }
    
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public List<PrivilegioPerfil> getRoles(Long userId) {
        List<PrivilegioPerfil> roles = this.privilegioPerfilRepository.findAllByUserId(userId);
        return roles;
    }
}
