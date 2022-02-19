package com.kenneth.api.services;

import com.kenneth.api.graphql.input.UpdatePosition;
import com.kenneth.api.models.BaseEntity;
import com.kenneth.api.models.Company;
import com.kenneth.api.models.Position;
import com.kenneth.api.repositories.PositionRepository;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Slf4j
@ApplicationScoped
public class PositionService {

    @Inject
    PositionRepository repository;

    @Inject
    CompanyService companyService;

    public Uni<Position> createOrUpdate(UpdatePosition createPositionRequest) {
        return companyService
                // Find company by id
                .findById(new ObjectId(createPositionRequest.getCompanyId()))
                // If found, get the id
                .map(BaseEntity::getId)
                // Switch streams to process the persist operation.
                .flatMap(id -> {
                    Position toBeCreated = Position.builder()
                        .role(createPositionRequest.getRole())
                        .startDate(createPositionRequest.getStartDate())
                        .endDate(createPositionRequest.getEndDate())
                        .tags(createPositionRequest.getTags())
                        .company(id)
                        .build();

                    return repository.persistOrUpdate(toBeCreated);
                });
    }

    public Uni<List<Position>> get() {
        return repository.findAll().list();
    }
}
