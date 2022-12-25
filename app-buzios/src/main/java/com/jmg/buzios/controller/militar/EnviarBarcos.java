/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.militar;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.militar.acciones.Ataque;
import com.jmg.buzios.model.militar.acciones.MisionMilitar;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Alumno
 */
public class EnviarBarcos {

    private List<UnidadMilitar> unidadmilitar;
    private List<Integer> cantidad;
    private Ciudad ciudadatacante;
    private Ciudad ciudadatacada;
    private Ataque ataque;

    public EnviarBarcos(List<UnidadMilitar> barcosdeguerra, List<Integer> cantidad, Ciudad ciudadatacante, Ciudad ciudadatacada) {
        this.unidadmilitar = barcosdeguerra;
        this.cantidad = cantidad;
        this.ciudadatacante = ciudadatacante;
        this.ciudadatacada = ciudadatacada;
    }

    public void CUEnviarBarcos() throws SQLException {
        if (this.ciudadatacante.getCiudadejercito().verificarunidadesmilitar(this.unidadmilitar, null, this.cantidad)) {
            MisionMilitar misionmilitar = new MisionMilitar("Apostar Barcos");
            this.ataque = new Ataque(this.ciudadatacante, this.ciudadatacada, misionmilitar);

            for (int i = 0; i < this.unidadmilitar.size(); i++) {
                this.ataque.getUnidadesdecombate().getAtacante().add(Boolean.TRUE);
                this.ataque.getUnidadesdecombate().getUnidadmilitar().add(this.unidadmilitar.get(i));
                this.ataque.getUnidadesdecombate().getArma().add(null);
                this.ataque.getUnidadesdecombate().getCantidad().add(this.cantidad.get(i));

            }

            this.ataque.almacenarataque();


            PlanificarSaqueoThread descontarunidades = new PlanificarSaqueoThread( this.ataque, 1, this.unidadmilitar, null, this.cantidad);
            Thread hdescontarunidades = new Thread(descontarunidades);
            hdescontarunidades.start();

            PlanificarSaqueoThread almacenarunidadesdecombate = new PlanificarSaqueoThread( this.ataque, 3);
            Thread halmacenarunidadesdecombate = new Thread(almacenarunidadesdecombate);
            halmacenarunidadesdecombate.start();
            while (hdescontarunidades.isAlive()) {
            }

            PlanificarSaqueoThread inicializarejercitociudad = new PlanificarSaqueoThread(this.ataque, 2);
            Thread hinicializarejercitociudad = new Thread(inicializarejercitociudad);
            hinicializarejercitociudad.start();


            JOptionPane.showMessageDialog(null, "Defensa de Puerto en Marcha.");
        } else {
            JOptionPane.showMessageDialog(null, "No tienes suficientes unidades militares.");
        }
    }
}
