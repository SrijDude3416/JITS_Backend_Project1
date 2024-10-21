package com.nighthawk.spring_portfolio.mvc.JITSKAssignment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). 
// Today JPA implementations have been extended for NoSQL.
public interface AssignmentsJpaRepository extends JpaRepository<Assignment, Long> {
    /**
     * JPA has many built-in methods. 
     * The below custom method is prototyped for this application.
     */
    // List<Assignment> findByAssignedIgnoreCase(String assigned);
}
