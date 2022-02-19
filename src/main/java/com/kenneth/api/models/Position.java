package com.kenneth.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.graphql.Type;

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

    private ObjectId user;

    private String timeInService;
    private ObjectId company;
    private Set<String> tags;
}
