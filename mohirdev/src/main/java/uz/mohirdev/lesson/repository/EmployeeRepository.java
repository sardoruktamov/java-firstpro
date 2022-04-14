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
    @Query("select e from Employee e where e.name = :name and e.lastName = :lastName")
    List<Employee> findAll(@Param("name") String name,
                           @Param("lastName") String lastName);

    //name orqali olishning 2-usuli
    List<Employee> findAllByName(String name);

    //name va lastName orqali olish
    List<Employee> findAllByNameAndLastName(String name, String lastName);

    // Native Query
    @Query(value = "SELECT * from employee e where e.name = :name", nativeQuery = true)
    List<Employee> findAll(@Param("name") String name);

    // LIKE dan foydalanb name orqali qidirish, bunda aynan bir xilini qaytaradi
    List<Employee> findAllByNameLike(String name);
    //LIKE    jpaquery
    @Query("select e from Employee e where e.name like :name")
    List<Employee> findAllByNameLikeJPA(String name);
    //LIKE    nativequery
    @Query(value = "SELECT * from employee e where e.name like :name", nativeQuery = true)
    List<Employee> findAllByNameLikeNative(String name);

    //Startwith
    List<Employee> findAllByNameStartingWith(String name);
    //Startwith    jpaquery
    @Query("select e from Employee e where UPPER(e.name) like upper(concat(:name, '%') ) ")
    List<Employee> findAllByNameStartingWithJPA(String name);
    //Startwith    nativequery
    @Query(value = "SELECT * from employee e where e.name like :name%", nativeQuery = true)
    List<Employee> findAllByNameStartingWithJPANative(String name);
}
