/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.ciudad;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.model.edificio.Edificio;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.model.imagen.Imagenes;
import lombok.Getter;
import lombok.Setter;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CiudadEdificiodeNivel {
    private Ciudad ciudad;
    private List<EdificioNivel> edificionivel = new ArrayList<>();
    private List<Integer> lugarciudad = new ArrayList<>();


    CiudadEdificiodeNivel() {

    }


    public void inicializaredificiosdeciudad() throws SQLException {
        this.edificionivel.clear();
        this.lugarciudad.clear();
        for (int i = 1; i <= 16; i++) {
            CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL inicializar_edificios_de_ciudad(?,?,?,?,?,?,?)");
            procedimiento.setString("nombreciudad", this.ciudad.getNombre());
            procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
            procedimiento.setInt("lugarciudad", i);
            procedimiento.registerOutParameter("nombreedificio", Types.VARCHAR);
            procedimiento.registerOutParameter("direccionimagen", Types.VARCHAR);
            procedimiento.registerOutParameter("niveledificio", Types.INTEGER);
            procedimiento.registerOutParameter("lugaredificiociudad", Types.INTEGER);
            procedimiento.execute();

            if (procedimiento.getString("nombreedificio") != null) {
                this.edificionivel.add(new EdificioNivel(new Edificio(procedimiento.getString("nombreedificio"), new Imagenes(procedimiento.getString("direccionimagen"))), procedimiento.getInt("niveledificio")));
                this.lugarciudad.add(procedimiento.getInt("lugaredificiociudad"));
            }


        }

    }

    public List<String> buscaredificiosconstruidos() {
        List<String> edificiosconstruidos = new ArrayList<>();
        for (int i = 0; i < this.edificionivel.size(); i++) {
            edificiosconstruidos.add(this.edificionivel.get(i).getEdificio().getNombre());
        }
        return edificiosconstruidos;
    }


    public boolean verificarcuartelvacio() throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL verificar_cuartel_vacio (?,?,?)");
        procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
        procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
        procedimiento.registerOutParameter("cuartelvacio", Types.BOOLEAN);
        procedimiento.execute();

        return false;
    }

    public void destruiredificiodeciudad(int indice) throws SQLException {


        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("call DESTRUIR_EDIFICIO (?,?,?)");
        procedimiento.setString("NOMBRECIUDAD", this.getCiudad().getNombre());
        procedimiento.setString("NOMBREJUGADOR", this.getCiudad().getJugador().getNick());
        procedimiento.setString("NOMBREEDIFICIO", this.getEdificionivel().get(indice).getEdificio().getNombre());
        procedimiento.execute();


    }

    public boolean verificarastillerodeguerravacio() throws SQLException {

        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL verificar_astillero_de_guerra_vacio(?,?,?)");
        procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
        procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
        procedimiento.registerOutParameter("cuartelvacio", Types.BOOLEAN);
        procedimiento.execute();
        return procedimiento.getBoolean("vacio");
    }


    public boolean verificarmercadosindeposito() throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL verificar_mercado_sin_deposito(?,?,?)");

        procedimiento.setString("nickjugador", this.getCiudad().getJugador().getNick());
        procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
        procedimiento.registerOutParameter("depositovacio", Types.BOOLEAN);
        procedimiento.execute();
        return procedimiento.getBoolean("depositovacio");
    }

    public boolean verificaredificioreal(int indice) {
        if (this.edificionivel.get(indice).getEdificio().getNombre().equals("Intendencia")) {
            return true;
        }
        if (this.edificionivel.get(indice).getEdificio().getNombre().equals("Residencia del Gobernador")) {
            return true;
        }
        if (this.edificionivel.get(indice).getEdificio().getNombre().equals("Palacio")) {
            return true;
        }
        return false;
    }

    public List<String> generarlistadeedificiosaconstruir(List<String> buscaredificiosconstruidos, List<String> buscaredificioshabilitados, String buscaredificioproduccion, String buscaredificioreal) {
        List<String> edificios = new ArrayList<>();
        boolean control = false;
        int indice = 0;
        buscaredificioshabilitados.add(buscaredificioreal);
        buscaredificioshabilitados.add(buscaredificioproduccion);
        for (int i = 0; i < buscaredificioshabilitados.size(); i++) {
            control = false;
            for (int j = 0; j < buscaredificiosconstruidos.size(); j++) {
                if (buscaredificiosconstruidos.get(j).equals(buscaredificioshabilitados.get(i))) {
                    control = true;


                }
            }

            if (control == false) {
                edificios.add(buscaredificioshabilitados.get(i));

            }
        }


        return edificios;
    }

    public void servirvino(Integer cantidad) throws SQLException {
        CallableStatement procedimiento = ConexionDB.getConexion().prepareCall("CALL servir_vino(?,?,?)");
        procedimiento.setString("nombreciudad", this.getCiudad().getNombre());
        procedimiento.setString("nombrejugador", this.getCiudad().getJugador().getNick());

        procedimiento.setInt("cantidadvino", cantidad);
        procedimiento.execute();

    }


}
