package com.vcs.project.ToDoApp.controllers;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.services.IToDoListBasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/list")
public class BasicUserController {

    private final static Logger LOG = LoggerFactory.getLogger(BasicUserController.class);

    @Autowired
    private IToDoListBasicService basicService;

    @PostMapping("/items")
    public List<Item> getAll() {
        LOG.info("Getting All (Started)");
        List<Item> itemList = basicService.getAll();
        LOG.info("Getting All (Finished) Total Items: {}", itemList.size());
        return itemList;
    }

    @PostMapping("/add/item")
    public Item addItem(@RequestBody Item item) {
        LOG.info("Add Item (Started)");
        Item addedItem = basicService.save(item);
        LOG.info("Item Added (Finished). ID: {}", addedItem.getId());
        return addedItem;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeById(@PathVariable("id") Long id) {
        LOG.info("Item deleting by id: {}", id);
        basicService.delete(id);
        return ResponseEntity.ok().build();
    }

}
