package learn.spring.curd.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CustomerId;

    private String Name;

    private String Email;

    @DateTimeFormat(pattern = "yyyy-MMM-dd")
    private LocalDate Dob;

    private Integer age;

    @PrePersist
    public void setAge() {
        this.age = LocalDate.now().getYear() - Dob.getYear();
    }
}
