package com.service;

import com.model.Course;

import java.util.Optional;

public interface AcademicServiceI {

    Optional<Course> findCourseByName(String name);

    void addCourse(Course course);
}
