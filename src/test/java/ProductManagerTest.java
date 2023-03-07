import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductManagerTest {

    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    private Product book1 = new Book(1, "Bukvar", 100, "People");
    private Product book2 = new Book(2, "Harry Potter", 500, "Rowling");
    private Product book3 = new Book(3, "Azbuka", 200, "People");
    private Product smartphone1 = new Smartphone(4, "Nokia 5", 20000, "China");
    private Product smartphone2 = new Smartphone(5, "Honor 5", 25000, "China");
    private Product smartphone3 = new Smartphone(6, "Iphone 13 Pro", 30000, "USA");

    @BeforeEach

    public void SetUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test

    public void shouldAddProductGetItems() {
        Product[] actual = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] expected = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchBySmartphoneName() {
        Product[] actual = manager.searchBy("Nokia 5");
        Product[] expected = new Product[]{smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = new Product[]{book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByNoSmartphoneName() {
        Product[] actual = manager.searchBy("Smartphone 7");
        Product[] expected = new Product[0];

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNoBookName() {
        Product[] actual = manager.searchBy("Унесенные Ветром");
        Product[] expected = new Product[0];

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTwoParametersInBook() {
        Product[] actual = manager.searchBy("Harry Potter");
        Product[] actual2 = manager.searchBy("Rowling");
        Product[] expected = new Product[]{book2};
        Assertions.assertArrayEquals(expected, actual, Arrays.toString(actual2));
    }

    @Test
    public void searchByTwoParametersInSmartphone() {
        Product[] actual = manager.searchBy("Iphone 13 Pro");
        Product[] actual2 = manager.searchBy("USA");
        Product[] expected = new Product[]{smartphone3};

        Assertions.assertArrayEquals(expected, actual, Arrays.toString(actual2));
    }

    @Test

    public void shouldSearchByProduct() {
        Product[] actual = manager.searchBy("Bukvar");
        Product[] expected = new Product[]{book1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchBy() {
        Product[] actual = manager.searchBy("Bukvar");
        Product[] actual2 = manager.searchBy("Iphone 13 Pro");
        Product[] expected = new Product[]{book1};

        Assertions.assertArrayEquals(expected, actual, Arrays.toString(actual2));
    }

    @Test

    public void shouldSearchByProductTo() {

        Product[] actual = manager.searchBy("14 Max");
        Product[] expected = new Product[]{};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchTwoSmartphones() {

        Product[] expected = new Product[]{smartphone1, smartphone2};
        Product[] actual = manager.searchBy("5");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByBookNameOne() {

        Product[] actual = manager.searchBy("Harry");
        Product[] expected = new Product[]{book2};
        Assertions.assertArrayEquals(expected, actual);
    }

}

