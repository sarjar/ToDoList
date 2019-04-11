package com.vcs.project.ToDoApp.services;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.entities.ItemPriority;

import java.util.List;

public interface IToDoListCustomService {

    List<Item> findByDescription(String description);

    List<Item> sortItemListByIndexOrPriority(List<Item> itemList, boolean orderByIndex,
                                             boolean orderByPriority, boolean reverseList);

    int sortListByPriority(List<Item> itemList, Item o1, Item o2);

    boolean update(long id, String desc, String subDate, boolean completed, ItemPriority itemPrty);

    boolean removeCompletedItem(long id);
}
