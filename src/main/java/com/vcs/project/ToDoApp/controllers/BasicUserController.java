package com.vcs.project.ToDoApp.controllers;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.services.IToDoListBasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/list/menu/basic")
public class BasicUserController {

    private final static Logger LOG = LoggerFactory.getLogger(BasicUserController.class);

    @Autowired
    private IToDoListBasicService basicService;

    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable("id") Long id) {
        LOG.info("Started Getting Item by Id");
        Optional<Item> itemOpt = basicService.findById(id);
        return itemOpt.isPresent() ? itemOpt.get() : null;
    }

    @GetMapping("/items")
    public List<Item> getAll() {
        LOG.info("Started Getting All");
        List<Item> itemList = basicService.getAll();
        LOG.info("Total Items: {}", itemList.size());
        return itemList;
    }

    @PostMapping("/add/item")
    public Item addItem(@RequestBody Item item) {
        LOG.info("Started Adding Item");
        Item addedItem = basicService.save(item);
        LOG.info("Item Added. ID: {}", addedItem.getId());
        return addedItem;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeById(@PathVariable("id") Long id) {
        LOG.info("Item's deleting by id: {}", id);
        basicService.delete(id);
        return ResponseEntity.ok().build();
    }

}
