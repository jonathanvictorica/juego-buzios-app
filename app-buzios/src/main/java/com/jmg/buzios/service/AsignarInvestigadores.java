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
public class AsignarInvestigadores extends Thread {

    public AsignarInvestigadores() {
    }
    
    @Override
    public void run()
    {
        this.CUAsignarInvestigadores();
    }
    private void CUAsignarInvestigadores() 
    {
        CallableStatement procedimiento;
         while(true)
         {
            try {
                procedimiento = ConexionDB.getConexion().prepareCall("CALL actualizar_investigadores_hora()");
                 procedimiento.execute();
                Thread.sleep(120000);
                System.out.printf("\nInvestigadores");
            } catch (InterruptedException | SQLException ex) {
               
            }
                    
         }
    }
}
