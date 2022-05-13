package uz.mohirdev.lesson.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.entity.PostDate;
import uz.mohirdev.lesson.model.Post;
import uz.mohirdev.lesson.repository.PostDateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PostDateService {

    private final PostDateRepository postDateRepository;

    public PostDateService(PostDateRepository postDateRepository) {
        this.postDateRepository = postDateRepository;
    }

    // bittalik malumotni saqlash.  23-qatordagi funksiyadan malumot keladi
    public PostDate save(PostDate postDate){
        return postDateRepository.save(postDate);
    }

    public List<PostDate> saveAll(Post[] posts){
        List<PostDate> postDateList = new ArrayList<>();
        for (Post post:posts) {
            PostDate postDate = new PostDate();
            postDate.setPostId(post.getId());
            postDate.setUserId(post.getUserId());
            postDate.setTitle(post.getTitle());
            postDate.setBody(post.getBody());
            postDateList.add(postDate);
        }
        return postDateRepository.saveAll(postDateList);
    }


}
