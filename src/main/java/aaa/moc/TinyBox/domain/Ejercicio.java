package aaa.moc.TinyBox.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "eres tonto?")
    private String nombre;

    @NotEmpty(message = "tontissssimo")
    private String foto;

    private String explicacion;
}
