package com.kenneth.api.models;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Data;

import javax.persistence.ManyToMany;
import java.util.Set;

@Data
public class Tag extends ReactivePanacheMongoEntity {
    private String name;
}
