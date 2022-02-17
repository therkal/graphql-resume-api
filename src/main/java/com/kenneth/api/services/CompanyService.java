package com.kenneth.api.services;

import com.kenneth.api.models.Company;
import com.kenneth.api.repositories.CompanyRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CompanyService {

    @Inject
    CompanyRepository repository;

    public Uni<Company> saveCompany(Company company) {
        return this.repository.persistOrUpdate(company);
    }

    public Uni<List<Company>> get() {
        return repository.findAll().list();
    }
}
