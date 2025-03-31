package learn.spring.curd.Service;

import learn.spring.curd.Entity.ProductEntity;
import learn.spring.curd.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<ProductEntity> listAll(){
        return repo.findAll();
    }

    public ProductEntity saveProduct(ProductEntity en) {
        return repo.save(en);
    }
}
