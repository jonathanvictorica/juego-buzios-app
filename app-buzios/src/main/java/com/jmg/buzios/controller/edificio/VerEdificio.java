/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.edificio;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;

import java.sql.SQLException;

/**
 * @author Alumno
 */
public class VerEdificio {
    private Ciudad ciudadjugador;
    private VCiudad vciudad;
    private int lugarciudad;

    public VerEdificio(Ciudad ciudadjugador, VCiudad vciudad, int lugarciudad) {
        this.ciudadjugador = ciudadjugador;
        this.vciudad = vciudad;
        this.lugarciudad = lugarciudad;
    }

    public void CUveredificio() throws SQLException {
        if (this.verificarlugarenciudad()) {
            //lugar vacio
            VerEdificiosDisponible veredificioconstruccion = new VerEdificiosDisponible(ciudadjugador, vciudad, lugarciudad);
            veredificioconstruccion.CUveredificiosconstruccion();
        } else {
            switch (retornaredificiodelugarciudad().getEdificio().getNombre()) {
                case "Academia":
                    VerAcademia veracademia = new VerAcademia(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    veracademia.actualizar_datospantalla();
                    veracademia.actualizardatospantalla();
                    veracademia.actualizarinterfazgrafica();
                    break;
                case "Almacen":
                    VerDepositooAlmacen veralmacen = new VerDepositooAlmacen(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    veralmacen.actualizar_datospantalla();
                    veralmacen.actualizardatospantalla();
                    veralmacen.actualizarinterfazgrafica();
                    break;

                case "Muralla":
                    VerMuralla vermuralla = new VerMuralla(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    vermuralla.actualizar_datospantalla();
                    vermuralla.actualizardatospantalla();
                    vermuralla.actualizarinterfazgrafica();
                    break;
                case "Deposito":
                    VerDepositooAlmacen deposito = new VerDepositooAlmacen(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    deposito.actualizar_datospantalla();
                    deposito.actualizardatospantalla();
                    deposito.actualizarinterfazgrafica();
                    break;
                case "Cuartel":
                    VerCuarteloAstillerodeGuerra vercuartel = new VerCuarteloAstillerodeGuerra(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    vercuartel.actualizar_datospantalla();
                    vercuartel.actualizardatospantalla();
                    vercuartel.actualizarinterfazgrafica();
                    break;
                case "Astillero de Guerra":
                    VerCuarteloAstillerodeGuerra verastillerodeguuerra = new VerCuarteloAstillerodeGuerra(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    verastillerodeguuerra.actualizar_datospantalla();
                    verastillerodeguuerra.actualizardatospantalla();
                    verastillerodeguuerra.actualizarinterfazgrafica();
                    break;
                case "Intendencia":
                    VerIntendencia ver_intendencia = new VerIntendencia(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    ver_intendencia.actualizar_datospantalla();
                    ver_intendencia.actualizardatospantalla();
                    ver_intendencia.actualizarinterfazgrafica();
                    break;
                case "Palacio":
                    VerPalaciooResidencia verpalacio = new VerPalaciooResidencia(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    verpalacio.actualizar_datospantalla();
                    verpalacio.actualizardatospantalla();
                    verpalacio.actualizarinterfazgrafica();
                    break;
                case "Residencia del Gobernador":
                    VerPalaciooResidencia verresidencia = new VerPalaciooResidencia(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    verresidencia.actualizar_datospantalla();
                    verresidencia.actualizardatospantalla();
                    verresidencia.actualizarinterfazgrafica();
                    break;
                case "Taberna":
                    VerTaberna vertaberna = new VerTaberna(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    vertaberna.actualizar_datospantalla();
                    vertaberna.actualizardatospantalla();
                    vertaberna.actualizarinterfazgrafica();
                    break;
                case "Puerto":
                    VerPuerto verpuerto = new VerPuerto(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    verpuerto.actualizar_datospantalla();
                    verpuerto.actualizardatospantalla();
                    verpuerto.actualizarinterfazgrafica();
                    break;
                case "Area de Pruebas Pirotecnicas":
                    VerEdificioReduccion verareapruebapirotecnicas = new VerEdificioReduccion(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    verareapruebapirotecnicas.actualizar_datospantalla();
                    verareapruebapirotecnicas.actualizardatospantalla();
                    verareapruebapirotecnicas.actualizarinterfazgrafica();
                    break;
                case "Carpinteria":
                    VerEdificioReduccion vercarpinteria = new VerEdificioReduccion(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    vercarpinteria.actualizar_datospantalla();
                    vercarpinteria.actualizardatospantalla();
                    vercarpinteria.actualizarinterfazgrafica();
                    break;
                case "Oficina del Arquitecto":
                    VerEdificioReduccion veroficinaarquitecto = new VerEdificioReduccion(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    veroficinaarquitecto.actualizar_datospantalla();
                    veroficinaarquitecto.actualizardatospantalla();
                    veroficinaarquitecto.actualizarinterfazgrafica();
                    break;
                case "Prensa de Vino":
                    VerEdificioReduccion verprensadevino = new VerEdificioReduccion(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    verprensadevino.actualizar_datospantalla();
                    verprensadevino.actualizardatospantalla();
                    verprensadevino.actualizarinterfazgrafica();
                    break;
                case "Optico":
                    VerEdificioReduccion optico = new VerEdificioReduccion(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    optico.actualizar_datospantalla();
                    optico.actualizardatospantalla();
                    optico.actualizarinterfazgrafica();
                    break;
                case "Cabaña del guarda Bosque":
                    VerEdificioProduccion cabaña = new VerEdificioProduccion(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    cabaña.actualizar_datospantalla();
                    cabaña.actualizardatospantalla();
                    cabaña.actualizarinterfazgrafica();
                    break;
                case "Cantero":
                    VerEdificioProduccion cantero = new VerEdificioProduccion(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    cantero.actualizar_datospantalla();
                    cantero.actualizardatospantalla();
                    cantero.actualizarinterfazgrafica();
                    break;
                case "Soplador de Vidrio":
                    VerEdificioProduccion sopladordevidrio = new VerEdificioProduccion(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    sopladordevidrio.actualizar_datospantalla();
                    sopladordevidrio.actualizardatospantalla();
                    sopladordevidrio.actualizarinterfazgrafica();
                    break;
                case "Torre del Alquimista":
                    VerEdificioProduccion alquimista = new VerEdificioProduccion(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    alquimista.actualizar_datospantalla();
                    alquimista.actualizardatospantalla();
                    alquimista.actualizarinterfazgrafica();
                    break;
                case "Vinicultor":
                    VerEdificioProduccion vinicultor = new VerEdificioProduccion(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    vinicultor.actualizar_datospantalla();
                    vinicultor.actualizardatospantalla();
                    vinicultor.actualizarinterfazgrafica();
                    break;
                case "Mercado":
                    VerMercado mercado = new VerMercado(this.vciudad, this.ciudadjugador, retornaredificiodelugarciudad(), this.lugarciudad);
                    mercado.actualizar_datospantalla();
                    mercado.actualizardatospantalla();
                    mercado.actualizarinterfazgrafica();
            }
        }
    }

    private EdificioNivel retornaredificiodelugarciudad() {
        EdificioNivel nombreedificio = null;

        for (int i = 0; i < this.ciudadjugador.getCiudadedificios().getLugarciudad().size(); i++) {
            if (this.ciudadjugador.getCiudadedificios().getLugarciudad().get(i) == this.lugarciudad) {
                return this.ciudadjugador.getCiudadedificios().getEdificionivel().get(i);
            }
        }

        return nombreedificio;
    }

    private boolean verificarlugarenciudad() {
        boolean control = true;

        for (int i = 0; i < this.ciudadjugador.getCiudadedificios().getEdificionivel().size(); i++) {
            if (lugarciudad == this.ciudadjugador.getCiudadedificios().getLugarciudad().get(i)) {
                control = false;
                return control;
            }
        }
        return control;
    }


}
