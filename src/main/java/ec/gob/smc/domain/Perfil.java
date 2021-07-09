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
@Table(name = "perfil", schema = "sc_comaco")
@AttributeOverride(name = "id", column = @Column(name = "prf_id"))
@AttributeOverride(name = "uuid", column = @Column(name = "unq_uuid", unique=true, nullable = false))
@AttributeOverride(name = "codigo", column = @Column(name = "unq_codigo", unique=true, nullable = false))
@AttributeOverride(name = "nombre", column = @Column(name = "unq_nombre", unique=true, nullable = false))
@AttributeOverride(name = "descripcion", column = @Column(name = "prf_descripcion"))
@AttributeOverride(name = "version", column = @Column(name = "prf_version"))
@AttributeOverride(name = "usuarioCreacion", column = @Column(name = "prf_reg_usu"))
@AttributeOverride(name = "usuarioModificacion", column = @Column(name = "prf_act_usu"))
@AttributeOverride(name = "fechaCreacion", column = @Column(name = "prf_reg_fecha"))
@AttributeOverride(name = "fechaModificacion", column = @Column(name = "prf_act_fecha"))
@AttributeOverride(name = "tiempoActivacion", column = @Column(name = "prf_tiempo_activacion"))
@AttributeOverride(name = "tiempoExpiracion", column = @Column(name = "prf_tiempo_expiracion"))
@AttributeOverride(name = "prioridad", column = @Column(name = "prf_prioridad"))
@AttributeOverride(name = "estado", column = @Column(name = "prf_estado"))
@AttributeOverride(name = "ipHost", column = @Column(name = "prf_ip_host"))
@AttributeOverride(name = "orden", column = @Column(name = "prf_orden"))
@AttributeOverride(name = "eliminado", column = @Column(name = "prf_eliminado"))
@AttributeOverride(name = "fechaEliminacion", column = @Column(name = "prf_fecha_eliminacion"))
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class Perfil extends ObjetoBorrable<Perfil> implements Serializable {
    
    static final Logger LOGGER = Logger.getLogger(Perfil.class.getName());
    private static final long serialVersionUID = 6689891520352664881L;
}