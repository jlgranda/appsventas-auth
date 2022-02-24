package org.jlgranda.appsventas.security.auth.ajax;


import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.jlgranda.appsventas.security.model.UserContext;
import org.jlgranda.appsventas.user.service.DatabaseUserService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.jlgranda.appsventas.domain.Subject;
import org.jlgranda.appsventas.domain.UsersRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.jlgranda.util.AESUtil;

/**
 * 
 * @author vladimir.stankovic
 *
 * Aug 3, 2016
 */
@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {
    private final BCryptPasswordEncoder encoder;
    private final DatabaseUserService userService;

    @Autowired
    public AjaxAuthenticationProvider(final DatabaseUserService userService, final BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        Assert.notNull(authentication, "No authentication data provided");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        Subject user = userService.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        
        //La contraseña ya viene encriptada, desencriptar y comparar con Shiro password service
        String plainText = "";
        try {
            plainText = AESUtil.decrypt("dXNyX2FwcGF0cGE6cHJ1ZWI0c19BVFBBXzIwMjA", password);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | InvalidAlgorithmParameterException | BadPaddingException ex) {
            Logger.getLogger(AjaxAuthenticationProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }
        
        DefaultPasswordService defaultPasswordService = new DefaultPasswordService();
        if (!defaultPasswordService.passwordsMatch(plainText, user.getPassword().trim())) { //TODO la constraseña debe viajar encryptada
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }
        List<UsersRoles> roles = userService.getRoles(user.getId());
        if (roles.isEmpty()) throw new InsufficientAuthenticationException("User has no roles assigned");
        List<GrantedAuthority> authorities = roles.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getUsersRolesPK().getRoleName()))
                .collect(Collectors.toList());
        UserContext userContext = UserContext.create(user.getUsername(), authorities);
        return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    
}
