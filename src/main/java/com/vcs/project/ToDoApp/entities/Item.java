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

    public Item() {
    }

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

    @Override
    public boolean equals(Object obj) {
        // checking if both the object references are
        // referring to the same object.
        if (this == obj) return true;
        // it checks if the argument is of the
        // type Item by comparing the classes
        // of the passed argument and this object.
        if (obj instanceof Item) {
            // type casting of the argument.
            Item item = (Item) obj;
            // comparing the state of argument with
            // the state of 'this' Object.

            return (item.id == this.id &&
                    item.description == this.description &&
                    item.itemPriority == this.itemPriority &&
                    item.hashTag == this.hashTag);
        }
        return false;
    }

    @Override
    public int hashCode() {
        // We are returning the Item_id
        // as a hashcode value.
        int result = 17;
        result = 31 * result + id.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + itemPriority.hashCode();
        result = 31 * result + hashTag.hashCode();
        return result;
    }
}
