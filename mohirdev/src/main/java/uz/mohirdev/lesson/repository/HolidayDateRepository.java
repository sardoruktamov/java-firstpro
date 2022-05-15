package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mohirdev.lesson.entity.HolidayDate;

@Repository
public interface HolidayDateRepository extends JpaRepository<HolidayDate, Long> {

    private
}
