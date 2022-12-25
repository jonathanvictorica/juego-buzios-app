/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.edificio;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.isla.Recurso;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

@Getter
@Setter
@NoArgsConstructor
public class EdificioNivel {
    private Integer codigoedifnivel;
    private Edificio edificio = new Edificio();
    private EdificioRecurso edificiorecurso = new EdificioRecurso();
    private int nivel;


    public EdificioNivel(Edificio edificio, int nivel) {
        this.edificio = edificio;
        this.nivel = nivel;
    }




    public boolean verificarposibleampliacionedificio() throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_POSIBLE_AMPLIACION(?,?,?)");
        procedimiento.setString("nombreedificio", this.getEdificio().getNombre());
        procedimiento.setInt("nivel", (this.getNivel() + 1));
        procedimiento.registerOutParameter("ampliacionposible", Types.BOOLEAN);
        procedimiento.execute();


        return procedimiento.getBoolean("ampliacionposible");

    }


    public void elevaredificio( Ciudad ciudadjugador) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL elevar_edificio(?,?,?,?)");
        procedimiento.setString("NOMBRECIUDAD", ciudadjugador.getNombre());
        procedimiento.setString("NOMBREJUGADOR", ciudadjugador.getJugador().getNick());
        procedimiento.setString("NOMBREEDIFICIO", this.getEdificio().getNombre());
        procedimiento.setInt("NIVELVIEJO", this.getNivel());
        procedimiento.execute();

    }

    public void inicializardatosdeedificio( Ciudad ciudadjugador) {
        try {
            //tener en cuenta los decuentos de madera,vino,cristal,azufre
            //que se necesitan para construir edificios
            this.edificio.inicializar_edificio();
            this.buscarlistarecursosconstruccion(1, ciudadjugador);
        } catch (SQLException ex) {

        }

    }

    public void buscarlistarecursosconstruccion( int i, Ciudad ciudadjugador) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("call BUSCAR_LISTA_CONSTRUCCION (?,?,?,?,?,?)");
        procedimiento.setString("NOMBREEDIFICIO", this.getEdificio().getNombre());
        procedimiento.setInt("NIVEL", i);
        procedimiento.registerOutParameter("MADERA", Types.INTEGER);
        procedimiento.registerOutParameter("MARMOL", Types.INTEGER);
        procedimiento.registerOutParameter("CRISTAL", Types.INTEGER);
        procedimiento.registerOutParameter("AZUFRE", Types.INTEGER);
        procedimiento.execute();


        if (procedimiento.getInt("Madera") > 0) {
            this.edificiorecurso.getRecurso().add(new Recurso("Madera"));
            this.edificiorecurso.getCantidad().add(procedimiento.getInt("Madera"));
        }
        if (procedimiento.getInt("Azufre") > 0) {
            this.edificiorecurso.getRecurso().add(new Recurso("Azufre"));
            this.edificiorecurso.getCantidad().add(procedimiento.getInt("Azufre"));
        }
        if (procedimiento.getInt("Cristal") > 0) {
            this.edificiorecurso.getRecurso().add(new Recurso("Cristal"));
            this.edificiorecurso.getCantidad().add(procedimiento.getInt("Cristal"));
        }
        if (procedimiento.getInt("Marmol") > 0) {
            this.edificiorecurso.getRecurso().add(new Recurso("Marmol"));
            this.edificiorecurso.getCantidad().add(procedimiento.getInt("Marmol"));
        }

    }


}
