package aaa.moc.TinyBox.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ejercicio")
public class Ejercicio implements Serializable {
    private static final long serialVersionUID = 9187028543191880167L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotEmpty(message = "El campo nombre no puede estar vacío.")
    @Size(max = 50, message = "El campo nombre no puede tener más de 50 caracteres")
    @Column(length = 50)
    private String nombre;

    @NotEmpty(message = "El campo foto no puede estar vacío.")
    @Size(max = 50, message = "El campo foto no puede tener más de 50 caracteres")
    @Column(length = 50)
    private String foto;

    @Size(max = 150, message = "El campo explicación no puede tener más de 50 caracteres")
    @Column(length = 150)
    private String explicacion;
}
