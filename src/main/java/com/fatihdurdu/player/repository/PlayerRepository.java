package com.fatihdurdu.player.repository;

import com.fatihdurdu.player.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player,String> {
}
