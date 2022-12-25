/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.militar;

import com.jmg.buzios.model.militar.acciones.*;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 1	El sistema recibe como parámetro los datos del ataque, la lista de unidades militares terrestres con sus respectivas cantidades.
 * 2	El Sistema calcula el peso de todas las unidades militares terrestres para moverlas por barco.
 * 3	El Sistema verifica que el jugador tenga en esa ciudad los barcos necesarios para mover a las tropas.
 * 4	El Sistema calcula la distancia y el tiempo que tardará en llegar las tropas a la ciudad atacada.
 * 5	El Sistema resta la cantidad disponible de cada barco que utilizo para planificar el ataque a esa ciudad.
 * 6	El Sistema resta la cantidad de cada unidad militar que utiliza de la ciudad que va realizar el ataque, ya que la va a utilizar en el saqueo.
 * 7	El Sistema almacena el movimiento de barcos, el movimiento militar y la carga militar.
 * Nº	Descripción del Flujo
 * 4 A 	El Sistema comunica al jugador atacante que no tiene los suficientes barcos mercantes para mover esa cantidad de tropas.
 */
public class GuardarMovimientoMilitar {

    private Ataque ataque;
    private List<UnidadMilitar> unidadesmilitares;
    private List<Arma> armas;
    private List<Integer> cantidaddearma;

    private List<Barco> barcosmercantes = new ArrayList<>();
    private List<Integer> cantidadbarcos = new ArrayList<>();


    public GuardarMovimientoMilitar( Ataque ataque, List<UnidadMilitar> unidadesmilitares, List<Arma> armas, List<Integer> cantidaddearma) {

        this.ataque = ataque;
        this.unidadesmilitares = unidadesmilitares;
        this.armas = armas;
        this.cantidaddearma = cantidaddearma;
    }

    public GuardarMovimientoMilitar( Ataque ataque, List<UnidadMilitar> unidadesmilitares, List<Arma> armas, List<Integer> cantidaddearma, List<Barco> barcosmercantes, List<Integer> cantidadbarcos) {

        this.ataque = ataque;
        this.unidadesmilitares = unidadesmilitares;
        this.armas = armas;
        this.cantidaddearma = cantidaddearma;
        this.barcosmercantes = barcosmercantes;
        this.cantidadbarcos = cantidadbarcos;
    }


    public boolean CUGuardarMovimientoMilitar() throws SQLException {
        boolean control = false;
        if ((this.ataque.getMisionmilitar().getNombremision().equals("Asalto")) || (this.ataque.getMisionmilitar().getNombremision().equals("Apostar Tropas"))) {
            Asalto asalto = new Asalto(this.ataque.getCodigoataque(), this.ataque.getCiudadjugatacado(), this.ataque.getCiudadjugatacante(), this.ataque.getMisionmilitar(), this.ataque.getUnidadesdecombate());
            BarcoMovimiento barcosautilizar = this.ataque.getCiudadjugatacante().getCiudadbarco().verificarbarcosdisponibles(this.ataque.getCiudadjugatacante().getCiudadejercito().calcularpeso(this.unidadesmilitares, this.cantidaddearma));
            if (barcosautilizar == null) {
                JOptionPane.showMessageDialog(null, "No tienes suficientes barcos para transportar tantas unidades");
                return control;
            } else {
                control = true;
                asalto.setMovimiento(new MovimientoMilitar(asalto.getCiudadjugatacante(), asalto.getCiudadjugatacado()));
                asalto.getMovimiento().calculartiempollegada();
                asalto.getMovimiento().setAtaque(asalto);
                asalto.getMovimiento().almacenarmovimientomilitar();
                //cargar unidades al movimiento

                GuardarMovimientoMilitarThread cargarunidadesmilitares = new GuardarMovimientoMilitarThread( asalto, 1, this.unidadesmilitares, this.armas, this.cantidaddearma);
                Thread hcargarunidadesmilitares = new Thread(cargarunidadesmilitares);
                hcargarunidadesmilitares.start();

                for (int i = 0; i < this.barcosmercantes.size(); i++) {
                    asalto.getMovimiento().getBarcomovimiento().getBarco().add(this.barcosmercantes.get(i));
                    asalto.getMovimiento().getBarcomovimiento().getCantidad().add(this.cantidadbarcos.get(i));
                    barcosautilizar.getBarco().add(this.barcosmercantes.get(i));
                    barcosautilizar.getCantidad().add(this.cantidadbarcos.get(i));


                }


                GuardarMovimientoMilitarThread descontarbarcosciudad = new GuardarMovimientoMilitarThread( asalto, 2, barcosautilizar);
                Thread hdescontarbarcosciudad = new Thread(descontarbarcosciudad);
                hdescontarbarcosciudad.start();


                GuardarMovimientoMilitarThread almacenarbarcosdemovimiento = new GuardarMovimientoMilitarThread( asalto, 3);
                Thread halmacenarbarcosdemovimiento = new Thread(almacenarbarcosdemovimiento);
                halmacenarbarcosdemovimiento.start();


                while (hcargarunidadesmilitares.isAlive() || hdescontarbarcosciudad.isAlive() || halmacenarbarcosdemovimiento.isAlive()) {
                    if ((hcargarunidadesmilitares.isInterrupted()) || (hdescontarbarcosciudad.isInterrupted()) || (halmacenarbarcosdemovimiento.isInterrupted())) {
                        return control;
                    }
                }
                control = true;
                return control;
            }
        } else {
            BarcoMovimiento barcosautilizar = this.ataque.getCiudadjugatacante().getCiudadbarco().verificarbarcosdisponibles(this.ataque.getCiudadjugatacante().getCiudadejercito().calcularpeso(this.unidadesmilitares, this.cantidaddearma));
            if (barcosautilizar == null) {
                JOptionPane.showMessageDialog(null, "No tienes suficientes barcos para transportar tantas unidades");
                return control;
            } else {
                control = true;
                ataque.setMovimiento(new MovimientoMilitar(ataque.getCiudadjugatacante(), ataque.getCiudadjugatacado()));
                ataque.getMovimiento().calculartiempollegada();
                ataque.getMovimiento().setAtaque(ataque);
                ataque.getMovimiento().almacenarmovimientomilitar();
                //cargar unidades al movimiento

                GuardarMovimientoMilitarThread cargarunidadesmilitares = new GuardarMovimientoMilitarThread( ataque, 4, this.unidadesmilitares, this.armas, this.cantidaddearma);
                Thread hcargarunidadesmilitares = new Thread(cargarunidadesmilitares);
                hcargarunidadesmilitares.start();


                GuardarMovimientoMilitarThread descontarbarcosciudad = new GuardarMovimientoMilitarThread( ataque, 5, barcosautilizar);
                Thread hdescontarbarcosciudad = new Thread(descontarbarcosciudad);
                hdescontarbarcosciudad.start();


                GuardarMovimientoMilitarThread almacenarbarcosdemovimiento = new GuardarMovimientoMilitarThread( ataque, 6);
                Thread halmacenarbarcosdemovimiento = new Thread(almacenarbarcosdemovimiento);
                halmacenarbarcosdemovimiento.start();


                while (hcargarunidadesmilitares.isAlive() || hdescontarbarcosciudad.isAlive() || halmacenarbarcosdemovimiento.isAlive()) {
                    if ((hcargarunidadesmilitares.isInterrupted()) || (hdescontarbarcosciudad.isInterrupted()) || (halmacenarbarcosdemovimiento.isInterrupted())) {
                        return control;
                    }
                }
                control = true;
                return control;
            }


        }
    }

}

class GuardarMovimientoMilitarThread extends Thread {

    private Ataque asalto;
    private int hilo;
    private List<UnidadMilitar> unidadesmilitares;
    private List<Arma> armas;
    private List<Integer> cantidaddearma;

    private BarcoMovimiento barcosautilizar;


    public GuardarMovimientoMilitarThread(Ataque asalto, int hilo, List<UnidadMilitar> unidadesmilitares, List<Arma> armas, List<Integer> cantidaddearma) {

        this.asalto = asalto;
        this.hilo = hilo;
        this.unidadesmilitares = unidadesmilitares;
        this.armas = armas;
        this.cantidaddearma = cantidaddearma;
    }


    public GuardarMovimientoMilitarThread( Ataque asalto, int hilo, BarcoMovimiento barcosautilizar) {

        this.asalto = asalto;
        this.hilo = hilo;
        this.barcosautilizar = barcosautilizar;
    }

    public GuardarMovimientoMilitarThread( Ataque asalto, int hilo) {

        this.asalto = asalto;
        this.hilo = hilo;
    }


    @Override
    public void run() {
        switch (hilo) {
            case 1:
                try {
                    ((Asalto) this.asalto).getMovimiento().getCargamiliar().setCantidad(cantidaddearma);
                    ((Asalto) this.asalto).getMovimiento().getCargamiliar().setUnidadmilitar(unidadesmilitares);
                    ((Asalto) this.asalto).getMovimiento().getCargamiliar().setArmas(armas);
                    ((Asalto) this.asalto).getMovimiento().getCargamiliar().cargarunidadesmilitares();
                } catch (SQLException ex) {

                }
                break;
            case 2:
                try {
                    ((Asalto) this.asalto).getCiudadjugatacante().getCiudadbarco().descontarbarcosdisponiblesenciudad( barcosautilizar);
                } catch (SQLException ex) {

                }
                break;
            case 3:
                ((Asalto) this.asalto).getMovimiento().getBarcomovimiento().setMovimiento(asalto.getMovimiento());
                try {
                    ((Asalto) this.asalto).getMovimiento().getBarcomovimiento().almacenarbarcosdemovimiento();
                } catch (SQLException ex) {

                }
                break;
            case 4:
                try {
                    asalto.getMovimiento().getCargamiliar().setCantidad(cantidaddearma);
                    asalto.getMovimiento().getCargamiliar().setUnidadmilitar(unidadesmilitares);
                    asalto.getMovimiento().getCargamiliar().setArmas(armas);
                    asalto.getMovimiento().getCargamiliar().cargarunidadesmilitares();
                } catch (SQLException ex) {

                }
                break;
            case 5:
                try {
                    asalto.getCiudadjugatacante().getCiudadbarco().descontarbarcosdisponiblesenciudad( barcosautilizar);
                } catch (SQLException ex) {

                }
                break;
            case 6:
                asalto.getMovimiento().getBarcomovimiento().setMovimiento(asalto.getMovimiento());
                try {
                    asalto.getMovimiento().getBarcomovimiento().almacenarbarcosdemovimiento();
                } catch (SQLException ex) {

                }
                break;


        }
    }

}