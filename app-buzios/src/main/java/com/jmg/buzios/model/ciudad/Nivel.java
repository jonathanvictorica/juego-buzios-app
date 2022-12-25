/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.ciudad;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.imagen.Imagenes;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
public class Nivel {
    private Integer nivel;
    private Integer capacidadhabitantes;
    private Integer capacidadmilitarterrestre;
    private Integer capacidadmilitarnaval;
    private Integer impuestociudadano;
    private Imagenes imagennivel;
    private Integer cantidadproduccionbienes;
    private Integer cantidadproduccionmadera;
    private Imagenes imagenciudad;

    public Nivel() {
    }

    public Nivel(Integer nivel) {
        this.nivel = nivel;
    }




    public void inicializar_nivel() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT nivelciudad.capacidadhabitante "
                    + "as cantidadHabitante, nivelciudad.capacidadmilitarterrestre "
                    + "as CapacidadMilitarTerrestre , nivelciudad.capacidadmilitarnaval as"
                    + " CapacidadMilitarNaval, nivelciudad.impuestociudadano as ImpuestoCiudadano,"
                    + " imagenes.direccion as ImagenNivel, nivelciudad.cantidadmaderamaxima as "
                    + "Madera, nivelciudad.cantidadrecursomaxima as CantidadRecursoLujo, "
                    + "imagenes_1.direccion as ImagenCiudad FROM (nivelciudad INNER JOIN"
                    + " imagenes ON nivelciudad.codigoimagen = imagenes.codigoimagen)"
                    + " INNER JOIN imagenes AS imagenes_1 ON nivelciudad.codigoimagenciudad "
                    + "= imagenes_1.codigoimagen WHERE (((nivelciudad.nivel)=" + this.getNivel() +
                    "))");

            if (rs.next()) {
                this.capacidadhabitantes = rs.getInt(1);
                this.capacidadmilitarterrestre = rs.getInt(2);
                this.capacidadmilitarnaval = rs.getInt(3);
                this.impuestociudadano = rs.getInt(4);
                this.imagennivel = new Imagenes(rs.getString(5));

                this.cantidadproduccionmadera = rs.getInt(6);
                this.cantidadproduccionbienes = rs.getInt(7);
                this.imagenciudad = new Imagenes(rs.getString(8));

            }
        } catch (SQLException ex) {

        }
    }
}
