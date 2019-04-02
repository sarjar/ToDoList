package com.vcs.project.service.helpers;

import com.vcs.project.entities.Item;

public class ItemListServiceHelpers {

    public String setItemStatus(boolean status) {
        if (status) {
            return "Completed";
        } else {
            return "Not Completed";
        }
    }

    public void printItem(Item item) {
        System.out.println("ID: " + item.getId() +
                " | Description: " + item.getDescription() +
                " | Submitted Date: " + item.getSubmittedDate() +
                " | Status: " + setItemStatus(item.isCompleted()) +
                " | Priority: " + item.getItemPriority());
    }
}
