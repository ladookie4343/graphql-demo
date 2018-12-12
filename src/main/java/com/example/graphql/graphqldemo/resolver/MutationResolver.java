package com.example.graphql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.graphqldemo.domain.CreateJob;
import com.example.graphql.graphqldemo.domain.DB;
import com.example.graphql.graphqldemo.domain.Job;
import com.example.graphql.graphqldemo.domain.User;
import com.example.graphql.graphqldemo.service.TokenService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    public Job createJob(CreateJob cj, DataFetchingEnvironment env) throws Exception {
        User user = TokenService.loggedInUser(env);

        if (user == null) {
            throw new Exception("unauthorized");
        }

        return DB.createJob(user.getCompanyId(), cj.getTitle(), cj.getDescription());
    }
}
