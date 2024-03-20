package com.survey.models;

public class Survey {
    private int id;
    private String name;
    private int expectedCompletes;
    private int completionPoints;
    private int filteredPoints;

    public Survey(int id, String name, int expectedCompletes, int completionPoints, int filteredPoints) {
        this.id = id;
        this.name = name;
        this.expectedCompletes = expectedCompletes;
        this.completionPoints = completionPoints;
        this.filteredPoints = filteredPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpectedCompletes() {
        return expectedCompletes;
    }

    public void setExpectedCompletes(int expectedCompletes) {
        this.expectedCompletes = expectedCompletes;
    }

    public int getCompletionPoints() {
        return completionPoints;
    }

    public void setCompletionPoints(int completionPoints) {
        this.completionPoints = completionPoints;
    }

    public int getFilteredPoints() {
        return filteredPoints;
    }

    public void setFilteredPoints(int filteredPoints) {
        this.filteredPoints = filteredPoints;
    }
}
