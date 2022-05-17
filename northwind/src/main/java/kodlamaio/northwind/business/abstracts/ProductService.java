package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
}
