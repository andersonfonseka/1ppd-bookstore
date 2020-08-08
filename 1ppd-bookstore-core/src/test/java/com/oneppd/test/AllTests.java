package com.oneppd.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BookServiceTest.class, AbstractRepositoryTest.class,
				AuthorBuilderTest.class, BookBuilderTest.class, BookRepositoryTest.class, 
				ShoppingCartTest.class, ItemTest.class, PriceTest.class, CatalogTest.class,
				CustomerTest.class, OrderTest.class
				})

public class AllTests {

}
