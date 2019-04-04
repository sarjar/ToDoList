package com.vcs.project.service;

import com.vcs.project.entities.Item;
import com.vcs.project.entities.enums.ItemPriority;

import java.time.LocalDate;
import java.util.*;

public class ItemListService extends ItemListDao {

    //TODO: pasigilinti i Map funkcionaluma.
    private Map<Integer, Item> itemsByKey = null;

    public void test() {
        System.out.println(getItemList());
    }

    public void changeItemStatus(int id) {
        System.out.println(getItemList());
        getItemList().get(id - 1).setCompleted(true);
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

    public List<Item> clearItemList(boolean clearCompleted) {
        List<Item> completedItems = new ArrayList<>();
        if (clearCompleted) {
            completedItems = removeCompletedItems();
        } else {
            itemsByKey.clear();
        }
        return completedItems;
    }

}
