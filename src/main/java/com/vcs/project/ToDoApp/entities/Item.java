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

        boolean itemPriorityCoppy = false;
        boolean hashTagCoppy = false;

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

            if (item.itemPriority != null) {
                itemPriorityCoppy = item.itemPriority.equals(item);
            } else {
                itemPriorityCoppy = item.itemPriority == null && itemPriority == null;
            }

            if (item.hashTag != null) {
                hashTagCoppy = item.hashTag.equals(item);
            } else {
                hashTagCoppy = item.hashTag == null && hashTag == null;
            }

            return ((item.id == this.id) && (item.description == this.description) &&
                    itemPriorityCoppy && hashTagCoppy && (item.completed == this.completed));
        }
        return false;
    }

    @Override
    public int hashCode() {
        // Returning parameters
        // as a hashcode value.
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 1);
        result = 31 * result + (description != null ? description.hashCode() : 1);
        result = 31 * result + (itemPriority != null ? itemPriority.hashCode() : 1);
        result = 31 * result + (hashTag != null ? hashTag.hashCode() : 1);
        result = 31 * result + (completed ? 1 : 2);
        return result;
    }
}
