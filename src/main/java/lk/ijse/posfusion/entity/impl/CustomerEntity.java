package lk.ijse.posfusion.entity.impl;

import jakarta.persistence.*;
import lk.ijse.posfusion.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "customer")
@Entity
public class CustomerEntity implements SuperEntity {
    @Id
    @Column(unique = true, nullable = false)
    private String id;
    @Column(nullable = false, length = 40)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private double salary;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders = new ArrayList<>();
}
