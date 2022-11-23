package com.kainos.ea.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRole {
    protected int jobid;

    protected String jobName;

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    protected String jobResponsibility;

    public String getSpecification() {
        return specification;
    }

    protected String specification;

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobResponsibility() {
        return jobResponsibility;
    }

    public void setJobResponsibility(String jobResponsibility) {
        this.jobResponsibility = jobResponsibility;
    }

    @JsonCreator
    public JobRole(
            @JsonProperty("jobname") String jobname,
            @JsonProperty("jobResponsibility") String jobResponsibility
    ) {
        this.setJobName(jobname);
        this.setJobResponsibility(jobResponsibility);
    }

    @JsonCreator
    public JobRole(
            @JsonProperty("jobname") String jobname
    ) {
        this.setJobName(jobname);
    }
}
