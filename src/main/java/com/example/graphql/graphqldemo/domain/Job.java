package com.example.graphql.graphqldemo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Job {
    private String id;
    private String companyId;
    private String title;
    private String description;
}
