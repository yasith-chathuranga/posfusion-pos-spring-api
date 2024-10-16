package lk.ijse.posfusion.dto.impl;

import lk.ijse.posfusion.customObj.ItemResponse;
import lk.ijse.posfusion.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemResponse {
    private String id;
    private String name;
    private int qty;
    private double price;
}
