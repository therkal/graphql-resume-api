package com.kenneth.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.graphql.Type;

@Type
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company extends BaseEntity {
    private String name;
    private String lat;
    private String lon;
    private String city;
    private String country;
}
