package com.kenneth.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.graphql.Type;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Type
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position extends BaseEntity {

    private String role;

    private LocalDate startDate;
    private LocalDate endDate;

    private String timeInService;

    @ManyToOne
    private Company company;

    @ManyToMany
    private Set<Tag> tags;
}
