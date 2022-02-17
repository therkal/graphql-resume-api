package com.kenneth.api.graphql;

import com.kenneth.api.models.Company;
import com.kenneth.api.services.CompanyService;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class CompanyGraphqlApi {

    @Inject
    CompanyService service;

    @Query
    public Uni<List<Company>> companies() {
        return service.get();
    }

    @Mutation
    public Uni<Company> createCompany(@Name("company") Company saveCompanyRequest) {
        return service.saveCompany(saveCompanyRequest);
    }

}
