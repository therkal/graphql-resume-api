package com.kenneth.api.services;

import com.kenneth.api.graphql.input.UpdatePosition;
import com.kenneth.api.models.Position;
import com.kenneth.api.models.Tag;
import com.kenneth.api.repositories.PositionRepository;
import com.kenneth.api.repositories.TagRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class PositionService {

    @Inject
    PositionRepository repository;

    @Inject
    TagRepository tagRepository;

    public Uni<Position> createOrUpdate(UpdatePosition createPositionRequest) {
        Set<Tag> tagSet;

        Position toBeCreated = Position.builder()
                .role(createPositionRequest.getRole())
                .startDate(createPositionRequest.getStartDate())
                .endDate(createPositionRequest.getEndDate())
                //ToDo: add Company
                .build();

        tagSet = createPositionRequest.getTags().stream()
                .map(s ->
                    tagRepository.find("name", s)
                        .firstResult().await()
                        .asOptional().indefinitely()
                        .orElse(
                            Tag.builder()
                                    .name(s)
                                    .build()
                    ))
                .collect(Collectors.toSet());

        toBeCreated.setTags(tagSet);

        return repository.persistOrUpdate(toBeCreated);
    }

    public Uni<List<Position>> get() {
        return repository.findAll().list();
    }
}
