package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.lesson.entity.Employee;
import uz.mohirdev.lesson.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private final EmployeeService employeeService;


    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity create(@RequestBody Employee employee){
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employee employee){

        if(employee.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getOne(@PathVariable Long id){
        if (employeeService.findById(id) == null){
            return ResponseEntity.badRequest().build();
        }
        Employee result = employeeService.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees")
    public ResponseEntity getAll(@RequestParam String name, @RequestParam String lastName){
        List<Employee> employees = employeeService.findAll(name, lastName);
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("Malumot o`chirildi!");
    }
}
