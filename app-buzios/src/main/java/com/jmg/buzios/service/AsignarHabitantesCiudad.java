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
public class AsignarHabitantesCiudad extends Thread {


    public AsignarHabitantesCiudad() {
    }
    
    @Override
    public void run()
    {
         CallableStatement procedimiento;
        
            try {
                 while(true)
                    {
                           procedimiento = ConexionDB.getConexion().prepareCall("CALL actualizar_habitantes_hora()");
                                   procedimiento.execute();
                                  Thread.sleep(120000);
                                  System.out.printf("\nHabitantes");
                    }
                    } catch (InterruptedException ex) {

                } catch (SQLException ex) {

                    }
         
    }
}
