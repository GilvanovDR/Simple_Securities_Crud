package ru.GilvanovDR.web.History;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.GilvanovDR.model.History;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = HistoryRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoryRestController extends AbstractHistoryController {
    static final String REST_URL = "/rest/history";

    @GetMapping
    public List<History> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public History get(@PathVariable int id) {
        return super.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<History> createWithLocation(@RequestBody History history, @RequestBody String secId) {
        History created = super.create(history, secId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        super.delete(id);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody History history, @RequestBody String secId) {
        super.update(history, secId);
    }

}
