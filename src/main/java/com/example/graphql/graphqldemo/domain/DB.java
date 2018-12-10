package com.example.graphql.graphqldemo.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DB {
    private static List<Job> jobs;
    private static List<Company> companies;

    static {
        Job job1 = Job.builder()
                .id("1")
                .companyId("c1")
                .title("Frontend Developer")
                .description("we are looking for a great front end developer")
                .build();

        Company c1 = Company.builder().id("c1").name("foo").description("bar").build();

        c1.setJobs(Collections.singletonList(job1));
        job1.setCompany(c1);

        Job job2 = Job.builder()
                .id("2")
                .companyId("c2")
                .title("Backend Developer")
                .description("we are looking for a great back end developer")
                .build();

        Company c2 = Company.builder().id("c2").name("foo").description("bar").build();

        c2.setJobs(Collections.singletonList(job2));
        job2.setCompany(c2);

        Job job3 = Job.builder()
                .id("3")
                .companyId("c3")
                .title("poop Developer")
                .description("we are looking for a poop developer")
                .build();

        Company c3 = Company.builder().id("c3").name("foo").description("bar").build();

        c3.setJobs(Collections.singletonList(job3));
        job3.setCompany(c3);

        jobs = new ArrayList<>(Arrays.asList(job1, job2, job3));
        companies = new ArrayList<>(Arrays.asList(c1, c2, c3));
    }

    public static Job createJob(String companyId, String title, String description) {
        Job job = Job.builder()
                .id(String.valueOf(jobs.size() + 1))
                .title(title)
                .companyId(companyId)
                .description(description)
                .company(companies.stream().filter(c -> c.getId().equals(companyId)).collect(Collectors.toList()).get(0))
                .build();

        jobs.add(job);

        return job;
    }

    public static Job getJob(String id) {
        return jobs.stream()
                .filter(job -> job.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }

    public static List<Job> getJobs() {
        return jobs;
    }

    public static Company getCompany(String id) {
        return companies.stream()
                .filter(company -> company.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }

    public static List<Company> getCompanies() {
        return companies;
    }
}
