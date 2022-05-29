package uz.mohirdev.lesson.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    // bittalik malumotni saqlash.
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

    @Transactional(readOnly = true)
    public Page<PostDate> findAll(Pageable pageable){
        return postDateRepository.findAll(pageable);
    }

}
