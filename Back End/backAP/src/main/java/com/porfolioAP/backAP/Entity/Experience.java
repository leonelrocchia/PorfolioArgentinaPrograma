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
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ex_id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String ex_puesto;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String ex_empresa;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String ex_tipo;

    @NotNull
    @Size(min = 1, max = 500, message = "No cumple con la longitud.")
    private String ex_descripcion;

    @NotNull
    @Size(min = 1, max = 200, message = "No cumple con la longitud.")
    private String ex_img;

    @NotNull
    @Size(min = 1, max = 20, message = "No cumple con la longitud.")
    private String ex_inicio;

    @Size(min = 1, max = 20, message = "No cumple con la longitud.")
    private String ex_final;

}
