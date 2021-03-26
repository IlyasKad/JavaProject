package services;

import models.Item;
import org.springframework.stereotype.Service;
import repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository;
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public void create(Item item) {
        itemRepository.create(item);
    }
    public Item findById(int id) {
        return  itemRepository.findById(id);
    }
}
