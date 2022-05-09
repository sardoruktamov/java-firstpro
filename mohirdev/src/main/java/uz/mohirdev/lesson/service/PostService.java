package uz.mohirdev.lesson.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.mohirdev.lesson.model.Post;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    // boshqa tashqi serverdagi servislarga ulanish uchun RestTemplatedan foydalanamiz
    private final RestTemplate restTemplate;

    @Value("${api.jsonplaceholder}")
    private String api;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Post> findAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Post>> entity = new HttpEntity<>(headers);
        List<Post> resoult = restTemplate.exchange(this.api + "/posts", HttpMethod.GET, entity, List.class).getBody();
        return resoult;
    }
}
