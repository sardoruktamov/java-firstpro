package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.mohirdev.lesson.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // findAll() methodini qo`lda yozamiz va shart qoyamiz
    @Query("select e from Employee e where e.id = 5")
    List<Employee> findAll();
}
