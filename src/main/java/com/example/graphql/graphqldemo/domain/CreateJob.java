package com.example.graphql.graphqldemo.domain;

import lombok.Data;

@Data
public class CreateJob {
    private String companyId;
    private String title;
    private String description;
}
