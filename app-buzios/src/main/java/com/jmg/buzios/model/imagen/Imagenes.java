/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.imagen;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Imagenes {

    private int codigoimagen;
    private String direccion;

    public Imagenes(String direccion) {
        this.direccion = direccion;
    }




}
