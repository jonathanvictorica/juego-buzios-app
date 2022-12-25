/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.islas;

import com.jmg.buzios.controller.ciudad.MostrarCiudad;
import com.jmg.buzios.controller.isla.HabilitarOpcionCiudad;
import com.jmg.buzios.controller.isla.MostrarIslaRecurso;
import com.jmg.buzios.controller.isla.MostrarMundo;
import com.jmg.buzios.controller.militar.DeclararGuerra;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.isla.Isla;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class VerIsla2 extends javax.swing.JFrame {

    private Ciudad ciudadjugador;
    private Isla isla;
    private Ciudad ciudadelegida;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage Datosciudad;
    private javax.swing.JLabel Protegido;
    private org.edisoncor.gui.panel.PanelImage VerIsla;
    private javax.swing.JButton cmdAserrado;
    private javax.swing.JButton cmdCiudad1;
    private javax.swing.JButton cmdCiudad10;
    private javax.swing.JButton cmdCiudad11;
    private javax.swing.JButton cmdCiudad12;
    private javax.swing.JButton cmdCiudad13;
    private javax.swing.JButton cmdCiudad14;
    private javax.swing.JButton cmdCiudad15;
    private javax.swing.JButton cmdCiudad2;
    private javax.swing.JButton cmdCiudad3;
    private javax.swing.JButton cmdCiudad4;
    private javax.swing.JButton cmdCiudad5;
    private javax.swing.JButton cmdCiudad6;
    private javax.swing.JButton cmdCiudad7;
    private javax.swing.JButton cmdCiudad8;
    private javax.swing.JButton cmdCiudad9;
    private javax.swing.JButton cmdCiudadJugador;
    private javax.swing.JButton cmdDeclararGuerra2;
    private javax.swing.JButton cmdEdificiodeLujo;
    private javax.swing.JButton cmdEnviarMensaje2;
    private javax.swing.JButton cmdEnviarRecursos2;
    private javax.swing.JButton cmdMostrarMundo;
    private org.edisoncor.gui.panel.PanelImage habilitadoropciones2;
    private org.edisoncor.gui.panel.PanelImage imagenIsla;
    private javax.swing.JLabel lblCiudadNombre;
    private javax.swing.JLabel lblDeclararGuerra2;
    private javax.swing.JLabel lblEnviarMensaje2;
    private javax.swing.JLabel lblEnviarRecurso2;
    private javax.swing.JLabel lblNombreJugador;
    private javax.swing.JLabel lblOro;
    private javax.swing.JLabel lblPuntosConstructor;
    private javax.swing.JLabel lblPuntosSoldados;
    private javax.swing.JLabel lblPuntosTotales;
    private org.edisoncor.gui.panel.PanelImage panelImage1;


    public VerIsla2(Isla isla, Ciudad ciudadjugador) {
        this.isla = isla;
        this.ciudadjugador = ciudadjugador;
        initComponents();
        this.habilitadoropciones2.setVisible(false);
        this.Datosciudad.setVisible(false);
        String direccionimagen;
        ImageIcon construirciudad;
        this.setTitle(this.isla.getNombre() + " - " + this.isla.getCoordenadax() + ":" + this.isla.getCoordenaday());
        for (int i = 0; i < this.isla.getIslarecurso().getRecursos().size(); i++) {
            if (!this.isla.getIslarecurso().getRecursos().get(i).getNombrerecurso().equals("Madera")) {
                switch (this.isla.getIslarecurso().getRecursos().get(i).getNombrerecurso()) {
                    case "Vino":
                        direccionimagen = ("/IMAGEN/ISLA/" + "vinicultor" + ".jpg");
                        construirciudad = new ImageIcon(getClass().getResource(direccionimagen));
                        this.cmdEdificiodeLujo.setIcon(construirciudad);
                        break;
                    case "Marmol":
                        direccionimagen = ("/IMAGEN/ISLA/" + "canteramarmol" + ".jpg");
                        construirciudad = new ImageIcon(getClass().getResource(direccionimagen));
                        this.cmdEdificiodeLujo.setIcon(construirciudad);
                        break;
                    case "Cristal":
                        direccionimagen = ("/IMAGEN/ISLA/" + "minacristal" + ".jpg");
                        construirciudad = new ImageIcon(getClass().getResource(direccionimagen));
                        this.cmdEdificiodeLujo.setIcon(construirciudad);
                        break;
                    case "Azufre":
                        direccionimagen = ("/IMAGEN/ISLA/" + "minadeazufre" + ".jpg");
                        construirciudad = new ImageIcon(getClass().getResource(direccionimagen));
                        this.cmdEdificiodeLujo.setIcon(construirciudad);
                        break;
                }
            }
        }
        this.setLocationRelativeTo(null);
        this.show();
    }

    public Isla getIsla() {
        return this.isla;
    }

    private void Habilitaropcionesciudad(int numeroposicion) {
        boolean control = false;
        for (int i = 0; i < this.isla.getCiudades().size(); i++) {
            if (this.habilitadoropciones2.isVisible() == false) {
                this.habilitadoropciones2.setVisible(true);

            }
            if (this.isla.getCiudades().get(i).getNumeroposicionisla() == numeroposicion) {
                try {
                    HabilitarOpcionCiudad habilitaropcionesciudad = new HabilitarOpcionCiudad(this, this.isla.getCiudades().get(i), ciudadjugador);
                    habilitaropcionesciudad.CUhabilitaropcionesciudad();
                    this.ciudadelegida = this.isla.getCiudades().get(i);
                    control = true;
                    this.Datosciudad.setVisible(true);


                    this.lblNombreJugador.setText("Jugador " + this.ciudadelegida.getJugador().getNick());
                    this.lblCiudadNombre.setText(this.ciudadelegida.getNombre());
                    this.lblPuntosTotales.setText("Puntos Totales: " + this.ciudadelegida.getJugador().getPuntostotales() + "");
                    this.lblPuntosConstructor.setText("Puntos Constructor: " + this.ciudadelegida.getJugador().getPuntosjugador().getPuntosconstructor());
                    this.lblPuntosSoldados.setText("Puntos Militar: " + (this.ciudadelegida.getJugador().getPuntosjugador().getPuntosataque() + this.ciudadelegida.getJugador().getPuntosjugador().getPuntosdefensa()) + "");
                    this.lblOro.setText("Oro: " + this.ciudadelegida.getJugador().getOro());
                    this.repaint();
                    return;
                } catch (SQLException ex) {

                }
            }
        }
        if (control == false) {
            this.habilitadoropciones2.setVisible(false);
            VFundarCiudad vfundar = new VFundarCiudad(this, this.ciudadjugador, this.isla, numeroposicion);

            this.Datosciudad.setVisible(false);

        }
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VerIsla = new org.edisoncor.gui.panel.PanelImage();
        imagenIsla = new org.edisoncor.gui.panel.PanelImage();
        cmdCiudad1 = new javax.swing.JButton();
        cmdMostrarMundo = new javax.swing.JButton();
        cmdCiudadJugador = new javax.swing.JButton();
        cmdCiudad2 = new javax.swing.JButton();
        cmdCiudad3 = new javax.swing.JButton();
        cmdCiudad4 = new javax.swing.JButton();
        cmdCiudad5 = new javax.swing.JButton();
        cmdCiudad6 = new javax.swing.JButton();
        cmdCiudad7 = new javax.swing.JButton();
        cmdCiudad8 = new javax.swing.JButton();
        cmdCiudad9 = new javax.swing.JButton();
        cmdCiudad10 = new javax.swing.JButton();
        cmdCiudad11 = new javax.swing.JButton();
        cmdCiudad12 = new javax.swing.JButton();
        cmdCiudad13 = new javax.swing.JButton();
        cmdCiudad14 = new javax.swing.JButton();
        cmdCiudad15 = new javax.swing.JButton();
        cmdEdificiodeLujo = new javax.swing.JButton();
        cmdAserrado = new javax.swing.JButton();
        habilitadoropciones2 = new org.edisoncor.gui.panel.PanelImage();
        cmdEnviarMensaje2 = new javax.swing.JButton();
        cmdDeclararGuerra2 = new javax.swing.JButton();
        lblEnviarMensaje2 = new javax.swing.JLabel();
        lblEnviarRecurso2 = new javax.swing.JLabel();
        lblDeclararGuerra2 = new javax.swing.JLabel();
        cmdEnviarRecursos2 = new javax.swing.JButton();
        Datosciudad = new org.edisoncor.gui.panel.PanelImage();
        lblCiudadNombre = new javax.swing.JLabel();
        Protegido = new javax.swing.JLabel();
        lblPuntosSoldados = new javax.swing.JLabel();
        lblPuntosConstructor = new javax.swing.JLabel();
        lblPuntosTotales = new javax.swing.JLabel();
        lblOro = new javax.swing.JLabel();
        lblNombreJugador = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenIsla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenIsla.setFocusable(false);
        imagenIsla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/ISLA/islavacia2.jpg"))); // NOI18N

        cmdCiudad1.setBorder(null);
        cmdCiudad1.setContentAreaFilled(false);
        cmdCiudad1.setDefaultCapable(false);
        cmdCiudad1.setFocusPainted(false);
        cmdCiudad1.setFocusable(false);
        cmdCiudad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad1ActionPerformed(evt);
            }
        });

        cmdMostrarMundo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmdMostrarMundo.setBorderPainted(false);
        cmdMostrarMundo.setContentAreaFilled(false);
        cmdMostrarMundo.setDefaultCapable(false);
        cmdMostrarMundo.setFocusPainted(false);
        cmdMostrarMundo.setFocusable(false);
        cmdMostrarMundo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMostrarMundoActionPerformed(evt);
            }
        });

        cmdCiudadJugador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmdCiudadJugador.setBorderPainted(false);
        cmdCiudadJugador.setContentAreaFilled(false);
        cmdCiudadJugador.setDefaultCapable(false);
        cmdCiudadJugador.setFocusPainted(false);
        cmdCiudadJugador.setFocusable(false);
        cmdCiudadJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudadJugadorActionPerformed(evt);
            }
        });

        cmdCiudad2.setBorder(null);
        cmdCiudad2.setContentAreaFilled(false);
        cmdCiudad2.setDefaultCapable(false);
        cmdCiudad2.setFocusPainted(false);
        cmdCiudad2.setFocusable(false);
        cmdCiudad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad2ActionPerformed(evt);
            }
        });

        cmdCiudad3.setBorder(null);
        cmdCiudad3.setContentAreaFilled(false);
        cmdCiudad3.setDefaultCapable(false);
        cmdCiudad3.setFocusPainted(false);
        cmdCiudad3.setFocusable(false);
        cmdCiudad3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad3ActionPerformed(evt);
            }
        });

        cmdCiudad4.setBorder(null);
        cmdCiudad4.setContentAreaFilled(false);
        cmdCiudad4.setDefaultCapable(false);
        cmdCiudad4.setFocusPainted(false);
        cmdCiudad4.setFocusable(false);
        cmdCiudad4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad4ActionPerformed(evt);
            }
        });

        cmdCiudad5.setBorder(null);
        cmdCiudad5.setContentAreaFilled(false);
        cmdCiudad5.setDefaultCapable(false);
        cmdCiudad5.setFocusPainted(false);
        cmdCiudad5.setFocusable(false);
        cmdCiudad5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad5ActionPerformed(evt);
            }
        });

        cmdCiudad6.setBorder(null);
        cmdCiudad6.setContentAreaFilled(false);
        cmdCiudad6.setDefaultCapable(false);
        cmdCiudad6.setFocusPainted(false);
        cmdCiudad6.setFocusable(false);
        cmdCiudad6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad6ActionPerformed(evt);
            }
        });

        cmdCiudad7.setBorder(null);
        cmdCiudad7.setContentAreaFilled(false);
        cmdCiudad7.setDefaultCapable(false);
        cmdCiudad7.setFocusPainted(false);
        cmdCiudad7.setFocusable(false);
        cmdCiudad7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad7ActionPerformed(evt);
            }
        });

        cmdCiudad8.setBorder(null);
        cmdCiudad8.setContentAreaFilled(false);
        cmdCiudad8.setDefaultCapable(false);
        cmdCiudad8.setFocusPainted(false);
        cmdCiudad8.setFocusable(false);
        cmdCiudad8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad8ActionPerformed(evt);
            }
        });

        cmdCiudad9.setBorder(null);
        cmdCiudad9.setContentAreaFilled(false);
        cmdCiudad9.setDefaultCapable(false);
        cmdCiudad9.setFocusPainted(false);
        cmdCiudad9.setFocusable(false);
        cmdCiudad9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad9ActionPerformed(evt);
            }
        });

        cmdCiudad10.setBorder(null);
        cmdCiudad10.setContentAreaFilled(false);
        cmdCiudad10.setDefaultCapable(false);
        cmdCiudad10.setFocusPainted(false);
        cmdCiudad10.setFocusable(false);
        cmdCiudad10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad10ActionPerformed(evt);
            }
        });

        cmdCiudad11.setBorder(null);
        cmdCiudad11.setContentAreaFilled(false);
        cmdCiudad11.setDefaultCapable(false);
        cmdCiudad11.setFocusPainted(false);
        cmdCiudad11.setFocusable(false);
        cmdCiudad11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad11ActionPerformed(evt);
            }
        });

        cmdCiudad12.setBorder(null);
        cmdCiudad12.setContentAreaFilled(false);
        cmdCiudad12.setDefaultCapable(false);
        cmdCiudad12.setFocusPainted(false);
        cmdCiudad12.setFocusable(false);
        cmdCiudad12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad12ActionPerformed(evt);
            }
        });

        cmdCiudad13.setBorder(null);
        cmdCiudad13.setContentAreaFilled(false);
        cmdCiudad13.setDefaultCapable(false);
        cmdCiudad13.setFocusPainted(false);
        cmdCiudad13.setFocusable(false);
        cmdCiudad13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad13ActionPerformed(evt);
            }
        });

        cmdCiudad14.setBorder(null);
        cmdCiudad14.setContentAreaFilled(false);
        cmdCiudad14.setDefaultCapable(false);
        cmdCiudad14.setFocusPainted(false);
        cmdCiudad14.setFocusable(false);
        cmdCiudad14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad14ActionPerformed(evt);
            }
        });

        cmdCiudad15.setBorder(null);
        cmdCiudad15.setContentAreaFilled(false);
        cmdCiudad15.setDefaultCapable(false);
        cmdCiudad15.setFocusPainted(false);
        cmdCiudad15.setFocusable(false);
        cmdCiudad15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCiudad15ActionPerformed(evt);
            }
        });

        cmdEdificiodeLujo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmdEdificiodeLujo.setContentAreaFilled(false);
        cmdEdificiodeLujo.setDefaultCapable(false);
        cmdEdificiodeLujo.setFocusPainted(false);
        cmdEdificiodeLujo.setFocusable(false);
        cmdEdificiodeLujo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEdificiodeLujoActionPerformed(evt);
            }
        });

        cmdAserrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/ISLA/aserrado.jpg"))); // NOI18N
        cmdAserrado.setBorder(null);
        cmdAserrado.setContentAreaFilled(false);
        cmdAserrado.setDefaultCapable(false);
        cmdAserrado.setFocusPainted(false);
        cmdAserrado.setFocusable(false);
        cmdAserrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAserradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenIslaLayout = new javax.swing.GroupLayout(imagenIsla);
        imagenIsla.setLayout(imagenIslaLayout);
        imagenIslaLayout.setHorizontalGroup(
                imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addComponent(cmdMostrarMundo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmdCiudadJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 62, Short.MAX_VALUE))
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(cmdCiudad15, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmdCiudad9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(cmdCiudad10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmdCiudad14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)))
                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                                .addGap(0, 13, Short.MAX_VALUE)
                                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                                                .addComponent(cmdCiudad11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(47, 47, 47))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                                                .addComponent(cmdCiudad12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(38, 38, 38))))
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cmdCiudad8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cmdEdificiodeLujo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                                .addComponent(cmdCiudad7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(41, 41, 41))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                                                .addComponent(cmdAserrado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                .addComponent(cmdCiudad6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addComponent(cmdCiudad13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(cmdCiudad3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(cmdCiudad5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(cmdCiudad4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51))
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(cmdCiudad2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                                .addComponent(cmdCiudad1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62))))
        );
        imagenIslaLayout.setVerticalGroup(
                imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cmdCiudadJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cmdMostrarMundo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addComponent(cmdCiudad5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(cmdCiudad9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addGap(168, 168, 168)
                                                .addComponent(cmdCiudad15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                                .addComponent(cmdCiudad14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmdCiudad10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(61, 61, 61))
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(cmdCiudad2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(cmdCiudad6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(90, 90, 90))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addComponent(cmdCiudad7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(cmdAserrado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                                                .addGap(42, 42, 42)
                                                                .addComponent(cmdCiudad8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(cmdEdificiodeLujo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)))
                                .addComponent(cmdCiudad12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(cmdCiudad11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(imagenIslaLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdCiudad4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(imagenIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                                .addComponent(cmdCiudad1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(119, 119, 119))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                                .addComponent(cmdCiudad3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(89, 89, 89))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenIslaLayout.createSequentialGroup()
                                                .addComponent(cmdCiudad13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(110, 110, 110))))
        );

        javax.swing.GroupLayout VerIslaLayout = new javax.swing.GroupLayout(VerIsla);
        VerIsla.setLayout(VerIslaLayout);
        VerIslaLayout.setHorizontalGroup(
                VerIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(VerIslaLayout.createSequentialGroup()
                                .addComponent(imagenIsla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 28, Short.MAX_VALUE))
        );
        VerIslaLayout.setVerticalGroup(
                VerIslaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(VerIslaLayout.createSequentialGroup()
                                .addComponent(imagenIsla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(VerIsla, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 11, -1, -1));

        habilitadoropciones2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        habilitadoropciones2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N

        cmdEnviarMensaje2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/enviar_mensaje.png"))); // NOI18N
        cmdEnviarMensaje2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmdEnviarMensaje2.setContentAreaFilled(false);
        cmdEnviarMensaje2.setDefaultCapable(false);
        cmdEnviarMensaje2.setEnabled(false);
        cmdEnviarMensaje2.setFocusPainted(false);
        cmdEnviarMensaje2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarMensajeActionPerformed(evt);
            }
        });

        cmdDeclararGuerra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/declarar_guerra.jpg"))); // NOI18N
        cmdDeclararGuerra2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmdDeclararGuerra2.setContentAreaFilled(false);
        cmdDeclararGuerra2.setDefaultCapable(false);
        cmdDeclararGuerra2.setEnabled(false);
        cmdDeclararGuerra2.setFocusPainted(false);
        cmdDeclararGuerra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeclararGuerraActionPerformed(evt);
            }
        });

        lblEnviarMensaje2.setText("Enviar Mensaje");
        lblEnviarMensaje2.setEnabled(false);

        lblEnviarRecurso2.setText("Enviar Recursos");
        lblEnviarRecurso2.setEnabled(false);

        lblDeclararGuerra2.setText("Declarar Guerra");
        lblDeclararGuerra2.setEnabled(false);

        cmdEnviarRecursos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/enviar_recursos.png"))); // NOI18N
        cmdEnviarRecursos2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmdEnviarRecursos2.setContentAreaFilled(false);
        cmdEnviarRecursos2.setDefaultCapable(false);
        cmdEnviarRecursos2.setEnabled(false);
        cmdEnviarRecursos2.setFocusPainted(false);
        cmdEnviarRecursos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarRecursosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout habilitadoropciones2Layout = new javax.swing.GroupLayout(habilitadoropciones2);
        habilitadoropciones2.setLayout(habilitadoropciones2Layout);
        habilitadoropciones2Layout.setHorizontalGroup(
                habilitadoropciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(habilitadoropciones2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(habilitadoropciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(habilitadoropciones2Layout.createSequentialGroup()
                                                .addGap(107, 107, 107)
                                                .addGroup(habilitadoropciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblDeclararGuerra2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cmdDeclararGuerra2))
                                                .addContainerGap(14, Short.MAX_VALUE))
                                        .addGroup(habilitadoropciones2Layout.createSequentialGroup()
                                                .addGroup(habilitadoropciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblEnviarMensaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cmdEnviarMensaje2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(habilitadoropciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblEnviarRecurso2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cmdEnviarRecursos2))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        habilitadoropciones2Layout.setVerticalGroup(
                habilitadoropciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(habilitadoropciones2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(habilitadoropciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmdEnviarRecursos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmdEnviarMensaje2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(habilitadoropciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEnviarMensaje2)
                                        .addComponent(lblEnviarRecurso2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdDeclararGuerra2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDeclararGuerra2)
                                .addContainerGap(170, Short.MAX_VALUE))
        );

        getContentPane().add(habilitadoropciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        Datosciudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Datosciudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N
        Datosciudad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCiudadNombre.setText("Ciudad : Nombre de ciudad");
        Datosciudad.add(lblCiudadNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 134, -1));

        Protegido.setText("Protegido");
        Datosciudad.add(Protegido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, -1));

        lblPuntosSoldados.setText("Puntos Militar");
        Datosciudad.add(lblPuntosSoldados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 180, -1));

        lblPuntosConstructor.setText("Puntos Constructor");
        Datosciudad.add(lblPuntosConstructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 180, -1));

        lblPuntosTotales.setText("Puntos Totales");
        Datosciudad.add(lblPuntosTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        lblOro.setText("Oro");
        Datosciudad.add(lblOro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, -1));

        lblNombreJugador.setText("Jugador");
        Datosciudad.add(lblNombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, -1));

        getContentPane().add(Datosciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 230, 163));

        panelImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 978, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 528, Short.MAX_VALUE)
        );

        getContentPane().add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCiudad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad1ActionPerformed
        this.Habilitaropcionesciudad(1);
    }//GEN-LAST:event_cmdCiudad1ActionPerformed

    private void cmdEnviarRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarRecursosActionPerformed
        VEnviarRecurso venviarrecurso = new VEnviarRecurso(this.ciudadjugador, this.ciudadelegida);

    }//GEN-LAST:event_cmdEnviarRecursosActionPerformed

    private void cmdDeclararGuerraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeclararGuerraActionPerformed
        try {
            DeclararGuerra guerranueva = new DeclararGuerra(this.ciudadjugador.getJugador(), this.ciudadelegida.getJugador());
            guerranueva.CUdeclararguerra();
        } catch (SQLException ex) {
        }

    }//GEN-LAST:event_cmdDeclararGuerraActionPerformed

    private void cmdEnviarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarMensajeActionPerformed
        VEnviarMensaje enviarmensaje = new VEnviarMensaje(this.ciudadjugador, this.ciudadelegida);


    }//GEN-LAST:event_cmdEnviarMensajeActionPerformed

    private void cmdMostrarMundoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMostrarMundoActionPerformed
        MostrarMundo mostrarmundo = new MostrarMundo(this.ciudadjugador);
        mostrarmundo.CUMostrarmundo();
        this.hide();
    }//GEN-LAST:event_cmdMostrarMundoActionPerformed

    private void cmdCiudadJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudadJugadorActionPerformed
        MostrarCiudad mostrarciudad = new MostrarCiudad(this.ciudadjugador);
        try {
            mostrarciudad.CUmostrarciudad();
        } catch (SQLException ex) {

        }
        this.hide();
    }//GEN-LAST:event_cmdCiudadJugadorActionPerformed

    private void cmdCiudad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad2ActionPerformed
        this.Habilitaropcionesciudad(2);
    }//GEN-LAST:event_cmdCiudad2ActionPerformed

    private void cmdCiudad3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad3ActionPerformed
        this.Habilitaropcionesciudad(3);
    }//GEN-LAST:event_cmdCiudad3ActionPerformed

    private void cmdCiudad4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad4ActionPerformed
        this.Habilitaropcionesciudad(4);
    }//GEN-LAST:event_cmdCiudad4ActionPerformed

    private void cmdCiudad5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad5ActionPerformed
        this.Habilitaropcionesciudad(5);
    }//GEN-LAST:event_cmdCiudad5ActionPerformed

    private void cmdCiudad6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad6ActionPerformed
        this.Habilitaropcionesciudad(6);
    }//GEN-LAST:event_cmdCiudad6ActionPerformed

    private void cmdCiudad7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad7ActionPerformed
        this.Habilitaropcionesciudad(7);
    }//GEN-LAST:event_cmdCiudad7ActionPerformed

    private void cmdCiudad8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad8ActionPerformed
        this.Habilitaropcionesciudad(8);
    }//GEN-LAST:event_cmdCiudad8ActionPerformed

    private void cmdCiudad9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad9ActionPerformed
        this.Habilitaropcionesciudad(9);
    }//GEN-LAST:event_cmdCiudad9ActionPerformed

    private void cmdCiudad10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad10ActionPerformed
        this.Habilitaropcionesciudad(10);
    }//GEN-LAST:event_cmdCiudad10ActionPerformed

    private void cmdCiudad11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad11ActionPerformed
        this.Habilitaropcionesciudad(11);
    }//GEN-LAST:event_cmdCiudad11ActionPerformed

    private void cmdCiudad12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad12ActionPerformed
        this.Habilitaropcionesciudad(12);
    }//GEN-LAST:event_cmdCiudad12ActionPerformed

    private void cmdCiudad13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad13ActionPerformed
        this.Habilitaropcionesciudad(13);
    }//GEN-LAST:event_cmdCiudad13ActionPerformed

    private void cmdCiudad14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad14ActionPerformed
        this.Habilitaropcionesciudad(14);
    }//GEN-LAST:event_cmdCiudad14ActionPerformed

    private void cmdCiudad15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCiudad15ActionPerformed
        this.Habilitaropcionesciudad(15);
    }//GEN-LAST:event_cmdCiudad15ActionPerformed

    private void cmdEdificiodeLujoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEdificiodeLujoActionPerformed
        try {
            MostrarIslaRecurso mostrarislarecursos = new MostrarIslaRecurso(this.isla, this.ciudadjugador, this.isla.retornarRecursoEspecial());
            mostrarislarecursos.CUmostrarislarecurso();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdEdificiodeLujoActionPerformed

    private void cmdAserradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAserradoActionPerformed
        try {
            MostrarIslaRecurso mostrarislarecursos = new MostrarIslaRecurso(this.isla, this.ciudadjugador, "Madera");
            mostrarislarecursos.CUmostrarislarecurso();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_cmdAserradoActionPerformed

    public Ciudad getCiudadjugador() {
        return ciudadjugador;
    }

    public PanelImage getDatosciudad() {
        return Datosciudad;
    }

    public JLabel getLblCiudadNombre() {
        return lblCiudadNombre;
    }

    public PanelImage getVerIsla() {
        return VerIsla;
    }

    public JButton getCmdCiudad1() {
        return cmdCiudad1;
    }

    public JButton getCmdCiudad10() {
        return cmdCiudad10;
    }

    public JButton getCmdCiudad11() {
        return cmdCiudad11;
    }

    public JButton getCmdCiudad12() {
        return cmdCiudad12;
    }

    public JButton getCmdCiudad13() {
        return cmdCiudad13;
    }

    public JButton getCmdCiudad14() {
        return cmdCiudad14;
    }

    public JButton getCmdCiudad15() {
        return cmdCiudad15;
    }

    public JButton getCmdCiudad2() {
        return cmdCiudad2;
    }

    public JButton getCmdCiudad3() {
        return cmdCiudad3;
    }

    public JButton getCmdCiudad4() {
        return cmdCiudad4;
    }

    public JButton getCmdCiudad5() {
        return cmdCiudad5;
    }

    public JButton getCmdCiudad6() {
        return cmdCiudad6;
    }

    public JButton getCmdCiudad7() {
        return cmdCiudad7;
    }

    public JButton getCmdCiudad8() {
        return cmdCiudad8;
    }

    public JButton getCmdCiudad9() {
        return cmdCiudad9;
    }

    public JButton getCmdDeclararGuerra2() {
        return cmdDeclararGuerra2;
    }

    public JButton getCmdEnviarMensaje2() {
        return cmdEnviarMensaje2;
    }

    public JButton getCmdEnviarRecursos2() {
        return cmdEnviarRecursos2;
    }

    public PanelImage getHabilitadoropciones2() {
        return habilitadoropciones2;
    }

    public PanelImage getImagenIsla() {
        return imagenIsla;
    }

    public JLabel getjLabel1() {
        return lblCiudadNombre;
    }

    public JLabel getLblDeclararGuerra2() {
        return lblDeclararGuerra2;
    }

    public JLabel getLblEnviarMensaje2() {
        return lblEnviarMensaje2;
    }

    public JLabel getLblEnviarRecurso2() {
        return lblEnviarRecurso2;
    }
    // End of variables declaration//GEN-END:variables
}
