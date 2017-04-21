package com.herokuapp.todomvc;

import com.herokuapp.todomvc.categories.All;
import com.herokuapp.todomvc.features.TodosE2E;
import com.herokuapp.todomvc.features.TodosOperationsAtAllFilter;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.experimental.categories.Categories.*;
import static org.junit.runners.Suite.*;

/**
 * Created by inna on 4/21/17.
 */

@RunWith(Categories.class)
@IncludeCategory(All.class)
@SuiteClasses({TodosE2E.class, TodosOperationsAtAllFilter.class})
public class AllSuiteTest {
}
