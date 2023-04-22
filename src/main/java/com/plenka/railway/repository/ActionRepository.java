package com.plenka.railway.repository;

import com.plenka.railway.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action,Integer> {
    @Query(value = "select * from actions where to_tsvector(title || ' ' || description) @@ plainto_tsquery(?1)",nativeQuery = true)
    List<Action> search(String var);
}
