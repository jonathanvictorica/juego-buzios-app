/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.ciudad;

import com.jmg.buzios.config.ConexionDB;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

@Getter
@Setter
public class CiudadProduccion {
    private Ciudad ciudad;
    private int cantidadmaderaporhora;
    private int cantidadporhora;
    private String fechaactualizacion;

    public CiudadProduccion(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    CiudadProduccion() {

    }




    public void inicializarproduccionciudad() throws SQLException {


        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL Inicializar_produccion_ciudad(?,?,?,?,?)");
        procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
        procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
        procedimiento.registerOutParameter("cantidadmadera", Types.INTEGER);
        procedimiento.registerOutParameter("recursolujo", Types.VARCHAR);
        procedimiento.registerOutParameter("cantidadrecursolujo", Types.INTEGER);

        procedimiento.execute();


        this.cantidadmaderaporhora = procedimiento.getInt("cantidadmadera");
        this.cantidadporhora = procedimiento.getInt("cantidadrecursolujo");


    }

    public void asignarnuevostrabajadores( Integer trabajadoresnuevos, String recurso) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL asignar_nuevos_trabajadores(?,?,?,?)");
        procedimiento.setString("nombrejugador", this.getCiudad().getJugador().getNick());
        procedimiento.setString("nombreciudad", this.getCiudad().getNombre());

        procedimiento.setString("recurso", recurso);
        procedimiento.setInt("cantidadtrabajadores", trabajadoresnuevos);

        procedimiento.execute();
    }


}
