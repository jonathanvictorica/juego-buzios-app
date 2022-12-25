/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.isla.Recurso;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Asalto extends Ataque {


    private List<Recurso> recurso;
    private List<Integer> cantidad;

    public Asalto(List<Recurso> recurso, List<Integer> cantidad) {
        super();
        this.recurso = recurso;
        this.cantidad = cantidad;

    }

    public Asalto(Integer codigo, Ciudad ciudadjugatacante, Ciudad ciudadjugatacado, MisionMilitar misionmilitar, AtaqueUnidadesdeCombate unidadesdecombate) {
        super(ciudadjugatacante, ciudadjugatacado, misionmilitar);
        this.unidadesdecombate = unidadesdecombate;
        this.movimiento = new MovimientoMilitar();
        this.codigoataque = codigo;
    }




}
