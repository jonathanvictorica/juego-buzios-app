/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.ejercito;

import com.jmg.buzios.controller.edificio.ConstruirEdificio;
import com.jmg.buzios.controller.ejercito.AsignarArmaaUnidad;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class VAsignarArma extends javax.swing.JFrame {

    private Ciudad ciudadjugador;
    private UnidadMilitar unidadmilitar;
    private VCiudad vciudad;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAsasignararma;
    private javax.swing.JButton cmdAsasignararma1;
    private javax.swing.JButton cmdAsasignararma2;
    private javax.swing.JButton cmdAsasignararma3;
    private org.edisoncor.gui.panel.PanelImage imagenArmaasignar;
    private org.edisoncor.gui.panel.PanelImage imagenArmaasignar1;
    private org.edisoncor.gui.panel.PanelImage imagenArmaasignar2;
    private org.edisoncor.gui.panel.PanelImage imagenArmaasignar3;
    private org.edisoncor.gui.panel.PanelImage imagenArmasaAsignar;
    private org.edisoncor.gui.panel.PanelImage imagenAzufre;
    private org.edisoncor.gui.panel.PanelImage imagenAzufre1;
    private org.edisoncor.gui.panel.PanelImage imagenAzufre2;
    private org.edisoncor.gui.panel.PanelImage imagenAzufre3;
    private org.edisoncor.gui.panel.PanelImage imagenCristal;
    private org.edisoncor.gui.panel.PanelImage imagenCristal1;
    private org.edisoncor.gui.panel.PanelImage imagenCristal2;
    private org.edisoncor.gui.panel.PanelImage imagenCristal3;
    private org.edisoncor.gui.panel.PanelImage imagenMadera;
    private org.edisoncor.gui.panel.PanelImage imagenMadera1;
    private org.edisoncor.gui.panel.PanelImage imagenMadera2;
    private org.edisoncor.gui.panel.PanelImage imagenMadera3;
    private javax.swing.JLabel lblArmaaasignar;
    private javax.swing.JLabel lblArmaaasignar1;
    private javax.swing.JLabel lblArmaaasignar2;
    private javax.swing.JLabel lblArmaaasignar3;
    private javax.swing.JLabel lblAzufre;
    private javax.swing.JLabel lblAzufre1;
    private javax.swing.JLabel lblAzufre2;
    private javax.swing.JLabel lblAzufre3;
    private javax.swing.JLabel lblCristal;
    private javax.swing.JLabel lblCristal1;
    private javax.swing.JLabel lblCristal2;
    private javax.swing.JLabel lblCristal3;
    private javax.swing.JLabel lblMadera;
    private javax.swing.JLabel lblMadera1;
    private javax.swing.JLabel lblMadera2;
    private javax.swing.JLabel lblMadera3;
    private javax.swing.JLabel lblPuntosataque;
    private javax.swing.JLabel lblPuntosataque1;
    private javax.swing.JLabel lblPuntosataque2;
    private javax.swing.JLabel lblPuntosataque3;
    private javax.swing.JLabel lblPuntosdefensivos;
    private javax.swing.JLabel lblPuntosdefensivos1;
    private javax.swing.JLabel lblPuntosdefensivos2;
    private javax.swing.JLabel lblPuntosdefensivos3;
    private javax.swing.JTextField txtCantidadaasignar;
    private javax.swing.JTextField txtCantidadaasignar1;
    private javax.swing.JTextField txtCantidadaasignar2;
    private javax.swing.JTextField txtCantidadaasignar3;

    public VAsignarArma(Ciudad ciudadjugador, UnidadMilitar unidadmilitar, VCiudad vciudad) {
        this.ciudadjugador = ciudadjugador;
        this.unidadmilitar = unidadmilitar;
        this.vciudad = vciudad;

        initComponents();
        //  panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N

        imagenArmasaAsignar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N
        cmdAsasignararma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Asignar.png"))); // NOI18N

        cmdAsasignararma1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Asignar.png"))); // NOI18N
        cmdAsasignararma2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Asignar.png"))); // NOI18N

        cmdAsasignararma3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Asignar.png"))); // NOI18N
        imagenMadera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Maderadeedificionivel.jpg"))); // NOI18N

        imagenAzufre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Azufredeedificionivel.jpg"))); // NOI18N

        imagenCristal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Cristaldeedificionivel.jpg"))); // NOI18N

        imagenCristal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Cristaldeedificionivel.jpg"))); // NOI18N
        imagenAzufre1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Azufredeedificionivel.jpg"))); // NOI18N

        imagenMadera1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Maderadeedificionivel.jpg"))); // NOI18N

        imagenCristal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Cristaldeedificionivel.jpg"))); // NOI18N

        imagenAzufre2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Azufredeedificionivel.jpg"))); // NOI18N
        imagenMadera2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Maderadeedificionivel.jpg"))); // NOI18N

        imagenCristal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Cristaldeedificionivel.jpg"))); // NOI18N

        imagenAzufre3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Azufredeedificionivel.jpg"))); // NOI18N

        imagenMadera3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Maderadeedificionivel.jpg"))); // NOI18N


        this.setLocationRelativeTo(null);
        this.show();
    }

    private boolean validarrecursos(int cantidad, int madera, int cristal, int azufre) {
        boolean control = true;
        for (int i = 0; i < this.ciudadjugador.getCiudadrecurso().getRecurso().size(); i++) {
            switch (this.ciudadjugador.getCiudadrecurso().getRecurso().get(i).getNombrerecurso()) {
                case "Madera":
                    if ((this.ciudadjugador.getCiudadrecurso().getCantidad().get(i).intValue() * cantidad) < madera) {
                        control = false;
                    }
                    break;
                case "Cristal":
                    if ((this.ciudadjugador.getCiudadrecurso().getCantidad().get(i).intValue() * cantidad) < cristal) {
                        control = false;
                    }
                    break;
                case "Azufre":
                    if ((this.ciudadjugador.getCiudadrecurso().getCantidad().get(i).intValue() * cantidad) < azufre) {
                        control = false;
                    }
                    break;
            }
        }


        return control;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenArmasaAsignar = new org.edisoncor.gui.panel.PanelImage();
        imagenArmaasignar = new org.edisoncor.gui.panel.PanelImage();
        lblArmaaasignar = new javax.swing.JLabel();
        txtCantidadaasignar = new javax.swing.JTextField();
        cmdAsasignararma = new javax.swing.JButton();
        cmdAsasignararma1 = new javax.swing.JButton();
        txtCantidadaasignar1 = new javax.swing.JTextField();
        lblArmaaasignar1 = new javax.swing.JLabel();
        imagenArmaasignar1 = new org.edisoncor.gui.panel.PanelImage();
        cmdAsasignararma2 = new javax.swing.JButton();
        txtCantidadaasignar2 = new javax.swing.JTextField();
        lblArmaaasignar2 = new javax.swing.JLabel();
        imagenArmaasignar2 = new org.edisoncor.gui.panel.PanelImage();
        cmdAsasignararma3 = new javax.swing.JButton();
        txtCantidadaasignar3 = new javax.swing.JTextField();
        lblArmaaasignar3 = new javax.swing.JLabel();
        imagenArmaasignar3 = new org.edisoncor.gui.panel.PanelImage();
        lblPuntosdefensivos = new javax.swing.JLabel();
        lblPuntosataque = new javax.swing.JLabel();
        imagenMadera = new org.edisoncor.gui.panel.PanelImage();
        imagenAzufre = new org.edisoncor.gui.panel.PanelImage();
        lblMadera = new javax.swing.JLabel();
        lblAzufre = new javax.swing.JLabel();
        lblCristal = new javax.swing.JLabel();
        imagenCristal = new org.edisoncor.gui.panel.PanelImage();
        lblMadera1 = new javax.swing.JLabel();
        lblAzufre1 = new javax.swing.JLabel();
        lblCristal1 = new javax.swing.JLabel();
        imagenCristal1 = new org.edisoncor.gui.panel.PanelImage();
        imagenAzufre1 = new org.edisoncor.gui.panel.PanelImage();
        imagenMadera1 = new org.edisoncor.gui.panel.PanelImage();
        lblPuntosataque1 = new javax.swing.JLabel();
        lblPuntosdefensivos1 = new javax.swing.JLabel();
        lblMadera2 = new javax.swing.JLabel();
        lblAzufre2 = new javax.swing.JLabel();
        lblCristal2 = new javax.swing.JLabel();
        imagenCristal2 = new org.edisoncor.gui.panel.PanelImage();
        imagenAzufre2 = new org.edisoncor.gui.panel.PanelImage();
        imagenMadera2 = new org.edisoncor.gui.panel.PanelImage();
        lblPuntosataque2 = new javax.swing.JLabel();
        lblPuntosdefensivos2 = new javax.swing.JLabel();
        lblMadera3 = new javax.swing.JLabel();
        lblAzufre3 = new javax.swing.JLabel();
        lblCristal3 = new javax.swing.JLabel();
        imagenCristal3 = new org.edisoncor.gui.panel.PanelImage();
        imagenAzufre3 = new org.edisoncor.gui.panel.PanelImage();
        imagenMadera3 = new org.edisoncor.gui.panel.PanelImage();
        lblPuntosataque3 = new javax.swing.JLabel();
        lblPuntosdefensivos3 = new javax.swing.JLabel();

        imagenArmasaAsignar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenArmasaAsignar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenArmaasignar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArmaasignarLayout = new javax.swing.GroupLayout(imagenArmaasignar);
        imagenArmaasignar.setLayout(imagenArmaasignarLayout);
        imagenArmaasignarLayout.setHorizontalGroup(
                imagenArmaasignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenArmaasignarLayout.setVerticalGroup(
                imagenArmaasignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenArmaasignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 102, -1));

        lblArmaaasignar.setText("Nombrearma");
        lblArmaaasignar.setOpaque(true);
        imagenArmasaAsignar.add(lblArmaaasignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 120, 102, -1));

        txtCantidadaasignar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadaasignarKeyReleased(evt);
            }
        });
        imagenArmasaAsignar.add(txtCantidadaasignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 236, 102, -1));

        cmdAsasignararma.setBorderPainted(false);
        cmdAsasignararma.setContentAreaFilled(false);
        cmdAsasignararma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAsasignararmaActionPerformed(evt);
            }
        });
        imagenArmasaAsignar.add(cmdAsasignararma, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 262, 102, 20));

        cmdAsasignararma1.setBorderPainted(false);
        cmdAsasignararma1.setContentAreaFilled(false);
        cmdAsasignararma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAsasignararma1ActionPerformed(evt);
            }
        });
        imagenArmasaAsignar.add(cmdAsasignararma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 262, 102, 20));

        txtCantidadaasignar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadaasignar1KeyReleased(evt);
            }
        });
        imagenArmasaAsignar.add(txtCantidadaasignar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 236, 102, -1));

        lblArmaaasignar1.setText("Nombrearma");
        lblArmaaasignar1.setOpaque(true);
        imagenArmasaAsignar.add(lblArmaaasignar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 120, 102, -1));

        imagenArmaasignar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArmaasignar1Layout = new javax.swing.GroupLayout(imagenArmaasignar1);
        imagenArmaasignar1.setLayout(imagenArmaasignar1Layout);
        imagenArmaasignar1Layout.setHorizontalGroup(
                imagenArmaasignar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenArmaasignar1Layout.setVerticalGroup(
                imagenArmaasignar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenArmaasignar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 12, 102, -1));

        cmdAsasignararma2.setBorderPainted(false);
        cmdAsasignararma2.setContentAreaFilled(false);
        cmdAsasignararma2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAsasignararma2ActionPerformed(evt);
            }
        });
        imagenArmasaAsignar.add(cmdAsasignararma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 262, 102, 20));

        txtCantidadaasignar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadaasignar2KeyReleased(evt);
            }
        });
        imagenArmasaAsignar.add(txtCantidadaasignar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 236, 102, -1));

        lblArmaaasignar2.setText("Nombrearma");
        lblArmaaasignar2.setOpaque(true);
        imagenArmasaAsignar.add(lblArmaaasignar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 120, 102, -1));

        imagenArmaasignar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArmaasignar2Layout = new javax.swing.GroupLayout(imagenArmaasignar2);
        imagenArmaasignar2.setLayout(imagenArmaasignar2Layout);
        imagenArmaasignar2Layout.setHorizontalGroup(
                imagenArmaasignar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenArmaasignar2Layout.setVerticalGroup(
                imagenArmaasignar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenArmaasignar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 12, 102, -1));

        cmdAsasignararma3.setBorderPainted(false);
        cmdAsasignararma3.setContentAreaFilled(false);
        cmdAsasignararma3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAsasignararma3ActionPerformed(evt);
            }
        });
        imagenArmasaAsignar.add(cmdAsasignararma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 262, 102, 20));

        txtCantidadaasignar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadaasignar3KeyReleased(evt);
            }
        });
        imagenArmasaAsignar.add(txtCantidadaasignar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 236, 102, -1));

        lblArmaaasignar3.setText("Nombrearma");
        lblArmaaasignar3.setOpaque(true);
        imagenArmasaAsignar.add(lblArmaaasignar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 120, 102, -1));

        imagenArmaasignar3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArmaasignar3Layout = new javax.swing.GroupLayout(imagenArmaasignar3);
        imagenArmaasignar3.setLayout(imagenArmaasignar3Layout);
        imagenArmaasignar3Layout.setHorizontalGroup(
                imagenArmaasignar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenArmaasignar3Layout.setVerticalGroup(
                imagenArmaasignar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenArmaasignar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 12, 102, -1));

        lblPuntosdefensivos.setText("Defensivos:");
        lblPuntosdefensivos.setDoubleBuffered(true);
        lblPuntosdefensivos.setOpaque(true);
        imagenArmasaAsignar.add(lblPuntosdefensivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 140, 102, -1));

        lblPuntosataque.setText("Ataque:");
        lblPuntosataque.setDoubleBuffered(true);
        lblPuntosataque.setOpaque(true);
        imagenArmasaAsignar.add(lblPuntosataque, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 160, 102, -1));

        imagenMadera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenMaderaLayout = new javax.swing.GroupLayout(imagenMadera);
        imagenMadera.setLayout(imagenMaderaLayout);
        imagenMaderaLayout.setHorizontalGroup(
                imagenMaderaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenMaderaLayout.setVerticalGroup(
                imagenMaderaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenMadera, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 180, -1, 30));

        imagenAzufre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenAzufreLayout = new javax.swing.GroupLayout(imagenAzufre);
        imagenAzufre.setLayout(imagenAzufreLayout);
        imagenAzufreLayout.setHorizontalGroup(
                imagenAzufreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenAzufreLayout.setVerticalGroup(
                imagenAzufreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenAzufre, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 180, -1, 30));

        lblMadera.setText("0");
        lblMadera.setDoubleBuffered(true);
        lblMadera.setOpaque(true);
        imagenArmasaAsignar.add(lblMadera, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 216, 30, -1));

        lblAzufre.setText("0");
        lblAzufre.setDoubleBuffered(true);
        lblAzufre.setOpaque(true);
        imagenArmasaAsignar.add(lblAzufre, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 216, 30, -1));

        lblCristal.setText("0");
        lblCristal.setDoubleBuffered(true);
        lblCristal.setOpaque(true);
        imagenArmasaAsignar.add(lblCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 216, 30, -1));

        imagenCristal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenCristalLayout = new javax.swing.GroupLayout(imagenCristal);
        imagenCristal.setLayout(imagenCristalLayout);
        imagenCristalLayout.setHorizontalGroup(
                imagenCristalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenCristalLayout.setVerticalGroup(
                imagenCristalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 180, -1, -1));

        lblMadera1.setText("0");
        lblMadera1.setDoubleBuffered(true);
        lblMadera1.setOpaque(true);
        imagenArmasaAsignar.add(lblMadera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 216, 30, -1));

        lblAzufre1.setText("0");
        lblAzufre1.setDoubleBuffered(true);
        lblAzufre1.setOpaque(true);
        imagenArmasaAsignar.add(lblAzufre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 216, 30, -1));

        lblCristal1.setText("0");
        lblCristal1.setDoubleBuffered(true);
        lblCristal1.setOpaque(true);
        imagenArmasaAsignar.add(lblCristal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 216, 30, -1));

        imagenCristal1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenCristal1Layout = new javax.swing.GroupLayout(imagenCristal1);
        imagenCristal1.setLayout(imagenCristal1Layout);
        imagenCristal1Layout.setHorizontalGroup(
                imagenCristal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenCristal1Layout.setVerticalGroup(
                imagenCristal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenCristal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 180, -1, 30));

        imagenAzufre1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenAzufre1Layout = new javax.swing.GroupLayout(imagenAzufre1);
        imagenAzufre1.setLayout(imagenAzufre1Layout);
        imagenAzufre1Layout.setHorizontalGroup(
                imagenAzufre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenAzufre1Layout.setVerticalGroup(
                imagenAzufre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenAzufre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 180, -1, 30));

        imagenMadera1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenMadera1Layout = new javax.swing.GroupLayout(imagenMadera1);
        imagenMadera1.setLayout(imagenMadera1Layout);
        imagenMadera1Layout.setHorizontalGroup(
                imagenMadera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenMadera1Layout.setVerticalGroup(
                imagenMadera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenMadera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 180, -1, -1));

        lblPuntosataque1.setText("Ataque:");
        lblPuntosataque1.setDoubleBuffered(true);
        lblPuntosataque1.setOpaque(true);
        imagenArmasaAsignar.add(lblPuntosataque1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 160, 102, -1));

        lblPuntosdefensivos1.setText("Defensivos:");
        lblPuntosdefensivos1.setDoubleBuffered(true);
        lblPuntosdefensivos1.setOpaque(true);
        imagenArmasaAsignar.add(lblPuntosdefensivos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 140, 102, -1));

        lblMadera2.setText("0");
        lblMadera2.setDoubleBuffered(true);
        lblMadera2.setOpaque(true);
        imagenArmasaAsignar.add(lblMadera2, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 216, 30, -1));

        lblAzufre2.setText("0");
        lblAzufre2.setDoubleBuffered(true);
        lblAzufre2.setOpaque(true);
        imagenArmasaAsignar.add(lblAzufre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 216, 30, -1));

        lblCristal2.setText("0");
        lblCristal2.setDoubleBuffered(true);
        lblCristal2.setOpaque(true);
        imagenArmasaAsignar.add(lblCristal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 216, 30, -1));

        imagenCristal2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenCristal2Layout = new javax.swing.GroupLayout(imagenCristal2);
        imagenCristal2.setLayout(imagenCristal2Layout);
        imagenCristal2Layout.setHorizontalGroup(
                imagenCristal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenCristal2Layout.setVerticalGroup(
                imagenCristal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenCristal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 180, -1, 30));

        imagenAzufre2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenAzufre2Layout = new javax.swing.GroupLayout(imagenAzufre2);
        imagenAzufre2.setLayout(imagenAzufre2Layout);
        imagenAzufre2Layout.setHorizontalGroup(
                imagenAzufre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenAzufre2Layout.setVerticalGroup(
                imagenAzufre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenAzufre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 180, -1, 30));

        imagenMadera2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenMadera2Layout = new javax.swing.GroupLayout(imagenMadera2);
        imagenMadera2.setLayout(imagenMadera2Layout);
        imagenMadera2Layout.setHorizontalGroup(
                imagenMadera2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenMadera2Layout.setVerticalGroup(
                imagenMadera2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenMadera2, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 180, -1, -1));

        lblPuntosataque2.setText("Ataque:");
        lblPuntosataque2.setDoubleBuffered(true);
        lblPuntosataque2.setOpaque(true);
        imagenArmasaAsignar.add(lblPuntosataque2, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 160, 102, -1));

        lblPuntosdefensivos2.setText("Defensivos:");
        lblPuntosdefensivos2.setDoubleBuffered(true);
        lblPuntosdefensivos2.setOpaque(true);
        imagenArmasaAsignar.add(lblPuntosdefensivos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 140, 102, -1));

        lblMadera3.setText("0");
        lblMadera3.setDoubleBuffered(true);
        lblMadera3.setOpaque(true);
        imagenArmasaAsignar.add(lblMadera3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 216, 30, -1));

        lblAzufre3.setText("0");
        lblAzufre3.setDoubleBuffered(true);
        lblAzufre3.setOpaque(true);
        imagenArmasaAsignar.add(lblAzufre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 216, 30, -1));

        lblCristal3.setText("0");
        lblCristal3.setDoubleBuffered(true);
        lblCristal3.setOpaque(true);
        imagenArmasaAsignar.add(lblCristal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 216, 30, -1));

        imagenCristal3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenCristal3Layout = new javax.swing.GroupLayout(imagenCristal3);
        imagenCristal3.setLayout(imagenCristal3Layout);
        imagenCristal3Layout.setHorizontalGroup(
                imagenCristal3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenCristal3Layout.setVerticalGroup(
                imagenCristal3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenCristal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 180, -1, 30));

        imagenAzufre3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenAzufre3Layout = new javax.swing.GroupLayout(imagenAzufre3);
        imagenAzufre3.setLayout(imagenAzufre3Layout);
        imagenAzufre3Layout.setHorizontalGroup(
                imagenAzufre3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenAzufre3Layout.setVerticalGroup(
                imagenAzufre3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenAzufre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 180, -1, 30));

        imagenMadera3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenMadera3Layout = new javax.swing.GroupLayout(imagenMadera3);
        imagenMadera3.setLayout(imagenMadera3Layout);
        imagenMadera3Layout.setHorizontalGroup(
                imagenMadera3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );
        imagenMadera3Layout.setVerticalGroup(
                imagenMadera3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 26, Short.MAX_VALUE)
        );

        imagenArmasaAsignar.add(imagenMadera3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 180, -1, -1));

        lblPuntosataque3.setText("Ataque:");
        lblPuntosataque3.setDoubleBuffered(true);
        lblPuntosataque3.setOpaque(true);
        imagenArmasaAsignar.add(lblPuntosataque3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 160, 102, -1));

        lblPuntosdefensivos3.setText("Defensivos:");
        lblPuntosdefensivos3.setDoubleBuffered(true);
        lblPuntosdefensivos3.setOpaque(true);
        imagenArmasaAsignar.add(lblPuntosdefensivos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 140, 102, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(imagenArmasaAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(imagenArmasaAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadaasignarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadaasignarKeyReleased
        int numero;
        try {
            numero = Integer.parseInt(this.txtCantidadaasignar.getText());
            if (this.validarrecursos(numero, Integer.parseInt(this.getLblMadera().getText()), Integer.parseInt(this.getLblCristal().getText()), Integer.parseInt(this.getLblAzufre().getText()))) {
                this.txtCantidadaasignar.setText(numero + "");
            } else {
                this.txtCantidadaasignar.setText("");
            }

        } catch (NumberFormatException j) {
            this.txtCantidadaasignar.setText("");
        }
    }//GEN-LAST:event_txtCantidadaasignarKeyReleased

    private void txtCantidadaasignar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadaasignar1KeyReleased
        int numero;
        try {
            numero = Integer.parseInt(this.txtCantidadaasignar1.getText());
            if (this.validarrecursos(numero, Integer.parseInt(this.getLblMadera1().getText()), Integer.parseInt(this.getLblCristal1().getText()), Integer.parseInt(this.getLblAzufre1().getText()))) {
                this.txtCantidadaasignar1.setText(numero + "");
            } else {
                this.txtCantidadaasignar1.setText("");
            }

        } catch (NumberFormatException j) {
            this.txtCantidadaasignar1.setText("");
        }
    }//GEN-LAST:event_txtCantidadaasignar1KeyReleased

    private void txtCantidadaasignar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadaasignar2KeyReleased
        int numero;
        try {
            numero = Integer.parseInt(this.txtCantidadaasignar2.getText());
            if (this.validarrecursos(numero, Integer.parseInt(this.getLblMadera2().getText()), Integer.parseInt(this.getLblCristal2().getText()), Integer.parseInt(this.getLblAzufre2().getText()))) {
                this.txtCantidadaasignar2.setText(numero + "");
            } else {
                this.txtCantidadaasignar2.setText("");
            }

        } catch (NumberFormatException j) {
            this.txtCantidadaasignar2.setText("");
        }
    }//GEN-LAST:event_txtCantidadaasignar2KeyReleased

    private void txtCantidadaasignar3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadaasignar3KeyReleased
        int numero;
        try {
            numero = Integer.parseInt(this.txtCantidadaasignar3.getText());
            if (this.validarrecursos(numero, Integer.parseInt(this.getLblMadera3().getText()), Integer.parseInt(this.getLblCristal3().getText()), Integer.parseInt(this.getLblAzufre3().getText()))) {
                this.txtCantidadaasignar3.setText(numero + "");
            } else {
                this.txtCantidadaasignar3.setText("");
            }

        } catch (NumberFormatException j) {
            this.txtCantidadaasignar3.setText("");
        }
    }//GEN-LAST:event_txtCantidadaasignar3KeyReleased

    private void cmdAsasignararmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAsasignararmaActionPerformed
        AsignarArmaaUnidad asignararma = new AsignarArmaaUnidad(this.unidadmilitar, this.unidadmilitar.getArmaunidad().getListarmas().get(0), Integer.parseInt(this.txtCantidadaasignar.getText()), this.vciudad);
        try {
            asignararma.CUAsignararmaaunidad();
            ConstruirEdificio.actualizarinterfazgrafica(vciudad);
            this.hide();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdAsasignararmaActionPerformed

    private void cmdAsasignararma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAsasignararma1ActionPerformed
        AsignarArmaaUnidad asignararma = new AsignarArmaaUnidad(this.unidadmilitar, this.unidadmilitar.getArmaunidad().getListarmas().get(1), Integer.parseInt(this.txtCantidadaasignar1.getText()), this.vciudad);
        try {
            asignararma.CUAsignararmaaunidad();
            ConstruirEdificio.actualizarinterfazgrafica(vciudad);

            this.hide();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdAsasignararma1ActionPerformed

    private void cmdAsasignararma2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAsasignararma2ActionPerformed
        AsignarArmaaUnidad asignararma = new AsignarArmaaUnidad(this.unidadmilitar, this.unidadmilitar.getArmaunidad().getListarmas().get(2), Integer.parseInt(this.txtCantidadaasignar2.getText()), this.vciudad);
        try {
            asignararma.CUAsignararmaaunidad();
            ConstruirEdificio.actualizarinterfazgrafica(vciudad);

            this.hide();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdAsasignararma2ActionPerformed

    private void cmdAsasignararma3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAsasignararma3ActionPerformed
        AsignarArmaaUnidad asignararma = new AsignarArmaaUnidad(this.unidadmilitar, this.unidadmilitar.getArmaunidad().getListarmas().get(3), Integer.parseInt(this.txtCantidadaasignar3.getText()), this.vciudad);
        try {
            asignararma.CUAsignararmaaunidad();
            ConstruirEdificio.actualizarinterfazgrafica(vciudad);

            this.hide();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdAsasignararma3ActionPerformed

    public JButton getCmdAsasignararma() {
        return cmdAsasignararma;
    }

    public JButton getCmdAsasignararma1() {
        return cmdAsasignararma1;
    }

    public JButton getCmdAsasignararma2() {
        return cmdAsasignararma2;
    }

    public JButton getCmdAsasignararma3() {
        return cmdAsasignararma3;
    }

    public PanelImage getImagenArmaasignar() {
        return imagenArmaasignar;
    }

    public PanelImage getImagenArmaasignar1() {
        return imagenArmaasignar1;
    }

    public PanelImage getImagenArmaasignar2() {
        return imagenArmaasignar2;
    }

    public PanelImage getImagenArmaasignar3() {
        return imagenArmaasignar3;
    }

    public PanelImage getImagenArmasaAsignar() {
        return imagenArmasaAsignar;
    }

    public PanelImage getImagenAzufre() {
        return imagenAzufre;
    }

    public PanelImage getImagenAzufre1() {
        return imagenAzufre1;
    }

    public PanelImage getImagenAzufre2() {
        return imagenAzufre2;
    }

    public PanelImage getImagenAzufre3() {
        return imagenAzufre3;
    }

    public PanelImage getImagenCristal() {
        return imagenCristal;
    }

    public PanelImage getImagenCristal1() {
        return imagenCristal1;
    }

    public PanelImage getImagenCristal2() {
        return imagenCristal2;
    }

    public PanelImage getImagenCristal3() {
        return imagenCristal3;
    }

    public PanelImage getImagenMadera() {
        return imagenMadera;
    }

    public PanelImage getImagenMadera1() {
        return imagenMadera1;
    }

    public PanelImage getImagenMadera2() {
        return imagenMadera2;
    }

    public PanelImage getImagenMadera3() {
        return imagenMadera3;
    }

    public JLabel getLblArmaaasignar() {
        return lblArmaaasignar;
    }

    public JLabel getLblArmaaasignar1() {
        return lblArmaaasignar1;
    }

    public JLabel getLblArmaaasignar2() {
        return lblArmaaasignar2;
    }

    public JLabel getLblArmaaasignar3() {
        return lblArmaaasignar3;
    }

    public JLabel getLblAzufre() {
        return lblAzufre;
    }

    public JLabel getLblAzufre1() {
        return lblAzufre1;
    }

    public JLabel getLblAzufre2() {
        return lblAzufre2;
    }

    public JLabel getLblAzufre3() {
        return lblAzufre3;
    }

    public JLabel getLblCristal() {
        return lblCristal;
    }

    public JLabel getLblCristal1() {
        return lblCristal1;
    }

    public JLabel getLblCristal2() {
        return lblCristal2;
    }

    public JLabel getLblCristal3() {
        return lblCristal3;
    }

    public JLabel getLblMadera() {
        return lblMadera;
    }

    public JLabel getLblMadera1() {
        return lblMadera1;
    }

    public JLabel getLblMadera2() {
        return lblMadera2;
    }

    public JLabel getLblMadera3() {
        return lblMadera3;
    }

    public JLabel getLblPuntosataque() {
        return lblPuntosataque;
    }

    public JLabel getLblPuntosataque1() {
        return lblPuntosataque1;
    }

    public JLabel getLblPuntosataque2() {
        return lblPuntosataque2;
    }

    public JLabel getLblPuntosataque3() {
        return lblPuntosataque3;
    }

    public JLabel getLblPuntosdefensivos() {
        return lblPuntosdefensivos;
    }

    public JLabel getLblPuntosdefensivos1() {
        return lblPuntosdefensivos1;
    }

    public JLabel getLblPuntosdefensivos2() {
        return lblPuntosdefensivos2;
    }

    public JLabel getLblPuntosdefensivos3() {
        return lblPuntosdefensivos3;
    }

    public JTextField getTxtCantidadaasignar() {
        return txtCantidadaasignar;
    }

    public JTextField getTxtCantidadaasignar1() {
        return txtCantidadaasignar1;
    }

    public JTextField getTxtCantidadaasignar2() {
        return txtCantidadaasignar2;
    }

    public JTextField getTxtCantidadaasignar3() {
        return txtCantidadaasignar3;
    }
    // End of variables declaration//GEN-END:variables
}
