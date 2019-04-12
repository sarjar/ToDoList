package com.vcs.project.ToDoApp.services;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.entities.ItemPriority;
import com.vcs.project.ToDoApp.repositories.ItemRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class ToDoListServiceTest {

    @TestConfiguration
    static class ToDoListServiceTestContextConfiguration {

        @Bean
        public IToDoListService toDoListService() { return new ToDoListServiceImpl(); }
    }

    @Autowired
    private IToDoListService toDoListService;

    @MockBean
    private ItemRepository itemRepository;

    @Before
    public void setUp() {
        Item testItemOne = new Item(1L, "Call doctor", ItemPriority.High, "TODAY", false);
        Item testItemTwo = new Item(2L, "Visit Steve", ItemPriority.Low, "WEEKEND", false);
        List<Item> itemList = new ArrayList<>();
        itemList.add(testItemOne);
        itemList.add(testItemTwo);
        Mockito.when(itemRepository.findById(testItemOne.getId())).thenReturn(Optional.of(testItemOne));
        Mockito.when(itemRepository.findById(testItemTwo.getId())).thenReturn(Optional.of(testItemTwo));
//        Mockito.when(toDoListService.getAll()).thenReturn(itemList);
    }

    @Test
    public void updateItemSetCompletedToTrue() {
        Optional<Item> itemOne = itemRepository.findById(1L);
        Assert.assertTrue(itemOne.isPresent());
        itemOne.get().setDescription("Buy Milk");
        itemOne.get().setItemPriority(ItemPriority.Medium);
        itemOne.get().setHashTag(null);
        itemOne.get().setCompleted(true);
        toDoListService.update(itemOne.get());
        Assert.assertEquals("Item was renamed to 'Buy Milk'", itemOne.get().getDescription(), "Buy Milk");
        Assert.assertEquals("Item priority changed to Medium", itemOne.get().getItemPriority(), ItemPriority.Medium);
        Assert.assertEquals("Item hash tag changed to null", itemOne.get().getHashTag(), null);
        Assert.assertEquals("Item status changed to completed: true", itemOne.get().isCompleted(), true);
    }

//    @Test
//    public void cleanCompletedOrAllItems() {
//        Optional<Item> itemOne = itemRepository.findById(1L);
//        Assert.assertEquals(2, toDoListService.getAll().size());
//
//        toDoListService.cleanItemList(true, false);
//        Assert.assertTrue(itemOne.isPresent());
//
//        itemOne.get().setCompleted(true);
//        toDoListService.cleanItemList(true, false);
//        Assert.assertFalse(itemOne.isPresent());
//    }



}
