package com.nighthawk.spring_portfolio.mvc.JITSKAssignment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@Entity 
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)

    
    private String description;
    private double points; // max grade
    private String name;
    // private Date duedate;
    // private Date startdate;
    private String rubric;


    public static String[] init() {
        final String[] Assignments = {
            "Assignment1"
        };
        return Assignments;
    }




    class Date{
        String year;
        String month;
        String day;
        Date(String year, String month, String day){
            this.year=year;
            this.month=month;
            this.day=day;
        }

        public String getDate(){
            return year+" "+month+" "+day;
        }
    }

}
