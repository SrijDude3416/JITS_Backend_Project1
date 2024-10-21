package com.nighthawk.spring_portfolio.mvc.mortevision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentApiController {

    @Autowired
    private AssignmentJpaRepository repository;

    // GET all assignments
    @GetMapping("/")
    public ResponseEntity<List<Assignment>> getAssignments() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    // CREATE a new assignment
    @PostMapping("/create")
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        repository.save(assignment);
        return new ResponseEntity<>(assignment, HttpStatus.CREATED);
    }

    // DELETE an assignment by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAssignment(@PathVariable long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // UPDATE an assignment (except ID)
    @PutMapping("/update/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable long id, @RequestBody Assignment updatedAssignment) {
        Optional<Assignment> optional = repository.findById(id);
        if (optional.isPresent()) {
            Assignment assignment = optional.get();
            assignment.setName(updatedAssignment.getName());
            assignment.setStartDate(updatedAssignment.getStartDate());
            assignment.setDueDate(updatedAssignment.getDueDate());
            assignment.setRubric(updatedAssignment.getRubric());
            assignment.setPoints(updatedAssignment.getPoints());
            assignment.setQueue(updatedAssignment.getQueue());
            repository.save(assignment);
            return new ResponseEntity<>(assignment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
