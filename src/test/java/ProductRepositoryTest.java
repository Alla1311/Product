import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.security.sasl.AuthorizeCallback;

public class ProductRepositoryTest {

    private Product book1 = new Book(1, "Bukvar", 100, "People");
    private Product book2 = new Book(2, "Harry Potter", 500, "Rowling");
    private Product book3 = new Book(3, "Azbuka", 200, "People");
    private Product smartphone4 = new Smartphone(4, "Nokia 4", 20000, "Finland");
    private Product smartphone5 = new Smartphone(5, "Nokia 5", 25000, "Finland");
    private Product smartphone6 = new Smartphone(6, "Iphone 13 Pro", 30000, "USA");

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
