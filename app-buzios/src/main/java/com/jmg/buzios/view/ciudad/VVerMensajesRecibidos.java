/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.ciudad;

import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.jugador.MensajePrivado;
import com.jmg.buzios.view.islas.VEnviarMensaje;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class VVerMensajesRecibidos extends javax.swing.JFrame {
    private Ciudad ciudadjugador;
    private List<MensajePrivado> mensajes = new ArrayList<>();
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboMensajes;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label lblFecha;
    private java.awt.Label lblRemitente;
    private java.awt.Label lblTitulo;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTextPane txtMensaje;
    public VVerMensajesRecibidos(Ciudad ciudadjugador) {
        initComponents();
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N

        this.ciudadjugador = ciudadjugador;

        this.setLocationRelativeTo(null);
        this.show();
        MensajePrivado.inicializarmensajes( this.cboMensajes, this.mensajes, this.ciudadjugador.getJugador());
        if (this.mensajes.isEmpty()) {
            this.hide();

            JOptionPane.showMessageDialog(panelImage1, "No tienes mensajes privados recibidos.");
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
        cboMensajes = new javax.swing.JComboBox();
        label1 = new java.awt.Label();
        lblTitulo = new java.awt.Label();
        lblRemitente = new java.awt.Label();
        lblFecha = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboMensajes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMensajesItemStateChanged(evt);
            }
        });
        panelImage1.add(cboMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 344, -1));

        label1.setText("Mensajes Recibidos");
        panelImage1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 344, -1));

        lblTitulo.setText("Título");
        panelImage1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 344, -1));

        lblRemitente.setText("Remitente: ");
        panelImage1.add(lblRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 190, -1));

        lblFecha.setText("F/H:");
        panelImage1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 140, -1));

        txtMensaje.setEditable(false);
        jScrollPane2.setViewportView(txtMensaje);

        panelImage1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 344, 111));

        jButton1.setText("Responder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelImage1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 250, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMensajesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMensajesItemStateChanged

        int indice = this.cboMensajes.getSelectedIndex();

        this.lblTitulo.setText("TÍTULO: " + this.mensajes.get(indice).getTitulo());
        this.txtMensaje.setText(this.mensajes.get(indice).getMensaje());
        this.lblFecha.setText("" + this.mensajes.get(indice).getFecha() + " - " + this.mensajes.get(indice).getHora());
        this.lblRemitente.setText("REMITENTE: " + this.mensajes.get(indice).getJugemitente().getNick());
        this.repaint();


    }//GEN-LAST:event_cboMensajesItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VEnviarMensaje enviarmensaje = new VEnviarMensaje(this.ciudadjugador, this.mensajes.get(this.cboMensajes.getSelectedIndex()).getJugemitente());


    }//GEN-LAST:event_jButton1ActionPerformed
    // End of variables declaration//GEN-END:variables
}