package ec.gob.smc.domain;

import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Logger;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.tecnopro.modelo.comun.ObjetoBase;
import net.tecnopro.modelo.comun.ObjetoBorrable;

@Entity
@Table(name = "usuario", schema = "sc_comaco")
/*
@TableGenerator(
        name = "ProyectoGenerator",
        //schema = "proamazonia-core",
        table = "Generator",
        pkColumnName = "name",
        valueColumnName = "value",
        pkColumnValue = "Proyecto",
        initialValue = 10,
        allocationSize = 1)*/
@AttributeOverride(name = "id", column = @Column(name = "usr_id"))
@AttributeOverride(name = "uuid", column = @Column(name = "usr_uuid", unique=true, nullable = false))
@AttributeOverride(name = "codigo", column = @Column(name = "usr_codigo", unique=true, nullable = false))
@AttributeOverride(name = "nombre", column = @Column(name = "usr_nombre", unique=false, nullable = false))
@AttributeOverride(name = "descripcion", column = @Column(name = "usr_descripcion"))
@AttributeOverride(name = "version", column = @Column(name = "usr_version"))
@AttributeOverride(name = "usuarioCreacion", column = @Column(name = "usr_reg_usu"))
@AttributeOverride(name = "usuarioModificacion", column = @Column(name = "usr_act_usu"))
@AttributeOverride(name = "fechaCreacion", column = @Column(name = "usr_reg_fecha"))
@AttributeOverride(name = "fechaModificacion", column = @Column(name = "usr_act_fecha"))
@AttributeOverride(name = "tiempoActivacion", column = @Column(name = "usr_tiempo_activacion"))
@AttributeOverride(name = "tiempoExpiracion", column = @Column(name = "usr_tiempo_expiracion"))
@AttributeOverride(name = "prioridad", column = @Column(name = "usr_prioridad"))
@AttributeOverride(name = "estado", column = @Column(name = "usr_estado"))
@AttributeOverride(name = "ipHost", column = @Column(name = "usr_ip_host"))
@AttributeOverride(name = "orden", column = @Column(name = "usr_orden"))
@AttributeOverride(name = "eliminado", column = @Column(name = "usr_eliminado"))
@AttributeOverride(name = "fechaEliminacion", column = @Column(name = "usr_fecha_eliminacion"))

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@ToString
public class User extends ObjetoBorrable<User> implements Serializable {
    
    static final Logger LOGGER = Logger.getLogger(User.class.getName());

    private static final long serialVersionUID = 3447525385338903908L;

    @Column (name = "unq_correo_electronico", nullable = false, unique = true)
    private String email;
    @Column (name = "unq_username", nullable = false, unique = true)
    private String username;
    @Column (name = "usr_password", nullable = true)
    private String password;
    @Column (name = "usr_bio", nullable = true)
    private String bio;
    @Column (name = "usr_image", nullable = true)
    private String image;

    @Column(name = "usr_person_id", nullable = false)
    private Long personId;

    public User(Long personId, String email, String username, String password, String bio, String image) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.bio = bio;
        this.image = image;
        this.personId = personId;
    }

    public void update(String email, String username, String password, String bio, String image) {
        if (!"".equals(email)) {
            this.email = email;
        }

        if (!"".equals(username)) {
            this.username = username;
        }

        if (!"".equals(password)) {
            this.password = password;
        }

        if (!"".equals(bio)) {
            this.bio = bio;
        }

        if (!"".equals(image)) {
            this.image = image;
        }
    }
}
