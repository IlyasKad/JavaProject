package com.travelset.laba3.services;


import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Backpack;
import com.travelset.laba3.model.repository.BackpackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BackpackServiceImpl implements  BackpackService{

    private final BackpackRepository backpackRepository;

    @Autowired
    public BackpackServiceImpl(BackpackRepository backpackRepository) {
        this.backpackRepository = backpackRepository;
    }

    @Override
    public Backpack getBackpackById(Integer id) {
        return backpackRepository.findById(id).
                orElseThrow(()->new NoSuchEntityElementException(Backpack.class, id));
    }

    @Override
    public List<Backpack> getAllBackpacks() {
        return backpackRepository.findAll();
    }

    @Override
    public Backpack saveBackpack(Backpack backpack) {
        return backpackRepository.save(backpack);
    }

    @Override
    public void deleteBackpack(int id) {
        if(!backpackRepository.existsById(id)) {
            throw new NoSuchEntityElementException(Backpack.class,id);
        }
        backpackRepository.deleteById(id);
    }

    @Override
    public Backpack updateBackpack(Backpack backpack) {
        if(!backpackRepository.existsById(backpack.getId())) {
            throw new NoSuchEntityElementException(Backpack.class, backpack.getId());
        }
        return backpackRepository.save(backpack);
    }

}
