package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewRoleRequest {

    protected String jobName;

    protected String jobResponsibility;

    protected String specSummary;

    protected int capabilityID;

    protected int bandLevelID;

    protected int jobFamilyID;

    @JsonCreator
    public NewRoleRequest(
            @JsonProperty("jobName") String jobName,
            @JsonProperty("jobResponsibility") String jobResponsibility,
            @JsonProperty("specSummary") String spec,
            @JsonProperty("jobFamilyId") int jobFamilyID,
            @JsonProperty("bandLevelId") int bandLevelID,
            @JsonProperty("capabilityId") int capabilityID
    ) {
        this.setJobName(jobName);
        this.setJobResponsibility(jobResponsibility);
        this.setSpecSummary(spec);
        this.setJobFamilyID(jobFamilyID);
        this.setBandLevelID(bandLevelID);
        this.setCapabilityID(capabilityID);
    }
}
