package uz.mohirdev.lesson.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.repository.HolidayDateRepository;

@Service
public class HolidayDateService {
    private final HolidayDateRepository holidayDateRepository;

    public HolidayDateService(HolidayDateRepository holidayDateRepository) {
        this.holidayDateRepository = holidayDateRepository;
    }
}
