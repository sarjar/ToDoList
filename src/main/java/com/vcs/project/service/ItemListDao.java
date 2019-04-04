package com.vcs.project.service;

import com.vcs.project.entities.Item;
import com.vcs.project.entities.enums.ItemPriority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemListDao {

    //TODO: pasigilinti i Map funkcionaluma.
    private Map<Integer, Item> itemsByKey = null;

    private List<Item> itemList = new ArrayList<>();

    public List<Item> addItem(int id, String description, LocalDate submittedDate,
                              boolean completed, ItemPriority itemPriority) {

        itemList.add(new Item(id, description, submittedDate, completed, itemPriority));
        return itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public List<Item> removeCompletedItems() {
        List<Item> completedItems = itemList;
        for (Item item : completedItems) {
            if (item.isCompleted() && !item.equals(null)) {
                completedItems.remove(item);
            }
        }
        return completedItems;
    }

    public void updateItemById(int id) {
    }

    public void removeItemById(int id) {
        itemsByKey.remove(id);
    }
}
