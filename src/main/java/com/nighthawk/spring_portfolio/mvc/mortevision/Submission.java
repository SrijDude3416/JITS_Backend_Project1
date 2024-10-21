package com.nighthawk.spring_portfolio.mvc.mortevision;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long submissionId;

    private String assignmentName;

    private String studentName;

    @Temporal(TemporalType.DATE)
    private Date submissionDate;

    private String fileUrl;

    private int grade;

    @Column(nullable = true)
    private String feedback;
}
