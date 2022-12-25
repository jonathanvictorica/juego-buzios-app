/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.comercio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.comercio.DepositoMercado;
import com.jmg.buzios.model.isla.Recurso;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * verificarrecursoendeposito(recurso: RECURSO,cantidad: int): DEPOSITOMERCADO	DEPOSITOMERCADO
 * verificarcapacidadalmacenamientociudad(recurso: RECURSO,cantidad: int): boolean	CIUDAD
 * descontarrecursosdeldeposito(nickjugador: String,recurso: RECURSO,cantidad: int): void	DEPOSITOMERCADO
 * almacenarrecursosenciudad(recurso: RECURSO,cantidad: int): void	CIUDADRECURSO
 */
public class RecogerRecursodeMercado implements Actualizar {

    private VCiudad vciudad;
    private Ciudad ciudadairalmacenar;
    private Recurso recurso;
    private Integer cantidad;

    public RecogerRecursodeMercado(VCiudad vciudad, Ciudad ciudadairalmacenar, Recurso recurso, Integer cantidad) {
        this.vciudad = vciudad;
        this.ciudadairalmacenar = ciudadairalmacenar;
        this.recurso = recurso;
        this.cantidad = cantidad;
    }

    public void CURecogerRecursodeMercado() throws SQLException {
        DepositoMercado depositomercado_jugador = new DepositoMercado();
        depositomercado_jugador.setJugador(vciudad.getCiudad().getJugador());
        if (depositomercado_jugador.verificarrecursoendeposito(recurso.getNombrerecurso(), cantidad.intValue())) {
            if (this.vciudad.getCiudad().verificarCapacidadAlmacenamientoCiudad(recurso, cantidad)) {
                RecogerRecursodeMercadoThread almacenarrecursociudad = new RecogerRecursodeMercadoThread(1, this.vciudad, this.recurso, this.cantidad);
                Thread halmacenarrecursociudad = new Thread(almacenarrecursociudad);
                halmacenarrecursociudad.start();

                RecogerRecursodeMercadoThread descontarrecursodeposito = new RecogerRecursodeMercadoThread(2, depositomercado_jugador, this.recurso, this.cantidad);
                Thread hdescontarrecursodeposito = new Thread(descontarrecursodeposito);
                hdescontarrecursodeposito.start();


                while (halmacenarrecursociudad.isAlive() || hdescontarrecursodeposito.isAlive()) {
                    if ((halmacenarrecursociudad.isInterrupted()) || (hdescontarrecursodeposito.isInterrupted())) {

                    }

                }
                JOptionPane.showMessageDialog(vciudad, "Felicitaciones. Ya tienes " + this.cantidad + " unidades de " + this.recurso.getNombrerecurso() + " en  tu ciudad " + this.ciudadairalmacenar.getNombre() + ".");

            } else {
                JOptionPane.showMessageDialog(vciudad, "No tienes suficiente espacio en los depositos de esta ciudad para almacenar esa cantidad de " + this.recurso.getNombrerecurso() + ".");

            }
        } else {
            JOptionPane.showMessageDialog(vciudad, "No tiene esos recursos para retirar en el mercado.");
        }


    }

    @Override
    public void actualizardatospantalla() {

    }

    @Override
    public void actualizarinterfazgrafica() {

    }


}


class RecogerRecursodeMercadoThread extends Thread {

    private DepositoMercado depositojugador;
    private VCiudad ciudad;
    private Recurso recurso;
    private Integer cantidad;
    private Integer hilo;

    public RecogerRecursodeMercadoThread(Integer hilo, DepositoMercado depositojugador, Recurso recurso, Integer cantidad) {

        this.depositojugador = depositojugador;
        this.recurso = recurso;
        this.cantidad = cantidad;
        this.hilo = hilo;
    }

    public RecogerRecursodeMercadoThread(Integer hilo, VCiudad ciudad, Recurso recurso, Integer cantidad) {

        this.ciudad = ciudad;
        this.recurso = recurso;
        this.cantidad = cantidad;
        this.hilo = hilo;
    }

    @Override
    public void run() {
        switch (this.hilo) {
            case 1:
                try {
                    ciudad.getCiudad().getCiudadrecurso().almacenarrecursosenciudad(recurso.getNombrerecurso(), cantidad.intValue());
                } catch (SQLException ex) {
                    Logger.getLogger(RecogerRecursodeMercadoThread.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            case 2:
                try {
                    depositojugador.descontarrecursosdeldeposito(recurso.getNombrerecurso(), cantidad.intValue());
                } catch (SQLException ex) {

                }

                break;
        }
    }

}