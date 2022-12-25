/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.islas;

import com.jmg.buzios.controller.militar.EnviarBarcos;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alumno
 */
public class VEnviarBarcos extends javax.swing.JFrame {

    private List<UnidadMilitar> barcosdeguerra;
    private List<Integer> cantidad;
    private Ciudad ciudadatacante;
    private Ciudad ciudadatacada;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDefenderPuerto;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar1;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar2;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar3;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar4;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar5;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar6;
    private org.edisoncor.gui.panel.PanelImage imagendefondo;
    private javax.swing.JLabel lblUnidadmilitar;
    private javax.swing.JLabel lblUnidadmilitar1;
    private javax.swing.JLabel lblUnidadmilitar2;
    private javax.swing.JLabel lblUnidadmilitar3;
    private javax.swing.JLabel lblUnidadmilitar5;
    private javax.swing.JLabel lblUnidadmilitar6;
    private javax.swing.JLabel lblUnidadmilitar7;
    private javax.swing.JTextField txtCantidadBarcos;
    private javax.swing.JTextField txtCantidadBarcos1;
    private javax.swing.JTextField txtCantidadBarcos2;
    private javax.swing.JTextField txtCantidadBarcos3;
    private javax.swing.JTextField txtCantidadBarcos5;
    private javax.swing.JTextField txtCantidadBarcos6;
    private javax.swing.JTextField txtCantidadBarcos7;
    public VEnviarBarcos(List<UnidadMilitar> barcosdeguerra, List<Integer> cantidad, Ciudad ciudadatacante, Ciudad ciudadatacada) {
        initComponents();
        for (int j = 0; j < barcosdeguerra.size(); j++) {
            if (barcosdeguerra.get(j).isBarco()) {
                this.barcosdeguerra.add(barcosdeguerra.get(j));
                this.cantidad.add(cantidad.get(j));
            }
        }

        this.ciudadatacada = ciudadatacada;
        this.ciudadatacante = ciudadatacante;
        this.activar_unidades_navales();
        this.setLocationRelativeTo(null);
        this.show();
    }

    private void activar_unidades_navales() {
        for (int i = 0; i < this.barcosdeguerra.size(); i++) {
            if (this.cantidad.get(i) > 0) {
                switch (this.barcosdeguerra.get(i).getNombre()) {
                    case "Espolón":
                        this.imagenUnidadmilitar.setEnabled(true);
                        this.txtCantidadBarcos.setEditable(true);
                        this.lblUnidadmilitar.setEnabled(true);

                        break;
                    case "Ballesta":
                        this.imagenUnidadmilitar1.setEnabled(true);
                        this.txtCantidadBarcos1.setEnabled(true);
                        this.lblUnidadmilitar1.setEnabled(true);
                        break;
                    case "Lanza Llamas":
                        this.imagenUnidadmilitar2.setEnabled(true);
                        this.txtCantidadBarcos2.setEnabled(true);
                        this.lblUnidadmilitar2.setEnabled(true);
                        break;
                    case "Catapulta":
                        this.imagenUnidadmilitar3.setEnabled(true);
                        this.txtCantidadBarcos3.setEnabled(true);
                        this.lblUnidadmilitar3.setEnabled(true);
                        break;
                    case "Espolón a Vapor":
                        this.imagenUnidadmilitar4.setEnabled(true);
                        this.lblUnidadmilitar5.setEnabled(true);
                        this.txtCantidadBarcos7.setEnabled(true);
                    case "Mortero":
                        this.imagenUnidadmilitar5.setEnabled(true);
                        this.lblUnidadmilitar6.setEnabled(true);
                        this.txtCantidadBarcos6.setEnabled(true);
                        break;
                    case "Submarino":
                        this.imagenUnidadmilitar6.setEnabled(true);
                        this.lblUnidadmilitar7.setEnabled(true);
                        this.txtCantidadBarcos5.setEnabled(true);
                }
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

        imagendefondo = new org.edisoncor.gui.panel.PanelImage();
        imagenUnidadmilitar = new org.edisoncor.gui.panel.PanelImage();
        imagenUnidadmilitar1 = new org.edisoncor.gui.panel.PanelImage();
        imagenUnidadmilitar2 = new org.edisoncor.gui.panel.PanelImage();
        imagenUnidadmilitar3 = new org.edisoncor.gui.panel.PanelImage();
        lblUnidadmilitar3 = new javax.swing.JLabel();
        txtCantidadBarcos3 = new javax.swing.JTextField();
        txtCantidadBarcos5 = new javax.swing.JTextField();
        lblUnidadmilitar7 = new javax.swing.JLabel();
        imagenUnidadmilitar6 = new org.edisoncor.gui.panel.PanelImage();
        txtCantidadBarcos2 = new javax.swing.JTextField();
        lblUnidadmilitar2 = new javax.swing.JLabel();
        lblUnidadmilitar1 = new javax.swing.JLabel();
        txtCantidadBarcos1 = new javax.swing.JTextField();
        imagenUnidadmilitar5 = new org.edisoncor.gui.panel.PanelImage();
        lblUnidadmilitar6 = new javax.swing.JLabel();
        txtCantidadBarcos6 = new javax.swing.JTextField();
        txtCantidadBarcos7 = new javax.swing.JTextField();
        lblUnidadmilitar5 = new javax.swing.JLabel();
        imagenUnidadmilitar4 = new org.edisoncor.gui.panel.PanelImage();
        txtCantidadBarcos = new javax.swing.JTextField();
        lblUnidadmilitar = new javax.swing.JLabel();
        cmdDefenderPuerto = new javax.swing.JButton();

        imagenUnidadmilitar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenUnidadmilitar.setEnabled(false);

        javax.swing.GroupLayout imagenUnidadmilitarLayout = new javax.swing.GroupLayout(imagenUnidadmilitar);
        imagenUnidadmilitar.setLayout(imagenUnidadmilitarLayout);
        imagenUnidadmilitarLayout.setHorizontalGroup(
                imagenUnidadmilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenUnidadmilitarLayout.setVerticalGroup(
                imagenUnidadmilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );

        imagenUnidadmilitar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenUnidadmilitar1.setEnabled(false);

        javax.swing.GroupLayout imagenUnidadmilitar1Layout = new javax.swing.GroupLayout(imagenUnidadmilitar1);
        imagenUnidadmilitar1.setLayout(imagenUnidadmilitar1Layout);
        imagenUnidadmilitar1Layout.setHorizontalGroup(
                imagenUnidadmilitar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenUnidadmilitar1Layout.setVerticalGroup(
                imagenUnidadmilitar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );

        imagenUnidadmilitar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenUnidadmilitar2.setEnabled(false);

        javax.swing.GroupLayout imagenUnidadmilitar2Layout = new javax.swing.GroupLayout(imagenUnidadmilitar2);
        imagenUnidadmilitar2.setLayout(imagenUnidadmilitar2Layout);
        imagenUnidadmilitar2Layout.setHorizontalGroup(
                imagenUnidadmilitar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenUnidadmilitar2Layout.setVerticalGroup(
                imagenUnidadmilitar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );

        imagenUnidadmilitar3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenUnidadmilitar3.setEnabled(false);

        javax.swing.GroupLayout imagenUnidadmilitar3Layout = new javax.swing.GroupLayout(imagenUnidadmilitar3);
        imagenUnidadmilitar3.setLayout(imagenUnidadmilitar3Layout);
        imagenUnidadmilitar3Layout.setHorizontalGroup(
                imagenUnidadmilitar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenUnidadmilitar3Layout.setVerticalGroup(
                imagenUnidadmilitar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );

        lblUnidadmilitar3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar3.setText("jLabel1");
        lblUnidadmilitar3.setDoubleBuffered(true);
        lblUnidadmilitar3.setEnabled(false);
        lblUnidadmilitar3.setFocusable(false);

        txtCantidadBarcos3.setDoubleBuffered(true);
        txtCantidadBarcos3.setEnabled(false);
        txtCantidadBarcos3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadBarcos3KeyReleased(evt);
            }
        });

        txtCantidadBarcos5.setDoubleBuffered(true);
        txtCantidadBarcos5.setEnabled(false);
        txtCantidadBarcos5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadBarcos5KeyReleased(evt);
            }
        });

        lblUnidadmilitar7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar7.setText("jLabel1");
        lblUnidadmilitar7.setDoubleBuffered(true);
        lblUnidadmilitar7.setEnabled(false);
        lblUnidadmilitar7.setFocusable(false);

        imagenUnidadmilitar6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenUnidadmilitar6.setEnabled(false);

        javax.swing.GroupLayout imagenUnidadmilitar6Layout = new javax.swing.GroupLayout(imagenUnidadmilitar6);
        imagenUnidadmilitar6.setLayout(imagenUnidadmilitar6Layout);
        imagenUnidadmilitar6Layout.setHorizontalGroup(
                imagenUnidadmilitar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenUnidadmilitar6Layout.setVerticalGroup(
                imagenUnidadmilitar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );

        txtCantidadBarcos2.setDoubleBuffered(true);
        txtCantidadBarcos2.setEnabled(false);
        txtCantidadBarcos2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadBarcos2KeyReleased(evt);
            }
        });

        lblUnidadmilitar2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar2.setText("jLabel1");
        lblUnidadmilitar2.setDoubleBuffered(true);
        lblUnidadmilitar2.setEnabled(false);
        lblUnidadmilitar2.setFocusable(false);

        lblUnidadmilitar1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar1.setText("jLabel1");
        lblUnidadmilitar1.setDoubleBuffered(true);
        lblUnidadmilitar1.setEnabled(false);
        lblUnidadmilitar1.setFocusable(false);

        txtCantidadBarcos1.setDoubleBuffered(true);
        txtCantidadBarcos1.setEnabled(false);
        txtCantidadBarcos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadBarcos1KeyReleased(evt);
            }
        });

        imagenUnidadmilitar5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenUnidadmilitar5.setEnabled(false);

        javax.swing.GroupLayout imagenUnidadmilitar5Layout = new javax.swing.GroupLayout(imagenUnidadmilitar5);
        imagenUnidadmilitar5.setLayout(imagenUnidadmilitar5Layout);
        imagenUnidadmilitar5Layout.setHorizontalGroup(
                imagenUnidadmilitar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenUnidadmilitar5Layout.setVerticalGroup(
                imagenUnidadmilitar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );

        lblUnidadmilitar6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar6.setText("jLabel1");
        lblUnidadmilitar6.setDoubleBuffered(true);
        lblUnidadmilitar6.setEnabled(false);
        lblUnidadmilitar6.setFocusable(false);

        txtCantidadBarcos6.setDoubleBuffered(true);
        txtCantidadBarcos6.setEnabled(false);
        txtCantidadBarcos6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadBarcos6KeyReleased(evt);
            }
        });

        txtCantidadBarcos7.setDoubleBuffered(true);
        txtCantidadBarcos7.setEnabled(false);
        txtCantidadBarcos7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadBarcos7KeyReleased(evt);
            }
        });

        lblUnidadmilitar5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar5.setText("jLabel1");
        lblUnidadmilitar5.setDoubleBuffered(true);
        lblUnidadmilitar5.setEnabled(false);
        lblUnidadmilitar5.setFocusable(false);

        imagenUnidadmilitar4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenUnidadmilitar4.setEnabled(false);

        javax.swing.GroupLayout imagenUnidadmilitar4Layout = new javax.swing.GroupLayout(imagenUnidadmilitar4);
        imagenUnidadmilitar4.setLayout(imagenUnidadmilitar4Layout);
        imagenUnidadmilitar4Layout.setHorizontalGroup(
                imagenUnidadmilitar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenUnidadmilitar4Layout.setVerticalGroup(
                imagenUnidadmilitar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );

        txtCantidadBarcos.setDoubleBuffered(true);
        txtCantidadBarcos.setEnabled(false);
        txtCantidadBarcos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadBarcosKeyReleased(evt);
            }
        });

        lblUnidadmilitar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar.setText("jLabel1");
        lblUnidadmilitar.setDoubleBuffered(true);
        lblUnidadmilitar.setEnabled(false);
        lblUnidadmilitar.setFocusable(false);

        cmdDefenderPuerto.setText("Defender Puerto");
        cmdDefenderPuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDefenderPuertoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagendefondoLayout = new javax.swing.GroupLayout(imagendefondo);
        imagendefondo.setLayout(imagendefondoLayout);
        imagendefondoLayout.setHorizontalGroup(
                imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(imagendefondoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, imagendefondoLayout.createSequentialGroup()
                                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtCantidadBarcos)
                                                        .addComponent(imagenUnidadmilitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblUnidadmilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(imagenUnidadmilitar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblUnidadmilitar1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCantidadBarcos1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(imagenUnidadmilitar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblUnidadmilitar2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCantidadBarcos2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(imagenUnidadmilitar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblUnidadmilitar3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCantidadBarcos3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, imagendefondoLayout.createSequentialGroup()
                                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtCantidadBarcos7)
                                                        .addComponent(imagenUnidadmilitar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblUnidadmilitar5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(imagenUnidadmilitar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblUnidadmilitar6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCantidadBarcos6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(imagenUnidadmilitar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblUnidadmilitar7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCantidadBarcos5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmdDefenderPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        imagendefondoLayout.setVerticalGroup(
                imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagendefondoLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(imagendefondoLayout.createSequentialGroup()
                                                .addComponent(imagenUnidadmilitar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblUnidadmilitar3))
                                        .addGroup(imagendefondoLayout.createSequentialGroup()
                                                .addComponent(imagenUnidadmilitar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblUnidadmilitar2))
                                        .addGroup(imagendefondoLayout.createSequentialGroup()
                                                .addComponent(imagenUnidadmilitar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblUnidadmilitar1))
                                        .addGroup(imagendefondoLayout.createSequentialGroup()
                                                .addComponent(imagenUnidadmilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblUnidadmilitar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCantidadBarcos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCantidadBarcos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCantidadBarcos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCantidadBarcos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(imagendefondoLayout.createSequentialGroup()
                                                .addComponent(imagenUnidadmilitar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblUnidadmilitar7))
                                        .addGroup(imagendefondoLayout.createSequentialGroup()
                                                .addComponent(imagenUnidadmilitar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblUnidadmilitar6))
                                        .addGroup(imagendefondoLayout.createSequentialGroup()
                                                .addComponent(imagenUnidadmilitar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblUnidadmilitar5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(imagendefondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCantidadBarcos7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCantidadBarcos6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCantidadBarcos5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdDefenderPuerto)
                                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(imagendefondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(imagendefondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadBarcos3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadBarcos3KeyReleased
        int cantidadunidad = 0;
        try {
            //buscar la cantidad de esa unidad militar
            for (int i = 0; i < this.barcosdeguerra.size(); i++) {
                if (this.barcosdeguerra.get(i).getNombre().equals(this.lblUnidadmilitar3.getText())) {
                    cantidadunidad = this.cantidad.get(i).intValue();
                }
            }
            //verificar que la cantidad a asignar no sea mayor a la cantidad existente
            if (Integer.getInteger(this.txtCantidadBarcos3.getText()) > cantidadunidad) {
                this.txtCantidadBarcos3.setText("" + cantidadunidad);
            }

        } catch (NumberFormatException j) {
            this.txtCantidadBarcos3.setText("0");
        }
    }//GEN-LAST:event_txtCantidadBarcos3KeyReleased

    private void txtCantidadBarcos5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadBarcos5KeyReleased
        int cantidadunidad = 0;
        try {
            //buscar la cantidad de esa unidad militar
            for (int i = 0; i < this.barcosdeguerra.size(); i++) {
                if (this.barcosdeguerra.get(i).getNombre().equals(this.lblUnidadmilitar7.getText())) {
                    cantidadunidad = this.cantidad.get(i).intValue();
                }
            }
            //verificar que la cantidad a asignar no sea mayor a la cantidad existente
            if (Integer.getInteger(this.txtCantidadBarcos5.getText()) > cantidadunidad) {
                this.txtCantidadBarcos5.setText("" + cantidadunidad);
            }

        } catch (NumberFormatException j) {
            this.txtCantidadBarcos5.setText("0");
        }
    }//GEN-LAST:event_txtCantidadBarcos5KeyReleased

    private void txtCantidadBarcos2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadBarcos2KeyReleased
        int cantidadunidad = 0;
        try {
            //buscar la cantidad de esa unidad militar
            for (int i = 0; i < this.barcosdeguerra.size(); i++) {
                if (this.barcosdeguerra.get(i).getNombre().equals(this.lblUnidadmilitar2.getText())) {
                    cantidadunidad = this.cantidad.get(i).intValue();
                }
            }
            //verificar que la cantidad a asignar no sea mayor a la cantidad existente
            if (Integer.getInteger(this.txtCantidadBarcos2.getText()) > cantidadunidad) {
                this.txtCantidadBarcos2.setText("" + cantidadunidad);
            }

        } catch (NumberFormatException j) {
            this.txtCantidadBarcos2.setText("0");
        }
    }//GEN-LAST:event_txtCantidadBarcos2KeyReleased

    private void txtCantidadBarcos1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadBarcos1KeyReleased
        int cantidadunidad = 0;
        try {
            //buscar la cantidad de esa unidad militar
            for (int i = 0; i < this.barcosdeguerra.size(); i++) {
                if (this.barcosdeguerra.get(i).getNombre().equals(this.lblUnidadmilitar1.getText())) {
                    cantidadunidad = this.cantidad.get(i).intValue();
                }
            }
            //verificar que la cantidad a asignar no sea mayor a la cantidad existente
            if (Integer.getInteger(this.txtCantidadBarcos1.getText()) > cantidadunidad) {
                this.txtCantidadBarcos1.setText("" + cantidadunidad);
            }

        } catch (NumberFormatException j) {
            this.txtCantidadBarcos1.setText("0");
        }
    }//GEN-LAST:event_txtCantidadBarcos1KeyReleased

    private void txtCantidadBarcos6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadBarcos6KeyReleased
        int cantidadunidad = 0;
        try {
            //buscar la cantidad de esa unidad militar
            for (int i = 0; i < this.barcosdeguerra.size(); i++) {
                if (this.barcosdeguerra.get(i).getNombre().equals(this.lblUnidadmilitar6.getText())) {
                    cantidadunidad = this.cantidad.get(i).intValue();
                }
            }
            //verificar que la cantidad a asignar no sea mayor a la cantidad existente
            if (Integer.getInteger(this.txtCantidadBarcos6.getText()) > cantidadunidad) {
                this.txtCantidadBarcos6.setText("" + cantidadunidad);
            }

        } catch (NumberFormatException j) {
            this.txtCantidadBarcos6.setText("0");
        }
    }//GEN-LAST:event_txtCantidadBarcos6KeyReleased

    private void txtCantidadBarcos7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadBarcos7KeyReleased
        int cantidadunidad = 0;
        try {
            //buscar la cantidad de esa unidad militar
            for (int i = 0; i < this.barcosdeguerra.size(); i++) {
                if (this.barcosdeguerra.get(i).getNombre().equals(this.lblUnidadmilitar5.getText())) {
                    cantidadunidad = this.cantidad.get(i).intValue();
                }
            }
            //verificar que la cantidad a asignar no sea mayor a la cantidad existente
            if (Integer.getInteger(this.txtCantidadBarcos7.getText()) > cantidadunidad) {
                this.txtCantidadBarcos7.setText("" + cantidadunidad);
            }

        } catch (NumberFormatException j) {
            this.txtCantidadBarcos7.setText("0");
        }
    }//GEN-LAST:event_txtCantidadBarcos7KeyReleased

    private void txtCantidadBarcosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadBarcosKeyReleased
        int cantidadunidad = 0;
        try {
            //buscar la cantidad de esa unidad militar
            for (int i = 0; i < this.barcosdeguerra.size(); i++) {
                if (this.barcosdeguerra.get(i).getNombre().equals(this.lblUnidadmilitar.getText())) {
                    cantidadunidad = this.cantidad.get(i).intValue();
                }
            }
            //verificar que la cantidad a asignar no sea mayor a la cantidad existente
            if (Integer.getInteger(this.txtCantidadBarcos.getText()) > cantidadunidad) {
                this.txtCantidadBarcos.setText("" + cantidadunidad);
            }

        } catch (NumberFormatException j) {
            this.txtCantidadBarcos.setText("0");
        }
    }//GEN-LAST:event_txtCantidadBarcosKeyReleased

    private void cmdDefenderPuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDefenderPuertoActionPerformed
        try {
            List<UnidadMilitar> unidadmilitares = new ArrayList<>();
            List<Integer> cantidadaenviar = new ArrayList<>();

            for (int i = 0; i < this.cantidad.size(); i++) {
                if (this.cantidad.get(i).intValue() > 0) {
                    unidadmilitares.add(this.barcosdeguerra.get(i));
                    cantidadaenviar.add(this.cantidad.get(i));
                }
            }

            EnviarBarcos enviarbarcos;
            enviarbarcos = new EnviarBarcos(unidadmilitares, cantidadaenviar, ciudadatacante, ciudadatacada);
            enviarbarcos.CUEnviarBarcos();
        } catch (SQLException ex) {
            Logger.getLogger(VEnviarBarcos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdDefenderPuertoActionPerformed
    // End of variables declaration//GEN-END:variables
}
