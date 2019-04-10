package com.vcs.project.ToDoApp.services;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoListDaoImpl implements IToDoListDao {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAll() {
        List<Item> itemList = new ArrayList<>();
        for (Item item : itemRepository.findAll()) {
            itemList.add(item);
        }
        return itemList;
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    public void deleteAll(List<Item> items) {
        itemRepository.deleteAll(items);
    }
}
