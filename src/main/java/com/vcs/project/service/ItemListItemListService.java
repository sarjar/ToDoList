package com.vcs.project.service;

import com.vcs.project.entities.Item;
import com.vcs.project.entities.ItemPriority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ItemListItemListService extends ItemListServiceHelpers {

    List<Item> itemList = new ArrayList<>();

    public void addItem(int id, String title, String desc, LocalDate submittedDate,
                        boolean isCompleted, ItemPriority itemPriority) {
        Item item = new Item(id, title, desc, submittedDate, isCompleted, itemPriority);
        itemList.add(item);
    }

    public void changeItemStatus(int id) {
        itemList.get(id - 1).setCompleted(true);
    }

    public void sortItemList() {

    }

    public void removeItemById(int id) {
        for (Item itemId : itemList) {
            if (itemId != null && id == itemId.getId()) {
                itemList.remove(itemId);
            }
        }
    }

    public void clearItemList() {
        itemList.clear();
        if (!itemList.isEmpty()) {
            System.out.println("ToDo List is not empty");
        }
        System.out.println("ToDo List is empty");
    }

    public void displayItemById(int id) {
        for (Item item : itemList) {
            if (item != null && id == item.getId()) {
                printItem(item);
            } else {
                System.out.println("Item does not exist");
            }
        }
    }

    public void displayToDoList() {
        for (Item item : itemList) {
            printItem(item);
        }
    }

}
