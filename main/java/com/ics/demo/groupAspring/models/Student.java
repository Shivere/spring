package com.ics.demo.groupAspring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "student_number")
    private String studentNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "score")
    private int score = 0;

//    @JsonIgnore
//    @ManyToOne
////    @JoinColumn(name = "movie_id_fk")
//    private Teacher teacher;

    public Student(String studentNumber, String firstName) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
    }

    private Student() {
    }

    public Long getId() {
            return id;
        }

    public void setId(Long id) {
            this.id = id;
        }

    public String getStudentNumber() {
            return studentNumber;
        }

    public void setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
        }

    public String getFirstName() {
            return firstName;
        }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

    public int getScore() {
            return score;
        }

    public void setScore(int score) {
            this.score = score;
        }

//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", score=" + score +
                '}';
    }

    public interface Create{}

    public interface update {
    }
}
