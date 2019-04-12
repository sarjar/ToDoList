package com.vcs.project.ToDoApp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String description;
    @Column(name = "PRIORITY")
    private ItemPriority itemPriority;
    @Column(name = "HASH_TAG")
    private String hashTag;
    private boolean completed;

    public Item() {}

    public Item(Long id, @NotBlank String description, ItemPriority itemPriority, String hashTag, boolean completed) {
        this.id = id;
        this.description = description;
        this.itemPriority = itemPriority;
        this.hashTag = hashTag;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ItemPriority getItemPriority() {
        return itemPriority;
    }

    public void setItemPriority(ItemPriority itemPriority) {
        this.itemPriority = itemPriority;
    }

}
