package com.vcs.project.service;

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
                " | Title: " + item.getTitle() +
                " | Desc: " + item.getDescription() +
                " | Submitted Date: " + item.getSubmittedDate() +
                " | Status: " + setItemStatus(item.isCompleted()) +
                " | Priority: " + item.getItemPriority());
    }
}
