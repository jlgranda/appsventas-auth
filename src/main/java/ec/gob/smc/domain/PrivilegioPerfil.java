/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.smc.domain;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.tecnopro.modelo.comun.ObjetoBorrable;

/**
 * Modelo de entidad privilegio_perfil (roles del usuario)
 * @author jlgranda
 */
@Entity
@Table(name = "privilegio_perfil", schema = "sc_comaco")
@AttributeOverride(name = "id", column = @Column(name = "prvprf_id"))
@AttributeOverride(name = "uuid", column = @Column(name = "unq_uuid", unique=true, nullable = false))
@AttributeOverride(name = "codigo", column = @Column(name = "unq_codigo", unique=true, nullable = false))
@AttributeOverride(name = "nombre", column = @Column(name = "prvprf_nombre", unique=false, nullable = true))
@AttributeOverride(name = "descripcion", column = @Column(name = "prvprf_descripcion"))
@AttributeOverride(name = "version", column = @Column(name = "prvprf_version"))
@AttributeOverride(name = "usuarioCreacion", column = @Column(name = "prvprf_reg_usu"))
@AttributeOverride(name = "usuarioModificacion", column = @Column(name = "prvprf_act_usu"))
@AttributeOverride(name = "fechaCreacion", column = @Column(name = "prvprf_reg_fecha"))
@AttributeOverride(name = "fechaModificacion", column = @Column(name = "prvprf_act_fecha"))
@AttributeOverride(name = "tiempoActivacion", column = @Column(name = "prvprf_tiempo_activacion"))
@AttributeOverride(name = "tiempoExpiracion", column = @Column(name = "prvprf_tiempo_expiracion"))
@AttributeOverride(name = "prioridad", column = @Column(name = "prvprf_prioridad"))
@AttributeOverride(name = "estado", column = @Column(name = "prvprf_estado"))
@AttributeOverride(name = "ipHost", column = @Column(name = "prvprf_ip_host"))
@AttributeOverride(name = "orden", column = @Column(name = "prvprf_orden"))
@AttributeOverride(name = "eliminado", column = @Column(name = "prvprf_eliminado"))
@AttributeOverride(name = "fechaEliminacion", column = @Column(name = "prvprf_fecha_eliminacion"))
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class PrivilegioPerfil  extends ObjetoBorrable<PrivilegioPerfil> implements Serializable {
    
    private static final long serialVersionUID = 3960779307302762296L;
    
    static final Logger LOGGER = Logger.getLogger(PerfilPrivilegioTabla.class.getName());

    @Column(name="prf_id")
    private Long perfilId;
    
    @Column(name="usr_id")
    private Long userId;
}
