/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.ciudad;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.isla.Recurso;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CiudadRecurso {
    private Ciudad ciudad;
    private List<Recurso> recurso = new ArrayList<>();
    private List<Integer> cantidad = new ArrayList<>();

    public CiudadRecurso() {
    }




    public boolean verificarrecursosciudad(List<Recurso> recurso, List<Integer> cantidad) throws SQLException {
        int contadorverificador = 0;
        boolean control = false;
        for (int i = 0; i < recurso.size(); i++) {
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL VERIFICAR_RECURSO_EN_CIUDAD(?,?,?,?,?)");

            procedimiento.setString("NICKJUGADOR", this.ciudad.getJugador().getNick());
            procedimiento.setString("NOMBRECIUDAD", this.ciudad.getNombre());
            procedimiento.setString("nombrerecurso", recurso.get(i).getNombrerecurso());
            procedimiento.setInt("cantidadaverificar", cantidad.get(i));
            procedimiento.registerOutParameter("recursosdisponible", Types.BOOLEAN);

            procedimiento.execute();
            if (procedimiento.getBoolean("recursosdisponible") == true) {
                contadorverificador++;
            }

        }

        if (contadorverificador == recurso.size()) {
            control = true;
        }
        return control;

    }

    public void descontarrecursosciudad( List<Recurso> listarecursos, List<Integer> cantidad) throws SQLException {
        for (int j = 0; j < listarecursos.size(); j++) {
            this.descontarrecursosciudad(listarecursos.get(j), cantidad.get(j));

        }
    }


    public boolean verificarrecursosciudad(Recurso recursobuscado, int cantidad) throws SQLException {
        boolean control = false;
        List<Recurso> recursos = new ArrayList<>();
        recursos.add(recursobuscado);
        List<Integer> cantidades = new ArrayList<>();
        cantidades.add(cantidad);
        control = this.verificarrecursosciudad( recursos, cantidades);
        return control;

    }

    public void descontarrecursosciudad( Recurso recursobuscado, int cantidadacomprar) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL descontar_recursos(?,?,?,?)");


        procedimiento.setString("nick_jugador", this.ciudad.getJugador().getNick());
        procedimiento.setString("nombre_ciudad", this.ciudad.getNombre());
        procedimiento.setString("nombrerecur", recursobuscado.getNombrerecurso());

        procedimiento.setInt("madera", cantidadacomprar);


        procedimiento.execute();
        System.out.printf("LLegaste");

    }

    public void inicializarrecursosciudad() throws SQLException {
        this.recurso.clear();
        this.cantidad.clear();
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL inicializar_recursos_ciudad(?,?,?,?,?,?,?)");
        procedimiento.setString("nombreciudad", this.ciudad.getNombre());
        procedimiento.setString("nickjugador", this.ciudad.getJugador().getNick());
        procedimiento.registerOutParameter("cantidadmadera", Types.INTEGER);
        procedimiento.registerOutParameter("cantidadvino", Types.INTEGER);
        procedimiento.registerOutParameter("cantidadmarmol", Types.INTEGER);
        procedimiento.registerOutParameter("cantidadazufre", Types.INTEGER);
        procedimiento.registerOutParameter("cantidadcristal", Types.INTEGER);

        procedimiento.execute();


        this.recurso.add(new Recurso("Madera"));
        this.recurso.add(new Recurso("Vino"));
        this.recurso.add(new Recurso("Marmol"));
        this.recurso.add(new Recurso("Azufre"));
        this.recurso.add(new Recurso("Cristal"));


        this.cantidad.add(procedimiento.getInt("cantidadmadera"));
        this.cantidad.add(procedimiento.getInt("cantidadvino"));
        this.cantidad.add(procedimiento.getInt("cantidadmarmol"));
        this.cantidad.add(procedimiento.getInt("cantidadazufre"));
        this.cantidad.add(procedimiento.getInt("cantidadcristal"));

    }


    public void almacenarrecursosenciudad( String nombrerecurso, int cantidad) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL ALMACENAR_RECURSOS_EN_CIUDAD(?,?,?,?)");
        procedimiento.setString("NICKJUGADOR", this.ciudad.getJugador().getNick());
        procedimiento.setString("NOMBRECIUDAD", this.ciudad.getNombre());
        procedimiento.setString("NOMBRERECURSO", nombrerecurso);
        procedimiento.setInt("CANTIDADRECURSO", cantidad);
        procedimiento.execute();

    }

    public boolean verificarservirvino( Integer cantidad) {
        for (int i = 0; i < this.recurso.size(); i++) {
            if (this.recurso.get(i).getNombrerecurso().equals("Vino")) {
                if (this.cantidad.get(i) >= cantidad) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public int calcularpesorecursos(List<Integer> cantidad) {
        int cantidadacumulada = 0;
        for (int i = 0; i < cantidad.size(); i++) {
            cantidadacumulada += cantidad.get(i).intValue();
        }
        return cantidadacumulada;
    }


    public void almacenarrecursosenciudad(Recurso recurso, int cantidad) throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL ALMACANAR_RECURSOS_EN_CIUDAD (?,?,?,?)");
        procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
        procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
        procedimiento.setString("nombrerecurso", recurso.getNombrerecurso());
        procedimiento.setInt("cantidadrecurso", cantidad);
        procedimiento.execute();
    }


}
