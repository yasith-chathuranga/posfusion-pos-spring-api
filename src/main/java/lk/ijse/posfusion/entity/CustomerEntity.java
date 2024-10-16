package lk.ijse.posfusion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "customer")
@Entity
public class CustomerEntity implements SuperEntity{
    @Id
    @Column(unique = true, nullable = false)
    private String id;
    @Column(nullable = false, length = 40)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private double salary;
}
