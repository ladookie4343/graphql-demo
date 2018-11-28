package com.example.graphql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.graphqldemo.domain.Company;
import com.example.graphql.graphqldemo.domain.Job;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Builder
public class QueryResolver implements GraphQLQueryResolver {

    private static List<Job> jobs = Arrays.asList(
            Job.builder()
                    .id("1")
                    .companyId("c1")
                    .title("Frontend Developer")
                    .description("we are looking for a great front end developer")
                    .company(Company.builder().id("c1").name("foo").description("bar").build())
                    .build(),
            Job.builder()
                    .id("2")
                    .companyId("c2")
                    .title("Backend Developer")
                    .description("looking for a backend developer")
                    .company(Company.builder().id("c2").name("Indeed").description("we get people hired").build())
                    .build(),
            Job.builder()
                    .id("3")
                    .companyId("c3")
                    .title("Full-Stack Developer")
                    .description("full-stack devs are the best. work for us")
                    .company(Company.builder().id("c3").name("clearme").description("we get people identified").build())
                    .build()
    );

    private static List<Company> companies = Arrays.asList(
            Company.builder().id("c1").name("foo").description("bar").build(),
            Company.builder().id("c2").name("Indeed").description("we get people hired").build(),
            Company.builder().id("c3").name("clearme").description("we get people identified").build()
    );

    public Job getJob(String id) {
        return jobs.stream()
                .filter(job -> job.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }

    public List<Job> getJobs() {
        return this.jobs;
    }

    public Company getCompany(String id) {
        return companies.stream()
                .filter(company -> company.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);

    }
}
