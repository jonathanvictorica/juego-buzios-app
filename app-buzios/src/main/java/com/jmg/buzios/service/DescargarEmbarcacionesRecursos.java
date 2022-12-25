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
public class DescargarEmbarcacionesRecursos extends Thread{


    public DescargarEmbarcacionesRecursos() {
    }
    
    @Override
    public void run()
    {
         CallableStatement procedimiento;
        
            try {
                 while(true)
                    {
                           procedimiento = ConexionDB.getConexion().prepareCall("CALL desembarcar_barcos_recursos()");
                           procedimiento.execute();
                                 
                                  System.out.printf("\nDesembarcos");
                                   Thread.sleep(60000);
                    }
                    } catch (InterruptedException ex) {

                } catch (SQLException ex) {

                    }
         
    }
}
