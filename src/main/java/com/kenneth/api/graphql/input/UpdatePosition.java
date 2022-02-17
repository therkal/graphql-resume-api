package com.kenneth.api.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.graphql.Input;

import java.time.LocalDate;
import java.util.Set;

@Input
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePosition {

    private String role;
    private LocalDate startDate;
    private LocalDate endDate;

    private String companyId;
    private Set<String> tags;
}
