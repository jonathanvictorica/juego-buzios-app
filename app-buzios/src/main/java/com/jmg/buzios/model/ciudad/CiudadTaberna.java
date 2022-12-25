/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.ciudad;

import com.jmg.buzios.config.ConexionDB;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
public class CiudadTaberna {
    private Ciudad ciudad;
    private int vinoaservir;
    private Date fechaactualizacion;



    public void inicializar_taberna() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT cantidadvinoservido from CIUDADTABERNA where codigociudad =" + this.ciudad.getCodigociudad());

            if (rs.next()) {
                this.vinoaservir = rs.getInt(1);

            }
        } catch (SQLException ex) {

        }


    }


}
