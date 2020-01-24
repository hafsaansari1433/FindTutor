package com.project.findtutor.Models;

import android.content.Context;

public class StudentModel {
    int id;
    String stdName;
    String stdFatherName;
    int stdPhoneno;
    String stdAddress;
    String stdClass;
    String stdSubject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdFatherName() {
        return stdFatherName;
    }

    public void setStdFatherName(String stdFatherName) {
        this.stdFatherName = stdFatherName;
    }

    public int getStdPhoneno() {
        return stdPhoneno;
    }

    public void setStdPhoneno(int stdPhoneno) {
        this.stdPhoneno = stdPhoneno;
    }

    public String getStdAddress() {
        return stdAddress;
    }

    public void setStdAddress(String stdAddress) {
        this.stdAddress = stdAddress;
    }

    public String getStdClass() {
        return stdClass;
    }

    public void setStdClass(String stdClass) {
        this.stdClass = stdClass;
    }

    public String getStdSubject() {
        return stdSubject;
    }

    public void setStdSubject(String stdSubject) {
        this.stdSubject = stdSubject;
    }
}

