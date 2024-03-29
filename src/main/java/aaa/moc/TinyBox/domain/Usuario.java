package aaa.moc.TinyBox.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Actor implements Serializable {
    private static final long serialVersionUID = 2749092248295024083L;

    @NotNull(message = "El numero de entrenos no puede estar vacío.")
    @Min(value = 0, message = "El número de entrenos no puede ser negativo")
    @Max(value = 7, message = "El número de entrenos no puede ser superior a 7")
    private Integer numeroEntrenos;

    @Size(max = 1000, message = "El campo lesiones no puede tener más de 1000 caracteres")
    private String lesiones;
}
