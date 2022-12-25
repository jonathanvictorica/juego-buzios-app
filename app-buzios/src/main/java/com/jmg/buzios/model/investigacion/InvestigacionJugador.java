/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.investigacion;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.jugador.Jugador;
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
public class InvestigacionJugador {
    private Investigacion investigacion;
    private Jugador jugador;



    public InvestigacionJugador(Jugador jugador) {
        this.jugador = jugador;
    }



    public List<String> buscarunidadesmilitaresinvestigadas( boolean tipounidadbarco) {
        List<String> unidadesinvestigadas = new ArrayList<>();
        if (tipounidadbarco) {

            unidadesinvestigadas.add("Barco Espolon");
            unidadesinvestigadas.add("Barco Lanzallamas");
            unidadesinvestigadas.add("Barco Espolon a vapor");
            unidadesinvestigadas.add("Barco Ballesta");
            unidadesinvestigadas.add("Barco Catapulta");
            unidadesinvestigadas.add("barco Mortero");
            unidadesinvestigadas.add("Submarino");
            unidadesinvestigadas.add("Barco LanzaMisiles");

        } else {
            unidadesinvestigadas.add("Gigante a Vapor");
            unidadesinvestigadas.add("Hoplita");
            unidadesinvestigadas.add("Espadachin");
            unidadesinvestigadas.add("Lancero");
            unidadesinvestigadas.add("Arquero");
            unidadesinvestigadas.add("Fusilero");
            unidadesinvestigadas.add("Hondero");
            unidadesinvestigadas.add("Ariete");
            unidadesinvestigadas.add("Catapulta");
            unidadesinvestigadas.add("Mortero");
            unidadesinvestigadas.add("Girocoptero");
            unidadesinvestigadas.add("Globo Bombardero");
        }
        return unidadesinvestigadas;

    }

    public List<String> buscaredificioshabilitados() {
        List<String> lista = new ArrayList<>();


        lista.add("Taberna");
        lista.add("Academia");
        lista.add("Almacen");
        lista.add("Astillero de Guerra");
        lista.add("Cabaña del guarda Bosque");
        lista.add("Cuartel");
        lista.add("Deposito");

        lista.add("Mercado");

        lista.add("Puerto");

        lista.add("Carpinteria");
        lista.add("Prensa de Vino");
        lista.add("Oficina del Arquitecto");
        lista.add("Optico");
        lista.add("Area de Pruebas Pirotécnicas");
        return lista;

    }

    public void almacenarinvestigaciondejugador() throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL almacenar_investigacion_de_jugador(?,?)");

        procedimiento.setString("nombrejugador", this.jugador.getNick());
        procedimiento.setInt("codigoinvestigacion", this.investigacion.getCodigoinvestigacion());


        procedimiento.execute();
    }

    public int buscarUltimaInvestigacion( String economía) {
        try {
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL buscar_ultima_investigacion(?,?,?)");

            procedimiento.setString("nombrejugador", this.jugador.getNick());
            procedimiento.setString("temainvestigacion", economía);

            procedimiento.registerOutParameter("numeroinvestigacion", Types.INTEGER);


            procedimiento.execute();
            return procedimiento.getInt("numeroinvestigacion");
        } catch (SQLException ex) {

        }
        return 0;

    }


}
