package com.kenneth.api.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@MongoEntity
@Data
@Builder
public class Tag {

    @Id
    private String name;

    @ManyToMany
    private Set<Position> associatedPositions;

    public void addAssociatedPosition(Position p){
        this.associatedPositions.add(p);
    }
}
