package checkpoint3.philosophia.philosophicalMovement;

import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhilosophicalMovementService {
    private final PhilosophicalMovementRepository philosophicalMovementRepository;

    public PhilosophicalMovementService(PhilosophicalMovementRepository philosophicalMovementRepository) {
        this.philosophicalMovementRepository = philosophicalMovementRepository;
    }

    public List<PhilosophicalMovement> getAll() {
        return philosophicalMovementRepository.findAll();
    }

    public PhilosophicalMovement getById(Long id) {
        return philosophicalMovementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Philosophical Movement not found"));
    }

    public PhilosophicalMovement add(PhilosophicalMovement philosophicalMovement) {
        return philosophicalMovementRepository.save(philosophicalMovement);
    }

    public PhilosophicalMovement update(PhilosophicalMovement philosophicalMovement, Long id) {
        PhilosophicalMovement existingMovement = philosophicalMovementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Philosophical Movement not found"));

        existingMovement.setName(philosophicalMovement.getName());
        existingMovement.setDescription(philosophicalMovement.getDescription());

        return philosophicalMovementRepository.save(existingMovement);
    }

    public void delete(Long id) {
        philosophicalMovementRepository.deleteById(id);
    }
}

