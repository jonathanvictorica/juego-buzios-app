/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.islas;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.controller.ejercito.VerDestruirUnidad;
import com.jmg.buzios.controller.militar.EnviarUnidades;
import com.jmg.buzios.controller.militar.PlanificarSaqueo;
import com.jmg.buzios.model.ciudad.Ciudad;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alumno
 */
public class VPlanificarUnidadMilitar extends javax.swing.JFrame implements Actualizar {


    private List<UnidadMilitar> unidadesmilitares = new ArrayList<>();
    private List<Arma> armas = new ArrayList<>();
    private List<Integer> cantidaddearma = new ArrayList<>();


    private List<Integer> cantidadaenviada = new ArrayList<>();

    private UnidadMilitar unidadelegida;

    private Ciudad ciudadjugador;

    private Ciudad ciudadelegida;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdEnviarUnidades;
    private javax.swing.JButton cmdEnviarUnidades1;
    private javax.swing.JButton cmdEnviarUnidades10;
    private javax.swing.JButton cmdEnviarUnidades11;
    private javax.swing.JButton cmdEnviarUnidades2;
    private javax.swing.JButton cmdEnviarUnidades3;
    private javax.swing.JButton cmdEnviarUnidades4;
    private javax.swing.JButton cmdEnviarUnidades5;
    private javax.swing.JButton cmdEnviarUnidades6;
    private javax.swing.JButton cmdEnviarUnidades7;
    private javax.swing.JButton cmdEnviarUnidades8;
    private javax.swing.JButton cmdEnviarUnidades9;
    private javax.swing.JButton cmdEnviarUnidadesMilitares;
    private javax.swing.JButton cmdPlanificarSaqueo;
    private org.edisoncor.gui.panel.PanelImage imagenBarco;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar1;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar10;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar11;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar2;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar3;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar4;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar5;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar6;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar7;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar8;
    private org.edisoncor.gui.panel.PanelImage imagenUnidadmilitar9;
    private javax.swing.JLabel lblCantidadBarcos;
    private javax.swing.JLabel lblUnidadmilitar;
    private javax.swing.JLabel lblUnidadmilitar1;
    private javax.swing.JLabel lblUnidadmilitar10;
    private javax.swing.JLabel lblUnidadmilitar11;
    private javax.swing.JLabel lblUnidadmilitar2;
    private javax.swing.JLabel lblUnidadmilitar3;
    private javax.swing.JLabel lblUnidadmilitar4;
    private javax.swing.JLabel lblUnidadmilitar5;
    private javax.swing.JLabel lblUnidadmilitar6;
    private javax.swing.JLabel lblUnidadmilitar7;
    private javax.swing.JLabel lblUnidadmilitar8;
    private javax.swing.JLabel lblUnidadmilitar9;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private javax.swing.JTextField txtCantidadBarcos;

    public VPlanificarUnidadMilitar(Ciudad ciudadjugador, Ciudad ciudadelegida, boolean apostartropas) {
        initComponents();
        this.ciudadjugador = ciudadjugador;
        this.ciudadelegida = ciudadelegida;
        for (int i = 0; i < this.ciudadjugador.getCiudadejercito().getUnidad().size(); i++) {
            if (!this.ciudadjugador.getCiudadejercito().getUnidad().get(i).isBarco()) {
                this.unidadesmilitares.add(this.ciudadjugador.getCiudadejercito().getUnidad().get(i));
                this.armas.add(null);
                this.cantidaddearma.add(this.ciudadjugador.getCiudadejercito().getUnidadessinarmadisponible().get(i));

                this.cantidadaenviada.add(0);

                for (int j = 0; j < this.ciudadjugador.getCiudadejercito().getArmasdeunidad().get(i).getArma().size(); j++) {
                    this.unidadesmilitares.add(this.ciudadjugador.getCiudadejercito().getUnidad().get(i));
                    this.armas.add(this.ciudadjugador.getCiudadejercito().getArmasdeunidad().get(i).getArma().get(j));
                    this.cantidaddearma.add(this.ciudadjugador.getCiudadejercito().getArmasdeunidad().get(i).getCapacidaddisponibleenciudad().get(j));
                    this.cantidadaenviada.add(0);
                }

            }
        }
        this.actualizarinterfazgrafica();

        if (apostartropas) {
            this.cmdEnviarUnidadesMilitares.setVisible(true);
            this.cmdPlanificarSaqueo.setVisible(false);
        } else {
            this.cmdEnviarUnidadesMilitares.setVisible(false);
            this.cmdPlanificarSaqueo.setVisible(true);
        }

        this.setLocationRelativeTo(null);
        this.show();


    }

    public JButton getCmdEnviarUnidadesMilitares() {
        return cmdEnviarUnidadesMilitares;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        imagenUnidadmilitar = new org.edisoncor.gui.panel.PanelImage();
        imagenUnidadmilitar1 = new org.edisoncor.gui.panel.PanelImage();
        imagenUnidadmilitar2 = new org.edisoncor.gui.panel.PanelImage();
        imagenUnidadmilitar3 = new org.edisoncor.gui.panel.PanelImage();
        imagenUnidadmilitar4 = new org.edisoncor.gui.panel.PanelImage();
        lblUnidadmilitar3 = new javax.swing.JLabel();
        lblUnidadmilitar4 = new javax.swing.JLabel();
        cmdEnviarUnidades4 = new javax.swing.JButton();
        imagenUnidadmilitar10 = new org.edisoncor.gui.panel.PanelImage();
        lblUnidadmilitar10 = new javax.swing.JLabel();
        cmdEnviarUnidades10 = new javax.swing.JButton();
        cmdEnviarUnidades9 = new javax.swing.JButton();
        lblUnidadmilitar9 = new javax.swing.JLabel();
        imagenUnidadmilitar9 = new org.edisoncor.gui.panel.PanelImage();
        cmdEnviarUnidades3 = new javax.swing.JButton();
        cmdEnviarUnidades2 = new javax.swing.JButton();
        lblUnidadmilitar2 = new javax.swing.JLabel();
        lblUnidadmilitar1 = new javax.swing.JLabel();
        lblUnidadmilitar = new javax.swing.JLabel();
        cmdEnviarUnidades = new javax.swing.JButton();
        cmdEnviarUnidades1 = new javax.swing.JButton();
        imagenUnidadmilitar7 = new org.edisoncor.gui.panel.PanelImage();
        imagenUnidadmilitar6 = new org.edisoncor.gui.panel.PanelImage();
        lblUnidadmilitar6 = new javax.swing.JLabel();
        cmdEnviarUnidades6 = new javax.swing.JButton();
        cmdEnviarUnidades7 = new javax.swing.JButton();
        lblUnidadmilitar7 = new javax.swing.JLabel();
        lblUnidadmilitar8 = new javax.swing.JLabel();
        imagenUnidadmilitar8 = new org.edisoncor.gui.panel.PanelImage();
        cmdEnviarUnidades8 = new javax.swing.JButton();
        cmdEnviarUnidades11 = new javax.swing.JButton();
        lblUnidadmilitar11 = new javax.swing.JLabel();
        imagenUnidadmilitar11 = new org.edisoncor.gui.panel.PanelImage();
        cmdEnviarUnidades5 = new javax.swing.JButton();
        lblUnidadmilitar5 = new javax.swing.JLabel();
        imagenUnidadmilitar5 = new org.edisoncor.gui.panel.PanelImage();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        imagenBarco = new org.edisoncor.gui.panel.PanelImage();
        cmdPlanificarSaqueo = new javax.swing.JButton();
        txtCantidadBarcos = new javax.swing.JTextField();
        lblCantidadBarcos = new javax.swing.JLabel();
        cmdEnviarUnidadesMilitares = new javax.swing.JButton();

        panelImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panelImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        imagenUnidadmilitar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        imagenUnidadmilitar4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenUnidadmilitar4Layout = new javax.swing.GroupLayout(imagenUnidadmilitar4);
        imagenUnidadmilitar4.setLayout(imagenUnidadmilitar4Layout);
        imagenUnidadmilitar4Layout.setHorizontalGroup(
                imagenUnidadmilitar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );
        imagenUnidadmilitar4Layout.setVerticalGroup(
                imagenUnidadmilitar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );

        lblUnidadmilitar3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar3.setText("Espadachin");
        lblUnidadmilitar3.setEnabled(false);
        lblUnidadmilitar3.setFocusable(false);

        lblUnidadmilitar4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar4.setText("Fusilero");
        lblUnidadmilitar4.setEnabled(false);
        lblUnidadmilitar4.setFocusable(false);

        cmdEnviarUnidades4.setText("Preparar Unidades");
        cmdEnviarUnidades4.setEnabled(false);
        cmdEnviarUnidades4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades4ActionPerformed(evt);
            }
        });

        imagenUnidadmilitar10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenUnidadmilitar10Layout = new javax.swing.GroupLayout(imagenUnidadmilitar10);
        imagenUnidadmilitar10.setLayout(imagenUnidadmilitar10Layout);
        imagenUnidadmilitar10Layout.setHorizontalGroup(
                imagenUnidadmilitar10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );
        imagenUnidadmilitar10Layout.setVerticalGroup(
                imagenUnidadmilitar10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 134, Short.MAX_VALUE)
        );

        lblUnidadmilitar10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar10.setText("Lancero");
        lblUnidadmilitar10.setEnabled(false);
        lblUnidadmilitar10.setFocusable(false);

        cmdEnviarUnidades10.setText("Preparar Unidades");
        cmdEnviarUnidades10.setEnabled(false);
        cmdEnviarUnidades10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades10ActionPerformed(evt);
            }
        });

        cmdEnviarUnidades9.setText("Preparar Unidades");
        cmdEnviarUnidades9.setEnabled(false);
        cmdEnviarUnidades9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades9ActionPerformed(evt);
            }
        });

        lblUnidadmilitar9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar9.setText("Hoplita");
        lblUnidadmilitar9.setEnabled(false);
        lblUnidadmilitar9.setFocusable(false);

        imagenUnidadmilitar9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenUnidadmilitar9Layout = new javax.swing.GroupLayout(imagenUnidadmilitar9);
        imagenUnidadmilitar9.setLayout(imagenUnidadmilitar9Layout);
        imagenUnidadmilitar9Layout.setHorizontalGroup(
                imagenUnidadmilitar9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );
        imagenUnidadmilitar9Layout.setVerticalGroup(
                imagenUnidadmilitar9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 134, Short.MAX_VALUE)
        );

        cmdEnviarUnidades3.setText("Preparar Unidades");
        cmdEnviarUnidades3.setEnabled(false);
        cmdEnviarUnidades3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades3ActionPerformed(evt);
            }
        });

        cmdEnviarUnidades2.setText("Preparar Unidades");
        cmdEnviarUnidades2.setEnabled(false);
        cmdEnviarUnidades2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades2ActionPerformed(evt);
            }
        });

        lblUnidadmilitar2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar2.setText("Catapulta");
        lblUnidadmilitar2.setEnabled(false);
        lblUnidadmilitar2.setFocusable(false);

        lblUnidadmilitar1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar1.setText("Arquero");
        lblUnidadmilitar1.setEnabled(false);
        lblUnidadmilitar1.setFocusable(false);

        lblUnidadmilitar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar.setText("Ariete");
        lblUnidadmilitar.setEnabled(false);
        lblUnidadmilitar.setFocusable(false);

        cmdEnviarUnidades.setText("Preparar Unidades");
        cmdEnviarUnidades.setEnabled(false);
        cmdEnviarUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidadesActionPerformed(evt);
            }
        });

        cmdEnviarUnidades1.setText("Preparar Unidades");
        cmdEnviarUnidades1.setEnabled(false);
        cmdEnviarUnidades1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades1ActionPerformed(evt);
            }
        });

        imagenUnidadmilitar7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenUnidadmilitar7Layout = new javax.swing.GroupLayout(imagenUnidadmilitar7);
        imagenUnidadmilitar7.setLayout(imagenUnidadmilitar7Layout);
        imagenUnidadmilitar7Layout.setHorizontalGroup(
                imagenUnidadmilitar7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );
        imagenUnidadmilitar7Layout.setVerticalGroup(
                imagenUnidadmilitar7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 134, Short.MAX_VALUE)
        );

        imagenUnidadmilitar6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenUnidadmilitar6Layout = new javax.swing.GroupLayout(imagenUnidadmilitar6);
        imagenUnidadmilitar6.setLayout(imagenUnidadmilitar6Layout);
        imagenUnidadmilitar6Layout.setHorizontalGroup(
                imagenUnidadmilitar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );
        imagenUnidadmilitar6Layout.setVerticalGroup(
                imagenUnidadmilitar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 134, Short.MAX_VALUE)
        );

        lblUnidadmilitar6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar6.setText("Girocóptero");
        lblUnidadmilitar6.setEnabled(false);
        lblUnidadmilitar6.setFocusable(false);

        cmdEnviarUnidades6.setText("Preparar Unidades");
        cmdEnviarUnidades6.setEnabled(false);
        cmdEnviarUnidades6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades6ActionPerformed(evt);
            }
        });

        cmdEnviarUnidades7.setText("Preparar Unidades");
        cmdEnviarUnidades7.setEnabled(false);
        cmdEnviarUnidades7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades7ActionPerformed(evt);
            }
        });

        lblUnidadmilitar7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar7.setText("Globo Bombardero");
        lblUnidadmilitar7.setEnabled(false);
        lblUnidadmilitar7.setFocusable(false);

        lblUnidadmilitar8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar8.setText("Hondero");
        lblUnidadmilitar8.setEnabled(false);
        lblUnidadmilitar8.setFocusable(false);

        imagenUnidadmilitar8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenUnidadmilitar8Layout = new javax.swing.GroupLayout(imagenUnidadmilitar8);
        imagenUnidadmilitar8.setLayout(imagenUnidadmilitar8Layout);
        imagenUnidadmilitar8Layout.setHorizontalGroup(
                imagenUnidadmilitar8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );
        imagenUnidadmilitar8Layout.setVerticalGroup(
                imagenUnidadmilitar8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 134, Short.MAX_VALUE)
        );

        cmdEnviarUnidades8.setText("Preparar Unidades");
        cmdEnviarUnidades8.setEnabled(false);
        cmdEnviarUnidades8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades8ActionPerformed(evt);
            }
        });

        cmdEnviarUnidades11.setText("Preparar Unidades");
        cmdEnviarUnidades11.setEnabled(false);
        cmdEnviarUnidades11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades11ActionPerformed(evt);
            }
        });

        lblUnidadmilitar11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar11.setText("jLabel1");
        lblUnidadmilitar11.setEnabled(false);
        lblUnidadmilitar11.setFocusable(false);

        imagenUnidadmilitar11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenUnidadmilitar11Layout = new javax.swing.GroupLayout(imagenUnidadmilitar11);
        imagenUnidadmilitar11.setLayout(imagenUnidadmilitar11Layout);
        imagenUnidadmilitar11Layout.setHorizontalGroup(
                imagenUnidadmilitar11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );
        imagenUnidadmilitar11Layout.setVerticalGroup(
                imagenUnidadmilitar11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 134, Short.MAX_VALUE)
        );

        cmdEnviarUnidades5.setText("Preparar Unidades");
        cmdEnviarUnidades5.setEnabled(false);
        cmdEnviarUnidades5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidades5ActionPerformed(evt);
            }
        });

        lblUnidadmilitar5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUnidadmilitar5.setText("Gigante a Vapor");
        lblUnidadmilitar5.setEnabled(false);
        lblUnidadmilitar5.setFocusable(false);

        imagenUnidadmilitar5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenUnidadmilitar5Layout = new javax.swing.GroupLayout(imagenUnidadmilitar5);
        imagenUnidadmilitar5.setLayout(imagenUnidadmilitar5Layout);
        imagenUnidadmilitar5Layout.setHorizontalGroup(
                imagenUnidadmilitar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );
        imagenUnidadmilitar5Layout.setVerticalGroup(
                imagenUnidadmilitar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 136, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                                .addComponent(cmdEnviarUnidades6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmdEnviarUnidades7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmdEnviarUnidades8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmdEnviarUnidades9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmdEnviarUnidades10, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmdEnviarUnidades11, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(cmdEnviarUnidades, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(imagenUnidadmilitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblUnidadmilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(imagenUnidadmilitar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblUnidadmilitar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cmdEnviarUnidades1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblUnidadmilitar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(imagenUnidadmilitar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cmdEnviarUnidades2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblUnidadmilitar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(imagenUnidadmilitar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cmdEnviarUnidades3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                                                .addComponent(imagenUnidadmilitar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(imagenUnidadmilitar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                                                .addComponent(cmdEnviarUnidades4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cmdEnviarUnidades5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(lblUnidadmilitar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(imagenUnidadmilitar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblUnidadmilitar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(imagenUnidadmilitar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                                                .addGap(288, 288, 288)
                                                                .addComponent(lblUnidadmilitar4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblUnidadmilitar5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(lblUnidadmilitar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(imagenUnidadmilitar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                                                                .addComponent(imagenUnidadmilitar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(imagenUnidadmilitar10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(imagenUnidadmilitar11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                                                                .addComponent(lblUnidadmilitar9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(lblUnidadmilitar10, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(10, 10, 10)
                                                                                .addComponent(lblUnidadmilitar11, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap())
        );
        panelImage1Layout.setVerticalGroup(
                panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(imagenUnidadmilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imagenUnidadmilitar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imagenUnidadmilitar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imagenUnidadmilitar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imagenUnidadmilitar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imagenUnidadmilitar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUnidadmilitar)
                                        .addComponent(lblUnidadmilitar1)
                                        .addComponent(lblUnidadmilitar2)
                                        .addComponent(lblUnidadmilitar3)
                                        .addComponent(lblUnidadmilitar4)
                                        .addComponent(lblUnidadmilitar5))
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(imagenUnidadmilitar11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(imagenUnidadmilitar10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(imagenUnidadmilitar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(imagenUnidadmilitar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(imagenUnidadmilitar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cmdEnviarUnidades)
                                                        .addComponent(cmdEnviarUnidades1)
                                                        .addComponent(cmdEnviarUnidades2)
                                                        .addComponent(cmdEnviarUnidades3)
                                                        .addComponent(cmdEnviarUnidades4)
                                                        .addComponent(cmdEnviarUnidades5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(imagenUnidadmilitar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblUnidadmilitar8, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblUnidadmilitar6)
                                                        .addComponent(lblUnidadmilitar7))
                                                .addComponent(lblUnidadmilitar9, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblUnidadmilitar10, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent(lblUnidadmilitar11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmdEnviarUnidades6)
                                        .addComponent(cmdEnviarUnidades7)
                                        .addComponent(cmdEnviarUnidades8)
                                        .addComponent(cmdEnviarUnidades9)
                                        .addComponent(cmdEnviarUnidades10)
                                        .addComponent(cmdEnviarUnidades11))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelImage3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        imagenBarco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenBarcoLayout = new javax.swing.GroupLayout(imagenBarco);
        imagenBarco.setLayout(imagenBarcoLayout);
        imagenBarcoLayout.setHorizontalGroup(
                imagenBarcoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 77, Short.MAX_VALUE)
        );
        imagenBarcoLayout.setVerticalGroup(
                imagenBarcoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 72, Short.MAX_VALUE)
        );

        cmdPlanificarSaqueo.setText("Saquear Ciudad");
        cmdPlanificarSaqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPlanificarSaqueoActionPerformed(evt);
            }
        });

        txtCantidadBarcos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadBarcosKeyReleased(evt);
            }
        });

        lblCantidadBarcos.setText("Cantidad de Barcos");

        cmdEnviarUnidadesMilitares.setText("Apostar Unidades");
        cmdEnviarUnidadesMilitares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarUnidadesMilitaresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
                panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imagenBarco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblCantidadBarcos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCantidadBarcos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdEnviarUnidadesMilitares, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165)
                                .addComponent(cmdPlanificarSaqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        panelImage3Layout.setVerticalGroup(
                panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelImage3Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cmdPlanificarSaqueo)
                                                        .addComponent(cmdEnviarUnidadesMilitares)))
                                        .addGroup(panelImage3Layout.createSequentialGroup()
                                                .addGroup(panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(imagenBarco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(panelImage3Layout.createSequentialGroup()
                                                                .addGap(11, 11, 11)
                                                                .addComponent(lblCantidadBarcos)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtCantidadBarcos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
                panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelImage2Layout.setVerticalGroup(
                panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelImage2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actualizardatospantalla() {

    }

    @Override
    public void actualizarinterfazgrafica() {
        List<String> nombreunidades = new ArrayList<>();

        for (int i = 0; i < this.ciudadjugador.getCiudadejercito().getUnidad().size(); i++) {
            if (!this.ciudadjugador.getCiudadejercito().getUnidad().get(i).isBarco()) {
                nombreunidades.add(this.ciudadjugador.getCiudadejercito().getUnidad().get(i).getNombre());
            }
        }

        for (int i = 0; i < nombreunidades.size(); i++) {
            switch (nombreunidades.get(i)) {
                case "Ariete":
                    this.imagenUnidadmilitar.setEnabled(true);
                    this.getLblUnidadmilitar().setEnabled(true);
                    this.cmdEnviarUnidades.setEnabled(true);
                    break;
                case "Arquero":
                    this.imagenUnidadmilitar1.setEnabled(true);
                    this.getLblUnidadmilitar1().setEnabled(true);
                    this.cmdEnviarUnidades1.setEnabled(true);
                    break;
                case "Catapulta":
                    this.imagenUnidadmilitar2.setEnabled(true);
                    this.getLblUnidadmilitar2().setEnabled(true);
                    this.cmdEnviarUnidades2.setEnabled(true);
                    break;
                case "Espadachin":
                    this.imagenUnidadmilitar3.setEnabled(true);
                    this.getLblUnidadmilitar3().setEnabled(true);
                    this.cmdEnviarUnidades3.setEnabled(true);
                    break;
                case "Fusilero":
                    this.imagenUnidadmilitar4.setEnabled(true);
                    this.getLblUnidadmilitar4().setEnabled(true);
                    this.cmdEnviarUnidades4.setEnabled(true);
                    break;
                case "Gigante a Vapor":
                    this.imagenUnidadmilitar5.setEnabled(true);
                    this.getLblUnidadmilitar5().setEnabled(true);
                    this.cmdEnviarUnidades5.setEnabled(true);
                    break;
                case "Girocóptero":
                    this.imagenUnidadmilitar6.setEnabled(true);
                    this.getLblUnidadmilitar6().setEnabled(true);
                    this.cmdEnviarUnidades6.setEnabled(true);
                    break;
                case "Globo Bombardero":
                    this.imagenUnidadmilitar7.setEnabled(true);
                    this.getLblUnidadmilitar7().setEnabled(true);
                    this.cmdEnviarUnidades7.setEnabled(true);
                    break;
                case "Hondero":
                    this.imagenUnidadmilitar8.setEnabled(true);
                    this.getLblUnidadmilitar8().setEnabled(true);
                    this.cmdEnviarUnidades8.setEnabled(true);
                    break;
                case "Hoplita":
                    this.imagenUnidadmilitar9.setEnabled(true);
                    this.getLblUnidadmilitar9().setEnabled(true);
                    this.cmdEnviarUnidades9.setEnabled(true);
                    break;
                case "Lancero":
                    this.imagenUnidadmilitar10.setEnabled(true);
                    this.getLblUnidadmilitar10().setEnabled(true);
                    this.cmdEnviarUnidades10.setEnabled(true);
                    break;
                case "Mortero":
                    this.imagenUnidadmilitar11.setEnabled(true);
                    this.getLblUnidadmilitar11().setEnabled(true);
                    this.cmdEnviarUnidades11.setEnabled(true);
                    break;
            }
        }

        this.repaint();
    }

    private void cmdEnviarUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidadesActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar.getText());
    }//GEN-LAST:event_cmdEnviarUnidadesActionPerformed

    private void cmdEnviarUnidades1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades1ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar1.getText());
    }//GEN-LAST:event_cmdEnviarUnidades1ActionPerformed

    private void cmdEnviarUnidades2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades2ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar2.getText());
    }//GEN-LAST:event_cmdEnviarUnidades2ActionPerformed

    private void cmdEnviarUnidades3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades3ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar3.getText());
    }//GEN-LAST:event_cmdEnviarUnidades3ActionPerformed

    private void cmdEnviarUnidades4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades4ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar4.getText());
    }//GEN-LAST:event_cmdEnviarUnidades4ActionPerformed

    private void cmdEnviarUnidades5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades5ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar5.getText());
    }//GEN-LAST:event_cmdEnviarUnidades5ActionPerformed

    private void cmdEnviarUnidades6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades6ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar6.getText());
    }//GEN-LAST:event_cmdEnviarUnidades6ActionPerformed

    private void cmdEnviarUnidades7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades7ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar7.getText());
    }//GEN-LAST:event_cmdEnviarUnidades7ActionPerformed

    private void cmdEnviarUnidades8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades8ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar8.getText());
    }//GEN-LAST:event_cmdEnviarUnidades8ActionPerformed

    private void cmdEnviarUnidades9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades9ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar9.getText());
    }//GEN-LAST:event_cmdEnviarUnidades9ActionPerformed

    private void cmdEnviarUnidades10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades10ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar10.getText());
    }//GEN-LAST:event_cmdEnviarUnidades10ActionPerformed

    private void cmdEnviarUnidades11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidades11ActionPerformed
        this.verUnidadArma(this.lblUnidadmilitar11.getText());
    }//GEN-LAST:event_cmdEnviarUnidades11ActionPerformed

    private void cmdPlanificarSaqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPlanificarSaqueoActionPerformed
        try {
            PlanificarSaqueo planificarsaqueo = new PlanificarSaqueo(this.ciudadelegida, this.ciudadjugador, this.unidadesmilitares, this.armas, this.cantidadaenviada);
            planificarsaqueo.CUPlanificarSaqueo();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmdPlanificarSaqueoActionPerformed

    private void cmdEnviarUnidadesMilitaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarUnidadesMilitaresActionPerformed
        try {
            EnviarUnidades enviarunidades = new EnviarUnidades(this.ciudadelegida, this.ciudadjugador, this.unidadesmilitares, this.armas, this.cantidadaenviada);
            enviarunidades.CUEnviarUnidades();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_cmdEnviarUnidadesMilitaresActionPerformed

    private void txtCantidadBarcosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadBarcosKeyReleased

    }//GEN-LAST:event_txtCantidadBarcosKeyReleased

    private void verUnidadArma(String unidadmilitar) {

        for (int i = 0; i < this.unidadesmilitares.size(); i++) {
            if (this.unidadesmilitares.get(i).getNombre().equals(unidadmilitar)) {
                this.unidadelegida = this.unidadesmilitares.get(i);
            }
        }
        VerDestruirUnidad vplanificarunidades;
        vplanificarunidades = new VerDestruirUnidad(this.unidadesmilitares, this.armas, this.cantidaddearma, this.cantidadaenviada, this.unidadelegida);


    }

    public JButton getCmdEnviarUnidades() {
        return cmdEnviarUnidades;
    }

    public JButton getCmdEnviarUnidades1() {
        return cmdEnviarUnidades1;
    }

    public JButton getCmdEnviarUnidades10() {
        return cmdEnviarUnidades10;
    }

    public JButton getCmdEnviarUnidades11() {
        return cmdEnviarUnidades11;
    }

    public JButton getCmdEnviarUnidades2() {
        return cmdEnviarUnidades2;
    }

    public JButton getCmdEnviarUnidades3() {
        return cmdEnviarUnidades3;
    }

    public JButton getCmdEnviarUnidades4() {
        return cmdEnviarUnidades4;
    }

    public JButton getCmdEnviarUnidades5() {
        return cmdEnviarUnidades5;
    }

    public JButton getCmdEnviarUnidades6() {
        return cmdEnviarUnidades6;
    }

    public JButton getCmdEnviarUnidades7() {
        return cmdEnviarUnidades7;
    }

    public JButton getCmdEnviarUnidades8() {
        return cmdEnviarUnidades8;
    }

    public JButton getCmdEnviarUnidades9() {
        return cmdEnviarUnidades9;
    }

    public JButton getCmdPlanificarSaqueo() {
        return cmdPlanificarSaqueo;
    }

    public PanelImage getImagenBarco() {
        return imagenBarco;
    }

    public PanelImage getImagenUnidadmilitar() {
        return imagenUnidadmilitar;
    }

    public PanelImage getImagenUnidadmilitar1() {
        return imagenUnidadmilitar1;
    }

    public PanelImage getImagenUnidadmilitar10() {
        return imagenUnidadmilitar10;
    }

    public PanelImage getImagenUnidadmilitar11() {
        return imagenUnidadmilitar11;
    }

    public PanelImage getImagenUnidadmilitar2() {
        return imagenUnidadmilitar2;
    }

    public PanelImage getImagenUnidadmilitar3() {
        return imagenUnidadmilitar3;
    }

    public PanelImage getImagenUnidadmilitar4() {
        return imagenUnidadmilitar4;
    }

    public PanelImage getImagenUnidadmilitar5() {
        return imagenUnidadmilitar5;
    }

    public PanelImage getImagenUnidadmilitar6() {
        return imagenUnidadmilitar6;
    }

    public PanelImage getImagenUnidadmilitar7() {
        return imagenUnidadmilitar7;
    }

    public PanelImage getImagenUnidadmilitar8() {
        return imagenUnidadmilitar8;
    }

    public PanelImage getImagenUnidadmilitar9() {
        return imagenUnidadmilitar9;
    }

    public JLabel getLblCantidadBarcos() {
        return lblCantidadBarcos;
    }

    public JLabel getLblUnidadmilitar() {
        return lblUnidadmilitar;
    }

    public JLabel getLblUnidadmilitar1() {
        return lblUnidadmilitar1;
    }

    public JLabel getLblUnidadmilitar10() {
        return lblUnidadmilitar10;
    }

    public JLabel getLblUnidadmilitar11() {
        return lblUnidadmilitar11;
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

    public JLabel getLblUnidadmilitar7() {
        return lblUnidadmilitar7;
    }

    public JLabel getLblUnidadmilitar8() {
        return lblUnidadmilitar8;
    }

    public JLabel getLblUnidadmilitar9() {
        return lblUnidadmilitar9;
    }

    public PanelImage getPanelImage1() {
        return panelImage1;
    }

    public PanelImage getPanelImage2() {
        return panelImage2;
    }

    public PanelImage getPanelImage3() {
        return panelImage3;
    }

    public JTextField getTxtCantidadBarcos() {
        return txtCantidadBarcos;
    }
    // End of variables declaration//GEN-END:variables


}
