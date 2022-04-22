package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.mohirdev.lesson.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
