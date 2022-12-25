/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.isla.Recurso;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class Carga {
    private MovimientoBarcoActual movimiento;
    private List<Recurso> recurso;
    private List<Integer> cantidad;



    public Carga(MovimientoBarcoActual movimiento, List<Recurso> recurso, List<Integer> cantidad) {
        this.movimiento = movimiento;
        this.recurso = recurso;
        this.cantidad = cantidad;
    }



    public void almacenarcargarecursos() throws SQLException {
        for (int i = 0; i < this.recurso.size(); i++) {
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL almacenar_carga_en_barcos(?,?,?)");
            procedimiento.setInt("CODIGOMOVIMIENTO", this.movimiento.getCodigomov());
            procedimiento.setString("NOMBRERECURSO", this.getRecurso().get(i).getNombrerecurso());
            procedimiento.setInt("CANTIDADALMACENAR", this.getCantidad().get(i).intValue());

            procedimiento.execute();

        }

    }

}
