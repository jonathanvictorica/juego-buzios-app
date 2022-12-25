/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.ejercito;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.controller.edificio.ConstruirEdificio;
import com.jmg.buzios.controller.ejercito.CrearUnidadMilitar;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class VVerUnidadesMilitaresConstruccion extends javax.swing.JFrame {

    private UnidadMilitar unidadelegida;
    private Ciudad ciudadjugador;
    private VCiudad vciudad;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdConstruirunidad;
    private org.edisoncor.gui.panel.PanelImage imagenAzufre;
    private org.edisoncor.gui.panel.PanelImage imagenAzufre1;
    private org.edisoncor.gui.panel.PanelImage imagenCristal;
    private org.edisoncor.gui.panel.PanelImage imagenCristal1;
    private org.edisoncor.gui.panel.PanelImage imagenHabitantes;
    private org.edisoncor.gui.panel.PanelImage imagenHabitantes1;
    private org.edisoncor.gui.panel.PanelImage imagenMadera;
    private org.edisoncor.gui.panel.PanelImage imagenMadera1;
    private org.edisoncor.gui.panel.PanelImage imagenOro;
    private org.edisoncor.gui.panel.PanelImage imagenOro1;
    private org.edisoncor.gui.panel.PanelImage imagenUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAzufre;
    private javax.swing.JLabel lblAzufre1;
    private javax.swing.JLabel lblCristal;
    private javax.swing.JLabel lblCristal1;
    private javax.swing.JLabel lblHabitantes;
    private javax.swing.JLabel lblHabitantes1;
    private javax.swing.JLabel lblMadera;
    private javax.swing.JLabel lblMadera1;
    private javax.swing.JLabel lblNombreunidadmilitar;
    private javax.swing.JLabel lblOro;
    private javax.swing.JLabel lblOro1;
    private javax.swing.JLabel lblPuntosataque;
    private javax.swing.JLabel lblPuntosdefensa;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private org.edisoncor.gui.panel.PanelImage panelImage4;
    private org.edisoncor.gui.panel.PanelImage panelImage5;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextPane txtDescripcion;
    public VVerUnidadesMilitaresConstruccion(UnidadMilitar unidadelegida, Ciudad ciudadjugador) {
        this.unidadelegida = unidadelegida;
        this.ciudadjugador = ciudadjugador;

        initComponents();
        panelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N
        imagenMadera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Maderadeedificionivel.jpg"))); // NOI18N

        imagenAzufre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Azufredeedificionivel.jpg"))); // NOI18N

        imagenCristal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Cristaldeedificionivel.jpg"))); // NOI18N

        imagenHabitantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/aldeanoRECOR.png"))); // NOI18N

        imagenOro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/oro.png"))); // NOI18N

        panelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-1.png"))); // NOI18N

        cmdConstruirunidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Construir Unidades.png"))); // NOI18N
        imagenMadera1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Maderadeedificionivel.jpg"))); // NOI18N

        imagenAzufre1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Azufredeedificionivel.jpg"))); // NOI18N

        imagenCristal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Cristaldeedificionivel.jpg"))); // NOI18N

        imagenHabitantes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/aldeanoRECOR.png"))); // NOI18N

        imagenOro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/oro.png"))); // NOI18N


        this.seleciconarunidadmilitar();
        this.setLocationRelativeTo(null);
        this.show();
    }

    public VCiudad getVciudad() {
        return vciudad;
    }

    public void setVciudad(VCiudad vciudad) {
        this.vciudad = vciudad;
    }

    public UnidadMilitar getUnidadelegida() {
        return unidadelegida;
    }

    public Ciudad getCiudadjugador() {
        return ciudadjugador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        panelImage4 = new org.edisoncor.gui.panel.PanelImage();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        imagenMadera = new org.edisoncor.gui.panel.PanelImage();
        lblMadera = new javax.swing.JLabel();
        imagenAzufre = new org.edisoncor.gui.panel.PanelImage();
        lblAzufre = new javax.swing.JLabel();
        imagenCristal = new org.edisoncor.gui.panel.PanelImage();
        lblCristal = new javax.swing.JLabel();
        imagenUnidad = new org.edisoncor.gui.panel.PanelImage();
        lblNombreunidadmilitar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imagenHabitantes = new org.edisoncor.gui.panel.PanelImage();
        imagenOro = new org.edisoncor.gui.panel.PanelImage();
        lblOro = new javax.swing.JLabel();
        lblHabitantes = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPuntosataque = new javax.swing.JLabel();
        lblPuntosdefensa = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        panelImage5 = new org.edisoncor.gui.panel.PanelImage();
        cmdConstruirunidad = new javax.swing.JButton();
        imagenMadera1 = new org.edisoncor.gui.panel.PanelImage();
        imagenAzufre1 = new org.edisoncor.gui.panel.PanelImage();
        imagenCristal1 = new org.edisoncor.gui.panel.PanelImage();
        imagenHabitantes1 = new org.edisoncor.gui.panel.PanelImage();
        imagenOro1 = new org.edisoncor.gui.panel.PanelImage();
        lblOro1 = new javax.swing.JLabel();
        lblHabitantes1 = new javax.swing.JLabel();
        lblCristal1 = new javax.swing.JLabel();
        lblAzufre1 = new javax.swing.JLabel();
        lblMadera1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        setResizable(false);

        panelImage4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenMadera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imagenMadera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Maderadeedificionivel.jpg"))); // NOI18N

        javax.swing.GroupLayout imagenMaderaLayout = new javax.swing.GroupLayout(imagenMadera);
        imagenMadera.setLayout(imagenMaderaLayout);
        imagenMaderaLayout.setHorizontalGroup(
                imagenMaderaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenMaderaLayout.setVerticalGroup(
                imagenMaderaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        panelImage1.add(imagenMadera, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 98, -1, -1));

        lblMadera.setText("0");
        panelImage1.add(lblMadera, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 155, 53, -1));

        imagenAzufre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imagenAzufre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Azufredeedificionivel.jpg"))); // NOI18N

        javax.swing.GroupLayout imagenAzufreLayout = new javax.swing.GroupLayout(imagenAzufre);
        imagenAzufre.setLayout(imagenAzufreLayout);
        imagenAzufreLayout.setHorizontalGroup(
                imagenAzufreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenAzufreLayout.setVerticalGroup(
                imagenAzufreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        panelImage1.add(imagenAzufre, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 98, -1, -1));

        lblAzufre.setText("0");
        panelImage1.add(lblAzufre, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 155, 53, -1));

        imagenCristal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imagenCristal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Cristaldeedificionivel.jpg"))); // NOI18N

        javax.swing.GroupLayout imagenCristalLayout = new javax.swing.GroupLayout(imagenCristal);
        imagenCristal.setLayout(imagenCristalLayout);
        imagenCristalLayout.setHorizontalGroup(
                imagenCristalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenCristalLayout.setVerticalGroup(
                imagenCristalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        panelImage1.add(imagenCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 98, -1, -1));

        lblCristal.setText("0");
        panelImage1.add(lblCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 155, 53, -1));

        imagenUnidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenUnidadLayout = new javax.swing.GroupLayout(imagenUnidad);
        imagenUnidad.setLayout(imagenUnidadLayout);
        imagenUnidadLayout.setHorizontalGroup(
                imagenUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 131, Short.MAX_VALUE)
        );
        imagenUnidadLayout.setVerticalGroup(
                imagenUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 144, Short.MAX_VALUE)
        );

        panelImage1.add(imagenUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 21, -1, -1));

        lblNombreunidadmilitar.setText("Nombreunidadmilitar");
        panelImage1.add(lblNombreunidadmilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 175, 135, -1));

        jLabel1.setText("Descripción");
        panelImage1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 200, 442, 15));

        imagenHabitantes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenHabitantesLayout = new javax.swing.GroupLayout(imagenHabitantes);
        imagenHabitantes.setLayout(imagenHabitantesLayout);
        imagenHabitantesLayout.setHorizontalGroup(
                imagenHabitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenHabitantesLayout.setVerticalGroup(
                imagenHabitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        panelImage1.add(imagenHabitantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 98, -1, -1));

        imagenOro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenOroLayout = new javax.swing.GroupLayout(imagenOro);
        imagenOro.setLayout(imagenOroLayout);
        imagenOroLayout.setHorizontalGroup(
                imagenOroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenOroLayout.setVerticalGroup(
                imagenOroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        panelImage1.add(imagenOro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 98, -1, -1));

        lblOro.setText("0");
        panelImage1.add(lblOro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 155, 53, -1));

        lblHabitantes.setText("0");
        panelImage1.add(lblHabitantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 155, 53, -1));

        jLabel2.setText("Puntos de Ataque");
        panelImage1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 32, 112, -1));

        jLabel3.setText("Puntos de Defensa");
        panelImage1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 64, 112, -1));

        lblPuntosataque.setText("jLabel4");
        panelImage1.add(lblPuntosataque, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 32, 112, -1));

        lblPuntosdefensa.setText("jLabel5");
        panelImage1.add(lblPuntosdefensa, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 64, 112, -1));

        jScrollPane2.setViewportView(txtDescripcion);

        panelImage1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 440, 100));

        panelImage4.add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 128, 470, 330));

        panelImage5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdConstruirunidad.setBorderPainted(false);
        cmdConstruirunidad.setContentAreaFilled(false);
        cmdConstruirunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdConstruirunidadActionPerformed(evt);
            }
        });
        panelImage5.add(cmdConstruirunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 57, 155, 50));

        imagenMadera1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenMadera1Layout = new javax.swing.GroupLayout(imagenMadera1);
        imagenMadera1.setLayout(imagenMadera1Layout);
        imagenMadera1Layout.setHorizontalGroup(
                imagenMadera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenMadera1Layout.setVerticalGroup(
                imagenMadera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        panelImage5.add(imagenMadera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        imagenAzufre1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenAzufre1Layout = new javax.swing.GroupLayout(imagenAzufre1);
        imagenAzufre1.setLayout(imagenAzufre1Layout);
        imagenAzufre1Layout.setHorizontalGroup(
                imagenAzufre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenAzufre1Layout.setVerticalGroup(
                imagenAzufre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        panelImage5.add(imagenAzufre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        imagenCristal1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenCristal1Layout = new javax.swing.GroupLayout(imagenCristal1);
        imagenCristal1.setLayout(imagenCristal1Layout);
        imagenCristal1Layout.setHorizontalGroup(
                imagenCristal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenCristal1Layout.setVerticalGroup(
                imagenCristal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        panelImage5.add(imagenCristal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        imagenHabitantes1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenHabitantes1Layout = new javax.swing.GroupLayout(imagenHabitantes1);
        imagenHabitantes1.setLayout(imagenHabitantes1Layout);
        imagenHabitantes1Layout.setHorizontalGroup(
                imagenHabitantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenHabitantes1Layout.setVerticalGroup(
                imagenHabitantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        panelImage5.add(imagenHabitantes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        imagenOro1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenOro1Layout = new javax.swing.GroupLayout(imagenOro1);
        imagenOro1.setLayout(imagenOro1Layout);
        imagenOro1Layout.setHorizontalGroup(
                imagenOro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenOro1Layout.setVerticalGroup(
                imagenOro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        panelImage5.add(imagenOro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        lblOro1.setText("0");
        panelImage5.add(lblOro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 53, -1));

        lblHabitantes1.setText("0");
        panelImage5.add(lblHabitantes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 53, -1));

        lblCristal1.setText("0");
        panelImage5.add(lblCristal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 53, -1));

        lblAzufre1.setText("0");
        panelImage5.add(lblAzufre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 53, -1));

        lblMadera1.setText("0");
        panelImage5.add(lblMadera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 53, -1));

        txtCantidad.setMaximumSize(new java.awt.Dimension(5, 5));
        txtCantidad.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtCantidadInputMethodTextChanged(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        panelImage5.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 155, 28));

        panelImage4.add(panelImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 470, 110));

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
                panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage4, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        panelImage3Layout.setVerticalGroup(
                panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage3Layout.createSequentialGroup()
                                .addComponent(panelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtCantidadInputMethodTextChanged


    }//GEN-LAST:event_txtCantidadInputMethodTextChanged

    private void cmdConstruirunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdConstruirunidadActionPerformed
        if (this.txtCantidad.getText().trim().length() != 0) {
            if (Integer.parseInt(this.txtCantidad.getText()) > 0) {
                CrearUnidadMilitar construirunidad = new CrearUnidadMilitar(this, ciudadjugador, this.unidadelegida, Integer.parseInt(this.txtCantidad.getText()));

                try {
                    construirunidad.CUcrarunidadmilitar();
                    this.ciudadjugador.getCiudadejercito().inicializarejercitodeciudad();
                    ConstruirEdificio.actualizarinterfazgrafica(vciudad);
                    this.hide();
                } catch (SQLException ex) {
                    ConexionDB.mostrarmensajebasededatos();
                }
            } else {
                JOptionPane.showMessageDialog(panelImage1, "Debe Ingresar un numero mayor a 0.");
            }


        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar el numero de cantidades de unidades que quieres crear.");
        }
    }//GEN-LAST:event_cmdConstruirunidadActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        try {
            int i = Integer.parseInt(this.txtCantidad.getText());

            this.calcularrecursosnecesarios();
        } catch (NumberFormatException e) {
            this.txtCantidad.setText("0");
            this.calcularrecursosnecesarios();
            this.txtCantidad.setText("");
        }
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        if (this.txtCantidad.getText().trim().length() == 5) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped
    // End of variables declaration//GEN-END:variables

    private void seleciconarunidadmilitar() {
        unidadelegida.inicializar_unidad( unidadelegida.getCodigounidad());

        this.lblNombreunidadmilitar.setText(unidadelegida.getNombre());
        this.txtDescripcion.setText(unidadelegida.getDescripcion());

        for (int i = 0; i < unidadelegida.getUnidadmilitarconstruccion().getRecurso().size(); i++) {
            switch (unidadelegida.getUnidadmilitarconstruccion().getRecurso().get(i).getNombrerecurso()) {
                case "Madera":
                    this.lblMadera.setText(unidadelegida.getUnidadmilitarconstruccion().getCantidad().get(i) + "");
                    break;
                case "Azufre":
                    this.lblAzufre.setText(unidadelegida.getUnidadmilitarconstruccion().getCantidad().get(i) + "");
                    break;
                case "Cristal":
                    this.lblCristal.setText(unidadelegida.getUnidadmilitarconstruccion().getCantidad().get(i) + "");
                    break;

            }
        }

        this.lblHabitantes.setText("" + unidadelegida.getCantidadhabitantes());
        this.lblOro.setText("" + unidadelegida.getCosto());

        this.lblPuntosataque.setText("" + unidadelegida.getPuntosataque());
        this.lblPuntosdefensa.setText("" + unidadelegida.getPuntosdefensivos());
        this.repaint();

    }


    private void calcularrecursosnecesarios() {
        try {
            int numeromadera = 0;
            int numerocristal = 0;
            int numeroazufre = 0;
            int numerohabitantes = 0;
            int numerooro = 0;

            int numerounidades = 0;

            numeromadera = Integer.parseInt(this.lblMadera.getText());
            numerocristal = Integer.parseInt(this.lblCristal.getText());
            numeroazufre = Integer.parseInt(this.lblAzufre.getText());
            numerohabitantes = Integer.parseInt(this.lblHabitantes.getText());
            numerooro = Integer.parseInt(this.lblOro.getText());

            numerounidades = Integer.parseInt(this.txtCantidad.getText());

            numeromadera *= numerounidades;
            numerocristal *= numerounidades;
            numeroazufre *= numerounidades;
            numerohabitantes *= numerounidades;
            numerooro *= numerounidades;

            this.lblMadera1.setText("" + numeromadera);
            this.lblCristal1.setText("" + numerocristal);
            this.lblAzufre1.setText("" + numeroazufre);
            this.lblHabitantes1.setText("" + numerohabitantes);
            this.lblOro1.setText("" + numerooro);

            this.repaint();
        } catch (NumberFormatException e) {
            this.txtCantidad.setText("");
            this.repaint();
        }
    }
}
