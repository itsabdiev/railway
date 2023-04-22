package com.plenka.railway.web;


import com.plenka.railway.model.Action;
import com.plenka.railway.repository.ActionRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/actions")
@RequiredArgsConstructor
public class ActionController {
    private final ActionRepository actionCollectionRepository;

    @GetMapping({"/",""})
    public List<Action> fetchAll() {
        return actionCollectionRepository.findAll();
    }

    @GetMapping({"/search","/search/"})
    public List<Action> searchAll(@RequestParam(name = "var",required = true) String var) {
        return actionCollectionRepository.search(var + ":*");
    }

    @GetMapping({"/{id}","/{id}/"})
    public Action fetchOne(@PathVariable(name = "id",required = false) Integer id) {
        return actionCollectionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Action not found")
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping({"/",""})
    public void saveOne(@RequestBody @Valid Action action) {
        if (actionCollectionRepository.existsById(action.getId())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Action already exists");
        actionCollectionRepository.save(action);
    }

    @PutMapping({"/{id}","/{id}/"})
    public void updateOne(@PathVariable Integer id,@RequestBody Action action) {
        if (!actionCollectionRepository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Action not found");
        actionCollectionRepository.save(action);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping({"/{id}","/{id}/"})
    public void deleteOne(@PathVariable Integer id) {
        if (!actionCollectionRepository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Action not found");
        actionCollectionRepository.deleteById(id);
    }

}
