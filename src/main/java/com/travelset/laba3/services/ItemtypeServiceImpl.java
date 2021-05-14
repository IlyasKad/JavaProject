package com.travelset.laba3.services;

import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Category;
import com.travelset.laba3.model.entity.Itemtype;
import com.travelset.laba3.model.repository.ItemtypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemtypeServiceImpl implements ItemtypeService{

    private final ItemtypeRepository itemtypeRepository;

    @Autowired
    public ItemtypeServiceImpl(ItemtypeRepository itemtypeRepository) {
        this.itemtypeRepository = itemtypeRepository;
    }

    @Override
    public Itemtype getItemtypeById(Integer id) {
        return itemtypeRepository.findById(id).
                orElseThrow(()->new NoSuchEntityElementException(Category.class, id));
    }

    @Override
    public List<Itemtype> getAllItemtypes() {
        return itemtypeRepository.findAll();
    }

    @Override
    public Itemtype saveItemtype(Itemtype itemtype) {
        return itemtypeRepository.save(itemtype);
    }

    @Override
    public void deleteItemtype(int id) {
        if(!itemtypeRepository.existsById(id)) {
            throw new NoSuchEntityElementException(Category.class,id);
        }
        itemtypeRepository.deleteById(id);
    }

    @Override
    public Itemtype updateItemtype(Itemtype itemtype) {
        if(!itemtypeRepository.existsById(itemtype.getId())) {
            throw new NoSuchEntityElementException(Category.class, itemtype.getId());
        }
        return itemtypeRepository.save(itemtype);
    }
}
