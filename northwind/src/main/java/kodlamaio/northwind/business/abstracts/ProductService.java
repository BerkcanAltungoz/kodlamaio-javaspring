package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    public DataResult<List<Product>> getAll();
    public Result add(Product product);

}
