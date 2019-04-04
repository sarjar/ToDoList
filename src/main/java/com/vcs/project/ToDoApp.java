package com.vcs.project;

import com.vcs.project.entities.enums.ItemPriority;
import com.vcs.project.service.ItemListService;

import java.time.LocalDate;

public class ToDoApp {

    public static void main(String[] args) {

        LocalDate submittedDate = LocalDate.now();

        ItemListService toDoList = new ItemListService();

        toDoList.addItem(1, "Clean stuff", submittedDate.plusDays(7), false, ItemPriority.Medium);
        toDoList.addItem(2, "Buy: milk, bread, sugar.", null, false, ItemPriority.Medium);
        toDoList.addItem(3, "Call the doctor", submittedDate.plusDays(2), false, ItemPriority.High);
        toDoList.addItem(4, "Wash dishes", submittedDate.plusDays(2), false, ItemPriority.Low);

//        System.out.println(toDoList.getItemList());
//        toDoList.changeItemStatus(2);
//        toDoList.clearItemList(true);
//        System.out.println(toDoList.getItemList());

//        Change Item Status
//        toDoList.displayItemById(2);
//        toDoList.changeItemStatus(2);
//        toDoList.displayItemById(2);

//        Remove Item By Given Id
//        toDoList.removeItemById(1);
//        toDoList.displayToDoList();

//        Clear To Do List
//        toDoList.clearItemList();
//        toDoList.displayToDoList();
    }
}