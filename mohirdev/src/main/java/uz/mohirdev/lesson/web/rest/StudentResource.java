package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.lesson.model.Course;
import uz.mohirdev.lesson.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    // Get 1-usul
//    @GetMapping("/students")
//    public ResponseEntity hello(){
//        return ResponseEntity.ok("Ar-Roxman, Ar-Raxiym");
//    }
    // Get 2-usul
    @RequestMapping(value = "/students/list", method = RequestMethod.GET)
    public ResponseEntity hellow(){
        return ResponseEntity.ok("Ar-Roxman, Ar-Raxiym");
    }

    // POST
    @PostMapping("/students")
    public ResponseEntity createStudent(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }
    // POST  list holatida POST qilish
    @PostMapping("/students/list")
    public ResponseEntity createAll(@RequestBody List<Student> students){
        return ResponseEntity.ok(students);
    }

    //PUT--1
    @PutMapping("/students")
    public ResponseEntity updateStudent(@RequestBody Student student){
        student.setLastName("Test uchun");
        return ResponseEntity.ok(student);
    }

    //PUT--2
    @PutMapping("/students/{name}")
    public ResponseEntity updateStudent2(@PathVariable String name,@RequestBody Student student){
        student.setLastName("Test uchun");
        student.setName(name);
        return ResponseEntity.ok(student);
    }

//    @GetMapping("/students/{name}")
//    public ResponseEntity getOne(@PathVariable String name){
//        Student student = new Student(1L, name, "ikkinchi talaba", 20);
//        return ResponseEntity.ok(student);
//    }

    @GetMapping("/students")
    public ResponseEntity getAll(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam Integer age){
        List<Student> students = new ArrayList<>();
        Course course = new Course();
        course.setId(6L);
        course.setName("Test Course");

        students.add(new Student(id, name, lastName, course, age));
        students.add(new Student(1L, "Sardor1", "Uktamov1", course, 26));
        students.add(new Student(2L, "Sardor2", "Uktamov2",  course, 29));
        students.add(new Student(3L, "Sardor3", "Uktamov3",  course,28));
        return  ResponseEntity.ok(students);
    }

    @DeleteMapping("/students/{id}/delete")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(id+"-malumot uchirildi!");
    }

    @PatchMapping ("/students/{id}")
    public ResponseEntity patchUpdate(@PathVariable Long id, @RequestBody Student student){
//        Student student = new Student(1L, name, "ikkinchi talaba", 20);
        return ResponseEntity.ok(student);
    }
}











