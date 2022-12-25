/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.puerto;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.militar.acciones.Barco;

import javax.swing.*;
import java.sql.SQLException;

/**
 * verificaroro(cantidadoro: int): boolean	JUGADOR
 * comprarbarco(): void	CIUDADBARCO
 * pagaroro(cantidad: int): void	JUGADOR
 */
public class ComprarBarcoMercante {

    private Ciudad ciudadjugador;
    private Barco barcoacomprar;

    public ComprarBarcoMercante(Ciudad ciudadjugador, Barco barcoacomprar) {
        this.ciudadjugador = ciudadjugador;
        this.barcoacomprar = barcoacomprar;
    }

    public void CUComprarBarcomercante() throws SQLException {
        this.barcoacomprar = Barco.inicializar_barco_mercante();
        if (this.ciudadjugador.getJugador().verificaroro( this.barcoacomprar.getCosto())) {
            this.ciudadjugador.getJugador().pagaroro( this.barcoacomprar.getCosto());
            this.ciudadjugador.getCiudadbarco().agregarbarco( this.barcoacomprar);
            JOptionPane.showMessageDialog(null, "Nuevo barco comprado.");

        } else {
            JOptionPane.showMessageDialog(null, "No tienes suficiente oro para comprar este barco.");
        }
    }
}
