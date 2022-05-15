package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.mohirdev.lesson.model.Holiday;
import uz.mohirdev.lesson.service.HolidayService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HolidayResource {

    private final HolidayService holidayService;

    public HolidayResource(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/holidays")
    public ResponseEntity getAll(){
        List<Holiday> result = holidayService.findAll();
        return ResponseEntity.ok(result);
    }
}
