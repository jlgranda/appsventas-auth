/*
 * Licensed under the TECNOPRO License, Version 1.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.tecnopro.net/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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
 *
 * @author jlgranda
 */
@Entity
@Table(name = "perfil_privilegio_tabla", schema = "sc_comaco")
@AttributeOverride(name = "id", column = @Column(name = "prfpvtb_id"))
@AttributeOverride(name = "uuid", column = @Column(name = "unq_uuid", unique=true, nullable = false))
@AttributeOverride(name = "codigo", column = @Column(name = "unq_codigo", unique=true, nullable = false))
@AttributeOverride(name = "nombre", column = @Column(name = "prfpvtb_nombre", unique=false, nullable = true))
@AttributeOverride(name = "descripcion", column = @Column(name = "prfpvtb_descripcion"))
@AttributeOverride(name = "version", column = @Column(name = "prfpvtb_version"))
@AttributeOverride(name = "usuarioCreacion", column = @Column(name = "prfpvtb_reg_usu"))
@AttributeOverride(name = "usuarioModificacion", column = @Column(name = "prfpvtb_act_usu"))
@AttributeOverride(name = "fechaCreacion", column = @Column(name = "prfpvtb_reg_fecha"))
@AttributeOverride(name = "fechaModificacion", column = @Column(name = "prfpvtb_act_fecha"))
@AttributeOverride(name = "tiempoActivacion", column = @Column(name = "prfpvtb_tiempo_activacion"))
@AttributeOverride(name = "tiempoExpiracion", column = @Column(name = "prfpvtb_tiempo_expiracion"))
@AttributeOverride(name = "prioridad", column = @Column(name = "prfpvtb_prioridad"))
@AttributeOverride(name = "estado", column = @Column(name = "prfpvtb_estado"))
@AttributeOverride(name = "ipHost", column = @Column(name = "prfpvtb_ip_host"))
@AttributeOverride(name = "orden", column = @Column(name = "prfpvtb_orden"))
@AttributeOverride(name = "eliminado", column = @Column(name = "prfpvtb_eliminado"))
@AttributeOverride(name = "fechaEliminacion", column = @Column(name = "prfpvtb_fecha_eliminacion"))
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class PerfilPrivilegioTabla  extends ObjetoBorrable<PerfilPrivilegioTabla> implements Serializable {
    private static final long serialVersionUID = 3967079307302762296L;
    
    static final Logger LOGGER = Logger.getLogger(PerfilPrivilegioTabla.class.getName());
    
    @Column(name="prfpvtb_privilegio_tabla_id")
    private Long privilegioTablaId;
    
    
}
