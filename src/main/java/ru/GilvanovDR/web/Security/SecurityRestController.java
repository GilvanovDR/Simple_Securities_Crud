package ru.GilvanovDR.web.Security;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.GilvanovDR.model.Security;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = SecurityRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityRestController extends AbstractSecurityController {
    static final String REST_URL = "/rest/security";

    @GetMapping
    public List<Security> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Security get(@PathVariable int id) {
        return super.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Security> createWithLocation(@RequestBody Security security) {
        Security created = super.create(security);
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
    public void update(@RequestBody Security security) {
        super.update(security);
    }

    @GetMapping("/by")
    public Security getBySecId(@RequestParam String secId) {
        return super.getBySecId(secId);
    }
}
