package uz.mohirdev.lesson.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.entity.Counties;
import uz.mohirdev.lesson.entity.HolidayDate;
import uz.mohirdev.lesson.model.Holiday;
import uz.mohirdev.lesson.repository.HolidayDateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HolidayDateService {
    private final HolidayDateRepository holidayDateRepository;

    public HolidayDateService(HolidayDateRepository holidayDateRepository) {
        this.holidayDateRepository = holidayDateRepository;
    }

    public HolidayDate save(HolidayDate holidayDate){
        return holidayDateRepository.save(holidayDate);
    }

    public List<HolidayDate> saveAll(Holiday[] holidays){
        List<HolidayDate> holidayDateList = new ArrayList<>();
        for (Holiday holiday:holidays) {
            HolidayDate holidayDate = new HolidayDate();
            holidayDate.setDate(holiday.getDate());
            holidayDate.setLocalName(holiday.getLocalName());
            holidayDate.setName(holiday.getName());
            holidayDate.setCountryCode(holiday.getCountryCode());
            holidayDate.setFixed(holiday.getFixed());
            holidayDate.setGlobal(holiday.getGlobal());
            holidayDate.setCounties(holiday.getCounties());
            holidayDate.setLaunchYear(holiday.getLocalName());
            holidayDate.setType(holiday.getType());
            holidayDateList.add(holidayDate);
        }
        return holidayDateRepository.saveAll(holidayDateList);
    }
}
