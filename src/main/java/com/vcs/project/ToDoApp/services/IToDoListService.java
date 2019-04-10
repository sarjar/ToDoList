package com.vcs.project.ToDoApp.services;

import com.vcs.project.ToDoApp.entities.Item;

import java.util.List;
import java.util.Optional;

public interface IToDoListService {

    Optional<Item> findById(Long id);

    List<Item> findByDescription(String description);

    List<Item> sortItemList(List<Item> itemList, boolean orderByIndex,
                            boolean orderByPriority, boolean reverseList);

    int sortListByIndex(Item o1, Item o2);

    int sortListByPriority(Item o1, Item o2);

    int getItemIndex(Optional<Item> item);

    Item findByIndex(int index);

    boolean update(long id, Item item);

    boolean changeItemStatus(long id);

    boolean removeCompletedItem(long id);
}
