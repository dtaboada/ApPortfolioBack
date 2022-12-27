/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {
    @NotBlank
    private String puesto;
    private String empresa;
    private String anioInicio;
    private String anioFin;
    private String descripcion;
    private String logo;
    
    //Constructor

    public dtoExperiencia() {
    }

    public dtoExperiencia(String puesto, String empresa, String anioInicio, String anioFin, String descripcion, String logo) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.descripcion = descripcion;
        this.logo = logo;
    }
    
    
    
}
