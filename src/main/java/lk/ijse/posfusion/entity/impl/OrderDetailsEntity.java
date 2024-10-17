package lk.ijse.posfusion.entity.impl;

import jakarta.persistence.*;
import lk.ijse.posfusion.embedded.OrderDetailPrimaryKey;
import lk.ijse.posfusion.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_detail")
public class OrderDetailsEntity implements SuperEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable=false, updatable=false)
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId", referencedColumnName = "id", insertable=false, updatable=false)
    private ItemEntity item;

    private int quantity;
    @EmbeddedId
    private OrderDetailPrimaryKey orderDetailPrimaryKey;
}
