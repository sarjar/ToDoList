package com.vcs.project.ToDoApp.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.vcs.project.ToDoApp.entities.Item;
import com.vcs.project.ToDoApp.entities.ItemPriority;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Item testItemOne = null;
    private Item testItemTwo = null;
    private Item testItemThree = null;

    @Before
    public void init() {

        entityManager.clear();
        itemRepository.deleteAll();

        testItemOne = entityManager.persist(new Item(null, "Clean room", ItemPriority.Medium, null, false));
        entityManager.flush();

        testItemTwo = entityManager.persist(new Item(null, "Wash car", ItemPriority.Low, "WEEKEND", false));
        entityManager.flush();

        testItemThree = entityManager.persist(new Item(null, "Buy soap", ItemPriority.High, " SHOP ", false));
        entityManager.flush();

    }

    @Test
    public void searchByHashTagTest() {
        List<Item> resultSearchByHashTag = itemRepository.findByHashTagContainingIgnoreCase("shop");

        assertEquals(1, resultSearchByHashTag.size());
        assertTrue("Value Matches", resultSearchByHashTag.contains(testItemThree));
    }

    @Test
    public void sortListByIdAsc() {
        List<Item> resultById = itemRepository.orderByIdAsc();

        assertTrue(resultById.contains(testItemOne));
//        assertTrue(resultById.contains(testItemTwo.equals(testItemTwo)));
//        assertTrue(resultById.contains(testItemThree.equals(testItemThree)));

//        assertEquals(resultById.get(0).getId(), testItemOne.getId());
//        assertEquals(resultById.get(1).getId(), testItemTwo.getId());
//        assertEquals(resultById.get(2).getId(), testItemThree.getId());
    }

    @Test
    public void sortListByIdDesc() {
        List<Item> resultById = itemRepository.orderByIdDesc();

        assertEquals(resultById.get(0).getId(), testItemThree.getId());
        assertEquals(resultById.get(1).getId(), testItemTwo.getId());
        assertEquals(resultById.get(2).getId(),testItemOne.getId());
    }

    @Test
    public void sortListByPriority() {
        List<Item> resultByPriority = itemRepository.orderByItemPriorityAsc();

        assertEquals(ItemPriority.High, resultByPriority.get(0).getItemPriority());
        assertEquals(ItemPriority.Medium, resultByPriority.get(1).getItemPriority());
        assertEquals(ItemPriority.Low, resultByPriority.get(2).getItemPriority());

        resultByPriority = itemRepository.orderByItemPriorityDesc();

        assertEquals(ItemPriority.Low, resultByPriority.get(0).getItemPriority());
        assertEquals(ItemPriority.Medium, resultByPriority.get(1).getItemPriority());
        assertEquals(ItemPriority.High, resultByPriority.get(2).getItemPriority());
    }
}
