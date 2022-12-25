/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmg.buzios.model.militar.ejercito;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CiudadEjercitoArma {

    private List<Arma> arma = new ArrayList<>();
    private List<Integer> cantidad = new ArrayList<>();
    private List<Integer> capacidaddisponibleenciudad = new ArrayList<>();



}
