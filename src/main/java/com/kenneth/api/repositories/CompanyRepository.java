package com.kenneth.api.repositories;

import com.kenneth.api.models.Company;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompanyRepository implements ReactivePanacheMongoRepository<Company> {
}
