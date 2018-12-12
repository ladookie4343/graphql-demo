package com.example.graphql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.graphqldemo.domain.Company;
import com.example.graphql.graphqldemo.domain.DB;
import com.example.graphql.graphqldemo.domain.Job;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    public Job getJob(String id, DataFetchingEnvironment env) {
        Object context = env.getContext();
        return DB.getJob(id);
    }

    public List<Job> getJobs(DataFetchingEnvironment env) {
        return DB.getJobs();
    }

    public Company getCompany(String id) {
        return DB.getCompany(id);
    }

    public List<Company> getCompanies() {
        return DB.getCompanies();
    }
}
