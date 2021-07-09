/*
 * Copyright (C) 2015 jlgranda
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package net.tecnopro.modelo.comun;

import ec.gob.smc.Constantes;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import net.tecnopro.util.Strings;

/**
 *
 * @author jlgranda
 * @param <E>
 */
@MappedSuperclass
public abstract class ObjetoBase<E extends ObjetoBase<E>> implements Serializable {
    protected static final long serialVersionUID = -1272280183658745494L;

    protected static boolean getBooleanValue(final Boolean value) {
        return Boolean.valueOf(String.valueOf(value));
    }
    @Column(nullable = true)
    protected String uuid;
    @Column(nullable = false, unique = true)
    protected String codigo;
    @Column(nullable = false, length = 1024)
    protected String nombre;
    @Column(nullable = true, length = 4096)
    protected String descripcion;
    @Version
    @Column(name = "version", nullable = false)
    protected Integer version = 0;
    
    /**
     * Usuario de sessión en el sistema cliente, 
     * permite registrar quien esta realizando la modificación de los datos
     * y comunicar al subsistema de auditoria.
     */
    @Column(name="session_user_name", nullable = true, length = 50)
    protected Long usuarioSession;
    
    @Column(nullable = false)
    protected Long usuarioCreacion;
    @Column(nullable = true)
    protected Long usuarioModificacion;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    protected Date fechaModificacion;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(updatable = false, nullable = false)
    protected Date fechaCreacion;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = true)
    protected Date tiempoActivacion;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = true)
    protected Date tiempoExpiracion;
    @Column(nullable = true)
    protected Integer prioridad;
//    @Column(nullable = true)
//    protected Boolean activo;

    @Column(nullable = true)
    protected Long estado;
    
    @Column(nullable = true)
    protected String ipHost;

    @Column(nullable = true)
    protected Integer orden;
    
    @PrePersist
    void prePersist() {
        this.fechaCreacion = new Date();
        this.uuid = UUID.randomUUID().toString();
        this.estado = Constantes.ESTADO_COMACO_ACTIVO;
        if (Strings.isNullOrEmpty(this.codigo)){
            this.codigo = this.uuid; //Asignar un código si no se ha definido nada
        }
        //activo = true;
    }

    @PreUpdate
    void preUpdate() {
        fechaModificacion = new Date();
    }

//    public Integer getVersion() {
//        return version;
//    }

    public void setVersion(final Integer version) {
        this.version = version;
    }

    public Long getUsuarioSession() {
        return usuarioSession;
    }

    public void setUsuarioSession(Long usuarioSession) {
        this.usuarioSession = usuarioSession;
    }

    public Long getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Long usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Long getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Long usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    @SuppressWarnings(value = "unchecked")
    public E setFechaCreacion(final Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return (E) this;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getTiempoActivacion() {
        return tiempoActivacion;
    }

    public void setActivationTime(Date activationTime) {
        this.tiempoActivacion = activationTime;
    }

    public Date getTiempoExpiracion() {
        return tiempoExpiracion;
    }

    public void setTiempoExpiracion(Date tiempoExpiracion) {
        this.tiempoExpiracion = tiempoExpiracion;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

//    public Boolean getActivo() {
//        return activo;
//    }
//
//    public void setActivo(Boolean activo) {
//        this.activo = activo;
//    }

    @Transient
    public boolean isExpirado() {
        Calendar now = Calendar.getInstance();
        return now.after(getTiempoExpiracion());
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getIpHost() {
        return ipHost;
    }

    public void setIpHost(String ipHost) {
        this.ipHost = ipHost;
    }
}
