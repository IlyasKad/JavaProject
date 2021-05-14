package com.travelset.laba3.services;


import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Item;
import com.travelset.laba3.model.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getItemById(Integer id) {
        return itemRepository.findById(id).
                orElseThrow(()->new NoSuchEntityElementException(Item.class, id));
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(int id) {
        if(!itemRepository.existsById(id)) {
            throw new NoSuchEntityElementException(Item.class,id);
        }
        itemRepository.deleteById(id);
    }

    @Override
    public Item updateItem(Item item) {
        if(!itemRepository.existsById(item.getId())) {
            throw new NoSuchEntityElementException(Item.class, item.getId());
        }
        return itemRepository.save(item);
    }
}
