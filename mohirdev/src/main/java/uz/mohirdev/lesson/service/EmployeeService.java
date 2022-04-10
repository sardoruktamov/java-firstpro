package uz.mohirdev.lesson.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.entity.Employee;
import uz.mohirdev.lesson.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee findById(Long id){
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

}
