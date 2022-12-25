/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.jugador.Jugador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Ataque {
    protected Integer codigoataque;
    protected Ciudad ciudadjugatacante;
    protected Ciudad ciudadjugatacado;
    protected Date fechasalida;
    protected Time horasalida;
    protected Date fechallegada;
    protected Time horallegada;
    protected MisionMilitar misionmilitar;
    protected Jugador jugadorganador;
    protected AtaqueUnidadesdeCombate unidadesdecombate;
    protected MovimientoMilitar movimiento;

    public Ataque() {
        this.ciudadjugatacado = new Ciudad();
        this.ciudadjugatacante = new Ciudad();
    }

    public Ataque(Ciudad ciudadjugatacante, Ciudad ciudadjugatacado, MisionMilitar misionmilitar) {
        this.ciudadjugatacante = ciudadjugatacante;
        this.ciudadjugatacado = ciudadjugatacado;
        this.misionmilitar = misionmilitar;
        this.unidadesdecombate = new AtaqueUnidadesdeCombate(this);
    }

    public Ataque(Ciudad ciudadjugatacante, Ciudad ciudadjugatacado, Date fechallegada, Time horallegada, MisionMilitar misionmilitar, AtaqueUnidadesdeCombate unidadesdecombate) {
        this.ciudadjugatacante = ciudadjugatacante;
        this.ciudadjugatacado = ciudadjugatacado;
        this.fechallegada = fechallegada;
        this.horallegada = horallegada;
        this.misionmilitar = misionmilitar;
        this.unidadesdecombate = unidadesdecombate;
    }



    public void almacenarataque() {
        try {
            MovimientoBarcoActual mov = new MovimientoBarcoActual(this.ciudadjugatacado, this.ciudadjugatacante);
            mov.calculartiempollegada();

            CallableStatement procedimiento2 = ConexionDB.getConexion().prepareCall("CALL almacenar_ataque(?,?,?,?,?)");

            procedimiento2.setInt("codigo_ciudad_atacante", this.ciudadjugatacante.getCodigociudad());
            procedimiento2.setInt("codigo_ciudad_atacado", this.ciudadjugatacado.getCodigociudad());
            procedimiento2.setString("mision_militar", this.misionmilitar.getNombremision());
            procedimiento2.setInt("tiempotarda", mov.tiempo);
            procedimiento2.registerOutParameter("codigo_ataque", Types.INTEGER);
            procedimiento2.execute();
            this.codigoataque = procedimiento2.getInt("codigo_ataque");

        } catch (SQLException ex) {

        }
    }

    public void almacenarunidadesdecombate() throws SQLException {

        String jugador;
        String ciudad;
        for (int i = 0; i < this.getUnidadesdecombate().getUnidadmilitar().size(); i++) {
            if (this.getUnidadesdecombate().getAtacante().get(i).booleanValue()) {
                jugador = this.getCiudadjugatacante().getJugador().getNick();
                ciudad = this.getCiudadjugatacante().getNombre();
            } else {
                jugador = this.getCiudadjugatacado().getJugador().getNick();
                ciudad = this.getCiudadjugatacado().getNombre();
            }
            if (this.getUnidadesdecombate().getArma().get(i) == null) {
                CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL almacenar_unidades_militares_combate_sin_arma(?,?,?,?,?)");

                procedimiento.setInt("codigo_ataque", this.getCodigoataque());
                procedimiento.setString("nombreciudad", ciudad);
                procedimiento.setString("nickjugador", jugador);
                procedimiento.setString("nombreunidad", this.getUnidadesdecombate().getUnidadmilitar().get(i).getNombre());
                procedimiento.setInt("cantidad", this.getUnidadesdecombate().getCantidad().get(i).intValue());
                procedimiento.execute();

            } else {
                CallableStatement procedimiento2 = ConexionDB.getConexion().prepareCall("CALL almacenar_unidades_militares_combate_con_arma(?,?,?,?,?,?)");

                procedimiento2.setInt("codigo_ataque", this.getCodigoataque());
                procedimiento2.setString("nombreciudad", this.getCiudadjugatacante().getNombre());
                procedimiento2.setString("nickjugador", this.getCiudadjugatacante().getJugador().getNick());
                procedimiento2.setString("nombreunidad", this.getUnidadesdecombate().getUnidadmilitar().get(i).getNombre());
                procedimiento2.setString("NOMBREARMA", this.getUnidadesdecombate().getArma().get(i).getNombrearma());
                procedimiento2.setInt("cantidad", this.getUnidadesdecombate().getCantidad().get(i).intValue());


                procedimiento2.execute();

            }

        }
    }


}
