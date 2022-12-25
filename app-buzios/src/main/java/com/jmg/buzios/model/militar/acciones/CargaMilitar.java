/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import lombok.*;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CargaMilitar {
    private MovimientoMilitar movimientomilitar;
    private List<UnidadMilitar> unidadmilitar;
    private List<Arma> armas;
    private List<Integer> cantidad;

    public CargaMilitar(MovimientoMilitar movimientomilitar) {
        this.unidadmilitar = new ArrayList<>();
        this.armas = new ArrayList<>();
        this.cantidad = new ArrayList<>();
    }




    public void cargarunidadesmilitares() throws SQLException {
        String nombrearma = "";

        for (int i = 0; i < this.unidadmilitar.size(); i++) {
            if (this.armas.get(i) == null) {
                CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL CARGAR_UNIDADES_MILITARES(?,?,?,?)");
                procedimiento.setInt("codigomovimiento", this.getMovimientomilitar().getCodigomov());
                procedimiento.setString("unidadmilitarenviar", this.getUnidadmilitar().get(i).getNombre());
                procedimiento.setString("armaenviar", "");
                procedimiento.setInt("cantidad", this.cantidad.get(i));

                procedimiento.execute();
            } else {


                CallableStatement procedimiento2 = ConexionDB.getConexion().prepareCall("CALL CARGAR_UNIDADES_MILITARES(?,?,?,?)");
                procedimiento2.setInt("codigomovimiento", this.getMovimientomilitar().getCodigomov());
                procedimiento2.setString("unidadmilitarenviar", this.getUnidadmilitar().get(i).getNombre());
                procedimiento2.setString("armaenviar", this.getArmas().get(i).getNombrearma());
                procedimiento2.setInt("cantidad", this.cantidad.get(i));

                procedimiento2.execute();
            }

        }

    }

}
