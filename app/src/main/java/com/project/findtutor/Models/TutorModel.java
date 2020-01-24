package com.project.findtutor.Models;

import android.content.Context;

public class TutorModel {
    int id;
    String tutName;
    String tutEmail;
    int tutPhoneNo;
    String tutAddress;
    String tutQualification;
    String tutExperience;
    String tutClass;
    String tutSubjects, tutGender;
    int tutTiming;

    public String getTutUserName() {
        return tutUserName;
    }

    public void setTutUserName(String tutUserName) {
        this.tutUserName = tutUserName;
    }

    public String getTutPassword() {
        return tutPassword;
    }

    public void setTutPassword(String tutPassword) {
        this.tutPassword = tutPassword;
    }

    String tutUserName, tutPassword;


    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;

    }

    public String gettutName() {
        return tutName;

    }

    public void settutName(String tutName) {
        this.tutName = tutName;

    }

    public String gettutGender() {
        return tutGender;

    }

    public void settutGender(String tutGender) {
        this.tutGender = tutGender;

    }

    public String gettutEmail() {
        return tutEmail;

    }

    public void settutEmail(String
                                    tutEmail) {
        this.tutEmail = tutEmail;

    }

    public int gettutPhoneNo() {
        return tutPhoneNo;

    }

    public void settutPhoneNo(int tutPhoneNo) {
        this.tutPhoneNo = tutPhoneNo;

    }

    public String gettutAddress() {
        return tutAddress;

    }

    public void settutAddress(String tutAddress) {
        this.tutAddress = tutAddress;

    }

    public String getutQualification() {
        return tutQualification;

    }

    public void settutQualification(String tutQualification) {
        this.tutQualification = tutQualification;

    }

    public String gettutExperience() {
        return tutExperience;

    }

    public void settutExperience(String tutExperience) {
        this.tutExperience = tutExperience;

    }

    public String gettutSubjects() {
        return tutSubjects;

    }

    public void settutSubjects(String tutSubjects) {
        this.tutSubjects = tutSubjects;

    }

    public String gettutClass() {
        return tutClass;

    }

    public void settutClass(String tutClass) {
        this.tutClass = tutClass;

    }

    public int gettutTiming() {
        return tutTiming;

    }

    public void settutTiming(int tutTiming) {
        this.tutTiming = tutTiming;

    }

}
