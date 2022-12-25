/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.edificios;

import com.jmg.buzios.controller.ciudad.AsignarVino;
import com.jmg.buzios.controller.edificio.VerTaberna;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alumno
 */
public class VVerTaberna extends javax.swing.JFrame {

    private VerTaberna vertaberna;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider barraVino;
    private javax.swing.JButton cmdAsignarVino;
    private javax.swing.JButton cmdDestruiredificio;
    private javax.swing.JButton cmdElevarniveledificio;
    private org.edisoncor.gui.panel.PanelImage edificioAcademia;
    private org.edisoncor.gui.panel.PanelImage imagenAzufre;
    private org.edisoncor.gui.panel.PanelImage imagenCristal;
    private org.edisoncor.gui.panel.PanelImage imagenMadera;
    private org.edisoncor.gui.panel.PanelImage imagenMarmol;
    private javax.swing.JLabel lblAzufre;
    private javax.swing.JLabel lblCristal;
    private javax.swing.JLabel lblMadera;
    private javax.swing.JLabel lblMarmol;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNivelMaximo;
    private javax.swing.JLabel lblServirvinoporhora;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private org.edisoncor.gui.panel.PanelImage panelImage4;
    private org.edisoncor.gui.panel.PanelImage panelImage5;
    private org.edisoncor.gui.panel.PanelImage panelVentanaedificio;
    private org.edisoncor.gui.panel.PanelImage panelimagenedificio;
    public VVerTaberna(VerTaberna vertaberna) {
        this.vertaberna = vertaberna;
        initComponents();
        this.setLocationRelativeTo(null);
        this.show();
    }

    public JSlider getBarraVino() {
        return barraVino;
    }

    public JLabel getLblServirvinoporhora() {
        return lblServirvinoporhora;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVentanaedificio = new org.edisoncor.gui.panel.PanelImage();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        panelImage4 = new org.edisoncor.gui.panel.PanelImage();
        cmdDestruiredificio = new javax.swing.JButton();
        panelImage5 = new org.edisoncor.gui.panel.PanelImage();
        cmdElevarniveledificio = new javax.swing.JButton();
        imagenMadera = new org.edisoncor.gui.panel.PanelImage();
        imagenMarmol = new org.edisoncor.gui.panel.PanelImage();
        imagenAzufre = new org.edisoncor.gui.panel.PanelImage();
        imagenCristal = new org.edisoncor.gui.panel.PanelImage();
        lblCristal = new javax.swing.JLabel();
        lblAzufre = new javax.swing.JLabel();
        lblMarmol = new javax.swing.JLabel();
        lblMadera = new javax.swing.JLabel();
        panelimagenedificio = new org.edisoncor.gui.panel.PanelImage();
        lblNivel = new javax.swing.JLabel();
        lblNivelMaximo = new javax.swing.JLabel();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        edificioAcademia = new org.edisoncor.gui.panel.PanelImage();
        lblServirvinoporhora = new javax.swing.JLabel();
        cmdAsignarVino = new javax.swing.JButton();
        barraVino = new javax.swing.JSlider();

        setResizable(false);

        panelVentanaedificio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N

        panelImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-1.png"))); // NOI18N

        panelImage4.setOpaque(false);

        cmdDestruiredificio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/boton destruir edificio.png"))); // NOI18N
        cmdDestruiredificio.setAlignmentY(0.0F);
        cmdDestruiredificio.setBorder(null);
        cmdDestruiredificio.setContentAreaFilled(false);
        cmdDestruiredificio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cmdDestruiredificio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDestruiredificioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage4Layout = new javax.swing.GroupLayout(panelImage4);
        panelImage4.setLayout(panelImage4Layout);
        panelImage4Layout.setHorizontalGroup(
                panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmdDestruiredificio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelImage4Layout.setVerticalGroup(
                panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmdDestruiredificio)
        );

        panelImage5.setOpaque(false);

        cmdElevarniveledificio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/boton elevar nivel.png"))); // NOI18N
        cmdElevarniveledificio.setAlignmentY(0.0F);
        cmdElevarniveledificio.setBorder(null);
        cmdElevarniveledificio.setContentAreaFilled(false);
        cmdElevarniveledificio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cmdElevarniveledificio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdElevarniveledificioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage5Layout = new javax.swing.GroupLayout(panelImage5);
        panelImage5.setLayout(panelImage5Layout);
        panelImage5Layout.setHorizontalGroup(
                panelImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmdElevarniveledificio)
        );
        panelImage5Layout.setVerticalGroup(
                panelImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmdElevarniveledificio)
        );

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

        imagenMarmol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imagenMarmol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Marmoldeedificionivel.jpg"))); // NOI18N

        javax.swing.GroupLayout imagenMarmolLayout = new javax.swing.GroupLayout(imagenMarmol);
        imagenMarmol.setLayout(imagenMarmolLayout);
        imagenMarmolLayout.setHorizontalGroup(
                imagenMarmolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );
        imagenMarmolLayout.setVerticalGroup(
                imagenMarmolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

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

        lblCristal.setText("0");

        lblAzufre.setText("0");

        lblMarmol.setText("0");

        lblMadera.setText("0");

        panelimagenedificio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelimagenedificio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/fondoblanco.png"))); // NOI18N

        lblNivel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblNivel.setText("01");

        lblNivelMaximo.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblNivelMaximo.setText("Nivel Máximo");

        javax.swing.GroupLayout panelimagenedificioLayout = new javax.swing.GroupLayout(panelimagenedificio);
        panelimagenedificio.setLayout(panelimagenedificioLayout);
        panelimagenedificioLayout.setHorizontalGroup(
                panelimagenedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelimagenedificioLayout.createSequentialGroup()
                                .addGroup(panelimagenedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelimagenedificioLayout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(lblNivel))
                                        .addGroup(panelimagenedificioLayout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(lblNivelMaximo)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelimagenedificioLayout.setVerticalGroup(
                panelimagenedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelimagenedificioLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lblNivelMaximo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNivel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
                panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelimagenedificio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelImage2Layout.createSequentialGroup()
                                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelImage2Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblMadera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(imagenMadera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(imagenMarmol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblMarmol, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(panelImage5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(10, 10, 10)
                                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(panelImage2Layout.createSequentialGroup()
                                                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblAzufre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(imagenAzufre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblCristal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(imagenCristal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(panelImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        panelImage2Layout.setVerticalGroup(
                panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelimagenedificio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelImage5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(panelImage2Layout.createSequentialGroup()
                                                        .addComponent(imagenCristal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblCristal))
                                                .addGroup(panelImage2Layout.createSequentialGroup()
                                                        .addComponent(imagenAzufre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblAzufre))
                                                .addGroup(panelImage2Layout.createSequentialGroup()
                                                        .addComponent(imagenMarmol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(20, 20, 20)))
                                        .addGroup(panelImage2Layout.createSequentialGroup()
                                                .addComponent(imagenMadera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblMadera)
                                                        .addComponent(lblMarmol))))
                                .addContainerGap())
        );

        panelImage3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N

        edificioAcademia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        edificioAcademia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-1.png"))); // NOI18N

        lblServirvinoporhora.setText("Servir nn litros de vino por hora");

        cmdAsignarVino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/boton asignar vino.png"))); // NOI18N
        cmdAsignarVino.setAlignmentY(0.0F);
        cmdAsignarVino.setBorder(null);
        cmdAsignarVino.setContentAreaFilled(false);
        cmdAsignarVino.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cmdAsignarVino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAsignarVinoActionPerformed(evt);
            }
        });

        barraVino.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraVinoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout edificioAcademiaLayout = new javax.swing.GroupLayout(edificioAcademia);
        edificioAcademia.setLayout(edificioAcademiaLayout);
        edificioAcademiaLayout.setHorizontalGroup(
                edificioAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edificioAcademiaLayout.createSequentialGroup()
                                .addContainerGap(107, Short.MAX_VALUE)
                                .addGroup(edificioAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edificioAcademiaLayout.createSequentialGroup()
                                                .addComponent(barraVino, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(198, 198, 198))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edificioAcademiaLayout.createSequentialGroup()
                                                .addComponent(cmdAsignarVino)
                                                .addGap(297, 297, 297))))
                        .addGroup(edificioAcademiaLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(lblServirvinoporhora, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        edificioAcademiaLayout.setVerticalGroup(
                edificioAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(edificioAcademiaLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lblServirvinoporhora)
                                .addGap(38, 38, 38)
                                .addComponent(barraVino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(cmdAsignarVino)
                                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
                panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(edificioAcademia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelImage3Layout.setVerticalGroup(
                panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(edificioAcademia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelVentanaedificioLayout = new javax.swing.GroupLayout(panelVentanaedificio);
        panelVentanaedificio.setLayout(panelVentanaedificioLayout);
        panelVentanaedificioLayout.setHorizontalGroup(
                panelVentanaedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelVentanaedificioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelVentanaedificioLayout.setVerticalGroup(
                panelVentanaedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelVentanaedificioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelVentanaedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelVentanaedificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelVentanaedificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDestruiredificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDestruiredificioActionPerformed
        try {
            this.vertaberna.destruiredificio();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdDestruiredificioActionPerformed

    private void cmdElevarniveledificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdElevarniveledificioActionPerformed
        try {
            this.vertaberna.elevarniveledificio();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdElevarniveledificioActionPerformed

    private void cmdAsignarVinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAsignarVinoActionPerformed
        try {
            AsignarVino asignarvino = new AsignarVino(this, this.barraVino.getValue(), this.vertaberna.getVciudad().getCiudad());
            asignarvino.CUasignarvino();
        } catch (SQLException ex) {
            Logger.getLogger(VVerTaberna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JButton getCmdElevarniveledificio() {
        return cmdElevarniveledificio;
    }

    public PanelImage getImagenAzufre() {
        return imagenAzufre;
    }

    public PanelImage getImagenCristal() {
        return imagenCristal;
    }

    public PanelImage getImagenMadera() {
        return imagenMadera;
    }

    public PanelImage getImagenMarmol() {
        return imagenMarmol;
    }

    public JLabel getLblAzufre() {
        return lblAzufre;
    }

    public JLabel getLblCristal() {
        return lblCristal;
    }

    public JLabel getLblMadera() {
        return lblMadera;
    }

    public JLabel getLblMarmol() {
        return lblMarmol;
    }//GEN-LAST:event_cmdAsignarVinoActionPerformed

    private void barraVinoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraVinoStateChanged
        this.lblServirvinoporhora.setText("Servir " + this.barraVino.getValue() + " litros de vino por hora.");
        this.repaint();
    }//GEN-LAST:event_barraVinoStateChanged

    public JLabel getLblNivel() {
        return lblNivel;
    }

    public JLabel getLblNivelMaximo() {
        return lblNivelMaximo;
    }
    // End of variables declaration//GEN-END:variables
}
