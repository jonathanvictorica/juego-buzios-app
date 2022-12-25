/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.militar;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.militar.acciones.Ataque;
import com.jmg.buzios.model.militar.acciones.MisionMilitar;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
public class EnviarUnidades {

    private Ciudad ciudadatacada;
    private Ciudad ciudadatacante;
    private List<UnidadMilitar> unidadesmilitares;
    private List<Arma> armas;
    private List<Integer> cantidaddearma;

    private List<Boolean> atacante = new ArrayList<>();


    private Ataque ataque;

    public EnviarUnidades(Ciudad ciudadatacada, Ciudad ciudadatacante, List<UnidadMilitar> unidadesmilitares, List<Arma> armas, List<Integer> cantidaddearma) {
        this.ciudadatacada = ciudadatacada;
        this.ciudadatacante = ciudadatacante;
        this.unidadesmilitares = unidadesmilitares;
        this.armas = armas;
        this.cantidaddearma = cantidaddearma;

        for (int i = 0; i < this.armas.size(); i++) {
            this.atacante.add(Boolean.TRUE);
        }
    }


    public void CUEnviarUnidades() throws SQLException {

        if (this.ciudadatacante.getCiudadejercito().verificarunidadesmilitar( this.unidadesmilitares, this.armas, this.cantidaddearma)) {
            MisionMilitar misionmilitar = new MisionMilitar("Apostar Tropas");
            this.ataque = new Ataque(this.ciudadatacante, this.ciudadatacada, misionmilitar);

            this.ataque.getUnidadesdecombate().setUnidadmilitar(this.unidadesmilitares);
            this.ataque.getUnidadesdecombate().setArma(this.armas);
            this.ataque.getUnidadesdecombate().setCantidad(this.cantidaddearma);
            this.ataque.getUnidadesdecombate().setAtacante(this.atacante);

            this.ataque.almacenarataque();


            PlanificarSaqueoThread descontarunidades = new PlanificarSaqueoThread( this.ataque, 1, this.unidadesmilitares, this.armas, this.cantidaddearma);
            Thread hdescontarunidades = new Thread(descontarunidades);
            hdescontarunidades.start();

            PlanificarSaqueoThread almacenarunidadesdecombate = new PlanificarSaqueoThread( this.ataque, 3);
            Thread halmacenarunidadesdecombate = new Thread(almacenarunidadesdecombate);
            halmacenarunidadesdecombate.start();

            while (hdescontarunidades.isAlive()) {
            }

            PlanificarSaqueoThread inicializarejercitociudad = new PlanificarSaqueoThread( this.ataque, 2);
            Thread hinicializarejercitociudad = new Thread(inicializarejercitociudad);
            hinicializarejercitociudad.start();


            GuardarMovimientoMilitar guardarmovimientomilitar = new GuardarMovimientoMilitar( this.ataque, this.unidadesmilitares, this.armas, this.cantidaddearma);

            if (guardarmovimientomilitar.CUGuardarMovimientoMilitar()) {
                //CONFIRMAR TRANSACCION
                JOptionPane.showMessageDialog(null, "ENVIO DE UNIDADES EN MARCHA!!!");
            } else {
                //RETROCEDER TRANSACCION
            }

        } else {
            JOptionPane.showMessageDialog(null, "No tienes sufiente unidades militares para enviar!!!");

        }
    }


}
