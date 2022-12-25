/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.ejercito;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.isla.Recurso;
import lombok.*;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadMilitarConstruccion {
    private UnidadMilitar unidad;
    private List<Recurso> recurso = new ArrayList<>();
    private List<Integer> cantidad = new ArrayList<>();






    public void calcularcantidadtotalrecursos(int cantidad) {
        for (int i = 0; i < this.recurso.size(); i++) {
            this.cantidad.set(i, this.cantidad.get(i).intValue() * cantidad);
        }
    }

    public void buscarrecursosunidadconstruccion() throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL BUSCAR_RECURSO_UNIDAD_MILITAR(?,?,?,?,?,?)");

        procedimiento.setString("NOMBREUNIDAD", this.unidad.getNombre());

        procedimiento.registerOutParameter("MADERA", Types.INTEGER);
        procedimiento.registerOutParameter("MARMOL", Types.INTEGER);
        procedimiento.registerOutParameter("VINO", Types.INTEGER);
        procedimiento.registerOutParameter("CRISTAL", Types.INTEGER);
        procedimiento.registerOutParameter("AZUFRE", Types.INTEGER);
        procedimiento.execute();

        Recurso recurso;

        recurso = new Recurso("Madera");
        this.recurso.add(recurso);
        this.cantidad.add(procedimiento.getInt("madera"));

        recurso = new Recurso("Marmol");
        this.recurso.add(recurso);
        this.cantidad.add(procedimiento.getInt("marmol"));

        recurso = new Recurso("Vino");
        this.recurso.add(recurso);
        this.cantidad.add(procedimiento.getInt("vino"));

        recurso = new Recurso("Cristal");
        this.recurso.add(recurso);
        this.cantidad.add(procedimiento.getInt("cristal"));

        recurso = new Recurso("Azufre");
        this.recurso.add(recurso);
        this.cantidad.add(procedimiento.getInt("azufre"));


    }


}
