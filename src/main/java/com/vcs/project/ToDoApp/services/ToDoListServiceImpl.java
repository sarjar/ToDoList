package com.vcs.project.ToDoApp.services;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListServiceImpl implements IToDoListService {

    @Autowired
    private ItemRepository itemRepository;

    private ToDoListDaoImpl toDoListDao = new ToDoListDaoImpl();

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findByDescription(String description) {
        return null;
    }

    @Override
    public List<Item> sortItemList(List<Item> itemList, boolean orderByIndex, boolean orderByPriority,
                                   boolean reverseList) {

        List<Item> result = new ArrayList<>(itemList);
        if (orderByIndex && !orderByPriority) {
            Collections.sort(result, (o1, o2) -> sortListByIndex(o1, o2));
        } else if (orderByPriority && !orderByIndex) {
            Collections.sort(result, (o1, o2) -> sortListByPriority(o1, o2));
        } else if (orderByPriority && orderByIndex) {
            Collections.sort(result, (o1, o2) -> {
                int flag = sortListByIndex(o1, o2);
                if (flag == 0) flag = sortListByPriority(o1, o2);
                return flag;
            });
        }
        if (reverseList) {
            Collections.reverse(result);
        }
        return result;
    }

    @Override
    public int sortListByIndex(Item o1, Item o2) {
        int itemIndex1 = getItemIndex(itemRepository.findById(o1.getId()));
        int itemIndex2 = getItemIndex(itemRepository.findById(o2.getId()));
        return itemIndex1 - itemIndex2;
    }

    @Override
    public int sortListByPriority(Item o1, Item o2) {
        if (o1.getItemPriority() == o2.getItemPriority()) {
            return sortListByIndex(o1, o2);
        } else {
            return o1.getItemPriority().compareTo(o2.getItemPriority());
        }
    }

    @Override
    public int getItemIndex(Optional<Item> item) {
        return toDoListDao.getAll().indexOf(item);
    }

    @Override
    public Item findByIndex(int index) {
        return toDoListDao.getAll().get(index);
    }

    @Override
    public boolean update(long id, Item item) {
        return false;
    }

    @Override
    public boolean changeItemStatus(long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            itemRepository.findById(id).get().setCompleted(true);
            return true;
        }
        return false;
    }

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
