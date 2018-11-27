package com.example.graphql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.graphqldemo.domain.Job;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Builder
public class QueryResolver implements GraphQLQueryResolver {

    public List<Job> jobs() {
        return Arrays.asList(
                Job.builder().id("1").companyId("c1").title("Frontend Developer").description("we are looking for a great front end developer").build(),
                Job.builder().id("2").companyId("c2").title("Backend Developer").description("looking for a backend developer").build(),
                Job.builder().id("3").companyId("c3").title("Full-Stack Developer").description("full-stack devs are the best. work for us").build()
        );
    }
}
