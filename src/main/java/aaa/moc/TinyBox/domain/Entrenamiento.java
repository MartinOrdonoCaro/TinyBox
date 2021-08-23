package aaa.moc.TinyBox.domain;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "entrenamiento")
public class Entrenamiento implements Serializable {
    private static final long serialVersionUID = 1430940573646730649L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;


    /**
     * Relationships
     */
    @ManyToMany
    @JoinTable(
            name = "entrenamiento_calentamiento",
            joinColumns = @JoinColumn(name = "entrenamiento_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id"))
    private List<Actividad> actividadesCalentamiento;

    @ManyToMany
    @JoinTable(
            name = "entrenamiento_principal",
            joinColumns = @JoinColumn(name = "entrenamiento_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id"))
    private List<Actividad> actividadesPrincipal;

    @ManyToMany
    @JoinTable(
            name = "entrenamiento_final",
            joinColumns = @JoinColumn(name = "entrenamiento_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id"))
    private List<Actividad> actividadesFinal;

}
