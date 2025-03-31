package learn.spring.curd.Service;

import learn.spring.curd.DTO.Customer.CustomerDTO;
import learn.spring.curd.Entity.CustomerEntity;
import learn.spring.curd.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    // Field Injection
    @Autowired
    CustomerRepo customerRepo;

    // Create Service
    public CustomerDTO createCustomer(CustomerDTO en){
        CustomerEntity customerEntity = en.convToEntity(en);
        customerRepo.save(customerEntity);
        return en;
    }

    // Read Service [All Data]
    public List<CustomerEntity> getAllCustomer(){
        return customerRepo.findAll();
    }

    // Read Specific Data By ID
    public CustomerEntity getCustomerById(Long Id){
        return customerRepo.findById(Id).orElseThrow(() -> new RuntimeException("Customer Not Found..."));
    }

    // Update
    public CustomerEntity updateCustomer(Long id,CustomerEntity en){
        CustomerEntity data = customerRepo.findById(id).orElseThrow(()->new RuntimeException("Customer Not Found..."));
        if(en.getDob() != null){
            data.setDob(en.getDob());
        }
        if(en.getName() != null){
            data.setName(en.getName());
        }
        if(en.getEmail() != null){
            data.setEmail(en.getEmail());
        }
        return customerRepo.save(data);
    }

    // Delete
    public CustomerEntity deleteCustomer(Long id) {
        CustomerEntity data = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Not a Valid Customer ID"));
        customerRepo.delete(data);
        return data;
    }
}
