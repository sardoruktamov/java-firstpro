package uz.mohirdev.lesson.web.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.lesson.entity.PostDate;
import uz.mohirdev.lesson.model.Post;
import uz.mohirdev.lesson.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostResource {

    private final PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity create(@RequestBody Post post){
        Post result = postService.save(post);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/posts/params")
    public ResponseEntity getAllByParam(@RequestParam Long postId){
        List<Post> result = postService.findAllByQyeryParam(postId);
        return ResponseEntity.ok(result);
    }

    // ishlatish uchun postmanda params malumotlariga 2 ta qiymat yozamiz
    //page = 0      --> birinchi element(sahifa) hissoblanadi
    //size = 20
    //sort = id,desc yoki asc
    // http://localhost:8080/api/posts/paging?page=0&size=20
    @GetMapping("/posts/paging")
    public ResponseEntity getAllByPaging(Pageable pageable){
        Page<PostDate> result = postService.findAll(pageable);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/posts")
    public ResponseEntity getAll(){
        Object result = postService.findAll();
        return ResponseEntity.ok(result);
    }
}
