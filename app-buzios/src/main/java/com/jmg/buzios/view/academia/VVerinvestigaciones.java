/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.academia;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.controller.investigacion.InvestigarTema;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.investigacion.Investigacion;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class VVerinvestigaciones extends javax.swing.JFrame implements Actualizar {

    private Investigacion investigacioneconomia;
    private Investigacion investigacionnavegacion;
    private Investigacion investigacionmilitar;
    private Investigacion investigacionciencia;
    private Ciudad ciudadjugador;


    private Investigacion investigacionelegida;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdInvestigacionEconomia;
    private javax.swing.JButton cmdInvestigacionMilitar;
    private javax.swing.JButton cmdInvestigar;
    private org.edisoncor.gui.panel.PanelImage imagenBombita;
    private org.edisoncor.gui.panel.PanelImage imagenBombita4;
    private org.edisoncor.gui.panel.PanelImage imageninvestigacion;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPuntosNecesariosEconomia;
    private javax.swing.JLabel lblPuntosNecesariosMilitar;
    private javax.swing.JLabel lblTituloInvestigacion;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private org.edisoncor.gui.panel.PanelImage panelImage4;
    private javax.swing.JTextPane txtDescripcion;
    public VVerinvestigaciones(Investigacion investigacioneconomia, Investigacion investigacionnavegacion, Investigacion investigacionmilitar, Investigacion investigacionciencia, Ciudad ciudadjugador) {
        initComponents();
        this.imageninvestigacion.setVisible(false);
        this.investigacioneconomia = investigacioneconomia;
        this.investigacionnavegacion = investigacionnavegacion;
        this.investigacionmilitar = investigacionmilitar;
        this.investigacionciencia = investigacionciencia;


        this.ciudadjugador = ciudadjugador;
        this.actualizarinterfazgrafica();
        this.actualizardatospantalla();
        this.show();
        this.repaint();
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actualizardatospantalla() {


        this.cmdInvestigacionEconomia.setText(this.investigacioneconomia.getTitulo());
        this.lblPuntosNecesariosEconomia.setText("" + this.investigacioneconomia.getPuntosinvestigacion());

        this.cmdInvestigacionMilitar.setText(this.investigacionmilitar.getTitulo());
        this.lblPuntosNecesariosMilitar.setText("" + this.investigacionmilitar.getPuntosinvestigacion());


    }

    @Override
    public void actualizarinterfazgrafica() {
        this.lblTituloInvestigacion.setVisible(false);
        this.txtDescripcion.setVisible(false);
        this.cmdInvestigar.setVisible(false);

    }

    private void inicializar_investigacion(String tema) {
        this.imageninvestigacion.setVisible(true);
        this.lblTituloInvestigacion.setVisible(true);
        this.txtDescripcion.setVisible(true);
        this.cmdInvestigar.setVisible(true);
        switch (tema) {

            case "Ciencia":
                this.lblTituloInvestigacion.setText(this.investigacionciencia.getTitulo());
                this.txtDescripcion.setText("Descripcion " + this.investigacionciencia.getDescripcion() + " Permite: " + this.investigacionciencia.getPermite());
                this.investigacionelegida = this.investigacionciencia;
                break;
            case "Navegacion":
                this.lblTituloInvestigacion.setText(this.investigacionnavegacion.getTitulo());
                this.txtDescripcion.setText("Descripcion " + this.investigacionnavegacion.getDescripcion() + " Permite: " + this.investigacionnavegacion.getPermite());
                this.investigacionelegida = this.investigacionnavegacion;
                break;
            case "Militar":
                this.lblTituloInvestigacion.setText(this.investigacionmilitar.getTitulo());
                this.txtDescripcion.setText("Descripcion " + this.investigacionmilitar.getDescripcion() + " Permite: " + this.investigacionmilitar.getPermite());
                this.investigacionelegida = this.investigacionmilitar;
                break;
            case "Economia":
                this.lblTituloInvestigacion.setText(this.investigacioneconomia.getTitulo());
                this.txtDescripcion.setText("Descripcion " + this.investigacioneconomia.getDescripcion() + " Permite: " + this.investigacioneconomia.getPermite());
                this.investigacionelegida = this.investigacioneconomia;
                break;
        }
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        panelImage4 = new org.edisoncor.gui.panel.PanelImage();
        cmdInvestigacionEconomia = new javax.swing.JButton();
        lblPuntosNecesariosEconomia = new javax.swing.JLabel();
        imagenBombita = new org.edisoncor.gui.panel.PanelImage();
        cmdInvestigacionMilitar = new javax.swing.JButton();
        lblPuntosNecesariosMilitar = new javax.swing.JLabel();
        imagenBombita4 = new org.edisoncor.gui.panel.PanelImage();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        imageninvestigacion = new org.edisoncor.gui.panel.PanelImage();
        lblTituloInvestigacion = new javax.swing.JLabel();
        cmdInvestigar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2-330-260.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N

        cmdInvestigacionEconomia.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cmdInvestigacionEconomia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdInvestigacionEconomiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenBombitaLayout = new javax.swing.GroupLayout(imagenBombita);
        imagenBombita.setLayout(imagenBombitaLayout);
        imagenBombitaLayout.setHorizontalGroup(
                imagenBombitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 37, Short.MAX_VALUE)
        );
        imagenBombitaLayout.setVerticalGroup(
                imagenBombitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelImage4Layout = new javax.swing.GroupLayout(panelImage4);
        panelImage4.setLayout(panelImage4Layout);
        panelImage4Layout.setHorizontalGroup(
                panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmdInvestigacionEconomia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage4Layout.createSequentialGroup()
                                .addComponent(imagenBombita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPuntosNecesariosEconomia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelImage4Layout.setVerticalGroup(
                panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage4Layout.createSequentialGroup()
                                .addComponent(cmdInvestigacionEconomia, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblPuntosNecesariosEconomia, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(imagenBombita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        cmdInvestigacionMilitar.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cmdInvestigacionMilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdInvestigacionMilitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenBombita4Layout = new javax.swing.GroupLayout(imagenBombita4);
        imagenBombita4.setLayout(imagenBombita4Layout);
        imagenBombita4Layout.setHorizontalGroup(
                imagenBombita4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 31, Short.MAX_VALUE)
        );
        imagenBombita4Layout.setVerticalGroup(
                imagenBombita4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
                panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmdInvestigacionMilitar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelImage2Layout.createSequentialGroup()
                                                .addComponent(imagenBombita4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblPuntosNecesariosMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        panelImage2Layout.setVerticalGroup(
                panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdInvestigacionMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(imagenBombita4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPuntosNecesariosMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(81, Short.MAX_VALUE))
        );

        panelImage1.add(panelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 333));

        panelImage3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N

        imageninvestigacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imageninvestigacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-1.png"))); // NOI18N

        lblTituloInvestigacion.setText(" ");

        cmdInvestigar.setText("Investigar Tema");
        cmdInvestigar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdInvestigarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtDescripcion);

        javax.swing.GroupLayout imageninvestigacionLayout = new javax.swing.GroupLayout(imageninvestigacion);
        imageninvestigacion.setLayout(imageninvestigacionLayout);
        imageninvestigacionLayout.setHorizontalGroup(
                imageninvestigacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(imageninvestigacionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(imageninvestigacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTituloInvestigacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(imageninvestigacionLayout.createSequentialGroup()
                                                .addGroup(imageninvestigacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(imageninvestigacionLayout.createSequentialGroup()
                                                                .addGap(120, 120, 120)
                                                                .addComponent(cmdInvestigar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 10, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        imageninvestigacionLayout.setVerticalGroup(
                imageninvestigacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(imageninvestigacionLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(lblTituloInvestigacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdInvestigar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
                panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imageninvestigacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelImage3Layout.setVerticalGroup(
                panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imageninvestigacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelImage1.add(panelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 11, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdInvestigacionEconomiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdInvestigacionEconomiaActionPerformed
        this.inicializar_investigacion("Economia");
    }//GEN-LAST:event_cmdInvestigacionEconomiaActionPerformed

    private void cmdInvestigacionMilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdInvestigacionMilitarActionPerformed
        this.inicializar_investigacion("Militar");
    }//GEN-LAST:event_cmdInvestigacionMilitarActionPerformed

    private void cmdInvestigarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdInvestigarActionPerformed
        try {
            InvestigarTema investigar = new InvestigarTema(this.ciudadjugador, this.investigacionelegida, this);
            investigar.CUinvestigartema();
            this.hide();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdInvestigarActionPerformed

    public JButton getCmdInvestigacionEconomia() {
        return cmdInvestigacionEconomia;
    }

    public JButton getCmdInvestigacionMilitar() {
        return cmdInvestigacionMilitar;
    }
    // End of variables declaration//GEN-END:variables


}
