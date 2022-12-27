package com.portfolio.portfolio.Model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String puesto;
    private String empresa;
    private String anioInicio;
    private String anioFin;
    private String descripcion;
    private String logo;
   
    //Constructores

    public Experiencia() {
    }

    public Experiencia(String puesto, String empresa, String anioInicio, String anioFin, String descripcion, String logo) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.descripcion = descripcion;
        this.logo = logo;
    }
    
    // Getter and Setter
    
    
}