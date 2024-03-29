package uz.mohirdev.lesson.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.entity.Employee;
import uz.mohirdev.lesson.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public List<Employee> findAll(String name, String lastName){
//        List<Employee> employees = employeeRepository.findAll(name);  // name orqali olishning 1-usuli
//        List<Employee> employees = employeeRepository.findAllByName(name); // name orqali olishning 2-usuli
//        List<Employee> employees = employeeRepository.findAllByNameAndLastName(name, lastName); // name va lastName orqali olish
        List<Employee> employees = employeeRepository.findAll(name); // native query orqali
        return employees;
    }

    // LIKE dan foydalanb name orqali qidirish
    public List<Employee> findByQueryParam(String name){
//        return employeeRepository.findAllByNameLike(name);
//        return employeeRepository.findAllByNameLikeJPA(name); //JPA query
        return employeeRepository.findAllByNameLikeNative(name);   // Native Query
    }

    // Startwith,Endingwith orasida kelsa,
    public List<Employee> findByOther(String name){
//        return employeeRepository.findAllByNameStartingWith(name);
//        return employeeRepository.findAllByNameStartingWithJPA(name); //Startwith    jpaquery

//        return employeeRepository.findAllByNameEndingWith(name); //Endingwith
//        return employeeRepository.findAllByNameEndingwithWithJPA(name); //Allwith    jpaquery
//        return employeeRepository.findAllByNameEndingwithJPANative(name); //Allwith    jpaquery
        return employeeRepository.findAllByNameEndingWithOrderByIdAsc(name); //Allwith    jpaquery
    }

}
