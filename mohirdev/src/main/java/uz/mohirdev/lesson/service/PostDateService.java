package uz.mohirdev.lesson.service;

import uz.mohirdev.lesson.entity.PostDate;
import uz.mohirdev.lesson.model.Post;
import uz.mohirdev.lesson.repository.PostDateRepository;

import java.util.List;

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
        
    }


}
