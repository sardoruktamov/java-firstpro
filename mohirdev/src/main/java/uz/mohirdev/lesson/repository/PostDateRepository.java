package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mohirdev.lesson.entity.PostDate;

@Repository
public interface PostDateRepository extends JpaRepository<PostDate, Long> {

}
