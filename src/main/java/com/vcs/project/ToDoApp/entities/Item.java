package com.vcs.project.ToDoApp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String description;

    //TODO: Kokia anotacija, jei gali buti null?
    private LocalDate submittedDate;

    @NotBlank
    private boolean completed;

    //TODO: Kokia anotacija, jei gali buti null?
    private ItemPriority itemPriority;

    //TODO: Ar reikia Constructor'iu?

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

    public LocalDate getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(LocalDate submittedDate) {
        this.submittedDate = submittedDate;
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
