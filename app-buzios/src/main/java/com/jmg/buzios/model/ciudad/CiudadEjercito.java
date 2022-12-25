/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.ciudad;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.CiudadEjercitoArma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
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
public class CiudadEjercito {


    private Ciudad ciudad;
    private List<Integer> codigoejercitociudad = new ArrayList<>();
    private List<UnidadMilitar> unidad = new ArrayList<>();
    private List<Integer> cantidad = new ArrayList<>();
    private List<Integer> unidadessinarmadisponible = new ArrayList<>();
    private List<Integer> unidadesinarma = new ArrayList<>();
    private List<CiudadEjercitoArma> armasdeunidad = new ArrayList<>();



    CiudadEjercito() {

    }

    public List<Integer> getUnidadessinarmadisponible() {
        return unidadessinarmadisponible;
    }




    public int calcularpeso(List<UnidadMilitar> unidades, List<Integer> cantidad) {
        int pesototal = 0;
        for (int i = 0; i < unidades.size(); i++) {
            try {
                java.sql.Statement statement = ConexionDB.getConexion().createStatement();
                ResultSet rs = statement.executeQuery("SELECT "
                        + "carga from unidadmilitar where nombre='" + unidades.get(i).getNombre() + "'");


                pesototal = pesototal + (rs.getInt(1) * cantidad.get(i));
            } catch (SQLException ex) {
            }
        }
        return pesototal;
    }




    public void inicializarejercitodeciudad() {
        try {
            /*ejercito de jugador*/

            /* ejercito sin arma*/
            java.sql.Statement statement = ConexionDB.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from ciudadejercito where codigociudad=" + this.ciudad.getCodigociudad());
            this.unidad.clear();
            this.armasdeunidad.clear();
            this.codigoejercitociudad.clear();
            this.cantidad.clear();
            this.unidadesinarma.clear();
            this.unidadessinarmadisponible.clear();
            while (rs.next()) {

                UnidadMilitar unidadmilitar = new UnidadMilitar();
                unidadmilitar.inicializar_unidad( rs.getInt(3));

                this.unidad.add(unidadmilitar);
                this.codigoejercitociudad.add(rs.getInt(1));
                this.unidadesinarma.add(rs.getInt(5));
                this.unidadessinarmadisponible.add(rs.getInt(6));
                /*ejercito con arma*/
                java.sql.Statement statements = ConexionDB.getConexion().createStatement();

                ResultSet rs2 = statements.executeQuery("SELECT * from ciudadejercitoarma where codigounidadciudad=" + this.codigoejercitociudad.get(this.codigoejercitociudad.size() - 1));
                CiudadEjercitoArma ciudadejercitoarma = new CiudadEjercitoArma();

                while (rs2.next()) {
                    Arma arma = new Arma();
                    arma.setCodigoarma(rs2.getInt(2));
                    arma.inicializardatosdearma();

                    ciudadejercitoarma.getArma().add(arma);
                    ciudadejercitoarma.getCantidad().add(rs2.getInt(3));
                    ciudadejercitoarma.getCapacidaddisponibleenciudad().add(rs2.getInt(4));

                }

                this.armasdeunidad.add(ciudadejercitoarma);


            }


        } catch (SQLException ex) {

        }


    }

    public boolean verificarunidadesmilitar( List<UnidadMilitar> unidades, List<Arma> armas, List<Integer> cantidad) throws SQLException {
        boolean control = true;
        for (int i = 0; i < unidades.size(); i++) {
            if (armas.get(i) == null) {
                CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_UNIDAD_MILITAR_SIN_ARMA(?,?,?,?,?)");

                procedimiento.setString("nombreciudad", this.ciudad.getNombre());
                procedimiento.setString("nickjugador", this.ciudad.getJugador().getNick());
                procedimiento.setString("nombreunidad", unidades.get(i).getNombre());
                procedimiento.setInt("cantidad", cantidad.get(i));
                procedimiento.registerOutParameter("tiene", Types.BOOLEAN);


                procedimiento.execute();

                if (procedimiento.getBoolean("tiene") == false) {
                    return false;
                }


            } else {
                CallableStatement procedimiento2 = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_UNIDAD_MILITAR_CON_ARMA(?,?,?,?,?,?)");

                procedimiento2.setString("nombreciudad", this.ciudad.getNombre());
                procedimiento2.setString("nickjugador", this.ciudad.getJugador().getNick());
                procedimiento2.setString("nombreunidad", unidades.get(i).getNombre());
                procedimiento2.setString("NOMBREARMA", armas.get(i).getNombrearma());
                procedimiento2.setInt("cantidad", cantidad.get(i));
                procedimiento2.registerOutParameter("tiene", Types.BOOLEAN);

                procedimiento2.execute();

                if (procedimiento2.getBoolean("tiene") == false) {
                    return false;
                }

                procedimiento2.close();
            }
        }


        return control;

    }

    public void descontarunidadesmilitaresdisponibles( List<UnidadMilitar> unidades, List<Arma> armas, List<Integer> cantidad) throws SQLException {

        for (int i = 0; i < unidades.size(); i++) {
            if (armas.get(i) == null) {
                CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL DESCONTAR_UNIDADES_MILITARES_DISPONIBLES_SIN_ARMA(?,?,?,?)");

                procedimiento.setString("nombreciudad", this.ciudad.getNombre());
                procedimiento.setString("nickjugador", this.ciudad.getJugador().getNick());
                procedimiento.setString("nombreunidad", unidades.get(i).getNombre());
                procedimiento.setInt("cantidad", cantidad.get(i).intValue());
                procedimiento.execute();

                procedimiento.close();
            } else {

                CallableStatement procedimiento2 = ConexionDB.getConexion().prepareCall("CALL DESCONTAR_UNIDADES_MILITARES_DISPONIBLES_CON_ARMA(?,?,?,?,?)");

                procedimiento2.setString("nombreciudad", this.ciudad.getNombre());
                procedimiento2.setString("nickjugador", this.ciudad.getJugador().getNick());
                procedimiento2.setString("nombreunidad", unidades.get(i).getNombre());
                procedimiento2.setString("NOMBREARMA", armas.get(i).getNombrearma());
                procedimiento2.setInt("cantidad", cantidad.get(i).intValue());

                procedimiento2.execute();

                procedimiento2.close();
            }
        }


    }

    public Integer calcularcantidadunidadmilitarsinarma(UnidadMilitar unidadmilitar) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL CALCULAR_UNIDAD_MILITAR_SIN_ARMA(?,?,?,?)");

        procedimiento.setString("NICKJUGADOR", this.ciudad.getJugador().getNick());
        procedimiento.setString("NOMBRECIUDAD", this.ciudad.getNombre());
        procedimiento.setString("NOMBREUNIDAD", unidadmilitar.getNombre());
        procedimiento.registerOutParameter("CANTIDADSINARMA", Types.INTEGER);


        procedimiento.execute();

        return procedimiento.getInt("CANTIDADSINARMA");

    }

    public void construirunidadesmilitares(UnidadMilitar unidadmilitar, int cantidad) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL CONSTRUIR_UNIDADES_MILITARES(?,?,?,?)");

        procedimiento.setString("jugadornombre", this.ciudad.getJugador().getNick());
        procedimiento.setString("nombreciudad", this.ciudad.getNombre());
        procedimiento.setString("nombreunidad", unidadmilitar.getNombre());
        procedimiento.setInt("cantidadsoldados", cantidad);


        procedimiento.execute();
    }

    public boolean verificarcantidadasignamientoarma( UnidadMilitar unidadmilitar, Arma arma, Integer cantidad) throws SQLException {
        if (arma != null) {
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL Verificar_cantidad_asignamiento_arma(?,?,?,?,?,?)");

            procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
            procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
            procedimiento.setString("nombreunidad", unidadmilitar.getNombre());
            procedimiento.setString("nombrearma", arma.getNombrearma());
            procedimiento.setInt("cantidad", cantidad);
            procedimiento.registerOutParameter("existe", Types.BOOLEAN);


            procedimiento.execute();
            return procedimiento.getBoolean("existe");

        } else {
            for (int i = 0; i < this.unidad.size(); i++) {
                if (this.unidad.get(i).getNombre().equals(unidadmilitar.getNombre())) {
                    if (cantidad <= this.unidadessinarmadisponible.get(i)) {
                        return true;

                    } else {
                        return false;
                    }
                }
            }
        }
        return false;

    }

    public void descontararmasunidadmilitar( UnidadMilitar unidadmilitar, Arma arma, Integer cantidad) throws SQLException {


        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL eliminar_armas_unidad_militar(?,?,?,?,?)");

        procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
        procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
        procedimiento.setString("nombreunidad", unidadmilitar.getNombre());
        procedimiento.setString("nombre_arma", arma.getNombrearma());
        procedimiento.setInt("cantidadp", cantidad);

        procedimiento.execute();

    }

    public void aumentarunidadesinarma( UnidadMilitar unidadmilitar, Integer cantidad) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL AUMENTAR_UNIDADES_SIN_ARMA(?,?,?,?)");

        procedimiento.setString("nombreciudad", this.ciudad.getNombre());

        procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
        procedimiento.setString("nombreunidad", unidadmilitar.getNombre());

        procedimiento.setInt("cantidad", cantidad);

        procedimiento.execute();
    }

    public void eliminarunidades( UnidadMilitar unidadmilitar, Arma arma, Integer cantidad) throws SQLException {
        if (arma == null) {
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL eliminar_unidades(?,?,?,?)");

            procedimiento.setString("nombreciudad", this.ciudad.getNombre());

            procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
            procedimiento.setString("nombreunidad", unidadmilitar.getNombre());

            procedimiento.setInt("cantidad", cantidad);

            procedimiento.execute();

        } else {
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL eliminar_armas_unidad_militar(?,?,?,?,?)");

            procedimiento.setString("nombreciudad", this.ciudad.getNombre());

            procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
            procedimiento.setString("nombreunidad", unidadmilitar.getNombre());
            procedimiento.setString("nombre_arma", arma.getNombrearma());

            procedimiento.setInt("cantidadp", cantidad);

            procedimiento.execute();

        }
    }


}
