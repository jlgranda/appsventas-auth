package org.jlgranda.appsventas.security;

import java.util.List;
import java.util.Optional;
import org.jlgranda.appsventas.domain.Subject;
import org.jlgranda.appsventas.domain.UsersRoles;

/**
 * 
 * @author vladimir.stankovic
 *
 * Aug 17, 2016
 */
public interface UserService {
    public Optional<Subject> getByUsername(String username);
    public List<UsersRoles> getRoles(Long userId);
}
