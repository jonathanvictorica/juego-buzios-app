/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.islas;

import com.jmg.buzios.controller.isla.EnviarMensajeJugador;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.jugador.Jugador;

import javax.swing.*;

/**
 * @author Alumno
 */
public class VEnviarMensaje extends javax.swing.JFrame {

    private Ciudad jugadoreremitente;
    private Ciudad destinatario;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdEnviarrecurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDestinatario;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTitulo;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTextField txtJugadorDestinatario;
    private javax.swing.JTextArea txtMensaje;
    private javax.swing.JTextField txtTitulo;
    public VEnviarMensaje(Ciudad jugadorremitente, Ciudad destinatario) {
        initComponents();
        this.jugadoreremitente = jugadorremitente;
        this.destinatario = destinatario;
        this.txtJugadorDestinatario.setText(this.destinatario.getJugador().getNick());
        this.setLocationRelativeTo(null);
        this.show();
    }
    public VEnviarMensaje(Ciudad ciudadjugador, Jugador jugemitente) {
        initComponents();
        this.jugadoreremitente = ciudadjugador;
        this.destinatario = new Ciudad("", jugemitente);
        this.destinatario.inicializarciudad();
        this.txtJugadorDestinatario.setText(this.destinatario.getJugador().getNick());
        this.setLocationRelativeTo(null);
        this.show();
    }

    public Ciudad getJugadoreremitente() {
        return jugadoreremitente;
    }

    public void setJugadoreremitente(Ciudad jugadoreremitente) {
        this.jugadoreremitente = jugadoreremitente;
    }

    public Ciudad getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Ciudad destinatario) {
        this.destinatario = destinatario;
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
        lblTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        cmdEnviarrecurso = new javax.swing.JButton();
        lblDestinatario = new javax.swing.JLabel();
        txtJugadorDestinatario = new javax.swing.JTextField();

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-1.png"))); // NOI18N

        lblTitulo.setText("Título");

        lblMensaje.setText("Mensaje");

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        jScrollPane1.setViewportView(txtMensaje);

        cmdEnviarrecurso.setText("Enviar Mensaje");
        cmdEnviarrecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarrecursoActionPerformed(evt);
            }
        });

        lblDestinatario.setText("Jugador Destinatario");

        txtJugadorDestinatario.setEditable(false);

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTitulo)
                                        .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtJugadorDestinatario)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(cmdEnviarrecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        panelImage1Layout.setVerticalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblDestinatario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtJugadorDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMensaje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdEnviarrecurso)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdEnviarrecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarrecursoActionPerformed
        Integer control = 0;
        if ("".equals(this.txtTitulo.getText())) {
            JOptionPane.showMessageDialog(panelImage1, "Debe ingresar el titulo del mensaje");
            control++;
        }
        if ("".equals(this.txtMensaje.getText())) {
            JOptionPane.showMessageDialog(panelImage1, "Debe llenar el mensaje");
            control++;
        }
        if (control == 0) {
            EnviarMensajeJugador enviarmensajeprivado = new EnviarMensajeJugador(this.jugadoreremitente, this.destinatario, this.txtMensaje.getText(), this.txtTitulo.getText());
            enviarmensajeprivado.CUenviarmensaje();
            this.hide();
        }


    }//GEN-LAST:event_cmdEnviarrecursoActionPerformed
    // End of variables declaration//GEN-END:variables
}