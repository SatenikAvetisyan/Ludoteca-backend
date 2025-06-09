package com.ccsw.tutorial.game.repository;

import com.ccsw.tutorial.game.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {

}