package com.kenneth.api.repositories;

import com.kenneth.api.models.Position;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PositionRepository implements ReactivePanacheMongoRepository<Position> {
}
