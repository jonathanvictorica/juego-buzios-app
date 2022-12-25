/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.cuenta;

import com.jmg.buzios.model.jugador.Jugador;
import com.jmg.buzios.view.ciudad.VConfigurarCuenta;

/**
 * @author Alumno
 */
public class ConfigurarCuenta {

    Jugador jugador;


    VConfigurarCuenta vconfigurarcuenta;

    public ConfigurarCuenta(Jugador jugador) {
        this.jugador = jugador;
        this.vconfigurarcuenta = new VConfigurarCuenta(this.jugador);

    }

    public void CUConfigurarCuenta() {
        this.vconfigurarcuenta.show();
    }


}
