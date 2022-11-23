package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class JobRole {

    @Getter @Setter
    protected int jobid;

    @Getter @Setter
    protected String jobName;

    @Getter @Setter
    protected String jobResponsibility;

    @JsonCreator
    public JobRole(
            @JsonProperty("jobname") String jobname,
            @JsonProperty("jobResponsibility") String jobResponsibility
    ) {
        this.setJobName(jobname);
        this.setJobResponsibility(jobResponsibility);
    }

}
