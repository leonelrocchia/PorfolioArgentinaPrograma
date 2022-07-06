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
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ed_id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String ed_titulo;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String ed_institucion;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String ed_tipo;

    @NotNull
    @Size(min = 1, max = 500, message = "No cumple con la longitud.")
    private String ed_descripcion;

    @NotNull
    @Size(min = 1, max = 200, message = "No cumple con la longitud.")
    private String ed_img;

    @NotNull
    @Size(min = 1, max = 20, message = "No cumple con la longitud.")
    private String ed_inicio;

    @Size(min = 1, max = 20, message = "No cumple con la longitud.")
    private String ed_final;

}
