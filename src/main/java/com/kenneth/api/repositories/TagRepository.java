package com.kenneth.api.repositories;

import com.kenneth.api.models.Tag;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TagRepository implements ReactivePanacheMongoRepository<Tag> {
}
