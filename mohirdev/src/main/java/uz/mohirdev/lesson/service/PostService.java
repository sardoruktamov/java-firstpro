package uz.mohirdev.lesson.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import uz.mohirdev.lesson.entity.PostDate;
import uz.mohirdev.lesson.model.Post;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //post request
    public Post save(Post post){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);
        Post result = restTemplate.postForObject(api + "/posts", entity,Post.class);
        return result;
    }

    public Post update(Long id, Post post){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);
        Post result = restTemplate.postForObject(api + "/posts/"+id+"/comments", entity,Post.class);
        System.out.println(result+"********************"+api);
        return result;
    }

    public Object findAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Post[]> entity = new HttpEntity<>(headers);
        Post[] result = restTemplate.exchange(this.api + "/posts", HttpMethod.GET, entity, Post[].class).getBody();
        postDateService.saveAll(result);
        return result;
    }

    // ushbu methoddan boshqa loyihalarda ham kerakli URLlarni yasab olishimiz mumkin
    public List<Post> findAllByQyeryParam(Long postId){
        HttpEntity<List<Post>> entity = new HttpEntity<>(getHeader());
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(this.api + "/comments")
                .queryParam("postId", "{postId}")
                .encode()
                .toUriString();
        Map<String, Object> params = new HashMap<>();
        params.put("postId",postId);

        List<Post> result = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, List.class, params).getBody();
        return result;
    }

    private HttpHeaders getHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public Page<PostDate> findAll(Pageable pageable){
        return postDateService.findAll(pageable);
    }
}
