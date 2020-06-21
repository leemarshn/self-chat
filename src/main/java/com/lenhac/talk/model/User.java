package com.lenhac.talk.model;


import com.lenhac.talk.validator.ValidPassword;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

@Entity

@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "user_id_generator",
            sequenceName = "user_id_sequence",
            initialValue = 1000
    )
    private Long id;
    @NotNull
    @Size(min = 3, max = 100)
    private String fname;
    @NotNull
    @Size(min = 3, max = 100)
    private String lname;
    private long phone;
    @NotNull
    @Email(message = "Please enter a valid e-mail address")
    private String email;
    @ValidPassword
    private String password;
    @Transient
    private String confirmPassword;





    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }




    @Temporal(DATE)
    @DateTimeFormat(pattern="YYYY-MM-dd")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    private Date dob;



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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
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
