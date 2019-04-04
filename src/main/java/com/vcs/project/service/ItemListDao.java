package com.vcs.project.service;

import com.vcs.project.entities.Item;

import java.util.ArrayList;
import java.util.List;

import static com.vcs.project.service.utils.ItemListUtils.generateId;

public class ItemListDao implements IItemListDao {

    private List<Item> itemList = new ArrayList<>();

    @Override
    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public Item getItemById(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Item createItem(Item item) {
        item.setId(generateId());
        itemList.add(item);
        return item;
    }

    @Override
    public boolean updateItem(int id, Item item) {
        Item itemForUpdate = getItemById(id);
        if (itemForUpdate == null) {
            return false;
        }
        itemForUpdate.setDescription(item.getDescription());
        itemForUpdate.setSubmittedDate(item.getSubmittedDate());
        itemForUpdate.setCompleted(item.isCompleted());
        itemForUpdate.setItemPriority(item.getItemPriority());
        return true;
    }

    @Override
    public boolean removeById(int id) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getId() == id) {
                return itemList.remove(i) != null;
            }
        }
        return false;
    }
}
