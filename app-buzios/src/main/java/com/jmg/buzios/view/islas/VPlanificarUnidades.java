/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.view.islas;

import com.jmg.buzios.controller.Actualizar;
import com.jmg.buzios.model.militar.ejercito.Arma;
import com.jmg.buzios.model.militar.ejercito.UnidadMilitar;
import org.edisoncor.gui.panel.PanelImage;

import javax.swing.*;
import java.util.List;

/**
 * @author Alumno
 */
public class VPlanificarUnidades extends javax.swing.JFrame implements Actualizar {


    private List<UnidadMilitar> unidadesdejugador;
    private List<Arma> armasunidad;
    private List<Integer> cantidaddisponible;


    private List<Integer> cantidadaenviar;


    private UnidadMilitar unidadelegida;


    private List<String> nombredearmas;
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider barraArma;
    private javax.swing.JSlider barraArma1;
    private javax.swing.JSlider barraArma2;
    private javax.swing.JSlider barraArma3;
    private javax.swing.JSlider barraunidadsinarma;
    private javax.swing.JButton cmdAsignarUnidadesaBatalla;
    private org.edisoncor.gui.panel.PanelImage imagenArma;
    private org.edisoncor.gui.panel.PanelImage imagenArma1;
    private org.edisoncor.gui.panel.PanelImage imagenArma2;
    private org.edisoncor.gui.panel.PanelImage imagenArma3;
    private org.edisoncor.gui.panel.PanelImage imagenUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblArma;
    private javax.swing.JLabel lblUnidadessinarma;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTextField txtArma;
    private javax.swing.JTextField txtArma1;
    private javax.swing.JTextField txtArma2;
    private javax.swing.JTextField txtArma3;
    private javax.swing.JTextField txtSinarma;

    public VPlanificarUnidades(List<UnidadMilitar> unidadesdejugador, List<Arma> armasunidad, List<Integer> cantidaddisponible, List<Integer> cantidadaenviar, UnidadMilitar unidadelegida) {
        initComponents();
        this.unidadesdejugador = unidadesdejugador;
        this.armasunidad = armasunidad;
        this.cantidaddisponible = cantidaddisponible;
        this.cantidadaenviar = cantidadaenviar;
        this.unidadelegida = unidadelegida;
        this.actualizarinterfazgrafica();
        this.actualizardatospantalla();
        this.setLocationRelativeTo(null);
        this.show();
    }

    private void inicializar_pantalla() {


    }

    @Override
    public void actualizardatospantalla() {
        int indice = 1;

        for (int i = 0; i < this.unidadesdejugador.size(); i++) {
            if ((this.unidadesdejugador.get(i).getNombre().equals(this.unidadelegida.getNombre())) && (this.armasunidad.get(i) == null)) {

                this.barraunidadsinarma.setMaximum(this.cantidaddisponible.get(i).intValue());
                this.txtSinarma.setText("" + this.cantidadaenviar.get(i).intValue());
                this.barraunidadsinarma.setValue(this.cantidadaenviar.get(i).intValue());


            } else {

                if (this.unidadesdejugador.get(i).getNombre().equals(this.unidadelegida.getNombre())) {
                    this.lblArma.setVisible(true);
                    switch (indice) {
                        case 1:
                            this.barraArma.setMaximum(this.cantidaddisponible.get(i).intValue());
                            this.txtArma.setText("" + this.cantidadaenviar.get(i).intValue());
                            this.barraArma.setValue(this.cantidadaenviar.get(i).intValue());

                            this.nombredearmas.add(this.armasunidad.get(i).getNombrearma());
                            break;
                        case 2:
                            this.barraArma1.setMaximum(this.cantidaddisponible.get(i).intValue());
                            this.txtArma1.setText("" + this.cantidadaenviar.get(i).intValue());
                            this.barraArma1.setValue(this.cantidadaenviar.get(i).intValue());
                            this.nombredearmas.add(this.armasunidad.get(i).getNombrearma());
                            break;
                        case 3:
                            this.barraArma2.setMaximum(this.cantidaddisponible.get(i).intValue());
                            this.txtArma3.setText("" + this.cantidadaenviar.get(i).intValue());
                            this.barraArma2.setValue(this.cantidadaenviar.get(i).intValue());
                            this.nombredearmas.add(this.armasunidad.get(i).getNombrearma());
                            break;
                        case 4:
                            this.barraArma3.setMaximum(this.cantidaddisponible.get(i).intValue());
                            this.txtArma2.setText("" + this.cantidadaenviar.get(i).intValue());
                            this.barraArma3.setValue(this.cantidadaenviar.get(i).intValue());
                            this.nombredearmas.add(this.armasunidad.get(i).getNombrearma());
                            break;

                    }


                    indice++;
                }
            }
        }
        this.repaint();
    }

    @Override
    public void actualizarinterfazgrafica() {
        ImageIcon imagenarma;
        String direccion = "";

        int indice = 1;


        this.imagenUnidad.setEnabled(false);
        this.barraunidadsinarma.setEnabled(false);
        this.txtSinarma.setEnabled(false);

        this.lblArma.setVisible(false);
        this.barraArma.setVisible(false); // muestra el arma porque existe
        this.imagenArma.setVisible(false);

        this.txtArma.setVisible(false);
        this.barraArma1.setVisible(false); // muestra el arma porque existe
        this.imagenArma1.setVisible(false);

        this.txtArma1.setVisible(false);
        this.barraArma2.setVisible(false); // muestra el arma porque existe
        this.imagenArma2.setVisible(false);

        this.txtArma3.setVisible(false);
        this.barraArma3.setVisible(false); // muestra el arma porque existe
        this.imagenArma3.setVisible(false);
        this.txtArma2.setVisible(false);


        for (int i = 0; i < this.unidadesdejugador.size(); i++) {
            if ((this.unidadesdejugador.get(i).getNombre().equals(this.unidadelegida.getNombre())) && (this.armasunidad.get(i) == null)) {
                this.imagenUnidad.setEnabled(true);
                //  direccion  = ("/IMAGEN/"+ "planificar_"+this.unidadesdejugador.get(i).getNombre() +".jpg");
                // imagenarma = new ImageIcon(getClass().getResource(direccion));
                //  this.imagenUnidad.setIcon(imagenarma);

                this.barraunidadsinarma.setEnabled(true);
                this.txtSinarma.setEnabled(true);


            } else {

                if (this.unidadesdejugador.get(i).getNombre().equals(this.unidadelegida.getNombre())) {
                    this.lblArma.setVisible(true);
                    if (this.armasunidad.get(i) != null) {
                        switch (indice) {
                            case 1:
                                this.barraArma.setVisible(true); // muestra el arma porque existe
                                this.imagenArma.setVisible(true);
                                direccion = ("/IMAGEN/ARMA/" + this.armasunidad.get(i).getImagenarma().getDireccion() + ".png");
                                imagenarma = new ImageIcon(getClass().getResource(direccion));
                                this.imagenArma.setIcon(imagenarma);
                                this.txtArma.setVisible(true);
                                break;
                            case 2:
                                this.barraArma1.setVisible(true); // muestra el arma porque existe
                                this.imagenArma1.setVisible(true);
                                direccion = ("/IMAGEN/ARMA/" + this.armasunidad.get(i).getImagenarma().getDireccion() + ".png");
                                imagenarma = new ImageIcon(getClass().getResource(direccion));
                                this.imagenArma1.setIcon(imagenarma);
                                this.txtArma1.setVisible(true);
                                break;
                            case 3:
                                this.barraArma2.setVisible(true); // muestra el arma porque existe
                                this.imagenArma2.setVisible(true);
                                direccion = ("/IMAGEN/ARMA/" + this.armasunidad.get(i).getImagenarma().getDireccion() + ".png");
                                imagenarma = new ImageIcon(getClass().getResource(direccion));
                                this.imagenArma2.setIcon(imagenarma);
                                this.txtArma3.setVisible(true);
                                break;
                            case 4:
                                this.barraArma3.setVisible(true); // muestra el arma porque existe
                                this.imagenArma3.setVisible(true);
                                direccion = ("/IMAGEN/ARMA/" + this.armasunidad.get(i).getImagenarma().getDireccion() + ".png");
                                imagenarma = new ImageIcon(getClass().getResource(direccion));
                                this.imagenArma3.setIcon(imagenarma);
                                this.txtArma2.setVisible(true);
                                break;

                        }
                        indice++;
                    }


                }
            }
        }
        this.repaint();
    }

    private void asignar_unidades_sinarma(int cantidadasignar) {
        for (int i = 0; i < this.unidadesdejugador.size(); i++) {
            if ((this.unidadesdejugador.get(i).getNombre().equals(this.unidadelegida.getNombre())) && (this.armasunidad.get(i) == null)) {
                this.cantidadaenviar.set(i, cantidadasignar);
            }
        }

    }

    private void asignar_unidades_con_arma(int indice, int cantidadasignar) {

        for (int i = 0; i < this.unidadesdejugador.size(); i++) {
            if (this.armasunidad.get(i) != null) {
                if ((this.unidadesdejugador.get(i).getNombre().equals(this.unidadelegida.getNombre())) && (this.armasunidad.get(i).getNombrearma().equals(this.nombredearmas.get(indice)))) {
                    this.cantidadaenviar.set(i, cantidadasignar);
                }
            }
        }
    }

    public JLabel getLblArma() {
        return lblArma;
    }

    public void setLblArma(JLabel lblArma) {
        this.lblArma = lblArma;
    }

    public JLabel getLblUnidadessinarma() {
        return lblUnidadessinarma;
    }

    public void setLblUnidadessinarma(JLabel lblUnidadessinarma) {
        this.lblUnidadessinarma = lblUnidadessinarma;
    }

    public JSlider getBarraArma() {
        return barraArma;
    }

    public void setBarraArma(JSlider barraArma) {
        this.barraArma = barraArma;
    }

    public JSlider getBarraArma1() {
        return barraArma1;
    }

    public void setBarraArma1(JSlider barraArma1) {
        this.barraArma1 = barraArma1;
    }

    public JSlider getBarraArma2() {
        return barraArma2;
    }

    public void setBarraArma2(JSlider barraArma2) {
        this.barraArma2 = barraArma2;
    }

    public JSlider getBarraArma3() {
        return barraArma3;
    }

    public void setBarraArma3(JSlider barraArma3) {
        this.barraArma3 = barraArma3;
    }

    public JSlider getBarraunidadsinarma() {
        return barraunidadsinarma;
    }

    public void setBarraunidadsinarma(JSlider barraunidadsinarma) {
        this.barraunidadsinarma = barraunidadsinarma;
    }

    public JButton getCmdAsignarUnidadesaBatalla() {
        return cmdAsignarUnidadesaBatalla;
    }

    public void setCmdAsignarUnidadesaBatalla(JButton cmdAsignarUnidadesaBatalla) {
        this.cmdAsignarUnidadesaBatalla = cmdAsignarUnidadesaBatalla;
    }

    public PanelImage getImagenArma() {
        return imagenArma;
    }

    public void setImagenArma(PanelImage imagenArma) {
        this.imagenArma = imagenArma;
    }

    public PanelImage getImagenArma1() {
        return imagenArma1;
    }

    public void setImagenArma1(PanelImage imagenArma1) {
        this.imagenArma1 = imagenArma1;
    }

    public PanelImage getImagenArma2() {
        return imagenArma2;
    }

    public void setImagenArma2(PanelImage imagenArma2) {
        this.imagenArma2 = imagenArma2;
    }

    public PanelImage getImagenArma3() {
        return imagenArma3;
    }

    public void setImagenArma3(PanelImage imagenArma3) {
        this.imagenArma3 = imagenArma3;
    }

    public PanelImage getImagenUnidad() {
        return imagenUnidad;
    }

    public void setImagenUnidad(PanelImage imagenUnidad) {
        this.imagenUnidad = imagenUnidad;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return lblArma;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.lblArma = jLabel2;
    }

    public JLabel getjLabel3() {
        return lblUnidadessinarma;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.lblUnidadessinarma = jLabel3;
    }

    public PanelImage getPanelImage1() {
        return panelImage1;
    }

    public void setPanelImage1(PanelImage panelImage1) {
        this.panelImage1 = panelImage1;
    }

    public JTextField getTxtArma() {
        return txtArma;
    }

    public void setTxtArma(JTextField txtArma) {
        this.txtArma = txtArma;
    }

    public JTextField getTxtArma1() {
        return txtArma1;
    }

    public void setTxtArma1(JTextField txtArma1) {
        this.txtArma1 = txtArma1;
    }

    public JTextField getTxtArma2() {
        return txtArma3;
    }

    public void setTxtArma2(JTextField txtArma2) {
        this.txtArma3 = txtArma2;
    }

    public JTextField getTxtArma3() {
        return txtArma2;
    }

    public void setTxtArma3(JTextField txtArma3) {
        this.txtArma2 = txtArma3;
    }

    public JTextField getTxtSinarma() {
        return txtSinarma;
    }

    public void setTxtSinarma(JTextField txtSinarma) {
        this.txtSinarma = txtSinarma;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        imagenArma = new org.edisoncor.gui.panel.PanelImage();
        lblArma = new javax.swing.JLabel();
        barraArma = new javax.swing.JSlider();
        txtArma = new javax.swing.JTextField();
        txtArma1 = new javax.swing.JTextField();
        barraArma1 = new javax.swing.JSlider();
        imagenArma1 = new org.edisoncor.gui.panel.PanelImage();
        imagenArma2 = new org.edisoncor.gui.panel.PanelImage();
        imagenArma3 = new org.edisoncor.gui.panel.PanelImage();
        barraArma2 = new javax.swing.JSlider();
        barraArma3 = new javax.swing.JSlider();
        txtArma3 = new javax.swing.JTextField();
        txtArma2 = new javax.swing.JTextField();
        imagenUnidad = new org.edisoncor.gui.panel.PanelImage();
        barraunidadsinarma = new javax.swing.JSlider();
        txtSinarma = new javax.swing.JTextField();
        lblUnidadessinarma = new javax.swing.JLabel();
        cmdAsignarUnidadesaBatalla = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenArma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArmaLayout = new javax.swing.GroupLayout(imagenArma);
        imagenArma.setLayout(imagenArmaLayout);
        imagenArmaLayout.setHorizontalGroup(
                imagenArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 59, Short.MAX_VALUE)
        );
        imagenArmaLayout.setVerticalGroup(
                imagenArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        panelImage1.add(imagenArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 61, -1));

        lblArma.setText("Arma Unidad");
        panelImage1.add(lblArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        barraArma.setValue(0);
        barraArma.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraArmaStateChanged(evt);
            }
        });
        panelImage1.add(barraArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 223, -1));

        txtArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArmaActionPerformed(evt);
            }
        });
        txtArma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArmaKeyReleased(evt);
            }
        });
        panelImage1.add(txtArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 61, -1));

        txtArma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArma1ActionPerformed(evt);
            }
        });
        txtArma1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArma1KeyReleased(evt);
            }
        });
        panelImage1.add(txtArma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 61, -1));

        barraArma1.setValue(0);
        barraArma1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraArma1StateChanged(evt);
            }
        });
        panelImage1.add(barraArma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 223, -1));

        imagenArma1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArma1Layout = new javax.swing.GroupLayout(imagenArma1);
        imagenArma1.setLayout(imagenArma1Layout);
        imagenArma1Layout.setHorizontalGroup(
                imagenArma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 59, Short.MAX_VALUE)
        );
        imagenArma1Layout.setVerticalGroup(
                imagenArma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        panelImage1.add(imagenArma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        imagenArma2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArma2Layout = new javax.swing.GroupLayout(imagenArma2);
        imagenArma2.setLayout(imagenArma2Layout);
        imagenArma2Layout.setHorizontalGroup(
                imagenArma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 59, Short.MAX_VALUE)
        );
        imagenArma2Layout.setVerticalGroup(
                imagenArma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        panelImage1.add(imagenArma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        imagenArma3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagenArma3Layout = new javax.swing.GroupLayout(imagenArma3);
        imagenArma3.setLayout(imagenArma3Layout);
        imagenArma3Layout.setHorizontalGroup(
                imagenArma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 59, Short.MAX_VALUE)
        );
        imagenArma3Layout.setVerticalGroup(
                imagenArma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        panelImage1.add(imagenArma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        barraArma2.setValue(0);
        barraArma2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraArma2StateChanged(evt);
            }
        });
        panelImage1.add(barraArma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 223, -1));

        barraArma3.setValue(0);
        barraArma3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraArma3StateChanged(evt);
            }
        });
        panelImage1.add(barraArma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 223, -1));

        txtArma3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArma3ActionPerformed(evt);
            }
        });
        txtArma3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArma3KeyReleased(evt);
            }
        });
        panelImage1.add(txtArma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 61, -1));

        txtArma2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArma2ActionPerformed(evt);
            }
        });
        txtArma2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArma2KeyReleased(evt);
            }
        });
        panelImage1.add(txtArma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 61, -1));

        imagenUnidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenUnidad.setEnabled(false);
        imagenUnidad.setPreferredSize(new java.awt.Dimension(102, 102));

        javax.swing.GroupLayout imagenUnidadLayout = new javax.swing.GroupLayout(imagenUnidad);
        imagenUnidad.setLayout(imagenUnidadLayout);
        imagenUnidadLayout.setHorizontalGroup(
                imagenUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 78, Short.MAX_VALUE)
        );
        imagenUnidadLayout.setVerticalGroup(
                imagenUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 78, Short.MAX_VALUE)
        );

        panelImage1.add(imagenUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 80, 80));

        barraunidadsinarma.setValue(0);
        barraunidadsinarma.setDoubleBuffered(true);
        barraunidadsinarma.setEnabled(false);
        barraunidadsinarma.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraunidadsinarmaStateChanged(evt);
            }
        });
        panelImage1.add(barraunidadsinarma, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 223, -1));

        txtSinarma.setDoubleBuffered(true);
        txtSinarma.setEnabled(false);
        txtSinarma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSinarmaActionPerformed(evt);
            }
        });
        txtSinarma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSinarmaKeyReleased(evt);
            }
        });
        panelImage1.add(txtSinarma, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 61, -1));

        lblUnidadessinarma.setText("Unidades sin Arma");
        panelImage1.add(lblUnidadessinarma, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        cmdAsignarUnidadesaBatalla.setText("Asignar");
        cmdAsignarUnidadesaBatalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAsignarUnidadesaBatallaActionPerformed(evt);
            }
        });
        panelImage1.add(cmdAsignarUnidadesaBatalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 77, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArmaActionPerformed

    private void txtArma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArma1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArma1ActionPerformed

    private void txtArma3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArma3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArma3ActionPerformed

    private void txtArma2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArma2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArma2ActionPerformed

    private void txtSinarmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSinarmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSinarmaActionPerformed

    private void cmdAsignarUnidadesaBatallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAsignarUnidadesaBatallaActionPerformed

        this.hide();
    }//GEN-LAST:event_cmdAsignarUnidadesaBatallaActionPerformed

    private void txtSinarmaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSinarmaKeyReleased
        try {
            if (Integer.parseInt(this.txtSinarma.getText()) <= this.barraunidadsinarma.getMaximum()) {
                this.barraunidadsinarma.setValue(Integer.parseInt(this.txtSinarma.getText()));

            } else {
                this.txtSinarma.setText("" + this.barraunidadsinarma.getMaximum());
                this.barraunidadsinarma.setValue(this.barraunidadsinarma.getMaximum());
            }
            this.asignar_unidades_sinarma(this.barraunidadsinarma.getValue());

        } catch (NumberFormatException j) {
            this.txtSinarma.setText("" + this.barraunidadsinarma.getValue());
        }
    }//GEN-LAST:event_txtSinarmaKeyReleased

    private void barraunidadsinarmaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraunidadsinarmaStateChanged
        this.txtSinarma.setText("" + this.barraunidadsinarma.getValue());
        this.asignar_unidades_sinarma(this.barraunidadsinarma.getValue());
    }//GEN-LAST:event_barraunidadsinarmaStateChanged

    private void txtArmaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArmaKeyReleased
        try {
            if (Integer.parseInt(this.txtArma.getText()) <= this.barraArma.getMaximum()) {
                this.barraArma.setValue(Integer.parseInt(this.txtArma.getText()));

            } else {
                this.txtArma.setText("" + this.barraArma.getMaximum());
                this.barraArma.setValue(this.barraArma.getMaximum());
            }
            this.asignar_unidades_con_arma(0, this.barraArma.getValue());

        } catch (NumberFormatException j) {
            this.txtArma.setText("" + this.barraArma.getValue());
        }
    }//GEN-LAST:event_txtArmaKeyReleased

    private void txtArma1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArma1KeyReleased
        try {
            if (Integer.parseInt(this.txtArma1.getText()) <= this.barraArma1.getMaximum()) {
                this.barraArma1.setValue(Integer.parseInt(this.txtArma1.getText()));

            } else {
                this.txtArma1.setText("" + this.barraArma1.getMaximum());
                this.barraArma1.setValue(this.barraArma1.getMaximum());
            }
            this.asignar_unidades_con_arma(0, this.barraArma1.getValue());

        } catch (NumberFormatException j) {
            this.txtArma1.setText("" + this.barraArma1.getValue());
        }
    }//GEN-LAST:event_txtArma1KeyReleased

    private void txtArma2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArma2KeyReleased
        try {
            if (Integer.parseInt(this.txtArma2.getText()) <= this.barraArma2.getMaximum()) {
                this.barraArma2.setValue(Integer.parseInt(this.txtArma2.getText()));

            } else {
                this.txtArma2.setText("" + this.barraArma2.getMaximum());
                this.barraArma2.setValue(this.barraArma2.getMaximum());
            }
            this.asignar_unidades_con_arma(0, this.barraArma2.getValue());

        } catch (NumberFormatException j) {
            this.txtArma2.setText("" + this.barraArma2.getValue());
        }
    }//GEN-LAST:event_txtArma2KeyReleased

    private void txtArma3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArma3KeyReleased
        try {
            if (Integer.parseInt(this.txtArma3.getText()) <= this.barraArma3.getMaximum()) {
                this.barraArma3.setValue(Integer.parseInt(this.txtArma3.getText()));

            } else {
                this.txtArma3.setText("" + this.barraArma3.getMaximum());
                this.barraArma3.setValue(this.barraArma3.getMaximum());
            }
            this.asignar_unidades_con_arma(0, this.barraArma3.getValue());

        } catch (NumberFormatException j) {
            this.txtArma3.setText("" + this.barraArma3.getValue());
        }
    }//GEN-LAST:event_txtArma3KeyReleased

    private void barraArmaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraArmaStateChanged
        this.txtArma.setText("" + this.barraArma.getValue());
        this.asignar_unidades_con_arma(0, this.barraArma.getValue());
    }//GEN-LAST:event_barraArmaStateChanged

    private void barraArma1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraArma1StateChanged
        this.txtArma1.setText("" + this.barraArma1.getValue());
        this.asignar_unidades_con_arma(1, this.barraArma1.getValue());
    }//GEN-LAST:event_barraArma1StateChanged

    private void barraArma2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraArma2StateChanged
        this.txtArma2.setText("" + this.barraArma2.getValue());
        this.asignar_unidades_con_arma(2, this.barraArma2.getValue());
    }//GEN-LAST:event_barraArma2StateChanged

    private void barraArma3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraArma3StateChanged
        this.txtArma3.setText("" + this.barraArma3.getValue());
        this.asignar_unidades_con_arma(3, this.barraArma3.getValue());
    }//GEN-LAST:event_barraArma3StateChanged
    // End of variables declaration//GEN-END:variables


}
