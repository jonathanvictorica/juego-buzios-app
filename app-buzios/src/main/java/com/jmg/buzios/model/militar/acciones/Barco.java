/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

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
public class Barco {


    private Integer codigodebarco;
    private String nombre;
    private String descripcion;
    private Imagenes imagenbarco;
    private Integer capacidad;
    private Integer costo;


    public Barco(int codigo) {
        this.codigodebarco = codigo;
    }

    public Barco(String nombre, Integer capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public Barco(String nombre, String descripcion, Imagenes imagenbarco, Integer capacidad, Integer costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenbarco = imagenbarco;
        this.capacidad = capacidad;
        this.costo = costo;
    }

    public static Barco inicializar_barco_mercante() {
        Barco barcos = null;
        try {

            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from barcos");
            if (rs.next()) {
                barcos = new Barco(rs.getString(2), rs.getString(3), null, rs.getInt(5), (int) (rs.getFloat(6)));


            }


            return barcos;
        } catch (SQLException ex) {

        }
        return barcos;

    }



    public void inicializar_barco_mercante2() {
        try {

            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from barcos where codigobarco = " + this.codigodebarco + "");
            if (rs.next()) {
                this.codigodebarco = rs.getInt(1);
                this.nombre = rs.getString(2);
                this.descripcion = rs.getString(3);
                this.capacidad = rs.getInt(5);
                this.costo = (int) (rs.getFloat(6));

            }


        } catch (SQLException ex) {

        }
    }


}
