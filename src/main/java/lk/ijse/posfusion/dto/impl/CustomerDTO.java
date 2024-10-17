package lk.ijse.posfusion.dto.impl;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lk.ijse.posfusion.customObj.CustomerResponse;
import lk.ijse.posfusion.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO implements SuperDTO, CustomerResponse {
    @NotBlank(message = "Customer ID cannot be blank")
    @Size(min = 1, max = 20, message = "Customer ID must be between 1 and 20 characters")
    private String id;
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    @NotBlank(message = "Address cannot be blank")
    @Size(min = 3, max = 100, message = "Address must be between 3 and 100 characters")
    private String address;
    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    private double salary;
}