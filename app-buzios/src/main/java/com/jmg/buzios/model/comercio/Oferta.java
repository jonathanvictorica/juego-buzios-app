/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.comercio;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.isla.Recurso;
import com.jmg.buzios.model.jugador.Jugador;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Getter
@Setter
public class Oferta {


    private int codigooferta;
    private Recurso recurso;
    private int cantidad;
    private boolean orobuscado;
    private Recurso recursobuscado;
    private boolean jugador;

    public Oferta() {
    }

    public Oferta(int codigooferta, boolean jugador) {
        this.codigooferta = codigooferta;
        this.jugador = jugador;
    }

    public Oferta(Recurso recurso, int cantidad, boolean orobuscado, Recurso recursobuscado, boolean jugador) {
        this.recurso = recurso;
        this.cantidad = cantidad;
        this.orobuscado = orobuscado;
        this.recursobuscado = recursobuscado;
        this.jugador = jugador;
    }

    public static void buscarOfertas( List<Oferta> ofertas, Jugador jugador) {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("(SELECT oferta.codigooferta, oferta.jugador "
                    + "FROM (ofertajugador INNER JOIN oferta ON ofertajugador.codigooferta ="
                    + " oferta.codigooferta) INNER JOIN jugador ON (ofertajugador.codigojugador = "
                    + " jugador.codigojugador) AND (ofertajugador.codigojugador = jugador.codigojugador) "
                    + "  WHERE (((jugador.nick)<>'" + jugador.getNick() + "'))) union "
                    + "    (SELECT oferta.codigooferta, oferta.jugador FROM oferta "
                    + "    WHERE (((oferta.jugador)=False)))");

            while (rs.next()) {
                ofertas.add(new Oferta(rs.getInt(1), rs.getBoolean(2)));

            }
        } catch (SQLException ex) {

        }

    }

    public static void buscarOfertas( List<Oferta> ofertas, String recursofiltro, Jugador jugador) {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("(SELECT oferta.codigooferta, oferta.jugador FROM recurso INNER JOIN ((ofertajugador INNER JOIN oferta ON ofertajugador.codigooferta = oferta.codigooferta) INNER JOIN jugador ON (ofertajugador.codigojugador = jugador.codigojugador) AND (ofertajugador.codigojugador = jugador.codigojugador)) ON recurso.codigorecurso = oferta.codigorecurso WHERE (((jugador.nick)<>'" + jugador.getNick() + "') AND ((recurso.nombre)='" + recursofiltro + "'))) union (SELECT oferta.codigooferta, oferta.jugador FROM recurso INNER JOIN oferta ON recurso.codigorecurso = oferta.codigorecurso WHERE (((oferta.jugador)=False) AND ((recurso.nombre)='" + recursofiltro + "')))");

            while (rs.next()) {
                ofertas.add(new Oferta(rs.getInt(1), rs.getBoolean(2)));

            }
        } catch (SQLException ex) {
        }


    }



    public boolean verificarofertaexista( int codigooferta) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_OFERTA_EXISTA(?,?)");

        procedimiento.setInt("codigooferta", this.codigooferta);
        procedimiento.registerOutParameter("existe", Types.BOOLEAN);


        procedimiento.execute();
        return procedimiento.getBoolean("existe");


    }

    public boolean verificarcantidadacomprar( int cantidadacomprar) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL verificar_cantidad_a_comprar(?,?,?)");

        procedimiento.setInt("codigooferta", this.codigooferta);
        procedimiento.setInt("cantidad", cantidadacomprar);
        procedimiento.registerOutParameter("tiene", Types.BOOLEAN);


        procedimiento.execute();

        return procedimiento.getBoolean("tiene");
    }

    public void descontarrecursooferta( int cantidadacomprar) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL DESCONTAR_RECURSOS_OFERTA(?,?)");

        procedimiento.setInt("CODIGOOFERTAS", this.codigooferta);
        procedimiento.setInt("cantidaddescuento", cantidadacomprar);


        procedimiento.execute();
    }

    public void inicializarOferta() throws SQLException {
        java.sql.Statement statement = ConexionDB.getConexion().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from oferta where codigooferta=" + this.codigooferta);

        if (rs.next()) {

            this.codigooferta = rs.getInt(1);
            this.recurso = new Recurso(rs.getInt(2));
            this.recurso.inicializar_recurso();
            this.cantidad = rs.getInt(3);
            this.orobuscado = rs.getBoolean(4);
            if (rs.getInt(5) != 0) {
                this.recursobuscado = new Recurso(rs.getInt(5));

                this.recursobuscado.inicializar_recurso();


            }
        }


    }

    public void inicializarOfertaJugador( OfertaJugador ofertajugador) throws SQLException {

        java.sql.Statement statement = ConexionDB.getConexion().createStatement();
        ResultSet rs = statement.executeQuery("SELECT jugador.nick from jugador,oferta,ofertajugador where oferta.codigooferta=ofertajugador.codigooferta and jugador.codigojugador= ofertajugador.codigojugador and oferta.codigooferta=" + this.codigooferta);

        if (rs.next()) {
            ofertajugador.setJugador(new Jugador(rs.getString(1)));
            ofertajugador.inicializarOferta();
        }


    }

}
