package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class jobrole {

    protected int jobid;

    protected String jobName;

    protected String jobResponsibility;

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
    public jobrole(
            @JsonProperty("jobname") String jobname,
            @JsonProperty("jobResponsibility") String jobResponsibility
    ) {
        this.setJobName(jobname);
        this.setJobResponsibility(jobResponsibility);
    }

}
