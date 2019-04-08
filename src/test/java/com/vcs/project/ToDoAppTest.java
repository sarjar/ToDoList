package com.vcs.project;

import static org.junit.Assert.assertTrue;

import com.vcs.project.entities.Item;
import com.vcs.project.entities.enums.ItemPriority;
import com.vcs.project.service.ItemListDao;
import com.vcs.project.service.ItemListService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Unit test for simple ToDoApp.
 */
public class ToDoAppTest {

    @Before
    public void init() {
        LocalDate submittedDate = LocalDate.now();

        ItemListDao dao = new ItemListDao();
        ItemListService service = new ItemListService();


        dao.createItem(new Item(1, "Clean stuff", submittedDate.plusDays(7), false, ItemPriority.Medium));
        dao.createItem(new Item(2, "Buy: milk, bread, sugar.", null, false, ItemPriority.Medium));
        dao.createItem(new Item(3, "Call the doctor", submittedDate.plusDays(2), false, ItemPriority.High));
        dao.createItem(new Item(4, "Wash dishes", submittedDate.plusDays(2), false, ItemPriority.Low));

    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
