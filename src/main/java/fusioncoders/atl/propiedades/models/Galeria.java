package fusioncoders.atl.propiedades.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "vendedor")
public class Galeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dni")
    private String dni;
}
