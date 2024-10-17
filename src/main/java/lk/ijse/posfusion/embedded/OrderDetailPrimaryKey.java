package lk.ijse.posfusion.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class OrderDetailPrimaryKey implements Serializable {
    @Column(name = "orderId")
    private String orderId;
    @Column(name = "itemId")
    private String itemId;
}
