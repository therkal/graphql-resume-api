package com.kenneth.api.graphql;

import com.kenneth.api.graphql.input.UpdatePosition;
import com.kenneth.api.models.Position;
import com.kenneth.api.services.PositionService;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class PositionGraphqlApi {

    @Inject
    PositionService service;

    @Query
    public Uni<List<Position>> positions() {
        return service.get();
    }

    @Mutation
    public Uni<Position> createPosition(@Name("position") UpdatePosition createPositionRequest) {
        return service.createOrUpdate(createPositionRequest);
    }
}
