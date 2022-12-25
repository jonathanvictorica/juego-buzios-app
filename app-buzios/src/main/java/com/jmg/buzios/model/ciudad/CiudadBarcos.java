/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.ciudad;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.militar.acciones.Barco;
import com.jmg.buzios.model.militar.acciones.BarcoMovimiento;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
@Getter
@Setter
public class CiudadBarcos {
    private Ciudad ciudad;
    private List<Barco> barcos = new ArrayList<>();
    private List<Integer> cantidadtotal = new ArrayList<>();
    private List<Integer> cantidaddisponible = new ArrayList<>();


    CiudadBarcos() {

    }


    public void inicializarbarcosdeciudad() {
        try {
            /*consulta sql inicializar barcos de ciudad*/
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from ciudadbarco where codigociudad=" + this.ciudad.getCodigociudad() + "");
            this.barcos.clear();
            this.cantidaddisponible.clear();
            this.cantidadtotal.clear();
            while (rs.next()) {
                Barco barcomercante = new Barco(rs.getInt(2));
                barcomercante.inicializar_barco_mercante2();
                this.cantidaddisponible.add(rs.getInt(4));
                this.barcos.add(barcomercante);
                this.cantidadtotal.add(rs.getInt(3));


            }
        } catch (SQLException ex) {

        }


    }

    public BarcoMovimiento verificarbarcosdisponibles(int calcularpeso) {
        BarcoMovimiento barcomovimiento = new BarcoMovimiento();
        int acumulador = 0;
        int cantidad = 0;
        for (int i = 0; i < this.barcos.size(); i++) {
            cantidad = 0;
            for (int j = 0; j < this.cantidaddisponible.get(i); j++) {
                if (acumulador <= calcularpeso) {
                    acumulador += this.barcos.get(i).getCapacidad();
                    cantidad += 1;
                } else {


                }
            }
            if (cantidad != 0) {
                barcomovimiento.getBarco().add(this.barcos.get(i));
                barcomovimiento.getCantidad().add(cantidad);
            }
        }
        if (this.barcos.isEmpty()) {
            return null;
        }
        if (barcomovimiento.getBarco().isEmpty()) {
            return null;
        }
        if (acumulador >= calcularpeso) {
            return barcomovimiento;
        } else {
            return null;
        }


    }


    public void descontarbarcosdisponiblesenciudad( BarcoMovimiento barcosautilizar) throws SQLException {
        for (int i = 0; i < barcosautilizar.getBarco().size(); i++) {
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL DESCONTAR_BARCOS_DISPONIBLES_EN_CIUDAD(?,?,?,?)");
            procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
            procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
            procedimiento.setString("nombrebarco", barcosautilizar.getBarco().get(i).getNombre());
            procedimiento.setInt("cantidad", barcosautilizar.getCantidad().get(i).intValue());
            procedimiento.execute();
        }
    }

    public void agregarbarco( Barco barcoacomprar) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL agregar_barco(?,?,?)");
        procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
        procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
        procedimiento.setString("barcoacomprar", barcoacomprar.getNombre());

        procedimiento.execute();

    }


}
