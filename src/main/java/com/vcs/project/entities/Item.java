package com.vcs.project.entities;

import com.vcs.project.entities.enums.ItemPriority;

import java.time.LocalDate;

public class Item {

    private int id;
    private String description;
    private LocalDate submittedDate;
    private boolean completed;
    private ItemPriority itemPriority;

    public Item(int id, String description, LocalDate submittedDate,
                boolean completed, ItemPriority itemPriority) {
        this.id = id;
        this.description = description;
        this.submittedDate = submittedDate;
        this.completed = completed;
        this.itemPriority = itemPriority;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(LocalDate submittedDate) {
        this.submittedDate = submittedDate;
    }

    public boolean isCompleted() { return completed; }

    public void setCompleted(boolean completed) { this.completed = completed; }

    public ItemPriority getItemPriority() {
        return itemPriority;
    }

    public void setItemPriority(ItemPriority itemPriority) {
        this.itemPriority = itemPriority;
    }

    @Override
    public String toString() {
        return id + " " + description + " " + submittedDate + " " + completed + " " + itemPriority;}

}
