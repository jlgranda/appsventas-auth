package ec.gob.smc.user.repository;

import ec.gob.smc.domain.PrivilegioPerfil;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * PrivilegioPerfilRepository
 * 
 * @author jlgranda
 *
 * Jun 28, 2021
 */
public interface PrivilegioPerfilRepository extends JpaRepository<PrivilegioPerfil, Long> {
    
    
    @Query("select pp from PrivilegioPerfil pp where pp.userId=:userId")
    public List<PrivilegioPerfil> findAllByUserId(@Param("userId") Long userId);
}
