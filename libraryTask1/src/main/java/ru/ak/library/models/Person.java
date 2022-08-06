package ru.ak.library.models;

public class Person {

    private int id;

    private String fullName;
    private int year;


    public Person(String fullName, int year) {
        this.fullName = fullName;
        this.year = year;
    }

    public Person() {

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
