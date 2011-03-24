package com.rs.core;

public class Job {
    int id;
    String companyName;
    String location;
    String experience;
    String industry;
    String function;

    public Job(int id, String companyName, String location, String experience, String industry, String function) {
        this.id = id;
        this.companyName = companyName;
        this.location = location;
        this.experience = experience;
        this.industry = industry;
        this.function = function;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public String getExperience() {
        return experience;
    }

    public String getIndustry() {
        return industry;
    }

    public String getFunction() {
        return function;
    }

    public String toString() {
        return companyName + " " + location + " " + experience + " " + industry + " " + function;
    }


}
