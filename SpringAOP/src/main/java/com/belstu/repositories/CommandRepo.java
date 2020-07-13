package com.belstu.repositories;

import com.belstu.domain.Command;
import com.belstu.domain.Discipline;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandRepo extends CrudRepository<Command, Long> {
    List<Command> findAllByDiscipline(Discipline discipline);
}
