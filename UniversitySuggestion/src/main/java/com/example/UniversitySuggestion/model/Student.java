package com.example.UniversitySuggestion.model;

public class Student {
    private String name;
    private String email;
    private String gender;
    private String address;
    private String schoolName;
    private double qualityOfEducation;
    private double qualityOfFaculty;
    private double influence;
    private double score;
    private String institution;

    public String getInstitution() {
        return institution;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", qualityOfEducation=" + qualityOfEducation +
                ", qualityOfFaculty=" + qualityOfFaculty +
                ", influence=" + influence +
                ", score=" + score +
                ", institution='" + institution + '\'' +
                '}';
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

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
