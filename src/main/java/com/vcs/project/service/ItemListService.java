package com.vcs.project.service;

import com.vcs.project.entities.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemListService {

    ItemListDao dao = new ItemListDao();

//    public void changeItemStatus(int id) {
//        dao.getItemById(id).setCompleted(true);
//    }

//    public void changeItemStatus(Item item) {
//        item.setCompleted(true);
//    }

    public List<Item> sortItemList(List<Item> listItem, boolean orderByIndex,
                                   boolean orderByPriority, boolean reverseList) {

        List<Item> result = new ArrayList<>(listItem);

        if (orderByIndex && !orderByPriority) {
            Collections.sort(result, (o1, o2) -> sortingListByIndex(o1, o2));
        } else if (orderByPriority && !orderByIndex) {
            Collections.sort(result, (o1, o2) -> sortingListByPriority(o1, o2));
        } else if (orderByPriority && orderByIndex) {
            Collections.sort(result, (o1, o2) -> {
                int flag = sortingListByIndex(o1, o2);
                if (flag == 0) flag = sortingListByPriority(o1, o2);
                return flag;
            });
        }
        if (reverseList) {
            Collections.reverse(result);
        }
        return result;
    }

    public int sortingListByIndex(Item o1, Item o2) {
        int itemIndex1 = getItemIndex(dao.getItemById(o1.getId()));
        int itemIndex2 = getItemIndex(dao.getItemById(o2.getId()));
        return itemIndex1 - itemIndex2;
    }

    public int sortingListByPriority(Item o1, Item o2) {
        if (o1.getItemPriority() == o2.getItemPriority()) {
            return sortingListByIndex(o1, o2);
        } else {
            return o1.getItemPriority().compareTo(o2.getItemPriority());
        }
    }


    public int getItemIndex(Item item) {
        return dao.getItemList().indexOf(item);
    }

    public boolean removeCompletedItem(int id) {
        Item itemToCheck = dao.getItemById(id);
        if (itemToCheck.isCompleted() && !itemToCheck.equals(null)) {
            dao.removeById(id);
            return true;
        }
        return false;
    }

    public void clearItemList() {
        dao.getItemList().clear();
    }

    //Temporary method
    public void printInfo(List<Item> itemList) {
        for (Item item : itemList) {
            System.out.println("ID : " + item.getId() +
                    "   Desc : " + item.getDescription() +
                    "   Date : " + item.getSubmittedDate() +
                    "   Status : " + item.isCompleted() +
                    "   Priority : " + item.getItemPriority());
        }
    }

}
