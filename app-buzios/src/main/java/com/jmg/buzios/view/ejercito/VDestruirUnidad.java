/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.ejercito;

import com.jmg.buzios.controller.ejercito.DestruirUnidadMilitar;
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
public class VDestruirUnidad extends javax.swing.JFrame {

    private UnidadMilitar unidadmilitar;
    private List<Arma> armas;
    private List<Integer> cantidad;
    private VCiudad vciudad;
    private boolean destruir = true;
    /*atributos para Saquear Ciudad*/
    private List<UnidadMilitar> unidadesdejugador;
    private List<Arma> armasunidad;
    private List<Integer> cantidaddisponible;


    private UnidadMilitar unidadelegida;


    private List<Integer> cantidadaenviar;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDestruirUnidad;
    private javax.swing.JButton cmdDestruirUnidad1;
    private javax.swing.JButton cmdDestruirUnidad2;
    private javax.swing.JButton cmdDestruirUnidad3;
    private javax.swing.JButton cmdDestruirUnidad4;
    private org.edisoncor.gui.panel.PanelImage imagenArma;
    private org.edisoncor.gui.panel.PanelImage imagenArma1;
    private org.edisoncor.gui.panel.PanelImage imagenArma2;
    private org.edisoncor.gui.panel.PanelImage imagenArma3;
    private org.edisoncor.gui.panel.PanelImage imagenArmasasignadas;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadsinarma;
    private javax.swing.JLabel lblArma;
    private javax.swing.JLabel lblArma1;
    private javax.swing.JLabel lblArma2;
    private javax.swing.JLabel lblArma3;
    private javax.swing.JLabel lblCantidadSinArma;
    private javax.swing.JLabel lblCantidadarma;
    private javax.swing.JLabel lblCantidadarma1;
    private javax.swing.JLabel lblCantidadarma2;
    private javax.swing.JLabel lblCantidadarma3;
    private javax.swing.JLabel lblNombredeUnidadMilitar;
    private javax.swing.JLabel lblSUnidadMilitar;
    private javax.swing.JLabel lblUnidadMilitar;
    private javax.swing.JLabel lblUnidadsinarma;
    private javax.swing.JTextField txtCantidadadesasignar;
    private javax.swing.JTextField txtCantidadadesasignar1;
    private javax.swing.JTextField txtCantidadadesasignar2;
    private javax.swing.JTextField txtCantidadadesasignar3;
    private javax.swing.JTextField txtCantidadsinarma;

    public VDestruirUnidad(List<UnidadMilitar> unidadesdejugador, List<Arma> armasunidad, List<Integer> cantidaddisponible, List<Integer> cantidadaenviar, UnidadMilitar unidadelegida) {
        initComponents();
//		       panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N

        imagenArmasasignadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/backg-2.png"))); // NOI18N

        cmdDestruirUnidad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Desasignar.png"))); // NOI18N

        cmdDestruirUnidad2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Desasignar.png"))); // NOI18N

        cmdDestruirUnidad3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Desasignar.png"))); // NOI18N

        cmdDestruirUnidad4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Desasignar.png"))); // NOI18N

        cmdDestruirUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/Boton Desasignar.png"))); // NOI18N

        this.unidadesdejugador = unidadesdejugador;
        this.armasunidad = armasunidad;
        this.cantidaddisponible = cantidaddisponible;
        this.cantidadaenviar = cantidadaenviar;
        this.unidadelegida = unidadelegida;

        this.setLocationRelativeTo(null);
        this.show();
    }

    /***************************/


    public VDestruirUnidad(UnidadMilitar unidadmilitar, List<Arma> armas, List<Integer> cantidad, VCiudad vciudad) {
        initComponents();
        this.unidadmilitar = unidadmilitar;
        this.armas = armas;
        this.cantidad = cantidad;
        this.vciudad = vciudad;
        this.setLocationRelativeTo(null);
        this.show();
    }

    public void setDestruir(boolean destruirunidad) {
        this.destruir = destruirunidad;
        this.cmdDestruirUnidad.setText("Preparar");
        this.cmdDestruirUnidad1.setText("Preparar");
        this.cmdDestruirUnidad2.setText("Preparar");
        this.cmdDestruirUnidad3.setText("Preparar");
        this.cmdDestruirUnidad4.setText("Preparar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenArmasasignadas = new org.edisoncor.gui.panel.PanelImage();
        imagenArma = new org.edisoncor.gui.panel.PanelImage();
        lblArma = new javax.swing.JLabel();
        lblCantidadarma = new javax.swing.JLabel();
        cmdDestruirUnidad1 = new javax.swing.JButton();
        txtCantidadadesasignar = new javax.swing.JTextField();
        cmdDestruirUnidad2 = new javax.swing.JButton();
        txtCantidadadesasignar1 = new javax.swing.JTextField();
        lblCantidadarma1 = new javax.swing.JLabel();
        lblArma1 = new javax.swing.JLabel();
        imagenArma1 = new org.edisoncor.gui.panel.PanelImage();
        cmdDestruirUnidad3 = new javax.swing.JButton();
        txtCantidadadesasignar2 = new javax.swing.JTextField();
        lblCantidadarma2 = new javax.swing.JLabel();
        lblArma2 = new javax.swing.JLabel();
        imagenArma2 = new org.edisoncor.gui.panel.PanelImage();
        cmdDestruirUnidad4 = new javax.swing.JButton();
        txtCantidadadesasignar3 = new javax.swing.JTextField();
        lblCantidadarma3 = new javax.swing.JLabel();
        lblArma3 = new javax.swing.JLabel();
        imagenArma3 = new org.edisoncor.gui.panel.PanelImage();
        lblSUnidadMilitar = new javax.swing.JLabel();
        lblUnidadMilitar = new javax.swing.JLabel();
        lblNombredeUnidadMilitar = new javax.swing.JLabel();
        cmdDestruirUnidad = new javax.swing.JButton();
        txtCantidadsinarma = new javax.swing.JTextField();
        lblCantidadSinArma = new javax.swing.JLabel();
        lblUnidadsinarma = new javax.swing.JLabel();
        imagenUnidadsinarma = new org.edisoncor.gui.panel.PanelImage();

        imagenArmasasignadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenArmasasignadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/back-3.png"))); // NOI18N
        imagenArmasasignadas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenArma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArmaLayout = new javax.swing.GroupLayout(imagenArma);
        imagenArma.setLayout(imagenArmaLayout);
        imagenArmaLayout.setHorizontalGroup(
                imagenArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenArmaLayout.setVerticalGroup(
                imagenArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        imagenArmasasignadas.add(imagenArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 102, -1));

        lblArma.setText("Nombrearma");
        lblArma.setOpaque(true);
        imagenArmasasignadas.add(lblArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 102, -1));

        lblCantidadarma.setText("Cantidad");
        lblCantidadarma.setOpaque(true);
        imagenArmasasignadas.add(lblCantidadarma, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 102, -1));

        cmdDestruirUnidad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/boton destruir edificio.png"))); // NOI18N
        cmdDestruirUnidad1.setBorderPainted(false);
        cmdDestruirUnidad1.setContentAreaFilled(false);
        cmdDestruirUnidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDestruirUnidad1ActionPerformed(evt);
            }
        });
        imagenArmasasignadas.add(cmdDestruirUnidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 102, 20));

        txtCantidadadesasignar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadadesasignarKeyReleased(evt);
            }
        });
        imagenArmasasignadas.add(txtCantidadadesasignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 102, -1));

        cmdDestruirUnidad2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/boton destruir edificio.png"))); // NOI18N
        cmdDestruirUnidad2.setBorderPainted(false);
        cmdDestruirUnidad2.setContentAreaFilled(false);
        cmdDestruirUnidad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDestruirUnidad2ActionPerformed(evt);
            }
        });
        imagenArmasasignadas.add(cmdDestruirUnidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 102, 20));

        txtCantidadadesasignar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadadesasignar1KeyReleased(evt);
            }
        });
        imagenArmasasignadas.add(txtCantidadadesasignar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 102, -1));

        lblCantidadarma1.setText("Cantidad");
        lblCantidadarma1.setOpaque(true);
        imagenArmasasignadas.add(lblCantidadarma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 102, -1));

        lblArma1.setText("Nombrearma");
        lblArma1.setOpaque(true);
        imagenArmasasignadas.add(lblArma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 102, -1));

        imagenArma1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArma1Layout = new javax.swing.GroupLayout(imagenArma1);
        imagenArma1.setLayout(imagenArma1Layout);
        imagenArma1Layout.setHorizontalGroup(
                imagenArma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenArma1Layout.setVerticalGroup(
                imagenArma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        imagenArmasasignadas.add(imagenArma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 102, -1));

        cmdDestruirUnidad3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/boton destruir edificio.png"))); // NOI18N
        cmdDestruirUnidad3.setBorderPainted(false);
        cmdDestruirUnidad3.setContentAreaFilled(false);
        cmdDestruirUnidad3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDestruirUnidad3ActionPerformed(evt);
            }
        });
        imagenArmasasignadas.add(cmdDestruirUnidad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 102, 20));

        txtCantidadadesasignar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadadesasignar2KeyReleased(evt);
            }
        });
        imagenArmasasignadas.add(txtCantidadadesasignar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 102, -1));

        lblCantidadarma2.setText("Cantidad");
        lblCantidadarma2.setOpaque(true);
        imagenArmasasignadas.add(lblCantidadarma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 102, -1));

        lblArma2.setText("Nombrearma");
        lblArma2.setOpaque(true);
        imagenArmasasignadas.add(lblArma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 102, -1));

        imagenArma2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArma2Layout = new javax.swing.GroupLayout(imagenArma2);
        imagenArma2.setLayout(imagenArma2Layout);
        imagenArma2Layout.setHorizontalGroup(
                imagenArma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenArma2Layout.setVerticalGroup(
                imagenArma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        imagenArmasasignadas.add(imagenArma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 102, -1));

        cmdDestruirUnidad4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/boton destruir edificio.png"))); // NOI18N
        cmdDestruirUnidad4.setBorderPainted(false);
        cmdDestruirUnidad4.setContentAreaFilled(false);
        cmdDestruirUnidad4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDestruirUnidad4ActionPerformed(evt);
            }
        });
        imagenArmasasignadas.add(cmdDestruirUnidad4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 102, 20));

        txtCantidadadesasignar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadadesasignar3KeyReleased(evt);
            }
        });
        imagenArmasasignadas.add(txtCantidadadesasignar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 102, -1));

        lblCantidadarma3.setText("Cantidad");
        lblCantidadarma3.setOpaque(true);
        imagenArmasasignadas.add(lblCantidadarma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 102, -1));

        lblArma3.setText("Nombrearma");
        lblArma3.setOpaque(true);
        imagenArmasasignadas.add(lblArma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 102, -1));

        imagenArma3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArma3Layout = new javax.swing.GroupLayout(imagenArma3);
        imagenArma3.setLayout(imagenArma3Layout);
        imagenArma3Layout.setHorizontalGroup(
                imagenArma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenArma3Layout.setVerticalGroup(
                imagenArma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        imagenArmasasignadas.add(imagenArma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 102, -1));

        lblSUnidadMilitar.setText("Nombre Unidad");
        imagenArmasasignadas.add(lblSUnidadMilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 102, -1));
        imagenArmasasignadas.add(lblUnidadMilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 12, 210, -1));

        lblNombredeUnidadMilitar.setText("Nombre Unidad");
        imagenArmasasignadas.add(lblNombredeUnidadMilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 160, -1));

        cmdDestruirUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/boton destruir edificio.png"))); // NOI18N
        cmdDestruirUnidad.setBorderPainted(false);
        cmdDestruirUnidad.setContentAreaFilled(false);
        cmdDestruirUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDestruirUnidadActionPerformed(evt);
            }
        });
        imagenArmasasignadas.add(cmdDestruirUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 102, 20));

        txtCantidadsinarma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadsinarmaKeyReleased(evt);
            }
        });
        imagenArmasasignadas.add(txtCantidadsinarma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 102, -1));

        lblCantidadSinArma.setText("Cantidad");
        lblCantidadSinArma.setOpaque(true);
        imagenArmasasignadas.add(lblCantidadSinArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 102, -1));

        lblUnidadsinarma.setText("Unidad Sin arma");
        lblUnidadsinarma.setOpaque(true);
        imagenArmasasignadas.add(lblUnidadsinarma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 102, -1));

        imagenUnidadsinarma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenUnidadsinarmaLayout = new javax.swing.GroupLayout(imagenUnidadsinarma);
        imagenUnidadsinarma.setLayout(imagenUnidadsinarmaLayout);
        imagenUnidadsinarmaLayout.setHorizontalGroup(
                imagenUnidadsinarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenUnidadsinarmaLayout.setVerticalGroup(
                imagenUnidadsinarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        imagenArmasasignadas.add(imagenUnidadsinarma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 102, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(imagenArmasasignadas, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(imagenArmasasignadas, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public UnidadMilitar getUnidadmilitar() {
        return unidadmilitar;
    }

    public JButton getCmdDestruirUnidad() {
        return cmdDestruirUnidad;
    }

    public JButton getCmdDestruirUnidad1() {
        return cmdDestruirUnidad1;
    }

    public JButton getCmdDestruirUnidad2() {
        return cmdDestruirUnidad2;
    }

    public JButton getCmdDestruirUnidad3() {
        return cmdDestruirUnidad3;
    }

    public JButton getCmdDestruirUnidad4() {
        return cmdDestruirUnidad4;
    }

    public PanelImage getImagenArma() {
        return imagenArma;
    }

    public PanelImage getImagenArma1() {
        return imagenArma1;
    }

    public PanelImage getImagenArma2() {
        return imagenArma2;
    }

    public PanelImage getImagenArma3() {
        return imagenArma3;
    }

    public PanelImage getImagenUnidadsinarma() {
        return imagenUnidadsinarma;
    }

    public JLabel getLblArma() {
        return lblArma;
    }

    public JLabel getLblArma1() {
        return lblArma1;
    }

    public JLabel getLblArma2() {
        return lblArma2;
    }

    public JLabel getLblArma3() {
        return lblArma3;
    }

    public JLabel getLblCantidadSinArma() {
        return lblCantidadSinArma;
    }

    public JLabel getLblCantidadarma() {
        return lblCantidadarma;
    }

    public JLabel getLblCantidadarma1() {
        return lblCantidadarma1;
    }

    public JLabel getLblCantidadarma2() {
        return lblCantidadarma2;
    }

    public JLabel getLblCantidadarma3() {
        return lblCantidadarma3;
    }

    public JLabel getLblNombredeUnidadMilitar() {
        return lblNombredeUnidadMilitar;
    }

    public JLabel getLblSUnidadMilitar() {
        return lblSUnidadMilitar;
    }

    public JLabel getLblUnidadMilitar() {
        return lblUnidadMilitar;
    }

    public JLabel getLblUnidadsinarma() {
        return lblUnidadsinarma;
    }

    public JTextField getTxtCantidadadesasignar() {
        return txtCantidadadesasignar;
    }

    public JTextField getTxtCantidadadesasignar1() {
        return txtCantidadadesasignar1;
    }

    public JTextField getTxtCantidadadesasignar2() {
        return txtCantidadadesasignar2;
    }

    public JTextField getTxtCantidadadesasignar3() {
        return txtCantidadadesasignar3;
    }

    public JTextField getTxtCantidadsinarma() {
        return txtCantidadsinarma;
    }

    private void cmdDestruirUnidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDestruirUnidad1ActionPerformed
        if (destruir == true) {
            try {
                DestruirUnidadMilitar destruirunidad = new DestruirUnidadMilitar(this.unidadmilitar, this.armas.get(0), Integer.parseInt(this.txtCantidadadesasignar.getText()), this.vciudad);
                destruirunidad.CUDestruirUnidadMilitar();
                this.hide();
            } catch (SQLException ex) {

            }
        } else {
            this.asignar_unidades_con_arma(this.lblArma.getText(), Integer.parseInt(this.txtCantidadadesasignar.getText()));

        }
    }//GEN-LAST:event_cmdDestruirUnidad1ActionPerformed

    private void txtCantidadadesasignarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadadesasignarKeyReleased
        int numero;
        try {
            numero = Integer.parseInt(this.txtCantidadadesasignar.getText());
            if ((Integer.parseInt(this.txtCantidadadesasignar.getText())) <= (Integer.parseInt(this.lblCantidadarma.getText()))) {
                this.txtCantidadadesasignar.setText(numero + "");
            } else {
                this.txtCantidadadesasignar.setText("");
            }

        } catch (NumberFormatException j) {
            this.txtCantidadadesasignar.setText("");
        }
    }//GEN-LAST:event_txtCantidadadesasignarKeyReleased

    private void cmdDestruirUnidad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDestruirUnidad2ActionPerformed
        if (destruir == true) {
            try {
                DestruirUnidadMilitar destruirunidad = new DestruirUnidadMilitar(this.unidadmilitar, this.armas.get(1), Integer.parseInt(this.txtCantidadadesasignar1.getText()), this.vciudad);
                destruirunidad.CUDestruirUnidadMilitar();
                this.hide();
            } catch (SQLException ex) {

            }
        } else {
            this.asignar_unidades_con_arma(this.lblArma1.getText(), Integer.parseInt(this.txtCantidadadesasignar1.getText()));

        }
    }//GEN-LAST:event_cmdDestruirUnidad2ActionPerformed

    private void txtCantidadadesasignar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadadesasignar1KeyReleased
        int numero;
        try {
            numero = Integer.parseInt(this.txtCantidadadesasignar1.getText());
            if ((Integer.parseInt(this.txtCantidadadesasignar1.getText())) <= (Integer.parseInt(this.lblCantidadarma.getText()))) {
                this.txtCantidadadesasignar1.setText(numero + "");
            } else {
                this.txtCantidadadesasignar1.setText("");
            }

        } catch (NumberFormatException j) {
            this.txtCantidadadesasignar1.setText("");
        }
    }//GEN-LAST:event_txtCantidadadesasignar1KeyReleased

    private void cmdDestruirUnidad3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDestruirUnidad3ActionPerformed
        if (destruir == true) {
            try {
                DestruirUnidadMilitar destruirunidad = new DestruirUnidadMilitar(this.unidadmilitar, this.armas.get(2), Integer.parseInt(this.txtCantidadadesasignar2.getText()), this.vciudad);
                destruirunidad.CUDestruirUnidadMilitar();
                this.hide();
            } catch (SQLException ex) {

            }
        } else {
            this.asignar_unidades_con_arma(this.lblArma2.getText(), Integer.parseInt(this.txtCantidadadesasignar2.getText()));

        }
    }//GEN-LAST:event_cmdDestruirUnidad3ActionPerformed

    private void txtCantidadadesasignar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadadesasignar2KeyReleased
        int numero;
        try {
            numero = Integer.parseInt(this.txtCantidadadesasignar2.getText());
            if ((Integer.parseInt(this.txtCantidadadesasignar2.getText())) <= (Integer.parseInt(this.lblCantidadarma.getText()))) {
                this.txtCantidadadesasignar2.setText(numero + "");
            } else {
                this.txtCantidadadesasignar2.setText("");
            }

        } catch (NumberFormatException j) {
            this.txtCantidadadesasignar2.setText("");
        }
    }//GEN-LAST:event_txtCantidadadesasignar2KeyReleased

    private void cmdDestruirUnidad4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDestruirUnidad4ActionPerformed
        if (destruir == true) {
            try {
                DestruirUnidadMilitar destruirunidad = new DestruirUnidadMilitar(this.unidadmilitar, this.armas.get(3), Integer.parseInt(this.txtCantidadadesasignar3.getText()), this.vciudad);
                destruirunidad.CUDestruirUnidadMilitar();
                this.hide();
            } catch (SQLException ex) {

            }
        } else {
            this.asignar_unidades_con_arma(this.lblArma3.getText(), Integer.parseInt(this.txtCantidadadesasignar3.getText()));

        }

    }//GEN-LAST:event_cmdDestruirUnidad4ActionPerformed

    private void txtCantidadadesasignar3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadadesasignar3KeyReleased
        int numero;
        try {
            numero = Integer.parseInt(this.txtCantidadadesasignar3.getText());
            if ((Integer.parseInt(this.txtCantidadadesasignar3.getText())) <= (Integer.parseInt(this.lblCantidadarma.getText()))) {
                this.txtCantidadadesasignar3.setText(numero + "");
            } else {
                this.txtCantidadadesasignar3.setText("");
            }

        } catch (NumberFormatException j) {
            this.txtCantidadadesasignar3.setText("");
        }


    }//GEN-LAST:event_txtCantidadadesasignar3KeyReleased

    private void cmdDestruirUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDestruirUnidadActionPerformed
        if (destruir == true) {
            try {
                DestruirUnidadMilitar destruirunidad = new DestruirUnidadMilitar(this.unidadmilitar, null, Integer.parseInt(this.txtCantidadsinarma.getText()), this.vciudad);
                destruirunidad.CUDestruirUnidadMilitar();
                this.hide();
            } catch (SQLException ex) {

            }
        } else {
            this.asignar_unidades_sinarma(Integer.parseInt(this.txtCantidadsinarma.getText()));

        }
    }//GEN-LAST:event_cmdDestruirUnidadActionPerformed

    private void txtCantidadsinarmaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadsinarmaKeyReleased
        int numero;
        try {
            numero = Integer.parseInt(this.txtCantidadsinarma.getText());
            if ((Integer.parseInt(this.txtCantidadsinarma.getText())) <= (Integer.parseInt(this.lblCantidadSinArma.getText()))) {
                this.txtCantidadsinarma.setText(numero + "");
            } else {
                this.txtCantidadsinarma.setText("");
            }

        } catch (NumberFormatException j) {
            this.txtCantidadsinarma.setText("");
        }
    }//GEN-LAST:event_txtCantidadsinarmaKeyReleased
    // End of variables declaration//GEN-END:variables

    private void asignar_unidades_sinarma(int cantidadasignar) {
        for (int i = 0; i < this.unidadesdejugador.size(); i++) {
            if ((this.unidadesdejugador.get(i).getNombre().equals(this.unidadelegida.getNombre())) && (this.armasunidad.get(i) == null)) {
                this.cantidadaenviar.set(i, cantidadasignar);
            }
        }

    }

    private void asignar_unidades_con_arma(String nombrearmaenviada, int cantidadasignar) {

        for (int i = 0; i < this.unidadesdejugador.size(); i++) {
            if (this.armasunidad.get(i) != null) {
                if ((this.unidadesdejugador.get(i).getNombre().equals(this.unidadelegida.getNombre())) && (this.armasunidad.get(i).getNombrearma().equals(nombrearmaenviada))) {
                    this.cantidadaenviar.set(i, cantidadasignar);
                    JOptionPane.showMessageDialog(rootPane, "Unidades Listas!!!");
                }
            }
        }
    }


}


