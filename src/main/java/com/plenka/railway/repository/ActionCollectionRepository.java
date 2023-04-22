package com.plenka.railway.repository;


import com.plenka.railway.model.Action;
import com.plenka.railway.model.Status;
import com.plenka.railway.model.Type;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class ActionCollectionRepository {

    private final List<Action> collection = new ArrayList<>();

    public List<Action> findAll() {
        return collection;
    }

    public Optional<Action> findById(Integer id) {
        return collection.stream().filter(x-> x.getId().equals(id)).findFirst();
    }

    public boolean existsById(Integer id) {
        return collection.stream().anyMatch(x -> x.getId().equals(id));
    }
    public void save(Action action) {
        deleteById(action.getId());
        collection.add(action);
    }
    public void deleteById(Integer id) {
        collection.removeIf(x -> x.getId().equals(id));
    }
    @PostConstruct
    private void init() {
        Action action = Action.builder()
                .id(1)
                .title("Working on project")
                .contentType(Type.JOB)
                .url("-")
                .updatedAt(LocalDateTime.now())
                .status(Status.IDEA)
                .description("Complete chat application")
                .build();
        collection.add(action);

    }
}
