package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
