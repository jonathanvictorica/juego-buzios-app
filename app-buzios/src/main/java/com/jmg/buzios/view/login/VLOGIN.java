/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.login;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.controller.cuenta.RetomarPartida;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class VLOGIN extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdIngresar;
    private javax.swing.JButton cmdRegistrar;
    private javax.swing.JLabel lblConstraseña;
    private javax.swing.JLabel lblNickjugador;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JPasswordField txtConstraseña;
    private javax.swing.JTextField txtNickdejugador;

    /**
     * Creates new form VLOGIN
     */
    public VLOGIN() {
        initComponents();
        ImageIcon a;
        String direccionimagen = ("/IMAGEN/" + "Iconoedificio" + ".jpg");
        a = new ImageIcon(getClass().getResource(direccionimagen));
        this.setIconImage(a.getImage());
        this.setLocationRelativeTo(null);
        this.show();
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
        lblNickjugador = new javax.swing.JLabel();
        txtNickdejugador = new javax.swing.JTextField();
        lblConstraseña = new javax.swing.JLabel();
        txtConstraseña = new javax.swing.JPasswordField();
        cmdIngresar = new javax.swing.JButton();
        cmdRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BUZIO");
        setResizable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/vlogin3.png"))); // NOI18N

        lblNickjugador.setBackground(new java.awt.Color(255, 255, 255));
        lblNickjugador.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblNickjugador.setForeground(new java.awt.Color(51, 51, 51));
        lblNickjugador.setText("Nick de Jugador");

        lblConstraseña.setBackground(new java.awt.Color(255, 255, 255));
        lblConstraseña.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblConstraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblConstraseña.setText("CONTRASEÑA");

        cmdIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/botonconectate.png"))); // NOI18N
        cmdIngresar.setBorderPainted(false);
        cmdIngresar.setContentAreaFilled(false);
        cmdIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIngresarActionPerformed(evt);
            }
        });

        cmdRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/botonregistrarse.png"))); // NOI18N
        cmdRegistrar.setBorderPainted(false);
        cmdRegistrar.setContentAreaFilled(false);
        cmdRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                .addContainerGap(293, Short.MAX_VALUE)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblConstraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblNickjugador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtNickdejugador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtConstraseña, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmdRegistrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(cmdIngresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(266, 266, 266))
        );
        panelImage1Layout.setVerticalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(lblNickjugador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNickdejugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblConstraseña)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConstraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdIngresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdRegistrar)
                                .addContainerGap(211, Short.MAX_VALUE))
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
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIngresarActionPerformed
        try {
            RetomarPartida retomarpartida = new RetomarPartida(this);
            retomarpartida.CUretomarpartida();

        } catch (SQLException ex) {
            ConexionDB.mostrarmensajebasededatos();
        }

    }//GEN-LAST:event_cmdIngresarActionPerformed

    private void cmdRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRegistrarActionPerformed
        VCREARJUGADOR vcrearjugador = new VCREARJUGADOR();
        this.hide();
    }//GEN-LAST:event_cmdRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */


    public JButton getCmdIngresar() {
        return cmdIngresar;
    }

    public JLabel getLblConstraseña() {
        return lblConstraseña;
    }

    public JLabel getLblNickjugador() {
        return lblNickjugador;
    }

    public PanelImage getPanelImage1() {
        return panelImage1;
    }

    public JPasswordField getTxtConstraseña() {
        return txtConstraseña;
    }

    public JTextField getTxtNickdejugador() {
        return txtNickdejugador;
    }
    // End of variables declaration//GEN-END:variables
}