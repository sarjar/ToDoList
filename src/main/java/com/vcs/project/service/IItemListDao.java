package com.vcs.project.service;

import com.vcs.project.entities.Item;

import java.util.List;

public interface IItemListDao {

    void addItem();

    List<Item> getItem();

    List<Item> getAllItemList();

    List<Item> getCompletedItems();

    void updateItemById();

    void removeItemById();

}
