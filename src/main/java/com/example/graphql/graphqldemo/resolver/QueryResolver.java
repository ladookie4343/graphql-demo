package com.example.graphql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.graphqldemo.domain.Company;
import com.example.graphql.graphqldemo.domain.DB;
import com.example.graphql.graphqldemo.domain.Job;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    public Job getJob(String id) {
        return DB.getJob(id);
    }

    public List<Job> getJobs() {
        return DB.getJobs();
    }

    public Company getCompany(String id) {
        return DB.getCompany(id);
    }

    public List<Company> getCompanies() {
        return DB.getCompanies();
    }
}
