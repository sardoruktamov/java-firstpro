package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mohirdev.lesson.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
