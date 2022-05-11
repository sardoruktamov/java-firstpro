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

    private final PostDateService postDateService;

    @Value("${api.jsonplaceholder}")
    private String api;

    public PostService(RestTemplate restTemplate, PostDateService postDateService) {
        this.restTemplate = restTemplate;
        this.postDateService = postDateService;
    }

    public Object findAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Post[]> entity = new HttpEntity<>(headers);
        Post[] resoult = restTemplate.exchange(this.api + "/posts", HttpMethod.GET, entity, Post[].class).getBody();
        postDateService.saveAll(resoult);
        return resoult;
    }
}
