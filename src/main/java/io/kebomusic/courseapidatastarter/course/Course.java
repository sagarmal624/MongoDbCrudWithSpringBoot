package io.kebomusic.courseapidatastarter.course;

import io.kebomusic.courseapidatastarter.topic.Instructor;
import org.springframework.data.annotation.Id;

public class Course {

    @Id
    private String id;
    private String name;
    private String description;
    private String topicID;
    private String courseID;
    private Instructor instructor;

    public Course() {
        this.instructor = new Instructor();
    }

    public Course(String id, String name, String description, String topicID, Instructor instructor) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.topicID = topicID;
        this.instructor = instructor;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setInstructorFirstName(String firstName) {
        instructor.setFirstName(firstName);
    }

    public String getInstructorFirstName() {
        return instructor.getFirstName();
    }

    public void setInstructorLastName(String lastName) {
        instructor.setLastName(lastName);
    }

    public String getInstructorLastName() {
        return instructor.getLastName();
    }

    public void setInstructorDepartment(String department) {
        instructor.setDepartment(department);
    }

    public String getInstructorDepartment() {
        return instructor.getDepartment();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getTopicID() {
        return topicID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
}
