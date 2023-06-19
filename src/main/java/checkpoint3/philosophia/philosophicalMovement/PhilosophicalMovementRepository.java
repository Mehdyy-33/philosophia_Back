package checkpoint3.philosophia.philosophicalMovement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhilosophicalMovementRepository extends JpaRepository<PhilosophicalMovement, Long> {
}
