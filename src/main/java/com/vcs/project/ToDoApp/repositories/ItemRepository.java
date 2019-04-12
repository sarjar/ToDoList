package com.vcs.project.ToDoApp.repositories;

import com.vcs.project.ToDoApp.entities.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findByHashTagContainingIgnoreCase(String hashTag);

    @Query("SELECT i FROM Item AS i ORDER BY i.id ASC")
    List<Item> orderByIdAsc();

    @Query("SELECT i FROM Item AS i ORDER BY i.id DESC")
    List<Item> orderByIdDesc();

    @Query("SELECT i FROM Item AS i ORDER BY i.itemPriority ASC")
    List<Item> orderByItemPriorityAsc();

    @Query("SELECT i FROM Item AS i ORDER BY i.itemPriority DESC")
    List<Item> orderByItemPriorityDesc();

}
