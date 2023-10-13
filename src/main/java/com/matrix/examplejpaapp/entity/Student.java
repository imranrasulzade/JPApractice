package com.matrix.examplejpaapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matrix.examplejpaapp.model.StudentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String city;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    private String token;
    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }



    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private List<Project> projects;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "student_authorities" ,
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    private Set<Authority> authorities = new HashSet<>();

}
