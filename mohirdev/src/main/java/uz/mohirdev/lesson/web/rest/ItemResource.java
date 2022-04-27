package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/items")
    public ResponseEntity update(@RequestBody Item item){
        if (item.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Item resoult = itemService.save(item);
        return ResponseEntity.ok(resoult);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getOne(@PathVariable Long id){
        if (itemService.findById(id) == null){
            return ResponseEntity.badRequest().build();
        }
        Item resoult = itemService.findById(id);
        return ResponseEntity.ok(resoult);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        itemService.delete(id);
        return ResponseEntity.ok("Item malumotlari o'chirildi!");
    }
}
