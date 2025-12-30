package com.skillnext2;

import javax.persistence.*;

@Entity
@Table(name = "student")  // Matches your table name exactly
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")  // Matches your column name exactly
    private int id;
    
    @Column(name = "Name", length = 50)  // Matches your column name and length
    private String name;
    
    @Column(name = "email", length = 100)  // Matches your column name
    private String email;
    
    @Column(name = "branch", length = 20)  // Matches your column name
    private String branch;
    
    // Default constructor (required by Hibernate)
    public Student() {
    }
    
    // Parameterized constructor (without ID since it's auto-increment)
    public Student(String name, String email, String branch) {
        this.name = name;
        this.email = email;
        this.branch = branch;
    }
    
    // Parameterized constructor with all fields
    public Student(int id, String name, String email, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getBranch() {
        return branch;
    }
    
    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Email=" + email + ", Branch=" + branch + "]";
    }
}