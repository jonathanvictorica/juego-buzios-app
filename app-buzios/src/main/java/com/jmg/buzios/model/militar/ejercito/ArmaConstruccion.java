/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.ejercito;

import com.jmg.buzios.model.isla.Recurso;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArmaConstruccion {
    private Arma arma;
    private List<Recurso> recursos;
    private List<Integer> cantidad;

    public ArmaConstruccion(Arma arma) {
        this.arma = arma;
        this.recursos = new ArrayList<>();
        this.cantidad = new ArrayList<>();
    }




}
