package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.mohirdev.lesson.entity.Item;
import uz.mohirdev.lesson.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemResource {

    private final ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public ResponseEntity create(@RequestBody Item item){
        Item resoult = itemService.save(item);
        return ResponseEntity.ok(resoult);
    }
}
