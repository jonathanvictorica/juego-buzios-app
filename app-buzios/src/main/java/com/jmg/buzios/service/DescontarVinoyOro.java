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
public class DescontarVinoyOro extends Thread{
    
    

    private boolean descontarvino;

    public DescontarVinoyOro(boolean descontarvino) {
        this.descontarvino = descontarvino;
    }
    
    
    @Override
    public void run()
    {
         CallableStatement procedimiento;
        if(this.descontarvino)
        {
              try {
                 while(true)
                    {
                           procedimiento = ConexionDB.getConexion().prepareCall("CALL descontar_vino_hora()");
                                   procedimiento.execute();
                                  
                                  System.out.printf("\nDescontar Vino");
                                  Thread.sleep(120000);
                    }
                    } catch (InterruptedException ex) {

                } catch (SQLException ex) {

                    }
        }
        else
        {
            try {
                 while(true)
                    {
                           procedimiento = ConexionDB.getConexion().prepareCall("CALL descontar_oro_hora()");
                                   procedimiento.execute();
                                 
                                  System.out.printf("\nDescontar Oro");
                                   Thread.sleep(120000);
                    }
                    } catch (InterruptedException ex) {

                } catch (SQLException ex) {

                    }
        }
    }
    
}
