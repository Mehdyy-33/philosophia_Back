package checkpoint3.philosophia.thinker;

import checkpoint3.philosophia.philosophicalMovement.PhilosophicalMovement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Thinker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String biography;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "thinker_id", referencedColumnName = "id")
    @JsonIgnoreProperties("thinker")
    private Set<PhilosophicalMovement> philosophicalMovementsList = new HashSet<>();
}
