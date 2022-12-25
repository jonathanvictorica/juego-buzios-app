/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import com.jmg.buzios.config.ConexionDB;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class BarcoMovimiento {
    private MovimientoBarcoActual movimiento;
    private List<Barco> barco = new ArrayList<>();
    private List<Integer> cantidad = new ArrayList<>();

    public BarcoMovimiento() {
        this.barco = new ArrayList<>();
        this.cantidad = new ArrayList<>();
    }



    public void almacenarbarcosdemovimiento() throws SQLException {
        for (int i = 0; i < this.barco.size(); i++) {
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL ALMACENAR_BARCOS_DE_MOVIMIENTO(?,?,?)");
            procedimiento.setInt("CODIGOMOVIMIENTO", this.movimiento.getCodigomov());
            procedimiento.setString("NOMBREBARCO", this.barco.get(i).getNombre());
            procedimiento.setInt("CANTIDAD", this.cantidad.get(i).intValue());

            procedimiento.execute();
        }

    }


}
