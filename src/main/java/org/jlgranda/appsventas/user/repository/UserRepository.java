package org.jlgranda.appsventas.user.repository;

import java.util.Optional;
import org.jlgranda.appsventas.domain.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * UserRepository
 * 
 * @author vladimir.stankovic
 *
 * Aug 16, 2016
 */
public interface UserRepository extends JpaRepository<Subject, Long> {
    @Query("select u from Subject u where u.username=:username")
    public Optional<Subject> findByUsername(@Param("username") String username);
}
