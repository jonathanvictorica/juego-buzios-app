/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.mundo;

import com.jmg.buzios.controller.isla.MostrarIsla;
import com.jmg.buzios.controller.isla.MostrarMundo;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.isla.Isla;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
public class VMundo1 extends javax.swing.JFrame {

    public Integer numeroMundo = 1;
    private Ciudad ciudadjugador;
    private List<Isla> islas = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdIsla1;
    private javax.swing.JButton cmdIsla2;
    private javax.swing.JButton cmdIsla3;
    private javax.swing.JButton cmdIsla4;
    private javax.swing.JButton cmdIsla5;
    private javax.swing.JButton cmdIsla6;
    private javax.swing.JButton cmdIsla7;
    private javax.swing.JButton cmdIsla8;
    private javax.swing.JButton cmdIsla9;
    private org.edisoncor.gui.panel.PanelImage imagenmundo1;
    private javax.swing.JButton jButton1;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    private org.edisoncor.gui.label.LabelHeader labelHeader2;
    private org.edisoncor.gui.label.LabelHeader labelHeader3;
    private org.edisoncor.gui.label.LabelHeader labelHeader4;
    private org.edisoncor.gui.label.LabelHeader labelHeader5;
    private org.edisoncor.gui.label.LabelHeader labelHeader6;
    private org.edisoncor.gui.label.LabelHeader labelHeader7;
    private org.edisoncor.gui.label.LabelHeader labelHeader8;
    private org.edisoncor.gui.label.LabelHeader labelHeader9;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    public VMundo1(Ciudad ciudadjugador, List<Isla> islas) {

        this.ciudadjugador = ciudadjugador;

        this.islas = islas;

        initComponents();
        this.setLocationRelativeTo(null);


        this.labelHeader1.setText(islas.get(0).getNombre() + " - " + islas.get(0).getCoordenadax() + ":" + islas.get(0).getCoordenaday());
        this.labelHeader2.setText(islas.get(1).getNombre() + " - " + islas.get(1).getCoordenadax() + ":" + islas.get(1).getCoordenaday());
        this.labelHeader3.setText(islas.get(2).getNombre() + " - " + islas.get(2).getCoordenadax() + ":" + islas.get(2).getCoordenaday());
        this.labelHeader4.setText(islas.get(3).getNombre() + " - " + islas.get(3).getCoordenadax() + ":" + islas.get(3).getCoordenaday());
        this.labelHeader5.setText(islas.get(4).getNombre() + " - " + islas.get(4).getCoordenadax() + ":" + islas.get(4).getCoordenaday());
        this.labelHeader6.setText(islas.get(5).getNombre() + " - " + islas.get(5).getCoordenadax() + ":" + islas.get(5).getCoordenaday());
        this.labelHeader7.setText(islas.get(6).getNombre() + " - " + islas.get(6).getCoordenadax() + ":" + islas.get(6).getCoordenaday());
        this.labelHeader8.setText(islas.get(7).getNombre() + " - " + islas.get(7).getCoordenadax() + ":" + islas.get(7).getCoordenaday());
        this.labelHeader9.setText(islas.get(8).getNombre() + " - " + islas.get(8).getCoordenadax() + ":" + islas.get(8).getCoordenaday());


        this.show();
    }

    private void VerIsla(Integer coordenadax, Integer coordenaday) {
        for (int i = 0; i < this.islas.size(); i++) {
            if ((this.islas.get(i).getCoordenadax() == coordenadax) && (this.islas.get(i).getCoordenaday() == coordenaday)) {
                MostrarIsla mostrarisla = new MostrarIsla(this.islas.get(i), this.ciudadjugador);
                mostrarisla.CUmostrarisla();
                this.hide();
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenmundo1 = new org.edisoncor.gui.panel.PanelImage();
        cmdIsla1 = new javax.swing.JButton();
        cmdIsla2 = new javax.swing.JButton();
        cmdIsla3 = new javax.swing.JButton();
        cmdIsla4 = new javax.swing.JButton();
        cmdIsla5 = new javax.swing.JButton();
        cmdIsla6 = new javax.swing.JButton();
        cmdIsla7 = new javax.swing.JButton();
        cmdIsla8 = new javax.swing.JButton();
        cmdIsla9 = new javax.swing.JButton();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        labelHeader2 = new org.edisoncor.gui.label.LabelHeader();
        labelHeader3 = new org.edisoncor.gui.label.LabelHeader();
        labelHeader4 = new org.edisoncor.gui.label.LabelHeader();
        labelHeader5 = new org.edisoncor.gui.label.LabelHeader();
        labelHeader6 = new org.edisoncor.gui.label.LabelHeader();
        labelHeader7 = new org.edisoncor.gui.label.LabelHeader();
        labelHeader8 = new org.edisoncor.gui.label.LabelHeader();
        labelHeader9 = new org.edisoncor.gui.label.LabelHeader();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenmundo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/fondomundo.png"))); // NOI18N
        imagenmundo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdIsla1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/academia-ikariam.0.5.0.islas.11.gif"))); // NOI18N
        cmdIsla1.setBorderPainted(false);
        cmdIsla1.setContentAreaFilled(false);
        cmdIsla1.setFocusPainted(false);
        cmdIsla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIsla1ActionPerformed(evt);
            }
        });
        imagenmundo1.add(cmdIsla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 189));

        cmdIsla2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/academia-ikariam.0.5.0.islas.11.gif"))); // NOI18N
        cmdIsla2.setBorderPainted(false);
        cmdIsla2.setContentAreaFilled(false);
        cmdIsla2.setFocusPainted(false);
        cmdIsla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIsla2ActionPerformed(evt);
            }
        });
        imagenmundo1.add(cmdIsla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 0, -1, 189));

        cmdIsla3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/academia-ikariam.0.5.0.islas.11.gif"))); // NOI18N
        cmdIsla3.setBorderPainted(false);
        cmdIsla3.setContentAreaFilled(false);
        cmdIsla3.setFocusPainted(false);
        cmdIsla3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIsla3ActionPerformed(evt);
            }
        });
        imagenmundo1.add(cmdIsla3, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 0, -1, 189));

        cmdIsla4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/academia-ikariam.0.5.0.islas.11.gif"))); // NOI18N
        cmdIsla4.setBorderPainted(false);
        cmdIsla4.setContentAreaFilled(false);
        cmdIsla4.setFocusPainted(false);
        cmdIsla4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIsla4ActionPerformed(evt);
            }
        });
        imagenmundo1.add(cmdIsla4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 195, -1, 189));

        cmdIsla5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/academia-ikariam.0.5.0.islas.11.gif"))); // NOI18N
        cmdIsla5.setBorderPainted(false);
        cmdIsla5.setContentAreaFilled(false);
        cmdIsla5.setFocusPainted(false);
        cmdIsla5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIsla5ActionPerformed(evt);
            }
        });
        imagenmundo1.add(cmdIsla5, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 195, -1, 189));

        cmdIsla6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/academia-ikariam.0.5.0.islas.11.gif"))); // NOI18N
        cmdIsla6.setBorderPainted(false);
        cmdIsla6.setContentAreaFilled(false);
        cmdIsla6.setFocusPainted(false);
        cmdIsla6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIsla6ActionPerformed(evt);
            }
        });
        imagenmundo1.add(cmdIsla6, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 195, -1, 189));

        cmdIsla7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/academia-ikariam.0.5.0.islas.11.gif"))); // NOI18N
        cmdIsla7.setBorderPainted(false);
        cmdIsla7.setContentAreaFilled(false);
        cmdIsla7.setFocusPainted(false);
        cmdIsla7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIsla7ActionPerformed(evt);
            }
        });
        imagenmundo1.add(cmdIsla7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, 189));

        cmdIsla8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/academia-ikariam.0.5.0.islas.11.gif"))); // NOI18N
        cmdIsla8.setBorderPainted(false);
        cmdIsla8.setContentAreaFilled(false);
        cmdIsla8.setFocusPainted(false);
        cmdIsla8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIsla8ActionPerformed(evt);
            }
        });
        imagenmundo1.add(cmdIsla8, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 390, -1, 189));

        cmdIsla9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/academia-ikariam.0.5.0.islas.11.gif"))); // NOI18N
        cmdIsla9.setBorderPainted(false);
        cmdIsla9.setContentAreaFilled(false);
        cmdIsla9.setFocusPainted(false);
        cmdIsla9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIsla9ActionPerformed(evt);
            }
        });
        imagenmundo1.add(cmdIsla9, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 390, -1, 189));

        labelHeader1.setText("labelHeader1");
        imagenmundo1.add(labelHeader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        labelHeader2.setText("labelHeader2");
        imagenmundo1.add(labelHeader2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        labelHeader3.setText("labelHeader3");
        imagenmundo1.add(labelHeader3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, -1, -1));

        labelHeader4.setText("labelHeader4");
        imagenmundo1.add(labelHeader4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        labelHeader5.setText("labelHeader5");
        imagenmundo1.add(labelHeader5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, -1, -1));

        labelHeader6.setText("labelHeader6");
        imagenmundo1.add(labelHeader6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, -1, -1));

        labelHeader7.setText("labelHeader7");
        imagenmundo1.add(labelHeader7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, -1, -1));

        labelHeader8.setText("labelHeader8");
        imagenmundo1.add(labelHeader8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, -1, -1));

        labelHeader9.setText("labelHeader9");
        imagenmundo1.add(labelHeader9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 550, -1, -1));

        getContentPane().add(imagenmundo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addContainerGap())
        );
        panelImage1Layout.setVerticalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jButton1)
                                .addContainerGap(424, Short.MAX_VALUE))
        );

        getContentPane().add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, -1, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdIsla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIsla1ActionPerformed
        this.VerIsla(islas.get(0).getCoordenadax(), islas.get(0).getCoordenaday());
    }//GEN-LAST:event_cmdIsla1ActionPerformed

    private void cmdIsla2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIsla2ActionPerformed
        this.VerIsla(islas.get(1).getCoordenadax(), islas.get(1).getCoordenaday());
    }//GEN-LAST:event_cmdIsla2ActionPerformed

    private void cmdIsla3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIsla3ActionPerformed
        this.VerIsla(islas.get(2).getCoordenadax(), islas.get(2).getCoordenaday());
    }//GEN-LAST:event_cmdIsla3ActionPerformed

    private void cmdIsla4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIsla4ActionPerformed
        this.VerIsla(islas.get(3).getCoordenadax(), islas.get(3).getCoordenaday());
    }//GEN-LAST:event_cmdIsla4ActionPerformed

    private void cmdIsla5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIsla5ActionPerformed
        this.VerIsla(islas.get(4).getCoordenadax(), islas.get(4).getCoordenaday());
    }//GEN-LAST:event_cmdIsla5ActionPerformed

    private void cmdIsla6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIsla6ActionPerformed
        this.VerIsla(islas.get(5).getCoordenadax(), islas.get(5).getCoordenaday());
    }//GEN-LAST:event_cmdIsla6ActionPerformed

    private void cmdIsla7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIsla7ActionPerformed
        this.VerIsla(islas.get(6).getCoordenadax(), islas.get(6).getCoordenaday());
    }//GEN-LAST:event_cmdIsla7ActionPerformed

    private void cmdIsla8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIsla8ActionPerformed
        this.VerIsla(islas.get(7).getCoordenadax(), islas.get(7).getCoordenaday());
    }//GEN-LAST:event_cmdIsla8ActionPerformed

    private void cmdIsla9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIsla9ActionPerformed
        this.VerIsla(islas.get(8).getCoordenadax(), islas.get(8).getCoordenaday());
    }//GEN-LAST:event_cmdIsla9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.numeroMundo == 4) {
            MostrarMundo mostrarMundo = new MostrarMundo(this.ciudadjugador);
            mostrarMundo.parteMundo = 1;
            mostrarMundo.CUMostrarmundo();
            this.hide();
        } else {
            MostrarMundo mostrarMundo = new MostrarMundo(this.ciudadjugador);
            mostrarMundo.parteMundo = this.numeroMundo + 1;
            mostrarMundo.CUMostrarmundo();
            this.hide();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // End of variables declaration//GEN-END:variables
}
