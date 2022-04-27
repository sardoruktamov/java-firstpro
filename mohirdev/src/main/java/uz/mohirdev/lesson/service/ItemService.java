package uz.mohirdev.lesson.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.entity.Account;
import uz.mohirdev.lesson.entity.Employee;
import uz.mohirdev.lesson.entity.Item;
import uz.mohirdev.lesson.repository.ItemRepository;

import java.util.Optional;


@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public Item findById(Long id){
        Optional<Item> optional = itemRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
