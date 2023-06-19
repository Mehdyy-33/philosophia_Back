package checkpoint3.philosophia.thinker;


import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThinkerService {
    private final ThinkerRepository thinkerRepository;

    public ThinkerService(ThinkerRepository thinkerRepository) {
        this.thinkerRepository = thinkerRepository;
    }

    public List<Thinker> getAll() {
        return thinkerRepository.findAll();
    }

    public Thinker getById(Long id) {
        return thinkerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Thinker not found"));
    }

    public Thinker add(Thinker thinker) {
        return thinkerRepository.save(thinker);
    }

    public Thinker update(Thinker thinker, Long id) {
        Thinker existingThinker = thinkerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Thinker not found"));
        existingThinker.setName(thinker.getName());
        existingThinker.setBiography(thinker.getBiography());
        return thinkerRepository.save(existingThinker);
    }

    public void delete(Long id) {
        thinkerRepository.deleteById(id);
    }
    public Thinker save(Thinker thinker) {
        return thinkerRepository.save(thinker);
    }
}
