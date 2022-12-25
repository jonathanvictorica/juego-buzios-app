/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.comercio;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.isla.Recurso;
import com.jmg.buzios.model.jugador.Jugador;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DepositoMercado {
    private Jugador jugador;
    private List<Recurso> recursos = new ArrayList<>();
    private List<Integer> cantidad = new ArrayList<>();

    public DepositoMercado(Jugador jugador) {
        this.jugador = jugador;
    }





    public void almacenarrecursomercado( Recurso recurso, int cantidadacomprar) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL ALMACENAR_RECURSO_MERCADO(?,?,?)");

        procedimiento.setString("NICKJUGADOR", this.jugador.getNick());
        procedimiento.setString("RECURSO", recurso.getNombrerecurso());
        procedimiento.setInt("CANTIDADDEPOSITAR", cantidadacomprar);


        procedimiento.execute();
    }

    public boolean verificarrecursoendeposito( String nombrerecurso, int cantidad) throws SQLException {


        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL Verificar_recurso_mercado(?,?,?,?)");

        procedimiento.setString("NICKJUGADOR", this.jugador.getNick());
        procedimiento.setString("RECURSO", nombrerecurso);
        procedimiento.setInt("CANTIDADVERIFICAR", cantidad);
        procedimiento.registerOutParameter("RECURSODISPONIBLE", Types.BOOLEAN);


        procedimiento.execute();
        return procedimiento.getBoolean("RECURSODISPONIBLE");
    }

    public void descontarrecursosdeldeposito( String nombrerecurso, int cantidad) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL DESCONTAR_RECURSO_MERCADO(?,?,?)");

        procedimiento.setString("NICKJUGADOR", this.jugador.getNick());
        procedimiento.setString("RECURSO", nombrerecurso);
        procedimiento.setInt("CANTIDADDEPOSITAR", cantidad);


        procedimiento.execute();
    }

    public void inicializar_recursos_mercado() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select recurso.nombre , depositomercado.cantidad from jugador,depositomercado,recurso where jugador.codigojugador = depositomercado.codigojugador and  recurso.codigorecurso = depositomercado.codigorecurso and jugador.nick = '" + this.jugador.getNick() + "'");
            this.recursos = new ArrayList<>();
            this.cantidad = new ArrayList<>();
            while (rs.next()) {
                Recurso recursonuevo = new Recurso(rs.getString(1));
                this.recursos.add(recursonuevo);
                this.cantidad.add(rs.getInt(2));

            }

        } catch (SQLException ex) {

        }


    }


}
