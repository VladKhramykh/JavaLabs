package com.belstu.repositories;

import com.belstu.domain.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepo extends CrudRepository<Player, Long> {
    Player findUserByUsername(String username);
}
