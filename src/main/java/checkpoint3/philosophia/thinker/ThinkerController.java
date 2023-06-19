package checkpoint3.philosophia.thinker;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thinkers")
@RequiredArgsConstructor
public class ThinkerController {
    private final ThinkerService thinkerService;

    @GetMapping
    public List<Thinker> getAll() {
        return thinkerService.getAll();
    }

    @GetMapping("/{id}")
    public Thinker getById(@PathVariable("id") Long id) {
        return thinkerService.getById(id);
    }

    @PostMapping("/add")
    public Thinker add(@RequestBody Thinker thinker) {
        return thinkerService.add(thinker);
    }

    @PutMapping("/update/{id}")
    public Thinker update(@RequestBody Thinker thinker, @PathVariable("id") Long id) {
        return thinkerService.update(thinker, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        thinkerService.delete(id);
    }
}
