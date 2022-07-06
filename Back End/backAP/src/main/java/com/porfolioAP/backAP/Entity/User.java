package com.porfolioAP.backAP.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long us_id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String us_nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String us_apellido;

    @Size(min = 1, max = 500, message = "No cumple con la longitud.")
    private String us_img;

    @NotNull
    @Size(min = 1, max = 500, message = "No cumple con la longitud.")
    private String us_titulo;

    @NotNull
    @Size(min = 1, max = 2500, message = "No cumple con la longitud.")
    private String us_descripcion;

}
