package learn.spring.curd.Controller;

import learn.spring.curd.DTO.Customer.CustomerDTO;
import learn.spring.curd.Entity.CustomerEntity;
import learn.spring.curd.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // TEST
    @GetMapping
    public String test(){
        return "API IS WORKING 👍";
    }
    // Create
    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO en){
        CustomerDTO customer = customerService.createCustomer(en);
        return new ResponseEntity<>(customer, HttpStatusCode.valueOf(200));
    }

    // Read All
    @GetMapping("/all")
    public List<CustomerEntity> getCustomer(){
        return customerService.getAllCustomer();
    }

    // Read By ID
    @GetMapping("/user/{id}")
    public CustomerEntity getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    // Update
    @PutMapping("/update/{id}")
    public CustomerEntity updateCustomer(@PathVariable Long id,@RequestBody CustomerEntity en){
        return customerService.updateCustomer(id, en);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public CustomerEntity deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
