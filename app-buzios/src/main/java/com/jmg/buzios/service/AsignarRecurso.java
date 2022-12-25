/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.service;

import com.jmg.buzios.config.ConexionDB;

import java.sql.CallableStatement;
import java.sql.SQLException;


/**
 *
 * @author Alumno
 */
public class AsignarRecurso extends Thread{


    public AsignarRecurso() {
    }
    
    @Override
    public void run()
    {
        this.CUAsignarRecurso();
    }
    
     private void CUAsignarRecurso()
   {
       AsignarRecursoThread asignarmadera = new AsignarRecursoThread("Madera");
       Thread asignarmaderahilo = new Thread(asignarmadera);
       asignarmaderahilo.start();
       
       AsignarRecursoThread asignarmarmol = new AsignarRecursoThread("Marmol");
       Thread asignarmarmolhilo = new Thread(asignarmarmol);
       asignarmarmolhilo.start();
       
       AsignarRecursoThread asignarvino = new AsignarRecursoThread("Vino");
       Thread asignarvinohilo = new Thread(asignarvino);
       asignarvinohilo.start();
       
       AsignarRecursoThread asignarcristal = new AsignarRecursoThread("Cristal");
       Thread asignarcristalhilo = new Thread(asignarcristal);
       asignarcristalhilo.start();
       
       AsignarRecursoThread asignarazufre = new AsignarRecursoThread("Azufre");
       Thread asignarazufrehilo = new Thread(asignarazufre);
       asignarazufrehilo.start();
       
       while(asignarmaderahilo.isAlive())
       {
           
       }
       
   }
}
class AsignarRecursoThread extends Thread{
    private String recurso;
  

    public AsignarRecursoThread(String recurso) {
        this.recurso = recurso;
       
    }
    
  
    
    @Override
    public void run()
    {
         CallableStatement procedimiento;
        switch(this.recurso)
        {
            case "Madera":
               
                    try {
                        while(true)
                        {
                        procedimiento = ConexionDB.getConexion().prepareCall("CALL actualizar_madera_hora()");
                         procedimiento.execute();
                        Thread.sleep(120000);
                        
                        System.out.printf("\nMadera");
                    
                        }
                    } catch (InterruptedException | SQLException ex) {
           
                    }
                
                 break;
            case "Marmol":
                
                    try {
                        while(true)
                        {
                        procedimiento = ConexionDB.getConexion().prepareCall("CALL actualizar_marmol_hora()");
                        procedimiento.execute();
                        Thread.sleep(60000);
                        System.out.printf("\nMarmol");
                        }
                    } catch (InterruptedException | SQLException ex) {
           
                    }
                
                 break;
            case "Vino":
                
                    try {
                         while(true)
                        {
                        procedimiento = ConexionDB.getConexion().prepareCall("CALL actualizar_vino_hora()");
                        procedimiento.execute();
                        Thread.sleep(60000);
                        System.out.printf("\nVino");
                        }
                    } catch (InterruptedException |SQLException ex) {

                    }
             
                 break;
            case "Azufre":
                
                    try {
                        while(true)
                        {
                        procedimiento = ConexionDB.getConexion().prepareCall("CALL actualizar_azufre_hora()");
                        procedimiento.execute();
                        Thread.sleep(60000);
                        System.out.printf("\nAzufre");
                        }
                    } catch (InterruptedException |SQLException ex) {

                    }
             
                 break;
             case "Cristal":
                
                    try {
                        while(true)
                        {
                        procedimiento = ConexionDB.getConexion().prepareCall("CALL actualizar_cristal_hora()");
                        procedimiento.execute();
                        Thread.sleep(60000);
                        System.out.printf("\nCristal");
                        }
                    } catch (InterruptedException |SQLException ex) {

                    }
             
                 break;
        }
       
    }
    
    
    
    
    
    
}