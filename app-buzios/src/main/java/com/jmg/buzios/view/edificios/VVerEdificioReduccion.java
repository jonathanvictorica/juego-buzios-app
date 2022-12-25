/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.edificios;

import com.jmg.buzios.controller.edificio.VerEdificioReduccion;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class VVerEdificioReduccion extends javax.swing.JFrame {

    private VerEdificioReduccion veredificioreduccion;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label PorcentajeReduccion;
    private javax.swing.JButton cmdDestruiredificio;
    private javax.swing.JButton cmdElevarniveledificio;
    private org.edisoncor.gui.panel.PanelImage edificioAcademia;
    private org.edisoncor.gui.panel.PanelImage imagenAzufre;
    private org.edisoncor.gui.panel.PanelImage imagenCristal;
    private org.edisoncor.gui.panel.PanelImage imagenMadera;
    private org.edisoncor.gui.panel.PanelImage imagenMarmol;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel lblAzufre;
    private javax.swing.JLabel lblCristal;
    private javax.swing.JLabel lblMadera;
    private javax.swing.JLabel lblMarmol;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNivelMaximo;
    private java.awt.Label lblRecursoReducir;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private org.edisoncor.gui.panel.PanelImage panelImage4;
    private org.edisoncor.gui.panel.PanelImage panelImage5;
    private org.edisoncor.gui.panel.PanelImage panelVentanaedificio;
    private org.edisoncor.gui.panel.PanelImage panelimagenedificio;
    public VVerEdificioReduccion(VerEdificioReduccion veredificioreduccion) {
        this.veredificioreduccion = veredificioreduccion;
        initComponents();
        this.setLocationRelativeTo(null);
        this.show();
    }

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
        lblNivelMaximo = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        edificioAcademia = new org.edisoncor.gui.panel.PanelImage();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        lblRecursoReducir = new java.awt.Label();
        PorcentajeReduccion = new java.awt.Label();

        setResizable(false);

        panelVentanaedificio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N
        panelVentanaedificio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-1.png"))); // NOI18N

        panelImage4.setOpaque(false);

        cmdDestruiredificio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/boton destruir edificio.png"))); // NOI18N
        cmdDestruiredificio.setAlignmentY(0.0F);
        cmdDestruiredificio.setBorder(null);
        cmdDestruiredificio.setContentAreaFilled(false);
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

        lblNivelMaximo.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblNivelMaximo.setText("Nivel Máximo");

        lblNivel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblNivel.setText("01");

        javax.swing.GroupLayout panelimagenedificioLayout = new javax.swing.GroupLayout(panelimagenedificio);
        panelimagenedificio.setLayout(panelimagenedificioLayout);
        panelimagenedificioLayout.setHorizontalGroup(
                panelimagenedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelimagenedificioLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(panelimagenedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelimagenedificioLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblNivel))
                                        .addComponent(lblNivelMaximo))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelimagenedificioLayout.setVerticalGroup(
                panelimagenedificioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelimagenedificioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNivelMaximo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNivel)
                                .addContainerGap(34, Short.MAX_VALUE))
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

        panelVentanaedificio.add(panelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        panelImage3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N

        edificioAcademia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        edificioAcademia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-1.png"))); // NOI18N

        label1.setText("Recurso");

        label2.setText("Porcentaje de Reducción");

        lblRecursoReducir.setText("0");

        PorcentajeReduccion.setText("0");

        javax.swing.GroupLayout edificioAcademiaLayout = new javax.swing.GroupLayout(edificioAcademia);
        edificioAcademia.setLayout(edificioAcademiaLayout);
        edificioAcademiaLayout.setHorizontalGroup(
                edificioAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(edificioAcademiaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(edificioAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(edificioAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblRecursoReducir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PorcentajeReduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
        );
        edificioAcademiaLayout.setVerticalGroup(
                edificioAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(edificioAcademiaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(edificioAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRecursoReducir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(edificioAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PorcentajeReduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(66, Short.MAX_VALUE))
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
                                .addContainerGap(146, Short.MAX_VALUE))
        );

        panelVentanaedificio.add(panelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 11, -1, 287));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelVentanaedificio, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelVentanaedificio, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDestruiredificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDestruiredificioActionPerformed
        try {
            this.veredificioreduccion.destruiredificio();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdDestruiredificioActionPerformed

    private void cmdElevarniveledificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdElevarniveledificioActionPerformed
        try {
            this.veredificioreduccion.elevarniveledificio();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdElevarniveledificioActionPerformed

    public Label getPorcentajeReduccion() {
        return PorcentajeReduccion;
    }

    public Label getLblRecursoReducir() {
        return lblRecursoReducir;
    }

    public JLabel getLblMarmol() {
        return lblMarmol;
    }

    public JLabel getLblNivel() {
        return lblNivel;
    }

    public JLabel getLblNivelMaximo() {
        return lblNivelMaximo;
    }

    public JButton getCmdDestruiredificio() {
        return cmdDestruiredificio;
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
    // End of variables declaration//GEN-END:variables
}
