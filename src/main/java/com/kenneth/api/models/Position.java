package com.kenneth.api.models;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

public class Position {

    private String role;

    private LocalDate startDate;
    private LocalDate endDate;

    private String timeInService;

    @ManyToOne
    private Company company;

    @OneToMany
    private Set<Tag> tags;
}
