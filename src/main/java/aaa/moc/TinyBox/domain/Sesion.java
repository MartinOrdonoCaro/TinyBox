package aaa.moc.TinyBox.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "sesion")
public class Sesion implements Serializable {
    private static final long serialVersionUID = 510671539539198425L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @NotNull(message = "El campo fecha inicio no puede estar vacío.")
    private Date fechaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @NotNull(message = "El campo fecha fin no puede estar vacío.")
    private Date fechaFin;

    @NotEmpty(message = "El campo estado no puede estar vacío.")
    @Pattern(regexp = "^(BORRADOR|HECHO|ENVIADO|ACABADO)$")
    @Column(length = 50)
    private String estado;


    /**
     * Relationships
     */
    @ManyToOne
    @JoinColumn(name="entrenamiento_id")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

}
