/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.ejercito;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArmaUnidad {
    private UnidadMilitar unidad;
    private List<Arma> listarmas;

    public ArmaUnidad(UnidadMilitar unidad) {
        this.unidad = unidad;
        this.listarmas = new ArrayList<>();
    }




}
