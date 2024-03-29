package uz.mohirdev.lesson.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    public Student() {
    }

    private Long id;
    private String name;

    @JsonProperty("last_name")
    private String lastName;

    private Course course;

    private int age;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public Student(Long id, String name, String lastName, Course course, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.course = course;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
