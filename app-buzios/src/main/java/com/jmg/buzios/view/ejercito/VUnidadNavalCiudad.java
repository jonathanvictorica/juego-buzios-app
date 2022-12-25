/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.ejercito;

import com.jmg.buzios.controller.ejercito.DestruirUnidadMilitar;
import com.jmg.buzios.model.ciudad.CiudadEjercito;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import com.jmg.buzios.view.ciudad.VCiudad;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Alumno
 */
public class VUnidadNavalCiudad extends javax.swing.JFrame {


    private VCiudad vciudad;
    private CiudadEjercito ciudadejercito;


    private UnidadMilitar unidadmilitar;
    private List<Arma> armasasignadas;
    private List<Integer> cantidad;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDestruirunidadmilitar;
    private javax.swing.JButton cmdUnidadmilitar;
    private javax.swing.JButton cmdUnidadmilitar1;
    private javax.swing.JButton cmdUnidadmilitar2;
    private javax.swing.JButton cmdUnidadmilitar3;
    private javax.swing.JButton cmdUnidadmilitar4;
    private javax.swing.JButton cmdUnidadmilitar5;
    private javax.swing.JButton cmdUnidadmilitar6;
    private javax.swing.JButton cmdUnidadmilitar7;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCantidad1;
    private javax.swing.JLabel lblCantidad2;
    private javax.swing.JLabel lblCantidad3;
    private javax.swing.JLabel lblCantidad4;
    private javax.swing.JLabel lblCantidad5;
    private javax.swing.JLabel lblCantidad6;
    private javax.swing.JLabel lblCantidad7;
    private javax.swing.JLabel lblUnidadmilitar;
    private javax.swing.JLabel lblUnidadmilitar1;
    private javax.swing.JLabel lblUnidadmilitar2;
    private javax.swing.JLabel lblUnidadmilitar3;
    private javax.swing.JLabel lblUnidadmilitar4;
    private javax.swing.JLabel lblUnidadmilitar5;
    private javax.swing.JLabel lblUnidadmilitar6;
    private javax.swing.JLabel lblUnidadmilitar7;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage3;

    public VUnidadNavalCiudad(VCiudad vciudad, CiudadEjercito ciudadejercito) {
        initComponents();
        this.vciudad = vciudad;


        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N
        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N

        cmdDestruirunidadmilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Destruir Unidad Militar.png"))); // NOI18N


        cmdUnidadmilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-espolon.png"))); // NOI18N

        cmdUnidadmilitar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-ballesta.png"))); // NOI18N


        cmdUnidadmilitar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-catapulta.png"))); // NOI18N


        cmdUnidadmilitar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-lanzallamas.png"))); // NOI18N


        cmdUnidadmilitar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-mortero.png"))); // NOI18N
        cmdUnidadmilitar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/barco-espolon-a-vapor.png"))); // NOI18N
        cmdUnidadmilitar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/submarino.png"))); // NOI18N

        cmdUnidadmilitar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/BARCOS/lanzamisiles.png"))); // NOI18N
        this.ciudadejercito = ciudadejercito;
        this.setLocationRelativeTo(null);
        this.show();

    }

    public JButton getCmdUnidadmilitar7() {
        return cmdUnidadmilitar7;
    }

    public void setCmdUnidadmilitar7(JButton cmdUnidadmilitar7) {
        this.cmdUnidadmilitar7 = cmdUnidadmilitar7;
    }

    public JLabel getLblCantidad7() {
        return lblCantidad7;
    }

    public void setLblCantidad7(JLabel lblCantidad7) {
        this.lblCantidad7 = lblCantidad7;
    }

    public JLabel getLblUnidadmilitar7() {
        return lblUnidadmilitar7;
    }

    public void setLblUnidadmilitar7(JLabel lblUnidadmilitar7) {
        this.lblUnidadmilitar7 = lblUnidadmilitar7;
    }

    public VCiudad getVciudad() {
        return vciudad;
    }

    public CiudadEjercito getCiudadejercito() {
        return ciudadejercito;
    }

    public UnidadMilitar getUnidadmilitar() {
        return unidadmilitar;
    }

    public List<Arma> getArmasasignadas() {
        return armasasignadas;
    }

    public List<Integer> getCantidad() {
        return cantidad;
    }

    public JLabel getLblCantidad() {
        return lblCantidad;
    }

    public JLabel getLblCantidad1() {
        return lblCantidad1;
    }

    public JLabel getLblCantidad2() {
        return lblCantidad2;
    }

    public JLabel getLblCantidad3() {
        return lblCantidad3;
    }

    public JLabel getLblCantidad4() {
        return lblCantidad4;
    }

    public JLabel getLblCantidad5() {
        return lblCantidad5;
    }

    public JLabel getLblCantidad6() {
        return lblCantidad6;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        cmdDestruirunidadmilitar = new javax.swing.JButton();
        lblUnidadmilitar = new javax.swing.JLabel();
        cmdUnidadmilitar = new javax.swing.JButton();
        cmdUnidadmilitar1 = new javax.swing.JButton();
        lblUnidadmilitar1 = new javax.swing.JLabel();
        lblUnidadmilitar2 = new javax.swing.JLabel();
        lblUnidadmilitar3 = new javax.swing.JLabel();
        cmdUnidadmilitar3 = new javax.swing.JButton();
        cmdUnidadmilitar2 = new javax.swing.JButton();
        lblUnidadmilitar4 = new javax.swing.JLabel();
        lblUnidadmilitar5 = new javax.swing.JLabel();
        cmdUnidadmilitar5 = new javax.swing.JButton();
        cmdUnidadmilitar4 = new javax.swing.JButton();
        cmdUnidadmilitar6 = new javax.swing.JButton();
        lblUnidadmilitar6 = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblCantidad1 = new javax.swing.JLabel();
        lblCantidad2 = new javax.swing.JLabel();
        lblCantidad3 = new javax.swing.JLabel();
        lblCantidad4 = new javax.swing.JLabel();
        lblCantidad5 = new javax.swing.JLabel();
        lblCantidad6 = new javax.swing.JLabel();
        lblCantidad7 = new javax.swing.JLabel();
        lblUnidadmilitar7 = new javax.swing.JLabel();
        cmdUnidadmilitar7 = new javax.swing.JButton();

        panelImage3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImage3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdDestruirunidadmilitar.setBorderPainted(false);
        cmdDestruirunidadmilitar.setContentAreaFilled(false);
        cmdDestruirunidadmilitar.setEnabled(false);
        cmdDestruirunidadmilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDestruirunidadmilitarActionPerformed(evt);
            }
        });
        panelImage3.add(cmdDestruirunidadmilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 372, 138, 50));

        lblUnidadmilitar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar.setText("Espolon");
        lblUnidadmilitar.setEnabled(false);
        lblUnidadmilitar.setFocusable(false);
        panelImage3.add(lblUnidadmilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 153, 138, -1));

        cmdUnidadmilitar.setEnabled(false);
        cmdUnidadmilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitarActionPerformed(evt);
            }
        });
        panelImage3.add(cmdUnidadmilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 11, 138, 136));

        cmdUnidadmilitar1.setEnabled(false);
        cmdUnidadmilitar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar1ActionPerformed(evt);
            }
        });
        panelImage3.add(cmdUnidadmilitar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 11, 138, 136));

        lblUnidadmilitar1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar1.setText("Ballesta");
        lblUnidadmilitar1.setEnabled(false);
        lblUnidadmilitar1.setFocusable(false);
        panelImage3.add(lblUnidadmilitar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 153, 138, -1));

        lblUnidadmilitar2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar2.setText("Lanza Llamas");
        lblUnidadmilitar2.setEnabled(false);
        lblUnidadmilitar2.setFocusable(false);
        panelImage3.add(lblUnidadmilitar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 153, 138, -1));

        lblUnidadmilitar3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar3.setText("Catapulta");
        lblUnidadmilitar3.setEnabled(false);
        lblUnidadmilitar3.setFocusable(false);
        panelImage3.add(lblUnidadmilitar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 153, 138, -1));

        cmdUnidadmilitar3.setEnabled(false);
        cmdUnidadmilitar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar3ActionPerformed(evt);
            }
        });
        panelImage3.add(cmdUnidadmilitar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 11, 138, 136));

        cmdUnidadmilitar2.setEnabled(false);
        cmdUnidadmilitar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar2ActionPerformed(evt);
            }
        });
        panelImage3.add(cmdUnidadmilitar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 11, 138, 136));

        lblUnidadmilitar4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar4.setText("Espolon a Vapor");
        lblUnidadmilitar4.setEnabled(false);
        lblUnidadmilitar4.setFocusable(false);
        panelImage3.add(lblUnidadmilitar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 340, 138, -1));

        lblUnidadmilitar5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar5.setText("Mortero");
        lblUnidadmilitar5.setEnabled(false);
        lblUnidadmilitar5.setFocusable(false);
        panelImage3.add(lblUnidadmilitar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 138, -1));

        cmdUnidadmilitar5.setEnabled(false);
        cmdUnidadmilitar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar5ActionPerformed(evt);
            }
        });
        panelImage3.add(cmdUnidadmilitar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 198, 138, 136));

        cmdUnidadmilitar4.setEnabled(false);
        cmdUnidadmilitar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar4ActionPerformed(evt);
            }
        });
        panelImage3.add(cmdUnidadmilitar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 198, 138, 136));

        cmdUnidadmilitar6.setEnabled(false);
        cmdUnidadmilitar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar6ActionPerformed(evt);
            }
        });
        panelImage3.add(cmdUnidadmilitar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 198, 138, 136));

        lblUnidadmilitar6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar6.setText("Submarino");
        lblUnidadmilitar6.setEnabled(false);
        lblUnidadmilitar6.setFocusable(false);
        panelImage3.add(lblUnidadmilitar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 340, 138, -1));

        lblCantidad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCantidad.setEnabled(false);
        lblCantidad.setFocusable(false);
        panelImage3.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 175, 138, 18));

        lblCantidad1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCantidad1.setEnabled(false);
        lblCantidad1.setFocusable(false);
        panelImage3.add(lblCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 175, 138, 18));

        lblCantidad2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCantidad2.setEnabled(false);
        lblCantidad2.setFocusable(false);
        panelImage3.add(lblCantidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 175, 138, 18));

        lblCantidad3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCantidad3.setEnabled(false);
        lblCantidad3.setFocusable(false);
        panelImage3.add(lblCantidad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 175, 138, 18));

        lblCantidad4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCantidad4.setEnabled(false);
        lblCantidad4.setFocusable(false);
        panelImage3.add(lblCantidad4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 356, 138, 18));

        lblCantidad5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCantidad5.setEnabled(false);
        lblCantidad5.setFocusable(false);
        panelImage3.add(lblCantidad5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 356, 138, 18));

        lblCantidad6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCantidad6.setEnabled(false);
        lblCantidad6.setFocusable(false);
        panelImage3.add(lblCantidad6, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 356, 138, 18));

        lblCantidad7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCantidad7.setEnabled(false);
        lblCantidad7.setFocusable(false);
        panelImage3.add(lblCantidad7, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 362, 138, 18));

        lblUnidadmilitar7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar7.setText("Lanzamisiles");
        lblUnidadmilitar7.setEnabled(false);
        lblUnidadmilitar7.setFocusable(false);
        panelImage3.add(lblUnidadmilitar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 340, 138, -1));

        cmdUnidadmilitar7.setEnabled(false);
        cmdUnidadmilitar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUnidadmilitar7ActionPerformed(evt);
            }
        });
        panelImage3.add(cmdUnidadmilitar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 198, 138, 136));

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage1Layout.createSequentialGroup()
                                .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void habilitarboton(String unidadmilitarnaval) {

        for (int i = 0; i < this.ciudadejercito.getUnidad().size(); i++) {
            if (unidadmilitarnaval.equals(this.ciudadejercito.getUnidad().get(i).getNombre())) {
                this.unidadmilitar = this.ciudadejercito.getUnidad().get(i);
                this.cmdDestruirunidadmilitar.setEnabled(true);

                this.cantidad = this.ciudadejercito.getArmasdeunidad().get(i).getCapacidaddisponibleenciudad();
                return;
            } else {
                this.cmdDestruirunidadmilitar.setEnabled(false);

            }
        }
    }

    private void cmdUnidadmilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitarActionPerformed
        this.habilitarboton("Barco Espolon");
    }//GEN-LAST:event_cmdUnidadmilitarActionPerformed

    private void cmdUnidadmilitar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar1ActionPerformed
        this.habilitarboton("Barco Ballesta");
    }//GEN-LAST:event_cmdUnidadmilitar1ActionPerformed

    private void cmdUnidadmilitar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar2ActionPerformed
        this.habilitarboton("Barco Lanzallamas");
    }//GEN-LAST:event_cmdUnidadmilitar2ActionPerformed

    private void cmdUnidadmilitar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar3ActionPerformed
        this.habilitarboton("Barco Catapulta");
    }//GEN-LAST:event_cmdUnidadmilitar3ActionPerformed

    private void cmdUnidadmilitar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar4ActionPerformed
        this.habilitarboton("Barco Espolon a vapor");
    }//GEN-LAST:event_cmdUnidadmilitar4ActionPerformed

    private void cmdUnidadmilitar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar5ActionPerformed
        this.habilitarboton("barco Mortero");
    }//GEN-LAST:event_cmdUnidadmilitar5ActionPerformed

    private void cmdUnidadmilitar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar6ActionPerformed
        this.habilitarboton("Submarino");
    }//GEN-LAST:event_cmdUnidadmilitar6ActionPerformed

    private void cmdDestruirunidadmilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDestruirunidadmilitarActionPerformed

        String cant = JOptionPane.showInputDialog(this, "Ingrese la cantidad de " + this.unidadmilitar.getNombre() + " desea destruir: ");
        int cantidaddestruir = Integer.parseInt(cant);
        if (cantidaddestruir > 0) {
            try {
                DestruirUnidadMilitar destruirunidad = new DestruirUnidadMilitar(this.unidadmilitar, null, cantidaddestruir, this.vciudad);
                destruirunidad.CUDestruirUnidadMilitar();
                this.hide();
            } catch (SQLException ex) {

            }
        } else {
            JOptionPane.showConfirmDialog(panelImage1, "Debe ingresar un numero mayor a 0.");
        }
    }//GEN-LAST:event_cmdDestruirunidadmilitarActionPerformed

    private void cmdUnidadmilitar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUnidadmilitar7ActionPerformed
        this.habilitarboton("Barco LanzaMisiles");
    }//GEN-LAST:event_cmdUnidadmilitar7ActionPerformed

    public JButton getCmdDestruirunidadmilitar() {
        return cmdDestruirunidadmilitar;
    }

    public JButton getCmdUnidadmilitarEspolon1() {
        return cmdUnidadmilitar;
    }

    public JButton getCmdUnidadmilitarBallesta2() {
        return cmdUnidadmilitar1;
    }

    public JButton getCmdUnidadmilitarLanzaLlamas3() {
        return cmdUnidadmilitar2;
    }

    public JButton getCmdUnidadmilitarCatapulta4() {
        return cmdUnidadmilitar3;
    }

    public JButton getCmdUnidadmilitarEspolonaVapor5() {
        return cmdUnidadmilitar4;
    }

    public JButton getCmdUnidadmilitarMortero6() {
        return cmdUnidadmilitar6;
    }

    public JButton getCmdUnidadmilitarSubmarino7() {
        return cmdUnidadmilitar5;
    }

    public JLabel getLblUnidadmilitar() {
        return lblUnidadmilitar;
    }

    public JLabel getLblUnidadmilitar1() {
        return lblUnidadmilitar1;
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

    public PanelImage getPanelImage1() {
        return panelImage1;
    }

    public PanelImage getPanelImage3() {
        return panelImage3;
    }
    // End of variables declaration//GEN-END:variables
}
