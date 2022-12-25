/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.militar;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.militar.acciones.Ataque;
import com.jmg.buzios.model.militar.acciones.Barco;
import com.jmg.buzios.model.militar.acciones.MisionMilitar;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * verificarciudadsinprocesodeataque(): boolean	CIUDAD
 */
public class PlanificarSaqueo {

    private Ciudad ciudadatacada;
    private Ciudad ciudadatacante;
    private List<UnidadMilitar> unidadesmilitares;
    private List<Arma> armas;
    private List<Integer> cantidaddearma;

    private List<Boolean> atacante = new ArrayList<>();

    private List<Barco> barcosmercantes;
    private List<Integer> cantidadbarcos;


    private Ataque ataque;

    public PlanificarSaqueo(Ciudad ciudadatacada, Ciudad ciudadatacante, List<UnidadMilitar> unidadesmilitares, List<Arma> armas, List<Integer> cantidaddearma) {
        this.ciudadatacada = ciudadatacada;
        this.ciudadatacante = ciudadatacante;
        this.unidadesmilitares = unidadesmilitares;
        this.armas = armas;
        this.cantidaddearma = cantidaddearma;

        for (int i = 0; i < this.armas.size(); i++) {
            this.atacante.add(Boolean.TRUE);
        }
    }


    public void CUPlanificarSaqueo() throws SQLException {
        if (this.ciudadatacada.getJugador().isProtegido()) {
            JOptionPane.showMessageDialog(null, "No se puede atacar a este jugador porque esta protegido.");
        } else {
            if (this.ciudadatacada.verificarCiudadSinProcesosdeAtaque("Saqueo")) {
                JOptionPane.showMessageDialog(null, "No se puede atacar a esta ciudad porque ya esta siendo atacada por otro jugador.");
            } else {
                if (this.ciudadatacante.getCiudadejercito().verificarunidadesmilitar(this.unidadesmilitares, this.armas, this.cantidaddearma)) {
                    MisionMilitar misionmilitar = new MisionMilitar("Saqueo");
                    this.ataque = new Ataque(this.ciudadatacante, this.ciudadatacada, misionmilitar);

                    this.ataque.getUnidadesdecombate().setUnidadmilitar(this.unidadesmilitares);
                    this.ataque.getUnidadesdecombate().setArma(this.armas);
                    this.ataque.getUnidadesdecombate().setCantidad(this.cantidaddearma);
                    this.ataque.getUnidadesdecombate().setAtacante(this.atacante);

                    this.ataque.almacenarataque();


                    PlanificarSaqueoThread descontarunidades = new PlanificarSaqueoThread(this.ataque, 1, this.unidadesmilitares, this.armas, this.cantidaddearma);
                    Thread hdescontarunidades = new Thread(descontarunidades);
                    hdescontarunidades.start();

                    PlanificarSaqueoThread almacenarunidadesdecombate = new PlanificarSaqueoThread(this.ataque, 3);
                    Thread halmacenarunidadesdecombate = new Thread(almacenarunidadesdecombate);
                    halmacenarunidadesdecombate.start();

                    while (hdescontarunidades.isAlive()) {
                    }

                    PlanificarSaqueoThread inicializarejercitociudad = new PlanificarSaqueoThread(this.ataque, 2);
                    Thread hinicializarejercitociudad = new Thread(inicializarejercitociudad);
                    hinicializarejercitociudad.start();


                    GuardarMovimientoMilitar guardarmovimientomilitar = new GuardarMovimientoMilitar(this.ataque, this.unidadesmilitares, this.armas, this.cantidaddearma, this.barcosmercantes, this.cantidadbarcos);

                    if (guardarmovimientomilitar.CUGuardarMovimientoMilitar()) {
                        //CONFIRMAR TRANSACCION
                        JOptionPane.showMessageDialog(null, "SAQUEO EN MARCHA!!!");
                    } else {
                        //RETROCEDER TRANSACCION
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No tienes las unidades militares suficientes");
                }
            }
        }
    }


}

class PlanificarSaqueoThread extends Thread {

    private Ataque ataque;
    private int hilo;
    private List<UnidadMilitar> unidadesmilitares;
    private List<Arma> armas;
    private List<Integer> cantidaddearma;

    public PlanificarSaqueoThread( Ataque ataque, int hilo) {
        this.ataque = ataque;
        this.hilo = hilo;
    }


    public PlanificarSaqueoThread( Ataque ataque, int hilo, List<UnidadMilitar> unidadesmilitares, List<Arma> armas, List<Integer> cantidaddearma) {
        this.ataque = ataque;
        this.hilo = hilo;
        this.unidadesmilitares = unidadesmilitares;
        this.armas = armas;
        this.cantidaddearma = cantidaddearma;
    }


    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    this.ataque.getCiudadjugatacante().getCiudadejercito().descontarunidadesmilitaresdisponibles(this.unidadesmilitares, this.armas, this.cantidaddearma);
                } catch (SQLException ex) {
                }
                break;
            case 2:
                this.ataque.getCiudadjugatacante().getCiudadejercito().inicializarejercitodeciudad();
                break;
            case 3:
                try {
                    this.ataque.almacenarunidadesdecombate();
                } catch (SQLException ex) {

                }
                break;


        }
    }

}
