/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.edificios;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.controller.edificio.ConstruirEdificio;
import com.jmg.buzios.model.edificio.EdificioNivel;
import com.jmg.buzios.view.ciudad.VCiudad;
import com.jmg.buzios.view.ciudad.VVerEdificiosaConstruir;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.sql.SQLException;


/**
 * @author Alumno
 */
public class VEdificio extends javax.swing.JFrame {

    private VCiudad vciudad;
    private int lugarciudad;
    private EdificioNivel edificiosaconstruir;
    private VVerEdificiosaConstruir vedificiosaconstruir;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdConstruirEdificio;
    private org.edisoncor.gui.panel.PanelImage imagenAzufre;
    private org.edisoncor.gui.panel.PanelImage imagenCristal;
    private org.edisoncor.gui.panel.PanelImage imagenMadera;
    private org.edisoncor.gui.panel.PanelImage imagenMarmol;
    private org.edisoncor.gui.panel.PanelImage imagenedificio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAzufre;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblCristal;
    private javax.swing.JLabel lblMadera;
    private javax.swing.JLabel lblMarmol;
    private javax.swing.JLabel lblNombreedificio;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextPane txtdescripciones;

    public VEdificio(VCiudad vciudad, EdificioNivel edificiosaconstruir, int lugarciudad, VVerEdificiosaConstruir vedificiosaconstruir) {
        this.vciudad = vciudad;
        this.edificiosaconstruir = edificiosaconstruir;
        this.lugarciudad = lugarciudad;
        this.vedificiosaconstruir = vedificiosaconstruir;
        initComponents();
        this.setLocationRelativeTo(null);
        this.show();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        imagenedificio = new org.edisoncor.gui.panel.PanelImage();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombreedificio = new javax.swing.JLabel();
        imagenCristal = new org.edisoncor.gui.panel.PanelImage();
        lblCristal = new javax.swing.JLabel();
        imagenAzufre = new org.edisoncor.gui.panel.PanelImage();
        lblAzufre = new javax.swing.JLabel();
        imagenMarmol = new org.edisoncor.gui.panel.PanelImage();
        lblMarmol = new javax.swing.JLabel();
        imagenMadera = new org.edisoncor.gui.panel.PanelImage();
        lblMadera = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        cmdConstruirEdificio = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtdescripciones = new javax.swing.JTextPane();

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenedificio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenedificioLayout = new javax.swing.GroupLayout(imagenedificio);
        imagenedificio.setLayout(imagenedificioLayout);
        imagenedificioLayout.setHorizontalGroup(
                imagenedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 116, Short.MAX_VALUE)
        );
        imagenedificioLayout.setVerticalGroup(
                imagenedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 124, Short.MAX_VALUE)
        );

        getContentPane().add(imagenedificio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, -1, -1));

        jLabel2.setText("Edificio");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 12, 50, -1));

        jLabel3.setText("Costo ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 37, -1, -1));

        lblNombreedificio.setText("0");
        getContentPane().add(lblNombreedificio, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 12, 170, -1));

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

        getContentPane().add(imagenCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 72, -1, -1));

        lblCristal.setText("0");
        getContentPane().add(lblCristal, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 127, 53, -1));

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

        getContentPane().add(imagenAzufre, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 72, -1, -1));

        lblAzufre.setText("0");
        getContentPane().add(lblAzufre, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 127, 53, -1));

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

        getContentPane().add(imagenMarmol, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 72, -1, -1));

        lblMarmol.setText("0");
        getContentPane().add(lblMarmol, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 127, 53, -1));

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

        getContentPane().add(imagenMadera, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 72, -1, -1));

        lblMadera.setText("0");
        getContentPane().add(lblMadera, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 127, 53, -1));

        jLabel9.setText("Descripción");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 152, -1, -1));

        lblCosto.setText("0");
        getContentPane().add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 37, 170, -1));

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdConstruirEdificio.setText("Construir Edificio");
        cmdConstruirEdificio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdConstruirEdificioActionPerformed(evt);
            }
        });
        panelImage1.add(cmdConstruirEdificio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, -1, -1));

        txtdescripciones.setEditable(false);
        jScrollPane3.setViewportView(txtdescripciones);

        panelImage1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 370, 120));

        getContentPane().add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 390, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdConstruirEdificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdConstruirEdificioActionPerformed
        ConstruirEdificio construiredificio = new ConstruirEdificio(this.vciudad, this.vciudad.getCiudad(), this.edificiosaconstruir, this.lugarciudad);
        try {
            construiredificio.CUconstruiredificio();
            this.vedificiosaconstruir.hide();
            this.hide();
        } catch (SQLException ex) {
            ConexionDB.mostrarmensajebasededatos();
        }
    }//GEN-LAST:event_cmdConstruirEdificioActionPerformed

    public VCiudad getVciudad() {
        return vciudad;
    }

    public int getLugarciudad() {
        return lugarciudad;
    }

    public EdificioNivel getEdificiosaconstruir() {
        return edificiosaconstruir;
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

    public PanelImage getImagenedificio() {
        return imagenedificio;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JLabel getLblAzufre() {
        return lblAzufre;
    }

    public JLabel getLblCosto() {
        return lblCosto;
    }

    public JLabel getLblCristal() {
        return lblCristal;
    }

    public JLabel getLblMadera() {
        return lblMadera;
    }

    public JLabel getLblMarmol() {
        return lblMarmol;
    }

    public JLabel getLblNombreedificio() {
        return lblNombreedificio;
    }

    public JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    public JTextPane getTxtdescripciones() {
        return txtdescripciones;
    }
    // End of variables declaration//GEN-END:variables
}
