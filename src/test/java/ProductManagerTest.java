import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Букварь", 100, "Автор1");
    Product book2 = new Book(2, "Гарри Поттер", 500, "Автор2");
    Product book3 = new Book(3, "Азбука", 200, "Автор3");
    Product smartphone4 = new Smartphone(4, "Smartphone4", 20000, "Производитель1");
    Product smartphone5 = new Smartphone(5, "Smartphone5", 25000, "Производитель2");
    Product smartphone6 = new Smartphone(6, "Smartphone6", 30000, "Производитель3");

    @BeforeEach

    public void SetUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        manager.add(smartphone6);
    }

    @Test

    public void shouldAddProductGetItems() {
        Product[] results = new Product[]{book1, book2, book3, smartphone4, smartphone5, smartphone6};
        Product[] expected = repo.findAll();

        Assertions.assertArrayEquals(expected, results);
    }

    @Test

    public void shouldSearchBySmartphoneName() {
        Product[] results = manager.searchBy("Smartphone4");
        Product[] expected = new Product[]{smartphone4};

        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void shouldSearchByBookName() {
        Product[] results = manager.searchBy("Гарри Поттер");
        Product[] expected = new Product[]{book2};

        Assertions.assertArrayEquals(expected, results);
    }

    @Test

    public void shouldSearchByNoSmartphoneName() {
        Product[] results = manager.searchBy("Smartphone7");
        Product[] expected = new Product[0];

        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void shouldSearchByNoBookName() {
        Product[] results = manager.searchBy("Унесенные Ветром");
        Product[] expected = new Product[0];

        Assertions.assertArrayEquals(expected, results);
    }

}
