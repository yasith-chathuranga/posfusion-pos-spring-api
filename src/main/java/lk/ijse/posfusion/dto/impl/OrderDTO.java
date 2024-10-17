package lk.ijse.posfusion.dto.impl;

import jakarta.validation.constraints.*;
import lk.ijse.posfusion.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO implements SuperDTO {
    @NotBlank(message = "Order ID can't be blank")
    private String orderId;
    @NotBlank(message = "Date can't be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in the format YYYY-MM-DD")
    private String date;
    @NotBlank(message = "Customer ID can't be blank")
    private String custId;
    @NotNull(message = "Item list cannot be null")
    private List<ItemDTO> itemDTOList = new ArrayList<>();
    @DecimalMin(value = "0.0", inclusive = true, message = "Total must be non-negative")
    private double total;
    @DecimalMin(value = "0.0", inclusive = true, message = "Discount must be non-negative")
    private String discount;
    @DecimalMin(value = "0.0", inclusive = true, message = "Sub-total must be non-negative")
    private double subTotal;
    @Positive(message = "Cash amount must be greater than 0")
    private double cash;
    @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be non-negative")
    private double balance;
}
