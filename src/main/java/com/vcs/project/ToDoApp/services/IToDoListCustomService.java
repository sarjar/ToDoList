package com.vcs.project.ToDoApp.services;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.entities.ItemPriority;

import java.util.List;
import java.util.Optional;

public interface IToDoListCustomService {

    List<Item> findByHashTag(String hashTag);

    List<Item> sortListById(boolean ascending);

    List<Item> sortListByItemPriority(boolean ascending);

    Item update(Item itemForUpd);

    List<Item> cleanItemList(boolean onlyCompleted, boolean allList);
}
