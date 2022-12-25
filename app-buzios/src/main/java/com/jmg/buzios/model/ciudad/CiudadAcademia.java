/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.ciudad;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.ArmaUnidad;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
public class CiudadAcademia {

    private Ciudad ciudad;
    private int investigadores;
    private Date fechaactualizacion;



    CiudadAcademia() {

    }



    public void actualizarinvestigadores( int cantidadasignar) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL actualizar_investigadores(?,?,?)");
        procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
        procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
        procedimiento.setInt("cant_investigadores_actualizados", cantidadasignar);

        procedimiento.execute();

    }

    public void inicializaracademiadeciudad() throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL INICIALIZAR_ACADEMIA_DE_CIUDAD(?,?,?)");
        procedimiento.setString("nombreciudad", this.ciudad.getNombre());
        procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
        procedimiento.registerOutParameter("cantidadinvestigadores", this.getInvestigadores()); //verificar si
        //es de salida

        procedimiento.execute();
        this.investigadores = procedimiento.getInt("cantidadinvestigadores");
        //REVISADO

    }



    public void buscarlistadearmasdeunidad( UnidadMilitar unidad) {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select arma.codigoarma from arma,armaunidad,unidadmilitar where arma.codigoarma = armaunidad.codigoarma and armaunidad.codigounidad = unidadmilitar.codigounidad and unidadmilitar.nombre = '" + unidad.getNombre() + "'");
            unidad.setArmaunidad(new ArmaUnidad(unidad));

            while (rs.next()) {
                unidad.getArmaunidad().getListarmas().add(new Arma(rs.getInt(1)));
            }
        } catch (SQLException ex) {

        }


    }

    public boolean verificartemainvestigado(String bloqueo_de_puerto) {
        return true;
    }
}
