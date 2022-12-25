/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.puerto;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.isla.Recurso;
import com.jmg.buzios.model.militar.acciones.BarcoMovimiento;
import com.jmg.buzios.model.militar.acciones.Carga;
import com.jmg.buzios.model.militar.acciones.MovimientoBarcoActual;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Alumno
 */
public class EnviarRecurso {

    private List<Recurso> recursos;
    private List<Integer> cantidad;
    private Ciudad ciudadjugador;
    private Ciudad ciudadjugadoraenviar;


    public EnviarRecurso(List<Recurso> recursos, List<Integer> cantidad, Ciudad ciudadjugador, Ciudad ciudadjugadoraenviar) {
        this.recursos = recursos;
        this.cantidad = cantidad;
        this.ciudadjugador = ciudadjugador;
        this.ciudadjugadoraenviar = ciudadjugadoraenviar;
    }


    public void CUEnviarrecurso() throws SQLException {
        if (this.ciudadjugador.getCiudadrecurso().verificarrecursosciudad(recursos, cantidad)) {
            this.ciudadjugador.getCiudadbarco().inicializarbarcosdeciudad();

            MovimientoBarcoActual movimientobarco = new MovimientoBarcoActual(this.ciudadjugador, this.ciudadjugadoraenviar);
            BarcoMovimiento ciudadbarcos = this.ciudadjugador.getCiudadbarco().verificarbarcosdisponibles(this.ciudadjugador.getCiudadrecurso().calcularpesorecursos(this.cantidad));

            if (ciudadbarcos != null) {

                this.ciudadjugador.getCiudadrecurso().descontarrecursosciudad( recursos, cantidad);
                ciudadbarcos.setMovimiento(movimientobarco);
                movimientobarco.calculartiempollegada();

                movimientobarco.almacenarmovimientobarco(); //inicializa la variable codigomovimiento
                movimientobarco.setBarcomovimiento(ciudadbarcos);

                movimientobarco.setCarga(new Carga(movimientobarco, recursos, cantidad));

                EnviarRecursoThread descontarbarcosdisponibles = new EnviarRecursoThread( 1, movimientobarco);
                Thread hdescontarbarcosdisponibles = new Thread(descontarbarcosdisponibles);
                hdescontarbarcosdisponibles.start();

                EnviarRecursoThread almacenarbarcosmovimiento = new EnviarRecursoThread( 2, movimientobarco);
                Thread halmacenarbarcosmovimiento = new Thread(almacenarbarcosmovimiento);
                halmacenarbarcosmovimiento.start();

                EnviarRecursoThread almacenarcargarecurso = new EnviarRecursoThread( 3, movimientobarco);
                Thread halmacenarcargarecurso = new Thread(almacenarcargarecurso);
                halmacenarcargarecurso.start();

                while (hdescontarbarcosdisponibles.isAlive() || halmacenarbarcosmovimiento.isAlive() || halmacenarcargarecurso.isAlive()) {

                }

                JOptionPane.showMessageDialog(null, "Carga Enviada.");

            } else {
                JOptionPane.showMessageDialog(null, "No tienes suficientes barcos para trasladar estos recursos.");

            }


        } else {
            JOptionPane.showMessageDialog(null, "No tienes esos recursos que quieres enviar.");
        }

    }
}

class EnviarRecursoThread extends Thread {

    private MovimientoBarcoActual movimiento;

    private Integer hilo;


    public EnviarRecursoThread(Integer hilo, MovimientoBarcoActual movimiento) {

        this.movimiento = movimiento;

        this.hilo = hilo;
    }

    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    this.movimiento.getCiudadsalida().getCiudadbarco().descontarbarcosdisponiblesenciudad( this.movimiento.getBarcomovimiento());
                } catch (SQLException ex) {
                    Logger.getLogger(EnviarRecursoThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                try {
                    this.movimiento.getBarcomovimiento().almacenarbarcosdemovimiento();
                } catch (SQLException ex) {
                    Logger.getLogger(EnviarRecursoThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3:
                try {
                    this.movimiento.getCarga().almacenarcargarecursos();
                } catch (SQLException ex) {
                    Logger.getLogger(EnviarRecursoThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

        }
    }


}

