package com.nighthawk.spring_portfolio.mvc.JITSKAssignment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.chatBot.Chat;

import java.sql.Date;
import java.util.List;


@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/assignment")  // all requests in file begin with this URI
public class AssignmentApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private static AssignmentsJpaRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Assignment>> getAssignments() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
	public static ResponseEntity<?> a(@RequestParam String name,@RequestParam double points) {
		try {
			Assignment assignment = new Assignment(name, points);
			Assignment updated = repository.save(assignment);
			return new ResponseEntity<Assignment>(updated, HttpStatus.OK);
			//return response
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

   
    
}
