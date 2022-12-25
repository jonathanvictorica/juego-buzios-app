/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.controller.isla;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.isla.Isla;
import com.jmg.buzios.view.islas.VerIsla1;
import com.jmg.buzios.view.islas.VerIsla2;
import com.jmg.buzios.view.islas.VerIsla3;

import javax.swing.*;

/**
 * 1	El Jugador presiona un boton y envia por parametro el nombre de la isla.
 * <p>
 * 3	El Sistema busca todas las ciudades que hay en esa isla.
 * 4	El Sistema por cada ciudad de la isla busca los datos basicos, como el nombre, el jugador, el nivel de la ciudad, el estado en que se encuentra la ciudad, los puntos defensivos del jugador, los puntos de ataque del jugador, y la cantidad de oro que tiene.
 * 5	El Sistema debe cargar el grafico correcto de la isla y según el numero de posición de cada ciudad de la isla, dibujar en cada una la ciudad correspondiente a cada posción , permitiendo al jugador seleccionar cualquiera de ellas y ver toda esa información relacionada por cada ciudad.
 */
public class MostrarIsla implements Actualizar {
    private JFrame vistaisla;


    private Isla islaelegida;

    private Ciudad ciudadjugador;

    public MostrarIsla(Isla islaelegida, Ciudad ciudadjugador) {
        this.islaelegida = islaelegida;
        this.ciudadjugador = ciudadjugador;
    }

    public void CUmostrarisla() {
        islaelegida.inicializar_isla();
        islaelegida.buscarciudades();
        //islaelegida.setImagen(new Imagenes("islavacia1"));

        this.actualizarinterfazgrafica();

        this.actualizardatospantalla();
    }


    @Override
    public void actualizardatospantalla() {
        String direccionimagen;
        ImageIcon construirciudad;
        direccionimagen = ("/IMAGEN/ISLA/" + "parcelavacia" + ".png");
        construirciudad = new ImageIcon(getClass().getResource(direccionimagen));

        switch (this.vistaisla.getClass().getSimpleName()) {
            case "VerIsla1":
                VerIsla1 verisla1 = (VerIsla1) this.vistaisla;

                for (int i = 0; i < 16; i++) {

                    switch (i + 1) {
                        case 1:
                            verisla1.getCmdCiudad1().setIcon(construirciudad);
                            break;
                        case 2:
                            verisla1.getCmdCiudad2().setIcon(construirciudad);
                            break;
                        case 3:
                            verisla1.getCmdCiudad3().setIcon(construirciudad);
                            break;
                        case 4:
                            verisla1.getCmdCiudad4().setIcon(construirciudad);
                            break;
                        case 5:
                            verisla1.getCmdCiudad5().setIcon(construirciudad);
                            break;
                        case 6:
                            verisla1.getCmdCiudad6().setIcon(construirciudad);
                            break;
                        case 7:
                            verisla1.getCmdCiudad7().setIcon(construirciudad);
                            break;
                        case 8:
                            verisla1.getCmdCiudad8().setIcon(construirciudad);
                            break;
                        case 9:
                            verisla1.getCmdCiudad9().setIcon(construirciudad);
                            break;
                        case 10:
                            verisla1.getCmdCiudad10().setIcon(construirciudad);
                            break;
                        case 11:
                            verisla1.getCmdCiudad11().setIcon(construirciudad);
                            break;
                        case 12:
                            verisla1.getCmdCiudad12().setIcon(construirciudad);
                            break;
                        case 13:
                            verisla1.getCmdCiudad13().setIcon(construirciudad);
                            break;
                        case 14:
                            verisla1.getCmdCiudad14().setIcon(construirciudad);
                            break;
                        case 15:
                            verisla1.getCmdCiudad15().setIcon(construirciudad);
                            break;
                        case 16:
                            verisla1.getCmdCiudad16().setIcon(construirciudad);
                            break;
                    }


                }

                for (int i = 0; i < this.islaelegida.getCiudades().size(); i++) {
                    System.out.printf("" + this.islaelegida.getCiudades().get(i).getNivel().getImagennivel().getDireccion());
                    direccionimagen = ("/IMAGEN/ISLA/" + this.islaelegida.getCiudades().get(i).getNivel().getImagennivel().getDireccion() + ".png");
                    construirciudad = new ImageIcon(getClass().getResource(direccionimagen));

                    switch (this.islaelegida.getCiudades().get(i).getNumeroposicionisla()) {
                        case 1:
                            verisla1.getCmdCiudad1().setIcon(construirciudad);
                            break;
                        case 2:
                            verisla1.getCmdCiudad2().setIcon(construirciudad);
                            break;
                        case 3:
                            verisla1.getCmdCiudad3().setIcon(construirciudad);
                            break;
                        case 4:
                            verisla1.getCmdCiudad4().setIcon(construirciudad);
                            break;
                        case 5:
                            verisla1.getCmdCiudad5().setIcon(construirciudad);
                            break;
                        case 6:
                            verisla1.getCmdCiudad6().setIcon(construirciudad);
                            break;
                        case 7:
                            verisla1.getCmdCiudad7().setIcon(construirciudad);
                            break;
                        case 8:
                            verisla1.getCmdCiudad8().setIcon(construirciudad);
                            break;
                        case 9:
                            verisla1.getCmdCiudad9().setIcon(construirciudad);
                            break;
                        case 10:
                            verisla1.getCmdCiudad10().setIcon(construirciudad);
                            break;
                        case 11:
                            verisla1.getCmdCiudad11().setIcon(construirciudad);
                            break;
                        case 12:
                            verisla1.getCmdCiudad12().setIcon(construirciudad);
                            break;
                        case 13:
                            verisla1.getCmdCiudad13().setIcon(construirciudad);
                            break;
                        case 14:
                            verisla1.getCmdCiudad14().setIcon(construirciudad);
                            break;
                        case 15:
                            verisla1.getCmdCiudad15().setIcon(construirciudad);
                            break;
                        case 16:
                            verisla1.getCmdCiudad16().setIcon(construirciudad);
                            break;
                    }
                }
                verisla1.repaint();
                verisla1.show();
                break;
            case "VerIsla2":
                VerIsla2 verisla2 = (VerIsla2) this.vistaisla;

                for (int i = 0; i < 16; i++) {
                    switch (i + 1) {
                        case 1:
                            verisla2.getCmdCiudad1().setIcon(construirciudad);
                            break;
                        case 2:
                            verisla2.getCmdCiudad2().setIcon(construirciudad);
                            break;
                        case 3:
                            verisla2.getCmdCiudad3().setIcon(construirciudad);
                            break;
                        case 4:
                            verisla2.getCmdCiudad4().setIcon(construirciudad);
                            break;
                        case 5:
                            verisla2.getCmdCiudad5().setIcon(construirciudad);
                            break;
                        case 6:
                            verisla2.getCmdCiudad6().setIcon(construirciudad);
                            break;
                        case 7:
                            verisla2.getCmdCiudad7().setIcon(construirciudad);
                            break;
                        case 8:
                            verisla2.getCmdCiudad8().setIcon(construirciudad);
                            break;
                        case 9:
                            verisla2.getCmdCiudad9().setIcon(construirciudad);
                            break;
                        case 10:
                            verisla2.getCmdCiudad10().setIcon(construirciudad);
                            break;
                        case 11:
                            verisla2.getCmdCiudad11().setIcon(construirciudad);
                            break;
                        case 12:
                            verisla2.getCmdCiudad12().setIcon(construirciudad);
                            break;
                        case 13:
                            verisla2.getCmdCiudad13().setIcon(construirciudad);
                            break;
                        case 14:
                            verisla2.getCmdCiudad14().setIcon(construirciudad);
                            break;
                        case 15:
                            verisla2.getCmdCiudad15().setIcon(construirciudad);
                            break;

                    }


                }

                for (int i = 0; i < this.islaelegida.getCiudades().size(); i++) {
                    direccionimagen = ("/IMAGEN/ISLA/" + this.islaelegida.getCiudades().get(i).getNivel().getImagennivel().getDireccion() + ".png");
                    construirciudad = new ImageIcon(getClass().getResource(direccionimagen));

                    switch (this.islaelegida.getCiudades().get(i).getNumeroposicionisla()) {
                        case 1:
                            verisla2.getCmdCiudad1().setIcon(construirciudad);
                            break;
                        case 2:
                            verisla2.getCmdCiudad2().setIcon(construirciudad);
                            break;
                        case 3:
                            verisla2.getCmdCiudad3().setIcon(construirciudad);
                            break;
                        case 4:
                            verisla2.getCmdCiudad4().setIcon(construirciudad);
                            break;
                        case 5:
                            verisla2.getCmdCiudad5().setIcon(construirciudad);
                            break;
                        case 6:
                            verisla2.getCmdCiudad6().setIcon(construirciudad);
                            break;
                        case 7:
                            verisla2.getCmdCiudad7().setIcon(construirciudad);
                            break;
                        case 8:
                            verisla2.getCmdCiudad8().setIcon(construirciudad);
                            break;
                        case 9:
                            verisla2.getCmdCiudad9().setIcon(construirciudad);
                            break;
                        case 10:
                            verisla2.getCmdCiudad10().setIcon(construirciudad);
                            break;
                        case 11:
                            verisla2.getCmdCiudad11().setIcon(construirciudad);
                            break;
                        case 12:
                            verisla2.getCmdCiudad12().setIcon(construirciudad);
                            break;
                        case 13:
                            verisla2.getCmdCiudad13().setIcon(construirciudad);
                            break;
                        case 14:
                            verisla2.getCmdCiudad14().setIcon(construirciudad);
                            break;
                        case 15:
                            verisla2.getCmdCiudad15().setIcon(construirciudad);
                            break;

                    }
                }
                verisla2.repaint();
                verisla2.show();
                break;
            case "VerIsla3":
                VerIsla3 verisla3 = (VerIsla3) this.vistaisla;

                for (int i = 0; i < 16; i++) {
                    switch (i + 1) {
                        case 1:
                            verisla3.getCmdCiudad1().setIcon(construirciudad);
                            break;
                        case 2:
                            verisla3.getCmdCiudad2().setIcon(construirciudad);
                            break;
                        case 3:
                            verisla3.getCmdCiudad3().setIcon(construirciudad);
                            break;
                        case 4:
                            verisla3.getCmdCiudad4().setIcon(construirciudad);
                            break;
                        case 5:
                            verisla3.getCmdCiudad5().setIcon(construirciudad);
                            break;
                        case 6:
                            verisla3.getCmdCiudad6().setIcon(construirciudad);
                            break;
                        case 7:
                            verisla3.getCmdCiudad7().setIcon(construirciudad);
                            break;
                        case 8:
                            verisla3.getCmdCiudad8().setIcon(construirciudad);
                            break;
                        case 9:
                            verisla3.getCmdCiudad9().setIcon(construirciudad);
                            break;
                        case 10:
                            verisla3.getCmdCiudad10().setIcon(construirciudad);
                            break;
                        case 11:
                            verisla3.getCmdCiudad11().setIcon(construirciudad);
                            break;
                        case 12:
                            verisla3.getCmdCiudad12().setIcon(construirciudad);
                            break;
                        case 13:
                            verisla3.getCmdCiudad13().setIcon(construirciudad);
                            break;
                        case 14:
                            verisla3.getCmdCiudad14().setIcon(construirciudad);
                            break;

                    }


                }

                for (int i = 0; i < this.islaelegida.getCiudades().size(); i++) {
                    direccionimagen = ("/IMAGEN/ISLA/" + this.islaelegida.getCiudades().get(i).getNivel().getImagennivel().getDireccion() + ".png");
                    construirciudad = new ImageIcon(getClass().getResource(direccionimagen));

                    switch (this.islaelegida.getCiudades().get(i).getNumeroposicionisla()) {
                        case 1:
                            verisla3.getCmdCiudad1().setIcon(construirciudad);
                            break;
                        case 2:
                            verisla3.getCmdCiudad2().setIcon(construirciudad);
                            break;
                        case 3:
                            verisla3.getCmdCiudad3().setIcon(construirciudad);
                            break;
                        case 4:
                            verisla3.getCmdCiudad4().setIcon(construirciudad);
                            break;
                        case 5:
                            verisla3.getCmdCiudad5().setIcon(construirciudad);
                            break;
                        case 6:
                            verisla3.getCmdCiudad6().setIcon(construirciudad);
                            break;
                        case 7:
                            verisla3.getCmdCiudad7().setIcon(construirciudad);
                            break;
                        case 8:
                            verisla3.getCmdCiudad8().setIcon(construirciudad);
                            break;
                        case 9:
                            verisla3.getCmdCiudad9().setIcon(construirciudad);
                            break;
                        case 10:
                            verisla3.getCmdCiudad10().setIcon(construirciudad);
                            break;
                        case 11:
                            verisla3.getCmdCiudad11().setIcon(construirciudad);
                            break;
                        case 12:
                            verisla3.getCmdCiudad12().setIcon(construirciudad);
                            break;
                        case 13:
                            verisla3.getCmdCiudad13().setIcon(construirciudad);
                            break;
                        case 14:
                            verisla3.getCmdCiudad14().setIcon(construirciudad);
                            break;

                    }
                }
                verisla3.repaint();
                verisla3.show();
                break;
        }
    }

    @Override
    public void actualizarinterfazgrafica() {
        this.islaelegida.inicializar_isla();
        switch (this.islaelegida.getCapacidadciudades()) {
            case 14:
                this.vistaisla = new VerIsla1(this.islaelegida, this.ciudadjugador);
                break;
            case 16:
                this.vistaisla = new VerIsla2(this.islaelegida, this.ciudadjugador);
                break;
            case 15:
                this.vistaisla = new VerIsla3(this.islaelegida, this.ciudadjugador);
                break;
        }
    }

}
