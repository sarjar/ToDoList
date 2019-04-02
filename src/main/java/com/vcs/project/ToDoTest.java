package com.vcs.project;

import com.vcs.project.entities.ItemPriority;
import com.vcs.project.service.ItemListItemListService;

import java.time.LocalDate;

public class ToDoTest {

    public void controller() {

        LocalDate submittedDate = LocalDate.now();

        ItemListItemListService toDoList = new ItemListItemListService();

        toDoList.addItem(1, "Clean stuff", submittedDate.plusDays(7), false, ItemPriority.Medium);
        toDoList.addItem(2, "Buy: milk, bread, sugar.", null,false, ItemPriority.Medium);
        toDoList.addItem(3, "Call the doctor", submittedDate.plusDays(2), false, ItemPriority.High);
        toDoList.addItem(4, "Wash dishes", submittedDate.plusDays(2), false, ItemPriority.Low);


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
