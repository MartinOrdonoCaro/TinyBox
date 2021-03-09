package aaa.moc.TinyBox.domain;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "actividad")
public class Actividad implements Serializable {
    private static final long serialVersionUID = -2039009858826620761L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotNull(message = "El campo series no puede estar vacío")
    @Range(max= 50, message = "El campo series no puede tener más de 50 series")
    @Column(length = 50)
    private int series;

    @NotNull(message = "El campo repeticiones no puede estar vacío.")
    @Range(max= 80, message = "El campo repeticiones no puede tener más de 80 repeticiones")
    @Column(length = 80)
    private int repeticiones;

    @NotNull(message = "El campo descanso no puede estar vacío.")
    @Range(max= 300, message = "El campo descanso no puede tener más de 300 segundos") //No creo que vaya a ver un descanso de mas de 5 min
    @Column(length = 300)
    private int descanso;

    @NotNull(message = "El campo carga no puede estar vacío.")
    @Range(max=150, message = "El campo carga no puede tener más de 150 kilogramos") //Creo que adolfo no tiene tanto peso en el TinyBox
    @Column(length = 150)
    private int carga;

    @Size(max = 50, message = "El campo observaciones no puede tener más de 50 caracteres")
    @Column(length = 50)
    private String observaciones;

    @NotEmpty(message = "El campo tipo no puede estar vacío.")
    @Size(max = 50, message = "El campo foto no puede tener más de 50 caracteres")
    @Column(length = 50)
    private String tipo;

}
