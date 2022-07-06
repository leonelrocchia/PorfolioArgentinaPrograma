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
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sk_id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String sk_nombre;

    @NotNull
    @Size(min = 1, max = 3, message = "No cumple con la longitud.")
    private Integer sk_nivel;

}
