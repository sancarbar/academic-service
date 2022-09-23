package com.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    final String name;
    final String email;
    final String phoneNumber;
    final List<Course> enrolledCourses = new ArrayList<>();
    private final String id;
    double average;

    public Student(String id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }
}
