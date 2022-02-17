package com.kenneth.api.models;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import org.eclipse.microprofile.graphql.Id;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

public class BaseEntity extends ReactivePanacheMongoEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String id;
}
