package com.vcs.project.ToDoApp.controllers;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.services.IToDoListCustomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/list/menu/custom")
public class CustomUserController {

    private final static Logger LOG = LoggerFactory.getLogger(BasicUserController.class);

    @Autowired
    private IToDoListCustomService customService;

    @GetMapping("/search/hashtag/{hashTag}")
    public List<Item> searchByHashTag(@PathVariable("hashTag") String hashTag) {
        LOG.info("Started Searching by HashTag");
        List<Item> itemList = customService.findByHashTag(hashTag);
        LOG.info("Found: {}", itemList.size());
        return itemList;
    }

    @GetMapping("/sort/asc")
    public List<Item> sortListAsc() {
        LOG.info("Started Sorting ToDo List");
        List<Item> itemList = customService.sortListById(true);
        return itemList;
    }

    @GetMapping("/sort/desc")
    public List<Item> sortListDesc() {
        LOG.info("Started Sorting ToDo List");
        List<Item> itemList = customService.sortListById(false);
        return itemList;
    }

    @GetMapping("/sort/priority/asc")
    public List<Item> sortListByPriorityAsc() {
        LOG.info("Started Sorting ToDo List By Priority");
        List<Item> itemList = customService.sortListByItemPriority(true);
        return itemList;
    }

    @GetMapping("/sort/priority/desc")
    public List<Item> sortListByPriorityDesc() {
        LOG.info("Started Sorting ToDo List By Priority");
        List<Item> itemList = customService.sortListByItemPriority(false);
        return itemList;
    }

    @PutMapping("/update/item")
    public Item updateItem(@RequestBody Item item) {
        LOG.info("Started Updating Item");
        Item updateItem = customService.update(item);
        LOG.info("Item Updated. ID: {}", updateItem.getId());
        return updateItem;
    }

    @DeleteMapping("/clean/completed")
    public ResponseEntity<Void> cleanCompleted() {
        LOG.info("Started Cleaning: ONLY COMPLETED");
        customService.cleanItemList(true, false);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/clean/all")
    public ResponseEntity<Void> cleanAllItemList() {
        LOG.info("Started Cleaning: ALL ITEM LIST");
        customService.cleanItemList(true, true);
        return ResponseEntity.ok().build();
    }

}
