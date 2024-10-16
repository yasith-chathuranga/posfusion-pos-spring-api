package lk.ijse.posfusion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity implements SuperEntity {
    @Id
    @Column(unique = true, nullable = false)
    private String id;
    @Column(nullable = false, length = 40)
    private String name;
    @Column(nullable = false)
    private int qty;
    @Column(nullable = false)
    private double price;
}
