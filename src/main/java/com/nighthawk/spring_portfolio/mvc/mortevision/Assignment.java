package com.nighthawk.spring_portfolio.mvc.mortevision;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Data  // Lombok to generate constructors, getters, setters
@NoArgsConstructor
@AllArgsConstructor
@Entity // Defines this class as a JPA entity, representing a table in the database

public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Automatically generates a unique ID
    private Long assignmentId;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    private String rubric;
    private int points;

    @Column(nullable = true) // Allows null values
    private String queue;
}

