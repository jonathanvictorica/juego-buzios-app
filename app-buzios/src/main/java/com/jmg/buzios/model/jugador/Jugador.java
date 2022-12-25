/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.jugador;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.ciudad.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Jugador {


    private int codigojugador;
    private String nick;
    private String clave;
    private String fechaingreso;
    private String estado;
    private int oro;
    private int puntostotales;
    private boolean protegido;
    private boolean vacaciones;
    private PuntosJugador puntosjugador;

    private List<MensajePrivado> mensajesenviados;
    private List<MensajePrivado> mensajesrecibidos;
    private List<Ciudad> ciudades;

    public Jugador() {
        this.ciudades = new ArrayList<>();
        this.puntosjugador = new PuntosJugador();


    }

    public Jugador(String nick) {
        this.nick = nick;
    }

    public static Jugador buscarJugador( int codigo) {
        Jugador jugadornuevo = new Jugador();
        try {

            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from jugador where codigojugador =" + codigo);

            if (rs.next()) {
                jugadornuevo.codigojugador = codigo;
                jugadornuevo.nick = rs.getString(2);

            }
        } catch (SQLException ex) {

        }
        return jugadornuevo;
    }



    public boolean verificaroro( int costo) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_ORO(?,?,?)");

        procedimiento.setString("NICKJUGADOR", this.nick);
        procedimiento.setInt("CANTIDADORO", costo);
        procedimiento.registerOutParameter("TIENE", Types.BOOLEAN);


        procedimiento.execute();

        return procedimiento.getBoolean("TIENE");
    }

    public void pagaroro( int costo) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL PAGAR_ORO(?,?)");
        procedimiento.setString("NICKJUGADOR", this.getNick());
        procedimiento.setInt("CANTIDADORO", costo);
        procedimiento.execute();
    }

    public boolean verificarnombredeciudaddisponible( String nombreviejo, String nombrenuevo) throws SQLException {
        /* VERIFICAR_NOMBRE_DE_CIUDAD_DISPONIBLE(in nombreciudad varchar,in nickjugador varchar, in nombreciudadnuevo varchar, out disponible boolean)*/

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_NOMBRE_DE_CIUDAD_DISPONIBLE(?,?,?,?)");

        procedimiento.setString("nombreciudad", nombreviejo);
        procedimiento.setString("nickjugador", this.getNick());
        procedimiento.setString("nombreciudadnuevo", nombrenuevo);
        procedimiento.registerOutParameter("disponible", Types.BOOLEAN);

        procedimiento.execute();

        return procedimiento.getBoolean("disponible");

    }


    public boolean verificarcontraseñadistintaalaantigua( String contraseñanueva) throws SQLException {
        /*VERIFICAR_CONTRASEÑA_DISTINTA_A_LA_ANTIGUA(in nickjugador varchar, in clavenueva varchar, out igual boolean)*/
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_CONTRASENIA_DISTINTA_A_LA_ANTIGUA(?,?,?)");

        procedimiento.setString("nickjugador", this.getNick());
        procedimiento.setString("clavenueva", contraseñanueva);
        procedimiento.registerOutParameter("igual", Types.BOOLEAN);

        procedimiento.execute();

        return procedimiento.getBoolean("igual");


    }

    public void modificarcontraseña( String contraseñanueva) throws SQLException {
        /*MODIFICAR_CONTRASEÑA(in nickjugador varchar, in clavenueva varchar)*/

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("call MODIFICAR_CONTRASENIA(?,?)");
        procedimiento.setString("nickjugador", this.getNick());
        procedimiento.setString("clavenueva", contraseñanueva);

        procedimiento.execute();


    }

    public boolean verificarnickdisponible( String nicknuevo) throws SQLException {
        /*VERIFICAR_NICK_DISPONIBLE(in nickjugador varchar, in nickacambiar varchar, out nickdisponible boolean)*/
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_NICK_DISPONIBLE(?,?,?)");

        procedimiento.setString("nickjugador", this.getNick());
        procedimiento.setString("nickacambiar", nicknuevo);
        procedimiento.registerOutParameter("nickdisponible", Types.BOOLEAN);

        procedimiento.execute();

        return procedimiento.getBoolean("nickdisponible");
    }

    public void cambiarnick( String nicknuevo) throws SQLException {
        /*Cambiar_nick(in nickjugador varchar, in nickacambiar varchar)*/
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL CAMBIAR_NICK(?,?)");

        procedimiento.setString("nickjugador", this.getNick());
        procedimiento.setString("nickacambiar", nicknuevo);

        procedimiento.execute();

        this.setNick(nicknuevo);

    }

    public void recibiroro( int cantidadacomprar) throws SQLException {
        /*recibir_oro(in nickjugador varchar, in cantidadoro int);*/
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL recibir_oro(?,?)");

        procedimiento.setString("NICKJUGADOR", this.getNick());
        procedimiento.setInt("CANTIDADORO", cantidadacomprar);

        procedimiento.execute();


    }




    public void buscarciudadesdejugador() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT ciudad.nombre "
                    + "FROM ciudad INNER JOIN jugador ON ciudad.codigojugador ="
                    + " jugador.codigojugador WHERE (((jugador.nick)='" + this.getNick() + "')) and ciudad.activa = true");
            this.ciudades = new ArrayList<>();

            while (rs.next()) {
                Ciudad ciudadnueva = new Ciudad(rs.getString("nombre"), this);
                ciudadnueva.inicializarciudad();
                this.ciudades.add(ciudadnueva);


            }
        } catch (SQLException ex) {

        }
    }


    public void almacenarjugador() throws SQLException {
        //almacenar_jugador(in nickjugador varchar, in clave varchar)//
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL ALMACENAR_JUGADOR(?,?)");

        procedimiento.setString("nickjugador", this.getNick());
        procedimiento.setString("clave", this.getClave());

        procedimiento.execute();

        //Este procedimiento almacenado tambien debe crear la ciudad capital
    }

    public void inicializarciudadesdejugador() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT ciudad.nombre,ciudad.capital "
                    + "FROM ciudad INNER JOIN jugador ON ciudad.codigojugador ="
                    + " jugador.codigojugador WHERE (((jugador.nick)='" + this.getNick() + "'))");
            this.ciudades = new ArrayList<>();

            while (rs.next()) {
                Ciudad ciudadnueva = new Ciudad(rs.getString("nombre"), this);
                ciudadnueva.setCapital(rs.getBoolean(2));
                this.ciudades.add(ciudadnueva);


            }
        } catch (SQLException ex) {

        }
    }


    public int buscarcantidadciudades() throws SQLException, SQLException, SQLException, SQLException, SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL BUSCAR_CANTIDAD_CIUDADES(?,?)");

        procedimiento.setString("nickjugador", this.nick);
        procedimiento.registerOutParameter("cantidadciudades", Types.INTEGER);


        procedimiento.execute();
        return procedimiento.getInt("cantidadciudades");
    }

    public boolean verificarpalacioyciudades( int cantidadciudades) throws SQLException {
        /* verificar_palacio_y_ciudades(in nickjugador varchar,in cantidadciudades int, out capacidadconstruirciudad boolean)*/
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL verificar_palacio_y_ciudades(?,?,?)");

        procedimiento.setString("nickjugador", this.getNick());
        procedimiento.setInt("cantidadciudades", cantidadciudades);
        procedimiento.registerOutParameter("capacidaconstruirciudad", Types.BOOLEAN);

        procedimiento.execute();


        return procedimiento.getBoolean("capacidaconstruirciudad");
    }


    public Ciudad buscarultimaciudadfundada() {
        this.buscarciudadesdejugador();
        return this.ciudades.get(this.ciudades.size() - 1);

    }


}