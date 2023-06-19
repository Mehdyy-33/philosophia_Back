package checkpoint3.philosophia.thinker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThinkerRepository extends JpaRepository<Thinker, Long> {
}
