package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.mohirdev.lesson.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // findAll() methodini qo`lda yozamiz va shart qoyamiz
    // name orqali olishning 1-usuli
    @Query("select e from Employee e where e.name = :name")
    List<Employee> findAll(@Param("name") String name);

    //name orqali olishning 2-usuli
    List<Employee> findAllByName(String name);
}
