/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.isla;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
public class IslaRecurso {
    private Isla isla;
    private List<Recurso> recursos;

    public IslaRecurso() {
        this.recursos = new ArrayList<>();

    }

    public Isla getIsla() {
        return isla;
    }

    public void setIsla(Isla isla) {
        this.isla = isla;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }


}
