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
package org.jlgranda.appsventas.domain;

/**
 *
 * @author jlgranda
 */
public enum StatusType {
    ACTIVE,
    INACTIVE,
    LOCKED,
    DEPRECATED,
    IMPORTANT,
    SUCCESS,
    FAIL, 
    //Estados para mesas
    ATTEND, //Atendido
    SET,//Servido
    OPEN, //Agregar pedido
    CLOSE, //Cerrada pedido
    PAID, //PAGADO
    PAID_DIRECT,
    PRINTED //Impreso
}
