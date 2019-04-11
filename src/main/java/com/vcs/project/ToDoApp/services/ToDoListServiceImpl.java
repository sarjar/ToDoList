package com.vcs.project.ToDoApp.services;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.entities.ItemPriority;
import com.vcs.project.ToDoApp.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;

public class ToDoListServiceImpl implements IToDoListService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
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

    //TODO: Paklausti, ar torkiu paciu principu ir sorta apsiprasyti? Pvz metodas sortByPriority
    @Override
    public List<Item> findByDescription(String description) {
        return itemRepository.findByDescriptionContainingIgnoreCase(description);
    }

    //TODO: sutvarkyti methoda
    @Override
    public List<Item> sortItemListByIndexOrPriority(List<Item> itemList,
                                boolean orderByIndex, boolean orderByPriority, boolean reverseList) {

        List<Item> result = new ArrayList<>(itemList);

        if (orderByIndex && !orderByPriority) {
            Collections.sort(result, Comparator.comparingInt(result::indexOf));
        } else if (orderByPriority && !orderByIndex) {
            Collections.sort(result, (o1, o2) -> sortListByPriority(result, o1, o2));
        } else if (orderByPriority && orderByIndex) {
            Collections.sort(result, (o1, o2) -> {
                int flag = result.indexOf(o1) - result.indexOf(o2);
                if (flag == 0) flag = sortListByPriority(result, o1, o2);
                return flag;
            });
        }
        if (reverseList) {
            Collections.reverse(result);
        }
        return result;
    }

    @Override
    public int sortListByPriority(List<Item> itemList, Item o1, Item o2) {
        if (o1.getItemPriority() == o2.getItemPriority()) {
            return itemList.indexOf(o1) - itemList.indexOf(o2);
        } else {
            return o1.getItemPriority().compareTo(o2.getItemPriority());
        }
    }

    //TODO Optional<Item> ar Item?
    @Override
    public boolean update(long id, String desc, LocalDate subDate, boolean completed, ItemPriority priority) {

        Optional<Item> item = itemRepository.findById(id);

        if (item.isPresent()) {
            itemRepository.findById(id).get().setDescription(desc);
            itemRepository.findById(id).get().setSubmittedDate(subDate);
            itemRepository.findById(id).get().setCompleted(completed);
            itemRepository.findById(id).get().setItemPriority(priority);
            return true;
        }
        return false;
    }

    //TODO: Optional<Item> ar Item?
    @Override
    public boolean removeCompletedItem(long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent() && item.get().isCompleted()) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
