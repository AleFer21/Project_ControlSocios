package com.ale.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "socio")
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSocio;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    private String telefono;

}
