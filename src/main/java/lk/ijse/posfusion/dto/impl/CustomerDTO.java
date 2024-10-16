package lk.ijse.posfusion.dto.impl;

import lk.ijse.posfusion.customObj.CustomerResponse;
import lk.ijse.posfusion.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO implements SuperDTO, CustomerResponse {
    private String id;
    private String name;
    private String address;
    private double salary;
}