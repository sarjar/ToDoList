package com.vcs.project;

import com.vcs.project.entities.ItemPriority;
import com.vcs.project.service.ItemListItemListService;

import java.time.LocalDate;

public class ToDoTest {

    public void controller() {

        LocalDate submittedDate = LocalDate.now();

        ItemListItemListService toDoList = new ItemListItemListService();

        toDoList.addItem(1, "Clean stuff", null, submittedDate.plusDays(7), false, ItemPriority.Medium);
        toDoList.addItem(2, "Needs to buy", "Milk, not milk, smth", null, false, ItemPriority.Medium);
        toDoList.addItem(3, "Call the doctor", null, submittedDate.plusDays(2), false, ItemPriority.High);
        toDoList.addItem(4, "Wash dishes", "Only half", submittedDate.plusDays(2), false, ItemPriority.Low);


//        Change Item Status
//        toDoList.changeItemStatus(1);
//        toDoList.displayItemById(1);

//        Remove Item By Given Id
//        toDoList.removeItemById(2);
//        toDoList.displayToDoList();

//        Clear To Do List
//        toDoList.clearItemList();
//        toDoList.displayToDoList();
    }
}
