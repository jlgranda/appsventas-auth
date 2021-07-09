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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import net.tecnopro.util.Dates;

@MappedSuperclass
public abstract class ObjetoBorrable<E extends ObjetoBorrable<E>> extends ObjetoPersistente<E> {

    private static final long serialVersionUID = 49008810086044438L;
    
    @Column(nullable = true)
    protected Boolean eliminado;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEliminacion;
    
    @Override
    @PrePersist
    public void prePersist() {
        setEliminado(false);
        setUsuarioSession(getUsuarioCreacion()); //Establecer quién realiza el cambio para la vista de auditoria
        super.prePersist();
    }
    
    @Override
    public void preUpdate() {
        if (isEliminado() && (getFechaEliminacion() == null)) {
            setEstado(Constantes.ESTADO_COMACO_INACTIVO);
            setFechaEliminacion(Dates.now());
            setNombre(getNombre().concat(Constantes.ESTADO_ELIMINADO).concat("" + Dates.now().getTime()));
        }
        
        setUsuarioSession(getUsuarioModificacion()); //Establecer quién realiza el cambio para la vista de auditoria
        super.preUpdate();
    }
    
    public boolean isEliminado() {
        return this.eliminado == null ? false : this.eliminado;
    }
    
    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    public Boolean getEliminado() {
        return eliminado;
    }
    
    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }
    
    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }
    
}
