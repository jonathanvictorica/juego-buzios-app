/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.edificio;

import com.jmg.buzios.model.isla.Recurso;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EdificioRecurso {
    private EdificioNivel Edificionivel;
    private List<Recurso> recurso = new ArrayList<>();
    private List<Integer> cantidad = new ArrayList<>();




}
