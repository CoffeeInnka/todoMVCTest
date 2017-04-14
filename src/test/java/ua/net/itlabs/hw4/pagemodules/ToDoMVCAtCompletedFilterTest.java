package ua.net.itlabs.hw4.pagemodules;

import org.junit.Test;
import ua.net.itlabs.hw2.BaseTest;
import ua.net.itlabs.hw4.pagemodules.pages.ToDoMVC;

import static ua.net.itlabs.hw4.pagemodules.pages.ToDoMVC.*;
import static ua.net.itlabs.hw4.pagemodules.pages.ToDoMVC.TaskStatus.ACTIVE;
import static ua.net.itlabs.hw4.pagemodules.pages.ToDoMVC.TaskStatus.COMPLETED;

/**
 * Created by inna on 4/10/17.
 */
public class ToDoMVCAtCompletedFilterTest extends BaseTest {
    
    @Test
    public void delete() {
        givenAtCompleted(COMPLETED, "1", "2");

        ToDoMVC.delete("1");
        assertTasks("2");
        assertItemsLeft(0);
    }

    @Test
    public void reactivateAll() {
        givenAtCompleted(COMPLETED, "1", "2");

        toggleAll();
        assertNoTasks();
        assertItemsLeft(2);
    }

    @Test
    public void deleteByClearText() {
        givenAtCompleted(COMPLETED, "1", "2");

        edit("2", "");
        assertTasks("1");
        assertItemsLeft(0);
    }

    @Test
    public void switchFilterToActive() {
        givenAtCompleted(aTask(COMPLETED, "1"), aTask(COMPLETED, "2"), aTask(ACTIVE, "3"));

        filterActive();
        assertTasks("3");
        assertItemsLeft(1);
    }
}
