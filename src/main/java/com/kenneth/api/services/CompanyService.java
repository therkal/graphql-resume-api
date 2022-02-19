package com.kenneth.api.services;

import com.kenneth.api.models.Company;
import com.kenneth.api.repositories.CompanyRepository;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class CompanyService {

    @Inject
    CompanyRepository repository;

    public Uni<Company> saveCompany(Company company) {
        return this.repository.persistOrUpdate(company);
    }

    public Uni<Company> findById(ObjectId id) {
        return repository.findById(id)
                // If the item cannot be found, fail
                .onItem().ifNull().fail()
                // Throw exception on failure.
                .onFailure()
                .transform(t -> new NotFoundException("Company with id: " + id +" not found"));
    }
    public Uni<List<Company>> get() {
        return repository.findAll().list();
    }
}
