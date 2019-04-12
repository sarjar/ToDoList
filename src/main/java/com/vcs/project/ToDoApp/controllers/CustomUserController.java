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

    @GetMapping("/sort/{ascending}")
    public List<Item> sortList(@PathVariable("ascending") boolean ascending) {
        LOG.info("Started Sorting ToDo List");
        List<Item> itemList = customService.sortListById(ascending);
        return itemList;
    }

    @GetMapping("/sort/priority/{ascending}")
    public List<Item> sortListByPriority(@PathVariable("ascending") boolean ascending) {
        LOG.info("Started Sorting ToDo List By Priority");
        List<Item> itemList = customService.sortListByItemPriority(ascending);
        return itemList;
    }

    @PutMapping("/update/item")
    public Item updateItem(@RequestBody Item item) {
        LOG.info("Started Updating Item");
        Item updateItem = customService.update(item);
        LOG.info("Item Updated. ID: {}", updateItem.getId());
        return updateItem;
    }

    @DeleteMapping("/clean/completed/{onlyCompleted}/all/{allList}")
    public ResponseEntity<Void> cleanItemList(@PathVariable("allList") boolean onlyCompleted,
                                              @PathVariable("allList") boolean allList) {
        LOG.info("Started Cleaning: OnlyCo");
        customService.cleanItemList(onlyCompleted, allList);
        return ResponseEntity.ok().build();
    }

}
