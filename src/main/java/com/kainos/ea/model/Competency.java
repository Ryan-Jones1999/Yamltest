package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Competency {

    protected int competencyID;
    protected String subheading;
    protected String information;

    @JsonCreator
    public Competency(@JsonProperty("competencyID") int competencyID,  @JsonProperty("subheading") String subheading,  @JsonProperty("information") String info) {
        this.competencyID = competencyID;
        this.subheading = subheading;
        this.information = info;
    }
}