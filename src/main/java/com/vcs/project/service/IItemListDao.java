package com.vcs.project.service;

import com.vcs.project.entities.Item;

import java.util.List;

public interface IItemListDao {

    // CRUD

    List<Item> getItemList();

    Item getItemById(int id);

    Item createItem(Item item);

    boolean updateItem(int id, Item item);

    boolean removeById(int id);

}
