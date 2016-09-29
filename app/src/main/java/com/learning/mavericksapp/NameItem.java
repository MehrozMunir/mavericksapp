package com.learning.mavericksapp;
public class NameItem {
    private String id;
    private String fname;
    private String lname;

    public NameItem(String fname,String lname){
        this.fname  = fname;
        this.lname = lname;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
}
