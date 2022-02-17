package com.kenneth.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.graphql.Type;

import javax.persistence.UniqueConstraint;

@Type
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String githubUrl;
    private String linkedInUrl;
    private String website;
}
