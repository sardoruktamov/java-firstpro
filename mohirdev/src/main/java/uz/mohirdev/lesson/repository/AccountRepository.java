package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mohirdev.lesson.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
