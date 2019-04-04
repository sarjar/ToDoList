package com.vcs.project.service;

import com.vcs.project.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemListService {

    ItemListDao toDo = new ItemListDao();

    public void changeItemStatus(int id) {
        toDo.getItemById(id).setCompleted(true);
    }

//    //TODO: Kodel ir kas yra SortType.
//    public List<Item> sortItemList(SortType type) {
//
//        List<Item> result = new ArrayList<>(itemList);
//
//        if (SortType.ByPriority.equals(type)) {
//
//            Collections.sort(result, new Comparator<Item>() {
//                @Override
//                public int compare(Item o1, Item o2) {
//                    return result;
//                }
//            });
//        }
//    }

    public void clearItemList() {
        toDo.getItemList().clear();
    }

    public void removeCompletedItem(int id) {
        Item itemToCheck = toDo.getItemById(id);
        if (itemToCheck.isCompleted() && !itemToCheck.equals(null)) {
            toDo.removeById(id);
        }
    }

}
