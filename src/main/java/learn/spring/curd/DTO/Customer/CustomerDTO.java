package learn.spring.curd.DTO.Customer;


import learn.spring.curd.Entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String Name;
    private String Email;
    private LocalDate Dob;

    public CustomerEntity convToEntity(CustomerDTO dto){
        CustomerEntity en = new CustomerEntity();
        en.setName(dto.getName());
        en.setEmail(dto.getEmail());
        en.setDob(dto.getDob());
        return en;
    }

}
