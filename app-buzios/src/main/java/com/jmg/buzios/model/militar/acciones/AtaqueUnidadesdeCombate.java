/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtaqueUnidadesdeCombate {
    private Ataque ataque;
    private List<UnidadMilitar> unidadmilitar;
    private List<Arma> arma;
    private List<Boolean> atacante;
    private List<Integer> cantidad;

    public AtaqueUnidadesdeCombate(Ataque ataque) {
        this.ataque = ataque;
        this.unidadmilitar = new ArrayList<>();
        this.arma = new ArrayList<>();
        this.atacante = new ArrayList<>();
        this.cantidad = new ArrayList<>();
    }





}
