package com.example.graphql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.graphqldemo.domain.CreateJob;
import com.example.graphql.graphqldemo.domain.DB;
import com.example.graphql.graphqldemo.domain.Job;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    public Job createJob(CreateJob cj) {
        return DB.createJob(cj.getCompanyId(), cj.getTitle(), cj.getDescription());
    }
}
