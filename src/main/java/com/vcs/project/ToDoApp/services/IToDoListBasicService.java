package com.vcs.project.ToDoApp.services;

import com.vcs.project.ToDoApp.entities.Item;

import java.util.List;

public interface IToDoListBasicService {

    Item save(Item item);

    List<Item> getAll();

    void delete(Long id);

    void deleteAll(List<Item> items);

}
