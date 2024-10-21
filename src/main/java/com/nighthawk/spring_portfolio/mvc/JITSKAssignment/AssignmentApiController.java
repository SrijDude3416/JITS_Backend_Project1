package com.nighthawk.spring_portfolio.mvc.JITSKAssignment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/assignment")  // all requests in file begin with this URI
public class AssignmentApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private AssignmentsJpaRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Assignment>> getAssignments() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

   
    
}
