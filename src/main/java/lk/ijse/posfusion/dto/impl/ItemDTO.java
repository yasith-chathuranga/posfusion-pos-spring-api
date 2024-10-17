package lk.ijse.posfusion.dto.impl;

import jakarta.validation.constraints.*;
import lk.ijse.posfusion.customObj.ItemResponse;
import lk.ijse.posfusion.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemResponse {
    @NotBlank(message = "Item ID cannot be blank")
    @Size(min = 1, max = 20, message = "Item ID must be between 1 and 20 characters")
    private String id;
    @NotBlank(message = "Item name cannot be blank")
    @Size(min = 2, max = 100, message = "Item name must be between 2 and 100 characters")
    private String name;
    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be less than 0")
    private int qty;
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private double price;
}
