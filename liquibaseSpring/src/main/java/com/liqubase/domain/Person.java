package com.liqubase.domain;

import javax.persistence.*;

/**
 * @author tao_wc
 * @date 2018/1/19
 */
@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstname;
    private String lastname;
    private char state;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }
}
