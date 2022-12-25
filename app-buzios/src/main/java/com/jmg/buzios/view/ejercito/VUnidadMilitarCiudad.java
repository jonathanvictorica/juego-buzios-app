/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.ejercito;

import com.jmg.buzios.controller.ejercito.VerArmaAsignada;
import com.jmg.buzios.controller.ejercito.VerDestruirUnidad;
import com.jmg.buzios.controller.ejercito.VerUnidadArma;
import com.jmg.buzios.model.ciudad.CiudadEjercito;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;

import javax.swing.*;
import java.util.List;

/**
 * @author Alumno
 */
public class VUnidadMilitarCiudad extends javax.swing.JFrame {

    private VCiudad vciudad;
    private CiudadEjercito ciudadejercito;


    private UnidadMilitar unidadmilitar;

    private List<Arma> armasasignadas;
    private List<Integer> cantidad;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAsignamientodearma;
    private javax.swing.JButton cmdDestruirunidad;
    private javax.swing.JButton cmdUnidadmilitar;
    private javax.swing.JButton cmdUnidadmilitar1;
    private javax.swing.JButton cmdUnidadmilitar10;
    private javax.swing.JButton cmdUnidadmilitar11;
    private javax.swing.JButton cmdUnidadmilitar2;
    private javax.swing.JButton cmdUnidadmilitar3;
    private javax.swing.JButton cmdUnidadmilitar4;
    private javax.swing.JButton cmdUnidadmilitar5;
    private javax.swing.JButton cmdUnidadmilitar6;
    private javax.swing.JButton cmdUnidadmilitar7;
    private javax.swing.JButton cmdUnidadmilitar8;
    private javax.swing.JButton cmdUnidadmilitar9;
    private javax.swing.JButton cmdVerarmasasignadas;
    private javax.swing.JLabel lblUnidadmilitar;
    private javax.swing.JLabel lblUnidadmilitar1;
    private javax.swing.JLabel lblUnidadmilitar10;
    private javax.swing.JLabel lblUnidadmilitar11;
    private javax.swing.JLabel lblUnidadmilitar2;
    private javax.swing.JLabel lblUnidadmilitar3;
    private javax.swing.JLabel lblUnidadmilitar4;
    private javax.swing.JLabel lblUnidadmilitar5;
    private javax.swing.JLabel lblUnidadmilitar6;
    private javax.swing.JLabel lblUnidadmilitar7;
    private javax.swing.JLabel lblUnidadmilitar8;
    private javax.swing.JLabel lblUnidadmilitar9;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    public VUnidadMilitarCiudad(VCiudad vciudad, CiudadEjercito ciudadejercito) {

        this.ciudadejercito = ciudadejercito;
        this.vciudad = vciudad;
        initComponents();
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N

        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N

        cmdUnidadmilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/ariete-g.png"))); // NOI18N

        cmdUnidadmilitar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/arquero-g.png"))); // NOI18N

        cmdUnidadmilitar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/catapulta-g.png"))); // NOI18N

        cmdUnidadmilitar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/espadachin-g.png"))); // NOI18N


        cmdUnidadmilitar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/fusilero-g.png"))); // NOI18N

        cmdUnidadmilitar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/girocoptero-g.png"))); // NOI18N

        cmdUnidadmilitar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/gigante-g.png"))); // NOI18N

        cmdUnidadmilitar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/globo-g.png"))); // NOI18N

        cmdUnidadmilitar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/hoplita-g.png"))); // NOI18N


        cmdUnidadmilitar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/hondero-g.png"))); // NOI18N


        cmdUnidadmilitar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/mortero-g.png"))); // NOI18N

        cmdUnidadmilitar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/lancero-g.png"))); // NOI18N


        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N

        cmdDestruirunidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Destruir Unidad.png"))); // NOI18N

        cmdAsignamientodearma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Asignamiento de Armas.png"))); // NOI18N

        cmdVerarmasasignadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Ver Armas Asignadas.png"))); // NOI18N
        this.setLocationRelativeTo(null);
        this.show();
        //desabilitar botones


    }

    private void habilitarboton(String unidadmilitarnaval) {

        this.cmdDestruirunidad.setEnabled(true);
        this.cmdAsignamientodearma.setEnabled(true);
        for (int i = 0; i < this.ciudadejercito.getUnidad().size(); i++) {
            if (unidadmilitarnaval.equals(this.ciudadejercito.getUnidad().get(i).getNombre())) {
                this.unidadmilitar = this.ciudadejercito.getUnidad().get(i);

                if (!this.ciudadejercito.getArmasdeunidad().get(i).getArma().isEmpty()) {
                    this.cmdVerarmasasignadas.setEnabled(true);
                    this.armasasignadas = this.ciudadejercito.getArmasdeunidad().get(i).getArma();
                } else {
                    this.cmdVerarmasasignadas.setEnabled(false);

                }
                this.cantidad = this.ciudadejercito.getArmasdeunidad().get(i).getCapacidaddisponibleenciudad();

            }
        }
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        cmdUnidadmilitar = new javax.swing.JButton();
        cmdUnidadmilitar1 = new javax.swing.JButton();
        cmdUnidadmilitar2 = new javax.swing.JButton();
        cmdUnidadmilitar3 = new javax.swing.JButton();
        cmdUnidadmilitar4 = new javax.swing.JButton();
        cmdUnidadmilitar6 = new javax.swing.JButton();
        cmdUnidadmilitar5 = new javax.swing.JButton();
        cmdUnidadmilitar7 = new javax.swing.JButton();
        cmdUnidadmilitar9 = new javax.swing.JButton();
        cmdUnidadmilitar8 = new javax.swing.JButton();
        cmdUnidadmilitar11 = new javax.swing.JButton();
        cmdUnidadmilitar10 = new javax.swing.JButton();
        lblUnidadmilitar = new javax.swing.JLabel();
        lblUnidadmilitar1 = new javax.swing.JLabel();
        lblUnidadmilitar2 = new javax.swing.JLabel();
        lblUnidadmilitar3 = new javax.swing.JLabel();
        lblUnidadmilitar4 = new javax.swing.JLabel();
        lblUnidadmilitar5 = new javax.swing.JLabel();
        lblUnidadmilitar6 = new javax.swing.JLabel();
        lblUnidadmilitar7 = new javax.swing.JLabel();
        lblUnidadmilitar8 = new javax.swing.JLabel();
        lblUnidadmilitar9 = new javax.swing.JLabel();
        lblUnidadmilitar10 = new javax.swing.JLabel();
        lblUnidadmilitar11 = new javax.swing.JLabel();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        cmdDestruirunidad = new javax.swing.JButton();
        cmdAsignamientodearma = new javax.swing.JButton();
        cmdVerarmasasignadas = new javax.swing.JButton();

        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdUnidadmilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/ariete-g.png"))); // NOI18N
        cmdUnidadmilitar.setEnabled(false);
        cmdUnidadmilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitarActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 138, 136));

        cmdUnidadmilitar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/arquero-g.png"))); // NOI18N
        cmdUnidadmilitar1.setEnabled(false);
        cmdUnidadmilitar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar1ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 12, 138, 136));

        cmdUnidadmilitar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/catapulta-g.png"))); // NOI18N
        cmdUnidadmilitar2.setEnabled(false);
        cmdUnidadmilitar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar2ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 12, 138, 136));

        cmdUnidadmilitar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/espadachin-g.png"))); // NOI18N
        cmdUnidadmilitar3.setEnabled(false);
        cmdUnidadmilitar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar3ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 12, 138, 136));

        cmdUnidadmilitar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/UNIDADESMILITARES/fusilero-g.png"))); // NOI18N
        cmdUnidadmilitar4.setEnabled(false);
        cmdUnidadmilitar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar4ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 12, 138, 136));

        cmdUnidadmilitar6.setEnabled(false);
        cmdUnidadmilitar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar6ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 183, 138, 136));

        cmdUnidadmilitar5.setEnabled(false);
        cmdUnidadmilitar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar5ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 12, 138, 136));

        cmdUnidadmilitar7.setEnabled(false);
        cmdUnidadmilitar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar7ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 183, 138, 136));

        cmdUnidadmilitar9.setEnabled(false);
        cmdUnidadmilitar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar9ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 183, 138, 136));

        cmdUnidadmilitar8.setEnabled(false);
        cmdUnidadmilitar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar8ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 183, 138, 136));

        cmdUnidadmilitar11.setEnabled(false);
        cmdUnidadmilitar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar11ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 183, 138, 136));

        cmdUnidadmilitar10.setEnabled(false);
        cmdUnidadmilitar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar10ActionPerformed(evt);
            }
        });
        panelImage2.add(cmdUnidadmilitar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 183, 138, 136));

        lblUnidadmilitar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar.setText("Ariete");
        lblUnidadmilitar.setEnabled(false);
        lblUnidadmilitar.setFocusable(false);
        panelImage2.add(lblUnidadmilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 154, 138, -1));

        lblUnidadmilitar1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar1.setText("Arquero");
        lblUnidadmilitar1.setEnabled(false);
        lblUnidadmilitar1.setFocusable(false);
        panelImage2.add(lblUnidadmilitar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 154, 138, -1));

        lblUnidadmilitar2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar2.setText("Catapulta");
        lblUnidadmilitar2.setEnabled(false);
        lblUnidadmilitar2.setFocusable(false);
        panelImage2.add(lblUnidadmilitar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 154, 138, -1));

        lblUnidadmilitar3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar3.setText("Espadachin");
        lblUnidadmilitar3.setEnabled(false);
        lblUnidadmilitar3.setFocusable(false);
        panelImage2.add(lblUnidadmilitar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 154, 138, -1));

        lblUnidadmilitar4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar4.setText("Fusilero");
        lblUnidadmilitar4.setEnabled(false);
        lblUnidadmilitar4.setFocusable(false);
        panelImage2.add(lblUnidadmilitar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 154, 138, -1));

        lblUnidadmilitar5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar5.setText("Gigante a Vapor");
        lblUnidadmilitar5.setEnabled(false);
        lblUnidadmilitar5.setFocusable(false);
        panelImage2.add(lblUnidadmilitar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 154, 138, -1));

        lblUnidadmilitar6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar6.setText("Girocóptero");
        lblUnidadmilitar6.setEnabled(false);
        lblUnidadmilitar6.setFocusable(false);
        panelImage2.add(lblUnidadmilitar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 325, 138, -1));

        lblUnidadmilitar7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar7.setText("Globo Bombardero");
        lblUnidadmilitar7.setEnabled(false);
        lblUnidadmilitar7.setFocusable(false);
        panelImage2.add(lblUnidadmilitar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 325, 138, -1));

        lblUnidadmilitar8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar8.setText("Hondero");
        lblUnidadmilitar8.setEnabled(false);
        lblUnidadmilitar8.setFocusable(false);
        panelImage2.add(lblUnidadmilitar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 325, 138, -1));

        lblUnidadmilitar9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar9.setText("Hoplita");
        lblUnidadmilitar9.setEnabled(false);
        lblUnidadmilitar9.setFocusable(false);
        panelImage2.add(lblUnidadmilitar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 325, 138, -1));

        lblUnidadmilitar10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar10.setText("Lancero");
        lblUnidadmilitar10.setEnabled(false);
        lblUnidadmilitar10.setFocusable(false);
        panelImage2.add(lblUnidadmilitar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 325, 138, -1));

        lblUnidadmilitar11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar11.setText("Mortero");
        lblUnidadmilitar11.setEnabled(false);
        lblUnidadmilitar11.setFocusable(false);
        panelImage2.add(lblUnidadmilitar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 325, 138, -1));

        panelImage1.add(panelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 880, 360));

        panelImage3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdDestruirunidad.setText(" ");
        cmdDestruirunidad.setBorderPainted(false);
        cmdDestruirunidad.setContentAreaFilled(false);
        cmdDestruirunidad.setEnabled(false);
        cmdDestruirunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDestruirunidadActionPerformed(evt);
            }
        });
        panelImage3.add(cmdDestruirunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 279, -1));

        cmdAsignamientodearma.setText(" ");
        cmdAsignamientodearma.setBorderPainted(false);
        cmdAsignamientodearma.setContentAreaFilled(false);
        cmdAsignamientodearma.setEnabled(false);
        cmdAsignamientodearma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAsignamientodearmaActionPerformed(evt);
            }
        });
        panelImage3.add(cmdAsignamientodearma, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 286, -1));

        cmdVerarmasasignadas.setText(" ");
        cmdVerarmasasignadas.setBorderPainted(false);
        cmdVerarmasasignadas.setContentAreaFilled(false);
        cmdVerarmasasignadas.setEnabled(false);
        cmdVerarmasasignadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVerarmasasignadasActionPerformed(evt);
            }
        });
        panelImage3.add(cmdVerarmasasignadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 281, -1));

        panelImage1.add(panelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 880, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdVerarmasasignadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVerarmasasignadasActionPerformed
        VerArmaAsignada verarmaasignada = new VerArmaAsignada(this.vciudad, this.unidadmilitar, this.armasasignadas, this.cantidad);
        verarmaasignada.CUVerarmaasignada();
        this.cmdAsignamientodearma.setEnabled(false);
        this.cmdDestruirunidad.setEnabled(false);
        this.cmdVerarmasasignadas.setEnabled(false);
    }//GEN-LAST:event_cmdVerarmasasignadasActionPerformed

    private void cmdAsignamientodearmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAsignamientodearmaActionPerformed
        VerUnidadArma verunidadarma = new VerUnidadArma(this.ciudadejercito.getCiudad(), this.unidadmilitar, this.vciudad);
        verunidadarma.CUVerunidadarma();
        this.cmdAsignamientodearma.setEnabled(false);
        this.cmdDestruirunidad.setEnabled(false);
        this.cmdVerarmasasignadas.setEnabled(false);
    }//GEN-LAST:event_cmdAsignamientodearmaActionPerformed

    private void cmdUnidadmilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitarActionPerformed

        this.habilitarboton("Ariete");
    }//GEN-LAST:event_cmdUnidadmilitarActionPerformed

    private void cmdUnidadmilitar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar1ActionPerformed
        this.habilitarboton("Arquero");
    }//GEN-LAST:event_cmdUnidadmilitar1ActionPerformed

    private void cmdUnidadmilitar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar2ActionPerformed
        this.habilitarboton("Catapulta");
    }//GEN-LAST:event_cmdUnidadmilitar2ActionPerformed

    private void cmdUnidadmilitar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar3ActionPerformed
        this.habilitarboton("Espadachin");
    }//GEN-LAST:event_cmdUnidadmilitar3ActionPerformed

    private void cmdUnidadmilitar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar4ActionPerformed
        this.habilitarboton("Fusilero");
    }//GEN-LAST:event_cmdUnidadmilitar4ActionPerformed

    private void cmdDestruirunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDestruirunidadActionPerformed
        VerDestruirUnidad verdestruirunidad = new VerDestruirUnidad(this.unidadmilitar, this.armasasignadas, this.cantidad, this.vciudad);
        verdestruirunidad.CUVerDestruirUnidad();
        this.cmdAsignamientodearma.setEnabled(false);
        this.cmdDestruirunidad.setEnabled(false);
        this.cmdVerarmasasignadas.setEnabled(false);
    }//GEN-LAST:event_cmdDestruirunidadActionPerformed

    private void cmdUnidadmilitar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar5ActionPerformed
        this.habilitarboton("Gigante a Vapor");
    }//GEN-LAST:event_cmdUnidadmilitar5ActionPerformed

    private void cmdUnidadmilitar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar6ActionPerformed
        this.habilitarboton("Girocóptero");
    }//GEN-LAST:event_cmdUnidadmilitar6ActionPerformed

    private void cmdUnidadmilitar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar7ActionPerformed
        this.habilitarboton("Globo Bombardero");
    }//GEN-LAST:event_cmdUnidadmilitar7ActionPerformed

    private void cmdUnidadmilitar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar8ActionPerformed
        this.habilitarboton("Hondero");
    }//GEN-LAST:event_cmdUnidadmilitar8ActionPerformed

    private void cmdUnidadmilitar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar9ActionPerformed
        this.habilitarboton("Hoplita");
    }//GEN-LAST:event_cmdUnidadmilitar9ActionPerformed

    private void cmdUnidadmilitar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar10ActionPerformed
        this.habilitarboton("Lancero");
    }//GEN-LAST:event_cmdUnidadmilitar10ActionPerformed

    private void cmdUnidadmilitar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar11ActionPerformed
        this.habilitarboton("Mortero");
    }//GEN-LAST:event_cmdUnidadmilitar11ActionPerformed
    // End of variables declaration//GEN-END:variables

    public JButton getCmdUnidadmilitar() {
        return cmdUnidadmilitar;
    }

    public JButton getCmdUnidadmilitar1() {
        return cmdUnidadmilitar1;
    }

    public JButton getCmdUnidadmilitar10() {
        return cmdUnidadmilitar10;
    }

    public JButton getCmdUnidadmilitar11() {
        return cmdUnidadmilitar11;
    }

    public JButton getCmdUnidadmilitar2() {
        return cmdUnidadmilitar2;
    }

    public JButton getCmdUnidadmilitar3() {
        return cmdUnidadmilitar3;
    }

    public JButton getCmdUnidadmilitar4() {
        return cmdUnidadmilitar4;
    }

    public JButton getCmdUnidadmilitar5() {
        return cmdUnidadmilitar5;
    }

    public JButton getCmdUnidadmilitar6() {
        return cmdUnidadmilitar6;
    }

    public JButton getCmdUnidadmilitar7() {
        return cmdUnidadmilitar7;
    }

    public JButton getCmdUnidadmilitar8() {
        return cmdUnidadmilitar8;
    }

    public JButton getCmdUnidadmilitar9() {
        return cmdUnidadmilitar9;
    }

    public JLabel getLblUnidadmilitar() {
        return lblUnidadmilitar;
    }

    public JLabel getLblUnidadmilitar1() {
        return lblUnidadmilitar1;
    }

    public JLabel getLblUnidadmilitar10() {
        return lblUnidadmilitar10;
    }

    public JLabel getLblUnidadmilitar11() {
        return lblUnidadmilitar11;
    }

    public JLabel getLblUnidadmilitar2() {
        return lblUnidadmilitar2;
    }

    public JLabel getLblUnidadmilitar3() {
        return lblUnidadmilitar3;
    }

    public JLabel getLblUnidadmilitar4() {
        return lblUnidadmilitar4;
    }

    public JLabel getLblUnidadmilitar5() {
        return lblUnidadmilitar5;
    }

    public JLabel getLblUnidadmilitar6() {
        return lblUnidadmilitar6;
    }

    public JLabel getLblUnidadmilitar7() {
        return lblUnidadmilitar7;
    }

    public JLabel getLblUnidadmilitar8() {
        return lblUnidadmilitar8;
    }

    public JLabel getLblUnidadmilitar9() {
        return lblUnidadmilitar9;
    }


}
