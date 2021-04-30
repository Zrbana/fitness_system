package com.vip.zn.fitness_system.db.model;


import cn.hutool.core.date.DateTime;

public class Course {
    private Integer id;

    private String courseName;

    private DateTime courseBeginTime;

    private DateTime courseEndTime;

    private String teacherId;

    private String teacherName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public DateTime getCourseBeginTime() {
        return courseBeginTime;
    }

    public void setCourseBeginTime(DateTime courseBeginTime) {
        this.courseBeginTime = courseBeginTime;
    }

    public DateTime getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(DateTime courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}