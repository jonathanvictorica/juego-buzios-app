/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.ejercito;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.imagen.Imagenes;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadMilitar {
    private Integer codigounidad;
    private String nombre;
    private String descripcion;
    private Imagenes imagen;
    private Integer costo;
    private Integer puntosdefensivos;
    private Integer puntosataque;
    private Integer cantidadhabitantes;
    private boolean barco;
    private Integer nivelnecesario;
    private Integer carga;

    private int cantidadsinarma;


    private UnidadMilitarConstruccion unidadmilitarconstruccion;
    private ArmaUnidad armaunidad;




    public static List<UnidadMilitar> inicializarlistadeunidadesmilitares(List<String> nombredeunidades_descubiertas) {
        List<UnidadMilitar> unidadmilitar = new ArrayList<>();
        for (int i = 0; i < nombredeunidades_descubiertas.size(); i++) {
            UnidadMilitar unidadmilitarnueva = new UnidadMilitar();
            unidadmilitarnueva.inicializar_unidad_militar( nombredeunidades_descubiertas.get(i));
            unidadmilitarnueva.setUnidadmilitarconstruccion(new UnidadMilitarConstruccion());
            unidadmilitarnueva.unidadmilitarconstruccion.setUnidad(unidadmilitarnueva);
            try {
                unidadmilitarnueva.getUnidadmilitarconstruccion().buscarrecursosunidadconstruccion();
            } catch (SQLException ex) {
            }

            unidadmilitar.add(unidadmilitarnueva);
        }
        return unidadmilitar;
    }



    public void cantidadtotalhabitantes(Integer cantidad) {
        this.cantidadhabitantes *= cantidad;
    }



    public void inicializar_unidad( int codigo) {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from unidadmilitar where codigounidad=" + codigo);
            if (rs.next()) {
                this.codigounidad = rs.getInt(1);
                this.nombre = rs.getString(2);
                this.descripcion = rs.getString(3);
                this.imagen = new Imagenes();
                this.imagen.setCodigoimagen(rs.getInt(4));
                this.costo = rs.getInt(5);
                this.puntosdefensivos = rs.getInt(6);
                this.puntosataque = rs.getInt(7);
                this.barco = rs.getBoolean(8);
                this.nivelnecesario = rs.getInt(9);
                this.carga = rs.getInt(10);
                this.cantidadhabitantes = rs.getInt(11);


            }

        } catch (SQLException ex) {

        }

    }

    private void inicializar_unidad_militar(String nombreunidad) {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from unidadmilitar where nombre='" + nombreunidad + "'");
            if (rs.next()) {
                this.codigounidad = rs.getInt(1);
                this.nombre = rs.getString(2);
                this.descripcion = rs.getString(3);

                this.costo = rs.getInt(5);
                this.puntosdefensivos = rs.getInt(6);
                this.puntosataque = rs.getInt(7);
                this.barco = rs.getBoolean(8);
                this.nivelnecesario = rs.getInt(9);
                this.carga = rs.getInt(10);
                this.cantidadhabitantes = rs.getInt(11);
            }

        } catch (SQLException ex) {

        }
    }


}
