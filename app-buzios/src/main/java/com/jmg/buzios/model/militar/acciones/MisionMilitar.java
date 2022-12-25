/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.acciones;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MisionMilitar {
    private Integer codigomision;
    private String nombremision;

    public MisionMilitar(String nombremision) {
        this.nombremision = nombremision;
    }




}
