package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.lesson.model.Student;

@RestController
@RequestMapping("/api")
public class StudentResource {

    // Get 1-usul
//    @GetMapping("/students")
//    public ResponseEntity hello(){
//        return ResponseEntity.ok("Ar-Roxman, Ar-Raxiym");
//    }
    // Get 2-usul
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity hellow(){
        return ResponseEntity.ok("Ar-Roxman, Ar-Raxiym");
    }

    @PostMapping("/students")
    public ResponseEntity createStudent(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students")
    public ResponseEntity updateStudent(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }
}
