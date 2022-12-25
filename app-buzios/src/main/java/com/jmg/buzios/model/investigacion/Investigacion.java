/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.investigacion;

import com.jmg.buzios.config.ConexionDB;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Investigacion {


    private int codigoinvestigacion;
    private String titulo;
    private String descripcion;
    private String permite;
    private int puntosinvestigacion;
    private TemaInvestigacion tema;
    private int numeroorden;

    public Investigacion(int numeroinvestigacioneconomia, TemaInvestigacion tema) {
        this.numeroorden = numeroinvestigacioneconomia + 1;
        this.tema = tema;
    }



    public static int maximoNumerodeTema( TemaInvestigacion temaInvestigacion) {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT investigacion.numeroorden from "
                    + "investigacion,temainvestigacion where investigacion.codigotema =temainvestigacion.codigotema and "
                    + "temainvestigacion.tema ='" + temaInvestigacion.getTema() + "' order by investigacion.numeroorden desc limit 1");
            if (rs.next()) {
                return rs.getInt(1);

            }
        } catch (SQLException ex) {

        }
        return 0;
    }



    public boolean verificarhabilitacionparainvestigar(Integer puntosjugador, int puntosinvestigacion) {
        boolean control = false;
        if (puntosjugador >= puntosinvestigacion) {
            control = true;
        }


        return control;
    }

    public void inicializarInvestigacion() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT investigacion.codigoinvestigacion,investigacion.titulo,investigacion.descripcion,investigacion.puntosinvestigacion,temainvestigacion.tema,investigacion.efecto,investigacion.numeroorden from investigacion,temainvestigacion where numeroorden=" + this.numeroorden + " and investigacion.codigotema =temainvestigacion.codigotema and "
                    + "temainvestigacion.tema ='" + this.tema.getTema() + "' ");
            if (rs.next()) {
                this.codigoinvestigacion = rs.getInt(1);
                this.titulo = rs.getString(2);
                this.descripcion = rs.getString(3);
                this.puntosinvestigacion = rs.getInt(4);
                this.tema = new TemaInvestigacion(rs.getString(5));
                this.permite = rs.getString(6);
                this.numeroorden = rs.getInt(7);

            }
        } catch (SQLException ex) {

        }
    }

}
