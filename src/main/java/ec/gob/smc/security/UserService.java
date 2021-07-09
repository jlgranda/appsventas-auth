package ec.gob.smc.security;

import ec.gob.smc.domain.PrivilegioPerfil;
import ec.gob.smc.domain.User;
import java.util.List;
import java.util.Optional;


/**
 * 
 * @author vladimir.stankovic
 *
 * Aug 17, 2016
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
    public List<PrivilegioPerfil> getRoles(Long userId);
}
