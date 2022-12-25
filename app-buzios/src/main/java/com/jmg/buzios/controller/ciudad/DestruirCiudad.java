/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.ciudad;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;


/**
 * 1	El jugador aprieta un botón y envía por parámetro la ciudad que desea eliminar.
 * 2	El sistema verifica que la ciudad no sea la capital del imperio.
 * 3	El sistema cancela todos los ataques que se le están realizando a la ciudad.
 * 4	El sistema retornar todas las unidades militares de apostamiento sobre esa ciudad.
 * 5	El sistema cancela todos los envios por barcos que van a llegar al puerto de la ciudad y los retorna a sus ciudades de origen.
 * 6	El sistema elimina la ciudad de la isla.
 * 7	El sistema redirección la pantalla del jugador a su ciudad capital.
 * 8	El sistema envía un mensaje al jugador comunicándole que la ciudad ha sido eliminada exitosamente.
 */
public class DestruirCiudad {
    private ConexionDB conexion ;
    private VCiudad vciudad;

    public DestruirCiudad(VCiudad vciudad) {
        this.vciudad = vciudad;
    }


    public void CUDestruirCiudad() throws SQLException {
        if (vciudad.getCiudad().isCapital()) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar esta ciudad , porque es la capital del imperio");
        } else {

            vciudad.getCiudad().eliminarciudad();

            conexion.getConexion().close();
            JOptionPane.showMessageDialog(null, "La ciudad se ha eliminado.");


            for (int i = 0; i < this.vciudad.getCiudad().getJugador().getCiudades().size(); i++) {
                if (this.vciudad.getCiudad().getJugador().getCiudades().get(i).isCapital()) {
                    vciudad.hide();
                    MostrarCiudad mostrarciudad = new MostrarCiudad(this.vciudad.getCiudad().getJugador().getCiudades().get(i));
                    mostrarciudad.CUmostrarciudad();
                    return;
                }
            }

        }
    }


}
