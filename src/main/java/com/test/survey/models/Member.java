package com.test.survey.models;


public class Member {
    private int id;
    private String fullName;
    private String emailAddress;
    private int isActive;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public Member(){

    }
    public Member(int id, String fullName, String emailAddress, int isActive) {
        this.id = id;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
