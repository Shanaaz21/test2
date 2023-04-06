package com.example.UniversitySuggestion.model;


public class PredictModel {
    private double qualityOfEducation;
    private double qualityOfFaculty;
    private double influence;
    private double score;

    public double getQualityOfEducation() {
        return qualityOfEducation;
    }

    public void setQualityOfEducation(double qualityOfEducation) {
        this.qualityOfEducation = qualityOfEducation;
    }

    public double getQualityOfFaculty() {
        return qualityOfFaculty;
    }

    public void setQualityOfFaculty(double qualityOfFaculty) {
        this.qualityOfFaculty = qualityOfFaculty;
    }

    public double getInfluence() {
        return influence;
    }

    public void setInfluence(double influence) {
        this.influence = influence;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
