package com.example.graphql.graphqldemo.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Company {
    private String id;
    private String name;
    private String description;
    private List<Job> jobs;
}
