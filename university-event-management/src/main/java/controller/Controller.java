package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
@Validated
public class Controller {

    private final UniversityEventService eventService;
    private final StudentService studentService;

    @Autowired
    public UniversityEventController(UniversityEventService eventService, StudentService studentService) {
        this.eventService = eventService;
        this.studentService = studentService;
    }

    // Add student
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student createdStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    // Update student department
    @PatchMapping("/students/{studentId}/department")
    public ResponseEntity<Student> updateStudentDepartment(
            @PathVariable Long studentId,
            @RequestParam Department department
    ) {
        Student updatedStudent = studentService.updateStudentDepartment(studentId, department);
        return ResponseEntity.ok(updatedStudent);
    }

    // Delete student
    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    // Get all students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Get student by Id
    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }

    // Add event
    @PostMapping("/events")
    public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event) {
        Event createdEvent = eventService.addEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    // Update event
    @PutMapping("/events/{eventId}")
    public ResponseEntity<Event> updateEvent(
            @PathVariable Long eventId,
            @Valid @RequestBody Event event
    ) {
        Event updatedEvent = eventService.updateEvent(eventId, event);
        return ResponseEntity.ok(updatedEvent);
    }

    // Delete event
    @DeleteMapping("/events/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }

    // Get All events by date
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEventsByDate(@RequestParam LocalDate date) {
        List<Event> events = eventService.getAllEventsByDate(date);
        return ResponseEntity.ok(events);
    }
}
