/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.login;

import com.jmg.buzios.config.ConexionDB;
import com.jmg.buzios.controller.cuenta.CrearJugador;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Alumno
 */
public class VCREARJUGADOR extends javax.swing.JFrame {


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdIngresar;
    private javax.swing.JLabel lblConstraseña;
    private javax.swing.JLabel lblConstraseña1;
    private javax.swing.JLabel lblNickjugador;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JPasswordField txtConfirmarconstraseña;
    private javax.swing.JPasswordField txtConstraseña;
    private javax.swing.JTextField txtNickdejugador;

    public VCREARJUGADOR() {
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
        txtConfirmarconstraseña = new javax.swing.JPasswordField();
        lblConstraseña1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BUZIO");
        setResizable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/VLOGIN.jpg"))); // NOI18N

        lblNickjugador.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblNickjugador.setForeground(new java.awt.Color(255, 255, 255));
        lblNickjugador.setText("Nick de Jugador");

        lblConstraseña.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblConstraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblConstraseña.setText("Contraseña");

        cmdIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/botonregistrarse.png"))); // NOI18N
        cmdIngresar.setBorderPainted(false);
        cmdIngresar.setContentAreaFilled(false);
        cmdIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIngresarActionPerformed(evt);
            }
        });

        lblConstraseña1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblConstraseña1.setForeground(new java.awt.Color(255, 255, 255));
        lblConstraseña1.setText("Contraseña");

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblNickjugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNickdejugador)
                                        .addComponent(lblConstraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtConstraseña)
                                        .addComponent(cmdIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblConstraseña1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtConfirmarconstraseña))
                                .addContainerGap(154, Short.MAX_VALUE))
        );
        panelImage1Layout.setVerticalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                .addContainerGap(89, Short.MAX_VALUE)
                                .addComponent(lblNickjugador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNickdejugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblConstraseña)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConstraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblConstraseña1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConfirmarconstraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdIngresar)
                                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (this.txtConstraseña.getText().equals(this.txtConfirmarconstraseña.getText()) && (!this.txtConfirmarconstraseña.getText().equals(""))) {
            if (!this.txtNickdejugador.getText().equals("")) {
                try {
                    CrearJugador crearjugador = new CrearJugador(this);
                    crearjugador.CUcrearjugador();


                } catch (SQLException ex) {
                    ConexionDB.mostrarmensajebasededatos();
                }
            } else {
                JOptionPane.showMessageDialog(panelImage1, "Debe ingresar un nick");
            }
        } else {
            JOptionPane.showMessageDialog(panelImage1, "Las contraseñas no coinciden.");
        }
    }

    public JButton getCmdIngresar() {
        return cmdIngresar;
    }

    public JLabel getLblConstraseña() {
        return lblConstraseña;
    }

    public JLabel getLblConstraseña1() {
        return lblConstraseña1;
    }

    public JLabel getLblNickjugador() {
        return lblNickjugador;
    }

    public PanelImage getPanelImage1() {
        return panelImage1;
    }

    public JPasswordField getTxtConfirmarconstraseña() {
        return txtConfirmarconstraseña;
    }

    public JPasswordField getTxtConstraseña() {
        return txtConstraseña;
    }

    public JTextField getTxtNickdejugador() {
        return txtNickdejugador;
    }//GEN-LAST:event_cmdIngresarActionPerformed
    // End of variables declaration//GEN-END:variables
}
