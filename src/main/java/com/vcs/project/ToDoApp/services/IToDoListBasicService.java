package com.vcs.project.ToDoApp.services;

import com.vcs.project.ToDoApp.entities.Item;

import java.util.List;
import java.util.Optional;

public interface IToDoListBasicService {

    Item save(Item item);

    Optional<Item> findById(Long id);

    List<Item> getAll();

    void delete(Long id);

    void deleteAll(List<Item> items);

}
