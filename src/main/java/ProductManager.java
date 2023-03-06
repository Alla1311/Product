public class ProductManager {

    protected ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }
    public void add(Product items) {
        repository.save(items);

    }
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return (product.matches(search));
    }
}
