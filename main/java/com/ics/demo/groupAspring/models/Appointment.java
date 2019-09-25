package com.ics.demo.groupAspring.models;

import javax.persistence.*;

//@Entity
//@Table(name = "appointments")
public class Appointment {


    private Long studentId;
    private Long teacherId;
    private boolean confirmed;

    private Appointment(){}

    public Appointment(Long studentId, Long teacherId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}

