package lk.ijse.posfusion.service;

import lk.ijse.posfusion.customObj.CustomerResponse;
import lk.ijse.posfusion.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String id, CustomerDTO customerDTO);
    void deleteCustomer(String id);
    CustomerResponse getSelectedCustomer(String id);
    List<CustomerDTO> getAllCustomers();
}
