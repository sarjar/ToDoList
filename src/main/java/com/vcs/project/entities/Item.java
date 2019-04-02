package com.vcs.project.entities;

import java.time.LocalDate;

public class Item {

    private int id;
    private String description;
    private LocalDate submittedDate;
    private boolean isCompleted;
    private ItemPriority itemPriority;

    public Item(int id, String description, LocalDate submittedDate,
                boolean isCompleted, ItemPriority itemPriority) {
        this.id = id;
        this.description = description;
        this.submittedDate = submittedDate;
        this.isCompleted = isCompleted;
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public ItemPriority getItemPriority() {
        return itemPriority;
    }

    public void setItemPriority(ItemPriority itemPriority) {
        this.itemPriority = itemPriority;
    }

}
