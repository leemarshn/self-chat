package com.lenhac.talk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class user {

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "user_id_generator",
            sequenceName = "user_id_sequence",
            initialValue = 220032
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String fname;

    @NotBlank
    @Size(min = 3, max = 100)
    private String lname;

    @NotBlank
    @Size(min = 3, max = 10)
    private int phone;

    @NotBlank
    @Size(min = 3, max = 100)
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + fname + ", email=" + email + '}';
    }
}
