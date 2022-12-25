/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.isla;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.imagen.Imagenes;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recurso {

    private int codigorecurso;
    private String nombrerecurso;
    private Imagenes imagenrecurso;

    public Recurso(String madera) {
        this.nombrerecurso = madera;
    }

    public Recurso(int codigorecurso) {
        this.codigorecurso = codigorecurso;
    }



    public void inicializar_recurso() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from recurso where codigorecurso=" + this.codigorecurso);
            if (rs.next()) {
                this.nombrerecurso = rs.getString(2);
            }
        } catch (SQLException ex) {

        }

    }


}
