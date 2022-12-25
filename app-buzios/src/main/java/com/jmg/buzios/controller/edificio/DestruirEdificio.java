/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class DestruirEdificio implements Actualizar {


    private Ciudad ciudadjugador;
    private EdificioNivel edificioenciudad;
    private JFrame veredificio;
    private VCiudad vciudad;
    private int lugarciudad;

    public DestruirEdificio(Ciudad ciudadjugador, EdificioNivel edificionivel, VCiudad vciudad, int lugarciudad, JFrame veredificio) {
        this.ciudadjugador = ciudadjugador;
        this.edificioenciudad = edificionivel;
        this.vciudad = vciudad;
        this.lugarciudad = lugarciudad;
        this.veredificio = veredificio;
    }


    public void CUdestruiredificio() throws SQLException {


        int indice = ciudadjugador.verificaredificioenciudad(edificioenciudad.getEdificio().getNombre());
        if (indice != 0) {
            switch (edificioenciudad.getEdificio().getNombre()) {
                case "Cuartel":
                    if (this.ciudadjugador.getCiudadedificios().verificarcuartelvacio() == false) {
                        this.ciudadjugador.getCiudadedificios().destruiredificiodeciudad(indice);
                        this.actualizarinterfazgrafica();
                    } else {
                        JOptionPane.showMessageDialog(null, "El edificio " + edificioenciudad.getEdificio().getNombre() + " no se puede destruir porque tiene unidades militares en el lugar");
                    }

                    break;
                case "Astillero de Guerra":
                    if (this.ciudadjugador.getCiudadedificios().verificarastillerodeguerravacio() == false) {
                        this.ciudadjugador.getCiudadedificios().destruiredificiodeciudad(indice);
                        this.actualizarinterfazgrafica();
                    } else {
                        JOptionPane.showMessageDialog(null, "El edificio " + edificioenciudad.getEdificio().getNombre() + " no se puede destruir porque tiene unidades militares en el lugar");
                    }
                    break;
                case "ALMACEN":
                    this.ciudadjugador.getCiudadedificios().destruiredificiodeciudad(indice);
                    this.actualizarinterfazgrafica();

                    break;
                case "Deposito":
                    this.ciudadjugador.getCiudadedificios().destruiredificiodeciudad(indice);
                    this.actualizarinterfazgrafica();

                    break;
                case "Mercado":
                    if (this.ciudadjugador.getCiudadedificios().verificarmercadosindeposito() == false) {
                        this.ciudadjugador.getCiudadedificios().destruiredificiodeciudad(indice);
                        this.actualizarinterfazgrafica();
                    } else {
                        JOptionPane.showMessageDialog(null, "El edificio " + edificioenciudad.getEdificio().getNombre() + " no se puede destruir porque tiene recursos en el deposito del mercado para ser retirados.");
                    }
                    break;
                default:
                    if (this.ciudadjugador.getCiudadedificios().verificaredificioreal(indice) == false) {
                        this.ciudadjugador.getCiudadedificios().destruiredificiodeciudad(indice);
                        this.actualizarinterfazgrafica();
                    } else {
                        JOptionPane.showMessageDialog(null, "El edificio " + edificioenciudad.getEdificio().getNombre() + " no se puede destruir porque es un edificio real.");
                    }
                    break;
            }


        }
    }

    @Override
    public void actualizardatospantalla() {
    }

    @Override
    public void actualizarinterfazgrafica() {

        ConstruirEdificio.actualizarinterfazgrafica(vciudad);
        JOptionPane.showMessageDialog(veredificio, "Destruir Edificio");
        this.veredificio.hide();
    }
}
