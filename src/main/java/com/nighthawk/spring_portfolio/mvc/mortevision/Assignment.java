package com.nighthawk.spring_portfolio.mvc.mortevision;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assignmentId;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    private String rubric;
    private int points;

    @Convert(converter = QueueConverter.class)
    private Queue assignmentQueue = new Queue();

    public void resetQueue() {
        assignmentQueue.reset();
    }

    public void initQueue(List<String> people) {
        assignmentQueue.getHaventGone().addAll(people);
    }

    public void addQueue(List<String> people) {
        String person = people.get(0);
        assignmentQueue.getHaventGone().remove(person);
        assignmentQueue.getQueue().add(person);
    }

    public void removeQueue(List<String> people) {
        String person = people.get(0);
        assignmentQueue.getQueue().remove(person);
        assignmentQueue.getHaventGone().add(person);
    }

    public void doneQueue(List<String> people) {
        String person = people.get(0);
        assignmentQueue.getQueue().remove(person);
        assignmentQueue.getDone().add(person);
    }
}
