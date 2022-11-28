package com.kainos.ea.model;

public class BandLevel {

    private int bandLevelID;
    private int bandLevel;
    private String bandName;

    public BandLevel() {
    }

    public int getBandLevelID() {
        return bandLevelID;
    }

    public BandLevel(int bandLevelID, int bandLevel, String bandName) {
        this.bandLevelID = bandLevelID;
        this.bandLevel = bandLevel;
        this.bandName = bandName;
    }

    public void setBandLevelID(int bandLevelID) {
        this.bandLevelID = bandLevelID;
    }

    public int getBandLevel() {
        return bandLevel;
    }

    public void setBandLevel(int bandLevel) {
        this.bandLevel = bandLevel;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

}
