package checkpoint3.philosophia.philosophicalMovement;

import checkpoint3.philosophia.thinker.Thinker;
import checkpoint3.philosophia.thinker.ThinkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
@RequiredArgsConstructor
public class PhilosophicalMovementController {
    private final PhilosophicalMovementService philosophicalMovementService;
    private final ThinkerService thinkerService;

    @GetMapping
    public List<PhilosophicalMovement> getAll() {
        return philosophicalMovementService.getAll();
    }

    @GetMapping("/{id}")
    public PhilosophicalMovement getById(@PathVariable("id") Long id) {
        return philosophicalMovementService.getById(id);
    }

    @PostMapping("/add")
    public PhilosophicalMovement add(@RequestBody PhilosophicalMovement philosophicalMovement) {
        return philosophicalMovementService.add(philosophicalMovement);
    }

    @PutMapping("/update/{id}")
    public PhilosophicalMovement update(@RequestBody PhilosophicalMovement philosophicalMovement, @PathVariable("id") Long id) {
        return philosophicalMovementService.update(philosophicalMovement, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        philosophicalMovementService.delete(id);
    }
}
