package uz.mohirdev.lesson.service;

import uz.mohirdev.lesson.entity.PostDate;
import uz.mohirdev.lesson.model.Post;
import uz.mohirdev.lesson.repository.PostDateRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PostDateService {

    private final PostDateRepository postDateRepository;

    public PostDateService(PostDateRepository postDateRepository) {
        this.postDateRepository = postDateRepository;
    }

    // bittalik malumotni saqlash
    public PostDate save(PostDate postDate){
        return postDateRepository.save(postDate);
    }

    public List<PostDate> saveAll(List<Post> posts){
        List<PostDate> postDateList = posts
                .stream()
                .map(post -> {
                    PostDate postDate = new PostDate();
                    postDate.setPostId(post.getId());
                    postDate.setUserId(post.getUserId());
                    postDate.setTitle(post.getTitle());
                    postDate.setBody(post.getBody());
                    return postDate;
                }).collect(Collectors.toList());
        return postDateRepository.saveAll(postDateList);
    }


}
