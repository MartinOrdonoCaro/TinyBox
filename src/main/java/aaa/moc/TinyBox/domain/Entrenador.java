package aaa.moc.TinyBox.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
//@NoArgsConstructor
public class Entrenador extends Actor implements Serializable {
    private static final long serialVersionUID = -5117985404128879828L;
}
