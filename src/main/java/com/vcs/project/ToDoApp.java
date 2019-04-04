package com.vcs.project;

import com.vcs.project.entities.Item;
import com.vcs.project.entities.enums.ItemPriority;
import com.vcs.project.service.ItemListDao;
import com.vcs.project.service.ItemListService;

import java.time.LocalDate;

public class ToDoApp {

    public static void main(String[] args) {

        LocalDate submittedDate = LocalDate.now();

        ItemListDao dao = new ItemListDao();
        ItemListService service = new ItemListService();

        dao.createItem(new Item(1, "Clean stuff", submittedDate.plusDays(7), false, ItemPriority.Medium));
        dao.createItem(new Item(2, "Buy: milk, bread, sugar.", null, false, ItemPriority.Medium));
        dao.createItem(new Item(3, "Call the doctor", submittedDate.plusDays(2), false, ItemPriority.High));
        dao.createItem(new Item(4, "Wash dishes", submittedDate.plusDays(2), false, ItemPriority.Low));

    }
}