package learn.spring.curd.Controller;

import learn.spring.curd.Entity.ProductEntity;
import learn.spring.curd.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping("/listall")
    public List<ProductEntity> listAll(){
        return service.listAll();
    }

    @PostMapping("/add")
    public ProductEntity saveProduct(@RequestBody ProductEntity en){
        return service.saveProduct(en);
    }
}
