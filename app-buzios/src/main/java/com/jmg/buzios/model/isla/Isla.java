/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.isla;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.imagen.Imagenes;
import com.jmg.buzios.model.jugador.Jugador;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@Setter
public class Isla {

    private Integer codigoisla;
    private String nombre;
    private Imagenes imagen;
    private Integer capacidadciudades;
    private Integer cantidaddisponible;
    private Integer coordenadax;
    private Integer coordenaday;
    private IslaRecurso islarecurso;
    private List<Ciudad> ciudades;
    public Isla() {
    }
    public Isla(String ares) {
        this.nombre = ares;
    }

    public static Isla buscarislavacia() {
        Isla isla = null;
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select codigoisla,nombre from isla where  capacidaddisponible<capacidadciudades");
            if (rs.next()) {
                isla = new Isla();
                isla.setCodigoisla(rs.getInt(1));
                isla.setNombre(rs.getString(2));
                isla.inicializar_isla();

                return isla;
            }
        } catch (SQLException ex) {

        }
        return isla;


    }

    public static void buscar_posiciones_ocupadas( List<Integer> posicionesocupadas, Isla islaenviada) {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select ciudad.numeroposicionisla from ciudad,isla where ciudad.codigoisla =isla.codigoisla and isla.nombre='" + islaenviada.getNombre() + "'");

            while (rs.next()) {
                posicionesocupadas.add(rs.getInt(1));

            }
        } catch (SQLException ex) {

        }
    }

    public static void inicializar_todas_las_islas( List<Isla> islasmundo, Integer parteMundo) {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select coordenadax,coordenaday,nombre from isla");
            int posicionMaxima = (9 * parteMundo);
            int posicionMinima = posicionMaxima - 9;
            int contador = 0;
            while (rs.next()) {
                if ((contador >= posicionMinima) && (contador < posicionMaxima)) {
                    Isla isla = new Isla(rs.getString(3));
                    isla.setCoordenadax(rs.getInt(1));
                    isla.setCoordenaday(rs.getInt(2));
                    isla.inicializar_isla();
                    islasmundo.add(isla);
                }
                contador++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Isla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    public void buscarciudades() {
        try {
            this.ciudades = new ArrayList<>();
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT ciudad.nombre, jugador.nick FROM (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) INNER JOIN isla ON ciudad.codigoisla = isla.codigoisla WHERE ciudad.activa = true and (((isla.nombre)='" + this.getNombre() + "'))");

            while (rs.next()) {
                Ciudad ciudadnueva = new Ciudad(rs.getString(1), new Jugador(rs.getString(2)));
                ciudadnueva.inicializarciudad();
                ciudadnueva.getCiudadproduccion().setCiudad(ciudadnueva);
                ciudadnueva.getCiudadproduccion().inicializarproduccionciudad();

                ciudades.add(ciudadnueva);
            }


        } catch (SQLException ex) {
            Logger.getLogger(Isla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public boolean verificarUnLugarMasEnIsla() throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_LUGAR_EN_ISLA(?,?,?)");
        procedimiento.setInt("COORX", this.coordenadax);
        procedimiento.setInt("COORY", this.coordenaday);
        procedimiento.registerOutParameter("LUGARPARACONSTRUIR", Types.BOOLEAN);
        procedimiento.execute();

        return procedimiento.getBoolean("LUGARPARACONSTRUIR");
    }

    public void construirciudadenisla( Jugador jugador, int lugarisla) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL CONSTRUIR_CIUDAD_EN_ISLA(?,?,?,?)");

        procedimiento.setString("nickjugador", jugador.getNick());
        procedimiento.setInt("cx", this.coordenadax);
        procedimiento.setInt("cy", this.coordenaday);
        procedimiento.setInt("lugarenisla", lugarisla);


        procedimiento.execute();
    }

    public void descontarcapacidadciudadisla() throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL descontar_capacidad_isla(?,?)");

        procedimiento.setInt("coordenada_x", this.coordenadax);
        procedimiento.setInt("coordenada_y", this.coordenaday);

        procedimiento.execute();
    }


    public void inicializar_isla() {
        try {
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT isla.codigoisla, isla.nombre,"
                    + " isla.coordenadax, isla.coordenaday, imagenes.direccion, "
                    + "isla.capacidadciudades, isla.capacidaddisponible, "
                    + "recurso.nombre, imagenes_1.direccion FROM (recurso INNER JOIN ((islarecurso INNER JOIN isla ON islarecurso.codigoisla = isla.codigoisla) INNER JOIN imagenes ON isla.codigoimagen = imagenes.codigoimagen) ON recurso.codigorecurso = islarecurso.codigorecurso) INNER JOIN imagenes AS imagenes_1 ON recurso.codigoimagen = imagenes_1.codigoimagen WHERE (((recurso.nombre)<>'" + "Madera" + "')) and isla.nombre='" + this.nombre + "'");

            if (rs.next()) {
                this.codigoisla = rs.getInt(1);
                this.nombre = rs.getString(2);
                this.coordenadax = rs.getInt(3);
                this.coordenaday = rs.getInt(4);
                this.imagen = new Imagenes(rs.getString(5));

                this.capacidadciudades = rs.getInt(6);
                this.cantidaddisponible = rs.getInt(7);
                this.islarecurso = new IslaRecurso();
                Recurso recurso = new Recurso(rs.getString(8));
                recurso.setImagenrecurso(new Imagenes(rs.getString(9)));
                this.getIslarecurso().getRecursos().add(recurso);


            }
        } catch (SQLException ex) {
            Logger.getLogger(Isla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String retornarRecursoEspecial() {
        for (int i = 0; i < this.islarecurso.getRecursos().size(); i++) {
            if (!"Madera".equals(this.islarecurso.getRecursos().get(i).getNombrerecurso())) {
                return this.islarecurso.getRecursos().get(i).getNombrerecurso();
            }
        }
        return null;
    }


}
