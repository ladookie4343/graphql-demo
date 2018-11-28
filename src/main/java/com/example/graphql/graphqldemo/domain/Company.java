package com.example.graphql.graphqldemo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {
    private String id;
    private String name;
    private String description;
}
