package uz.mohirdev.lesson.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.mohirdev.lesson.model.Holiday;

import java.util.Arrays;
import java.util.List;

@Service
public class HolidayService {
    private final RestTemplate restTemplate;

    @Value("${api.publicholidays}")
    private String api;


    public HolidayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Holiday> findAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Holiday>> entity = new HttpEntity<>(headers);
        List<Holiday> result = restTemplate.exchange(this.api+"/api/v2/publicholidays/2020/US", HttpMethod.GET, entity, List.class).getBody();
        System.out.println(api);
        System.out.println(result);
        return result;
    }
}
