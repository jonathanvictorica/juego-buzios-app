/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.ejercito;

import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.util.List;

/**
 * @author Alumno
 */
public class VVerBarcosGuerraaConstruir extends javax.swing.JFrame {

    private VCiudad vciudad;
    private List<UnidadMilitar> unidadmilitar;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdUnidadmilitarBallesta;
    private javax.swing.JButton cmdUnidadmilitarCatapulta;
    private javax.swing.JButton cmdUnidadmilitarEspolonavapor;
    private javax.swing.JButton cmdUnidadmilitarLanzallamas;
    private javax.swing.JButton cmdUnidadmilitarLanzamisiles;
    private javax.swing.JButton cmdUnidadmilitarMortero;
    private javax.swing.JButton cmdUnidadmilitarSubmarino;
    private javax.swing.JButton cmdUnidadmilitarespolón;
    private javax.swing.JLabel lblUnidadmilitarBallesta;
    private javax.swing.JLabel lblUnidadmilitarCatapulta;
    private javax.swing.JLabel lblUnidadmilitarEspolonavapor;
    private javax.swing.JLabel lblUnidadmilitarLanzallamas;
    private javax.swing.JLabel lblUnidadmilitarLanzamisiles;
    private javax.swing.JLabel lblUnidadmilitarMortero;
    private javax.swing.JLabel lblUnidadmilitarSubmarino;
    private javax.swing.JLabel lblUnidadmilitarespolón;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;

    public VVerBarcosGuerraaConstruir(VCiudad vciudad) {
        initComponents();
        this.vciudad = vciudad;
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N

        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N

        cmdUnidadmilitarespolón.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-espolon.png"))); // NOI18N
        cmdUnidadmilitarLanzallamas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-lanzallamas.png"))); // NOI18N
        cmdUnidadmilitarEspolonavapor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-espolon-a-vapor.png"))); // NOI18N
        cmdUnidadmilitarBallesta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-ballesta.png"))); // NOI18N
        cmdUnidadmilitarCatapulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-catapulta.png"))); // NOI18N
        cmdUnidadmilitarSubmarino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/submarino.png"))); // NOI18N
        cmdUnidadmilitarMortero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-mortero.png"))); // NOI18N
        cmdUnidadmilitarLanzamisiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/lanzamisiles.png"))); // NOI18N

        this.setLocationRelativeTo(null);
        this.show();
    }

    public List<UnidadMilitar> getUnidadmilitar() {
        return unidadmilitar;
    }

    public void setUnidadmilitar(List<UnidadMilitar> unidadmilitar) {
        this.unidadmilitar = unidadmilitar;
    }

    private void elegirunidad(String unidadelegida) {
        for (int i = 0; i < this.unidadmilitar.size(); i++) {
            if (unidadelegida.equals(this.unidadmilitar.get(i).getNombre())) {
                VVerUnidadesMilitaresConstruccion verunidad = new VVerUnidadesMilitaresConstruccion(this.unidadmilitar.get(i), this.vciudad.getCiudad());
                verunidad.setVciudad(vciudad);
                return;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        cmdUnidadmilitarespolón = new javax.swing.JButton();
        cmdUnidadmilitarLanzallamas = new javax.swing.JButton();
        cmdUnidadmilitarEspolonavapor = new javax.swing.JButton();
        cmdUnidadmilitarBallesta = new javax.swing.JButton();
        cmdUnidadmilitarCatapulta = new javax.swing.JButton();
        cmdUnidadmilitarSubmarino = new javax.swing.JButton();
        cmdUnidadmilitarLanzamisiles = new javax.swing.JButton();
        lblUnidadmilitarespolón = new javax.swing.JLabel();
        lblUnidadmilitarLanzallamas = new javax.swing.JLabel();
        lblUnidadmilitarEspolonavapor = new javax.swing.JLabel();
        lblUnidadmilitarBallesta = new javax.swing.JLabel();
        lblUnidadmilitarCatapulta = new javax.swing.JLabel();
        lblUnidadmilitarSubmarino = new javax.swing.JLabel();
        lblUnidadmilitarMortero = new javax.swing.JLabel();
        lblUnidadmilitarLanzamisiles = new javax.swing.JLabel();
        cmdUnidadmilitarMortero = new javax.swing.JButton();

        setResizable(false);

        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdUnidadmilitarespolón.setEnabled(false);
        cmdUnidadmilitarespolón.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitarespolónActionPerformed(evt);
            }
        });

        cmdUnidadmilitarLanzallamas.setEnabled(false);
        cmdUnidadmilitarLanzallamas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitarLanzallamasActionPerformed(evt);
            }
        });

        cmdUnidadmilitarEspolonavapor.setEnabled(false);
        cmdUnidadmilitarEspolonavapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitarEspolonavaporActionPerformed(evt);
            }
        });

        cmdUnidadmilitarBallesta.setEnabled(false);
        cmdUnidadmilitarBallesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitarBallestaActionPerformed(evt);
            }
        });

        cmdUnidadmilitarCatapulta.setEnabled(false);
        cmdUnidadmilitarCatapulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitarCatapultaActionPerformed(evt);
            }
        });

        cmdUnidadmilitarSubmarino.setEnabled(false);
        cmdUnidadmilitarSubmarino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitarSubmarinoActionPerformed(evt);
            }
        });

        cmdUnidadmilitarLanzamisiles.setEnabled(false);
        cmdUnidadmilitarLanzamisiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitarLanzamisilesActionPerformed(evt);
            }
        });

        lblUnidadmilitarespolón.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitarespolón.setText("Espolon");
        lblUnidadmilitarespolón.setEnabled(false);
        lblUnidadmilitarespolón.setFocusable(false);

        lblUnidadmilitarLanzallamas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitarLanzallamas.setText("Lanza Llamas");
        lblUnidadmilitarLanzallamas.setEnabled(false);
        lblUnidadmilitarLanzallamas.setFocusable(false);

        lblUnidadmilitarEspolonavapor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitarEspolonavapor.setText("Espolon a Vapor");
        lblUnidadmilitarEspolonavapor.setEnabled(false);
        lblUnidadmilitarEspolonavapor.setFocusable(false);

        lblUnidadmilitarBallesta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitarBallesta.setText("Ballesta");
        lblUnidadmilitarBallesta.setEnabled(false);
        lblUnidadmilitarBallesta.setFocusable(false);

        lblUnidadmilitarCatapulta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitarCatapulta.setText("Catapulta");
        lblUnidadmilitarCatapulta.setEnabled(false);
        lblUnidadmilitarCatapulta.setFocusable(false);

        lblUnidadmilitarSubmarino.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitarSubmarino.setText("Mortero");
        lblUnidadmilitarSubmarino.setEnabled(false);
        lblUnidadmilitarSubmarino.setFocusable(false);

        lblUnidadmilitarMortero.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitarMortero.setText("Submarino");
        lblUnidadmilitarMortero.setEnabled(false);
        lblUnidadmilitarMortero.setFocusable(false);

        lblUnidadmilitarLanzamisiles.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitarLanzamisiles.setText("Lanzamisiles");
        lblUnidadmilitarLanzamisiles.setEnabled(false);
        lblUnidadmilitarLanzamisiles.setFocusable(false);

        cmdUnidadmilitarMortero.setEnabled(false);
        cmdUnidadmilitarMortero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitarMorteroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
                panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelImage2Layout.createSequentialGroup()
                                                .addComponent(cmdUnidadmilitarespolón, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(cmdUnidadmilitarLanzallamas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(cmdUnidadmilitarEspolonavapor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(cmdUnidadmilitarBallesta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelImage2Layout.createSequentialGroup()
                                                .addComponent(lblUnidadmilitarespolón, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(lblUnidadmilitarLanzallamas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(lblUnidadmilitarEspolonavapor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(lblUnidadmilitarBallesta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelImage2Layout.createSequentialGroup()
                                                .addComponent(cmdUnidadmilitarCatapulta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(cmdUnidadmilitarSubmarino, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmdUnidadmilitarMortero, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(cmdUnidadmilitarLanzamisiles, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelImage2Layout.createSequentialGroup()
                                                .addComponent(lblUnidadmilitarCatapulta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(lblUnidadmilitarMortero, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblUnidadmilitarSubmarino, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8)
                                                .addComponent(lblUnidadmilitarLanzamisiles, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelImage2Layout.setVerticalGroup(
                panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmdUnidadmilitarespolón, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmdUnidadmilitarLanzallamas, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmdUnidadmilitarEspolonavapor, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmdUnidadmilitarBallesta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUnidadmilitarespolón)
                                        .addComponent(lblUnidadmilitarLanzallamas)
                                        .addComponent(lblUnidadmilitarEspolonavapor)
                                        .addComponent(lblUnidadmilitarBallesta))
                                .addGap(13, 13, 13)
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmdUnidadmilitarMortero, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmdUnidadmilitarCatapulta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmdUnidadmilitarLanzamisiles, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmdUnidadmilitarSubmarino, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblUnidadmilitarCatapulta)
                                                .addComponent(lblUnidadmilitarMortero)
                                                .addComponent(lblUnidadmilitarSubmarino))
                                        .addComponent(lblUnidadmilitarLanzamisiles))
                                .addGap(6, 6, 6))
        );

        panelImage1.add(panelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 359));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdUnidadmilitarespolónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitarespolónActionPerformed
        this.elegirunidad("Barco Espolon");
    }//GEN-LAST:event_cmdUnidadmilitarespolónActionPerformed

    private void cmdUnidadmilitarLanzallamasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitarLanzallamasActionPerformed
        this.elegirunidad("Barco Lanzallamas");
    }//GEN-LAST:event_cmdUnidadmilitarLanzallamasActionPerformed

    private void cmdUnidadmilitarEspolonavaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitarEspolonavaporActionPerformed
        this.elegirunidad("Barco Espolon a vapor");
    }//GEN-LAST:event_cmdUnidadmilitarEspolonavaporActionPerformed

    private void cmdUnidadmilitarBallestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitarBallestaActionPerformed
        this.elegirunidad("Barco Ballesta");
    }//GEN-LAST:event_cmdUnidadmilitarBallestaActionPerformed

    private void cmdUnidadmilitarCatapultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitarCatapultaActionPerformed
        this.elegirunidad("Barco Catapulta");
    }//GEN-LAST:event_cmdUnidadmilitarCatapultaActionPerformed

    private void cmdUnidadmilitarMorteroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitarMorteroActionPerformed
        this.elegirunidad("barco Mortero");
    }//GEN-LAST:event_cmdUnidadmilitarMorteroActionPerformed

    private void cmdUnidadmilitarSubmarinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitarSubmarinoActionPerformed
        this.elegirunidad("Submarino");
    }//GEN-LAST:event_cmdUnidadmilitarSubmarinoActionPerformed

    private void cmdUnidadmilitarLanzamisilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitarLanzamisilesActionPerformed
        this.elegirunidad("Barco LanzaMisiles");
    }//GEN-LAST:event_cmdUnidadmilitarLanzamisilesActionPerformed

    public JButton getCmdUnidadmilitarBallesta() {
        return cmdUnidadmilitarBallesta;
    }

    public JButton getCmdUnidadmilitarCatapulta() {
        return cmdUnidadmilitarCatapulta;
    }

    public JButton getCmdUnidadmilitarEspolonavapor() {
        return cmdUnidadmilitarEspolonavapor;
    }

    public JButton getCmdUnidadmilitarLanzallamas() {
        return cmdUnidadmilitarLanzallamas;
    }

    public JButton getCmdUnidadmilitarLanzamisiles() {
        return cmdUnidadmilitarLanzamisiles;
    }

    public JButton getCmdUnidadmilitarMortero() {
        return cmdUnidadmilitarMortero;
    }

    public JButton getCmdUnidadmilitarSubmarino() {
        return cmdUnidadmilitarSubmarino;
    }

    public JButton getCmdUnidadmilitarespolón() {
        return cmdUnidadmilitarespolón;
    }

    public JLabel getLblUnidadmilitarBallesta() {
        return lblUnidadmilitarBallesta;
    }

    public JLabel getLblUnidadmilitarCatapulta() {
        return lblUnidadmilitarCatapulta;
    }

    public JLabel getLblUnidadmilitarEspolonavapor() {
        return lblUnidadmilitarEspolonavapor;
    }

    public JLabel getLblUnidadmilitarLanzallamas() {
        return lblUnidadmilitarLanzallamas;
    }

    public JLabel getLblUnidadmilitarLanzamisiles() {
        return lblUnidadmilitarLanzamisiles;
    }

    public JLabel getLblUnidadmilitarMortero() {
        return lblUnidadmilitarMortero;
    }

    public JLabel getLblUnidadmilitarSubmarino() {
        return lblUnidadmilitarSubmarino;
    }

    public JLabel getLblUnidadmilitarespolón() {
        return lblUnidadmilitarespolón;
    }

    public PanelImage getPanelImage1() {
        return panelImage1;
    }

    public PanelImage getPanelImage2() {
        return panelImage2;
    }
    // End of variables declaration//GEN-END:variables
}
