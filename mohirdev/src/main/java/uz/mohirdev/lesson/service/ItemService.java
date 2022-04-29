package uz.mohirdev.lesson.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.entity.Account;
import uz.mohirdev.lesson.entity.Employee;
import uz.mohirdev.lesson.entity.Item;
import uz.mohirdev.lesson.repository.ItemRepository;

import javax.servlet.http.PushBuilder;
import java.util.Optional;


@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // POST SAVE
    public Item save(Item item){
        return itemRepository.save(item);
    }

    // GET ID
    public Item findById(Long id){
        Optional<Item> optional = itemRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    // DELETE
    public void delete(Long id){
        itemRepository.deleteById(id);
    }
}
