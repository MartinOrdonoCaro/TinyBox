package aaa.moc.TinyBox.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Medida implements Serializable {
    private static final long serialVersionUID = 9187028543191880167L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotNull(message = "El campo peso no puede estar vacío.")
    @Min(value = 0, message = "El campo peso no puede ser negativo")
    @Max(value = 500, message = "El campo peso no puede ser superior a 500")
    private Double peso;

    @NotNull(message = "El campo altura no puede estar vacío.")
    @Min(value = 0, message = "El campo altura no puede ser negativo")
    @Max(value = 300, message = "El campo altura no puede ser superior a 300")
    private Double altura;

    @Min(value = 0, message = "El campo muslo no puede ser negativo")
    @Max(value = 300, message = "El campo muslo no puede ser superior a 300")
    private Double muslo;

    @Min(value = 0, message = "El campo cintura no puede ser negativo")
    @Max(value = 300, message = "El campo cintura no puede ser superior a 300")
    private Double cintura;

    @Min(value = 0, message = "El campo cadera no puede ser negativo")
    @Max(value = 300, message = "El campo cadera no puede ser superior a 300")
    private Double cadera;

    @Min(value = 0, message = "El campo muñeca no puede ser negativo")
    @Max(value = 300, message = "El campo muñeca no puede ser superior a 300")
    private Double muneca;

    @Min(value = 0, message = "El campo antetbrazo no puede ser negativo")
    @Max(value = 300, message = "El campo antetbrazo no puede ser superior a 300")
    private Double antebrazo;

    @Min(value = 0, message = "El campo brazo no puede ser negativo")
    @Max(value = 300, message = "El campo brazo no puede ser superior a 300")
    private Double brazo;

    @Min(value = 0, message = "El campo pecho no puede ser negativo")
    @Max(value = 300, message = "El campo pecho no puede ser superior a 300")
    private Double pecho;
}
