/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.edificio;

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
public class Edificio {

    private int codigoedificio;
    private String nombre;
    private Imagenes imagen;
    private int costo;
    private String descripcion;

    public Edificio(String nombre, Imagenes imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }



    public void inicializar_edificio() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT edificio.codigoedificio,edificio.nombre,imagenes.direccion,edificio.costo,edificio.descripcion from edificio,imagenes where imagenes.codigoimagen = edificio.codigoimagen and edificio.nombre='" + this.nombre + "'");
            if (rs.next()) {
                this.codigoedificio = rs.getInt(1);
                this.nombre = rs.getString(2);
                this.imagen = new Imagenes(rs.getString(3));
                this.costo = rs.getInt(4);
                this.descripcion = rs.getString(5);

            }
        } catch (SQLException ex) {

        }


    }


}
