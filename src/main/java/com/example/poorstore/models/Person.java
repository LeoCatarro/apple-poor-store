package com.example.poorstore.models;

//import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(nullable=false)
    private String username;

    @Column(nullable=false)
    private String password;

    //Constructor
    public Person(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    //Setters e getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

