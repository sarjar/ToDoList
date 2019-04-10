package com.vcs.project.ToDoApp.repositories;

import com.vcs.project.ToDoApp.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
