package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRole {
    protected int jobid;
    protected String jobName;
    protected String jobResponsibility;

    @JsonCreator
    public JobRole(
            @JsonProperty("jobName") String jobname
    ) {
        this.setJobName(jobname);
    }

}