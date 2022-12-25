
package com.jmg.buzios;

import com.jmg.buzios.scheduler.SchedulerBuzios;
import com.jmg.buzios.view.login.VLOGIN;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuziosApp {

    public static void main(String[] args) {
        new VLOGIN();
        new SchedulerBuzios().execute();
        SpringApplication.run(BuziosApp.class, args);
    }


}
