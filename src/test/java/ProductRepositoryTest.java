import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.security.sasl.AuthorizeCallback;

public class ProductRepositoryTest {

    Product book1 = new Book(1, "Букварь", 100, "Автор1");
    Product book2 = new Book(2, "Гарри Поттер", 500, "Автор2");
    Product book3 = new Book(3, "Азбука", 200, "Автор3");
    Product smartphone4 = new Smartphone(4, "Smartphone4", 20000, "Производитель1");
    Product smartphone5 = new Smartphone(5, "Smartphone5", 25000, "Производитель2");
    Product smartphone6 = new Smartphone(6, "Smartphone6", 30000, "Производитель3");

    @Test

    public void testNullBook() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void removeById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone4);
        repo.save(smartphone5);
        repo.save(smartphone6);
        repo.removeById(book2.getId());

        Product[] expected = {book1, book3, smartphone4, smartphone5, smartphone6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddProductsFindAll() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone4);
        repo.save(smartphone5);
        repo.save(smartphone6);
        repo.removeById(smartphone4.getId());

        Product[] expected = {book1, book2, book3, smartphone5, smartphone6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void Max() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone4);
        repo.save(smartphone5);
        repo.save(smartphone6);
        repo.removeById(book1.getId());
        repo.removeById(book2.getId());
        repo.removeById(book3.getId());
        repo.removeById(smartphone4.getId());
        repo.removeById(smartphone5.getId());
        repo.removeById(smartphone6.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone4);
        repo.save(smartphone5);
        repo.save(smartphone6);

        Product[] expected = {book1, book2, book3, smartphone4, smartphone5, smartphone6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNullFindAll() {
        ProductRepository repo = new ProductRepository();
        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
