package com.survey.models;

public class SurveyDto {
    private final int id;
    private final String name;
    private final int expectedCompletes;
    private final int completionPoints;
    private final int filteredPoints;
    private final double averageTimeToComplete;

    public SurveyDto(int id, String name, int expectedCompletes, int completionPoints, int filteredPoints, double averageTimeToComplete) {
        this.id = id;
        this.name = name;
        this.expectedCompletes = expectedCompletes;
        this.completionPoints = completionPoints;
        this.filteredPoints = filteredPoints;
        this.averageTimeToComplete = averageTimeToComplete;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getExpectedCompletes() {
        return expectedCompletes;
    }

    public int getCompletionPoints() {
        return completionPoints;
    }

    public int getFilteredPoints() {
        return filteredPoints;
    }

    public double getAverageTimeToComplete() {
        return averageTimeToComplete;
    }

    public static SurveyDto convert(Survey s, double averageTimeToComplete){
        return new SurveyDto(s.getId(),s.getName(),s.getExpectedCompletes(),s.getCompletionPoints(),
                s.getFilteredPoints(), averageTimeToComplete);
    }
}
