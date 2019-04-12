package com.vcs.project.ToDoApp.services;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListServiceImpl implements IToDoListService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> getAll() {
        List<Item> itemList = new ArrayList<>();
        for (Item item : itemRepository.findAll()) {
            itemList.add(item);
        }
        return itemList;
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Item> items) {
        itemRepository.deleteAll(items);
    }

    @Override
    public List<Item> findByHashTag(String hashTag) {
        return itemRepository.findByHashTagContainingIgnoreCase(hashTag);
    }

    @Override
    public List<Item> sortListById(boolean ascending) {
        return !ascending ? itemRepository.orderByIdDesc() : itemRepository.orderByIdAsc();
    }

    @Override
    public List<Item> sortListByItemPriority(boolean ascending) {
        return !ascending ? itemRepository.orderByItemPriorityDesc() : itemRepository.orderByItemPriorityAsc();
    }

    @Override
    public Item update(Item itemForUpd) {
        Optional<Item> itemFromDb = itemRepository.findById(itemForUpd.getId());

        if (itemFromDb.isPresent()) {
            itemFromDb.get().setDescription(itemForUpd.getDescription());
            itemFromDb.get().setItemPriority(itemForUpd.getItemPriority());
            itemFromDb.get().setHashTag(itemForUpd.getHashTag());
            itemFromDb.get().setCompleted(itemForUpd.isCompleted());
            return itemRepository.save(itemFromDb.get());
        }
        throw new RuntimeException("Not found by ID: " + itemForUpd.getId());
    }

    @Override
    public List<Item> cleanItemList(boolean onlyCompleted, boolean allList) {
        List<Item> itemList = getAll();
        for (Item item : itemList) {
            if (onlyCompleted && item.isCompleted() && !item.equals(null)) {
                delete(item.getId());
            } else if (allList) {
                deleteAll(itemList);
            }
        }
        return itemList;
    }
}
