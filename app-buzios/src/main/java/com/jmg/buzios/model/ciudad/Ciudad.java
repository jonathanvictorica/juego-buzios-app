/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.ciudad;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.model.imagen.Imagenes;
import com.jmg.buzios.model.isla.Isla;
import com.jmg.buzios.model.isla.Recurso;
import com.jmg.buzios.model.jugador.Jugador;
import com.jmg.buzios.model.jugador.PuntosJugador;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

@Getter
@Setter
public class Ciudad {
    private int codigociudad;
    private Jugador jugador;
    private String nombre;
    private Isla isla;
    private Imagenes imagen;
    private Nivel nivel;
    private int capacidadrecurso;
    private int cantidadhabitantes;
    private int cantidadhabitantesdisponibles;
    private int crecimientodehabitante;
    private int gradosatisfacciontotal;

    private EstadoCiudad estado;
    private int numeroposicionisla;
    private boolean activa;
    private boolean capital;

    private CiudadTaberna ciudadtaberna;

    private CiudadRecurso ciudadrecurso;

    private CiudadProduccion ciudadproduccion;
    private CiudadAcademia ciudadacademia;
    private CiudadEdificiodeNivel ciudadedificios;
    private CiudadEjercito ciudadejercito;
    private CiudadBarcos ciudadbarco;

    public Ciudad(String nombre, Jugador jugador) {
        this.nombre = nombre;
        this.jugador = jugador;
        this.estado = new EstadoCiudad();
        this.ciudadacademia = new CiudadAcademia();
        this.ciudadedificios = new CiudadEdificiodeNivel();
        this.ciudadproduccion = new CiudadProduccion();
        this.ciudadejercito = new CiudadEjercito();
        this.ciudadrecurso = new CiudadRecurso();
        this.ciudadtaberna = new CiudadTaberna();
        this.ciudadbarco = new CiudadBarcos();

    }

    public Ciudad() {
        this.estado = new EstadoCiudad();
        this.ciudadacademia = new CiudadAcademia();
        this.ciudadedificios = new CiudadEdificiodeNivel();
        this.ciudadproduccion = new CiudadProduccion();
        this.ciudadejercito = new CiudadEjercito();
        this.ciudadrecurso = new CiudadRecurso();
        this.ciudadtaberna = new CiudadTaberna();
        this.ciudadbarco = new CiudadBarcos();


    }


    public int verificaredificioenciudad(String nombreedif) {
        for (int i = 0; i < this.ciudadedificios.getEdificionivel().size(); i++) {
            if (nombreedif.equals(this.ciudadedificios.getEdificionivel().get(i).getEdificio().getNombre())) {
                return i;
            }
        }
        return -1;


    }


    public boolean verificarcantidadhabitantes(int i)  {
        boolean control = false;
        if (this.cantidadhabitantesdisponibles >= i) {
            control = true;
        }
        return control;

    }


    public boolean verificarnosuperarcapacidadmilitar( int cantidad, boolean barco) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL verificar_no_superar_capacidad_militar(?,?,?,?,?)");
        procedimiento.setString("nickjugador", this.getJugador().getNick());
        procedimiento.setString("nombreciudad", this.nombre);

        procedimiento.setBoolean("BARCO", barco);
        procedimiento.setInt("cantidad", cantidad);
        procedimiento.registerOutParameter("capacidadsuperada", Types.BOOLEAN);

        procedimiento.execute();

        return procedimiento.getBoolean("capacidadsuperada");
    }


    public void descontarhabitantes( int cantidadhabitantes) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL DESCONTAR_HABITANTES(?,?,?)");
        procedimiento.setString("NICKJUGADOR", this.getJugador().getNick());
        procedimiento.setString("NOMBRECIUDAD", this.nombre);
        procedimiento.setInt("CANTIDADDESCONTAR", cantidadhabitantes);
        procedimiento.execute();
    }


    public void cambiarnombre( String nombrenuevo) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL CAMBIAR_NOMBRE(?,?,?)");
        procedimiento.setString("nombreciudad", this.nombre);
        procedimiento.setString("nickjugador", this.getJugador().getNick());
        procedimiento.setString("nombreciudadnuevo", nombrenuevo);

        procedimiento.execute();


    }


    public void aumentarhabitantesdisponibles( int i) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL aumentar_habitantes_disponibles(?,?,?)");
        procedimiento.setString("nombreciudad", this.nombre);
        procedimiento.setString("nombrejugador", this.jugador.getNick());
        procedimiento.setInt("cantidad", i);

        procedimiento.execute();

    }


    public void inicializarciudad() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT ciudad.nombre,jugador.nick, jugador.oro, jugador.puntostotales, puntosjugador.puntosconstructor, puntosjugador.puntossoldado, puntosjugador.puntosdefenta, puntosjugador.puntosataque, ciudad.nivel, ciudad.capacidadrecurso, ciudad.cantidadhabitantes,ciudad.cantidadhabitantesdisponibles, ciudad.crecimientodehabitante, ciudad.gradodesatisfacciontotal, ciudad.numeroposicionisla, estadociudad.estado,ciudad.capital ,ciudad.codigociudad,jugador.codigojugador FROM estadociudad INNER JOIN (ciudad INNER JOIN (puntosjugador INNER JOIN jugador ON puntosjugador.codigojugador = jugador.codigojugador) ON ciudad.codigojugador = jugador.codigojugador) ON estadociudad.codigoestado = ciudad.codigoestado WHERE (((ciudad.nombre)='" + this.getNombre() + "')) and jugador.nick='" + this.getJugador().getNick() + "'");

            if (rs.next()) {
                this.jugador.setCodigojugador(rs.getInt(19));
                this.nombre = rs.getString(1);
                this.jugador.setNick(rs.getString(2));
                this.jugador.setOro(rs.getInt(3));
                this.jugador.setPuntostotales(rs.getInt(4));
                this.jugador.setPuntosjugador(new PuntosJugador(this.jugador));
                this.jugador.getPuntosjugador().setPuntosconstructor(rs.getInt(5));
                this.jugador.getPuntosjugador().setPuntossoldados(rs.getInt(6));
                this.jugador.getPuntosjugador().setPuntosdefensa(rs.getInt(7));
                this.jugador.getPuntosjugador().setPuntosataque(rs.getInt(8));

                this.setNivel(new Nivel(rs.getInt(9)));
                this.capacidadrecurso = rs.getInt(10);

                this.cantidadhabitantes = rs.getInt(11);
                this.cantidadhabitantesdisponibles = rs.getInt(12);
                this.crecimientodehabitante = rs.getInt(13);
                this.gradosatisfacciontotal = rs.getInt(14);
                this.numeroposicionisla = rs.getInt(15);
                this.estado.setEstado(rs.getString(16));

                this.capital = rs.getBoolean(17);
                this.codigociudad = rs.getInt(18);
                this.nivel.inicializar_nivel();


                this.getCiudadacademia().setCiudad(this);
                this.getCiudadbarco().setCiudad(this);
                this.getCiudadedificios().setCiudad(this);
                this.getCiudadejercito().setCiudad(this);
                this.getCiudadproduccion().setCiudad(this);
                this.getCiudadrecurso().setCiudad(this);
                this.getCiudadtaberna().setCiudad(this);


                java.sql.Statement statement1 = ConexionDB.getConexion().createStatement();
                ResultSet rs1 = statement1.executeQuery("select isla.nombre from isla,ciudad,jugador where"
                        + " jugador.nick = '" + this.jugador.getNick() + "' and ciudad.nombre = '" + this.getNombre() + "' and "
                        + " ciudad.codigoisla = isla.codigoisla");
                if (rs1.next()) {
                    this.isla = new Isla(rs1.getString(1));
                    this.isla.inicializar_isla();
                }


            }
        } catch (SQLException ex) {

        }
    }

    public String buscaredificioproduccion() {
        String recurso = null;
        for (int i = 0; i < this.isla.getIslarecurso().getRecursos().size(); i++) {
            if (!this.isla.getIslarecurso().getRecursos().get(i).getNombrerecurso().equals("Madera")) {
                recurso = this.isla.getIslarecurso().getRecursos().get(i).getNombrerecurso();
            }
        }

        switch (recurso) {
            case "Marmol":
                return "Cantero";

            case "Vino":
                return "Vinicultor";

            case "Cristal":
                return "Soplador de Vidrio";

            case "Azufre":
                return "Torre del Alquimista";

        }

        return null;
    }


    public String buscaredificioreal() {
        if (this.capital) {
            return "Palacio";
        } else {
            return "Residencia del Gobernador";
        }
    }


    public void eliminarciudad() {
        try {
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL ELIMINAR_CIUDAD_JUGADOR(?,?)");

            procedimiento.setString("nickjugador", this.jugador.getNick());
            procedimiento.setString("nombreciudad", this.nombre);
            procedimiento.execute();
        } catch (SQLException ex) {

        }
    }

    public void construiredificio( int lugarciudad, EdificioNivel edificionivel) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL CIUDADEDIFICIONIVEL_CONSTRUIREDIFICIO(?,?,?,?)");

        procedimiento.setString("nickjugador", this.jugador.getNick());
        procedimiento.setString("nombreciudad", this.nombre);
        procedimiento.setString("nombreedificio", edificionivel.getEdificio().getNombre());
        procedimiento.setInt("lugarciudad", lugarciudad);


        procedimiento.execute();
    }

    public boolean verificarCiudadSinProcesosdeAtaque( String tipoataque) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_CIUDAD_SIN_PROCESO_DE_ATAQUE(?,?,?,?)");
        procedimiento.setString("NOMBRECIUDAD", this.nombre);
        procedimiento.setString("NICKJUGADOR", this.getJugador().getNick());

        procedimiento.setString("TIPOATAQUE", tipoataque);
        procedimiento.registerOutParameter("PROCESOATAQUE", Types.BOOLEAN);

        procedimiento.execute();

        return procedimiento.getBoolean("procesoataque");
    }

    public boolean verificarCapacidadAlmacenamientoCiudad( Recurso recurso, Integer cantidad) throws SQLException {
        boolean control = true;
        int cantidadrecursos = 0;
        for (int i = 0; i < this.ciudadrecurso.getRecurso().size(); i++) {
            if (recurso.getNombrerecurso().equals(this.ciudadrecurso.getRecurso().get(i).getNombrerecurso())) {
                cantidadrecursos = this.ciudadrecurso.getCantidad().get(i) + cantidad;
            }
        }

        if (cantidadrecursos <= this.capacidadrecurso) {
            control = true;
        } else {
            control = false;
        }

        return control;
    }


    public void descontarHabitantesDisponibles( Integer habitantes) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL descontar_habitantes_disponibles(?,?,?)");
        procedimiento.setString("nombreciudad", this.nombre);
        procedimiento.setString("nombrejugador", this.jugador.getNick());
        procedimiento.setInt("cantidad", habitantes);

        procedimiento.execute();
    }

    public void inicializarHabitantes() {

        this.inicializarciudad();
    }

    public boolean verificarPuertoBloqueado() throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL verificar_puerto_no_bloqueado(?,?,?)");

        procedimiento.setString("nick", this.jugador.getNick());
        procedimiento.setString("ciudad", this.nombre);
        procedimiento.registerOutParameter("nobloqueado", Types.BOOLEAN);
        procedimiento.execute();

        return procedimiento.getBoolean("nobloqueado");

    }


}
