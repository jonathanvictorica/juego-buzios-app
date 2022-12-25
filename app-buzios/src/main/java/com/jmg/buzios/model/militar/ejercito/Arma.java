/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.ejercito;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.imagen.Imagenes;
import com.jmg.buzios.model.isla.Recurso;
import com.jmg.buzios.view.ciudad.VCiudad;
import lombok.*;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Arma {
    private int codigoarma;
    private String nombrearma;
    private int puntosataque;
    private int puntosdefensivos;
    private int costo;
    private ArmaConstruccion armaconstruccion;
    private Imagenes imagenarma;

    public Arma(int codigoarma, String nombrearma, int puntosataque, int puntosdefensivos, int costo, ArmaConstruccion armaconstruccion) {
        this.codigoarma = codigoarma;
        this.nombrearma = nombrearma;
        this.puntosataque = puntosataque;
        this.puntosdefensivos = puntosdefensivos;
        this.costo = costo;
        this.armaconstruccion = armaconstruccion;
    }

    public Arma(int codigoarma){
        this.codigoarma=codigoarma;
    }


    public void calcularrecursosdecantidaddearma(Integer cantidad) {
        for (int i = 0; i < this.armaconstruccion.getRecursos().size(); i++) {

            this.armaconstruccion.getCantidad().set(i, (this.armaconstruccion.getCantidad().get(i) * cantidad));
        }
    }


    public void construiryasignararmas(Integer cantidad, UnidadMilitar unidadmilitar, VCiudad ciudad) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL CONSTRUIR_Y_ASIGNAR_ARMAS (?,?,?,?,?)");
        procedimiento.setString("jugadornombre", ciudad.getCiudad().getJugador().getNick());
        procedimiento.setString("nombreciudad", ciudad.getCiudad().getNombre());
        procedimiento.setString("nombreunidad", unidadmilitar.getNombre());
        procedimiento.setString("nombre_arma", this.getNombrearma());

        procedimiento.setInt("cantidadasignar", cantidad);

        procedimiento.execute();
    }

    public void inicializardatosdearma() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT arma.nombrearma,arma.puntosataque, arma.puntosdefensa,arma.costo, imagenes.direccion from arma,imagenes where arma.codigoarma=" + this.codigoarma + " and arma.codigoimagen = imagenes.codigoimagen");
            if (rs.next()) {
                this.nombrearma = rs.getString(1);

                this.costo = rs.getInt(4);
                this.puntosdefensivos = rs.getInt(3);
                this.puntosataque = rs.getInt(2);
                this.setImagenarma(new Imagenes(rs.getString(5)));


            }

        } catch (SQLException ex) {

        }
    }

    public void buscarRecursosArma() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery(" select recurso.nombre, armaconstruccion.cantidad from recurso,armaconstruccion where armaconstruccion.codigorecurso = recurso.codigorecurso and armaconstruccion.codigoarma =" + this.codigoarma);
            this.armaconstruccion = new ArmaConstruccion(this);

            while (rs.next()) {
                Recurso recursonuevo = new Recurso(rs.getString(1));
                this.armaconstruccion.getRecursos().add(recursonuevo);
                this.armaconstruccion.getCantidad().add(rs.getInt(2));
            }
        } catch (SQLException ex) {

        }

    }


}
