package com.ics.demo.groupAspring.models;

import javax.persistence.*;

//@Entity
//@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    private Teacher() {
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

    public interface Create {
    }

    public interface Update {
    }
}
