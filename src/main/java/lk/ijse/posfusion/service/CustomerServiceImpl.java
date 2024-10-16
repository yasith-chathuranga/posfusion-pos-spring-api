package lk.ijse.posfusion.service;

import lk.ijse.posfusion.customObj.CustomerErrorResponse;
import lk.ijse.posfusion.customObj.CustomerResponse;
import lk.ijse.posfusion.dao.CustomerDao;
import lk.ijse.posfusion.dto.impl.CustomerDTO;
import lk.ijse.posfusion.entity.CustomerEntity;
import lk.ijse.posfusion.exception.CustomerNotFoundException;
import lk.ijse.posfusion.exception.DataPersistFailedException;
import lk.ijse.posfusion.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity savedCustomer = customerDao.save(mapping.convertToCustomerEntity(customerDTO));
        if(savedCustomer == null) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public void updateCustomer(String id, CustomerDTO incomeCustomerDTO) {
        Optional<CustomerEntity> tmpCustomerEntity = customerDao.findById(id);
        if (!tmpCustomerEntity.isPresent()){
            throw new CustomerNotFoundException("Customer not found");
        }else {
            tmpCustomerEntity.get().setName(incomeCustomerDTO.getName());
            tmpCustomerEntity.get().setAddress(incomeCustomerDTO.getAddress());
            tmpCustomerEntity.get().setSalary(incomeCustomerDTO.getSalary());
        }
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<CustomerEntity> findId = customerDao.findById(id);
        if (!findId.isPresent()){
            throw new CustomerNotFoundException("Customer not found");
        }else {
            customerDao.deleteById(id);
        }
    }

    @Override
    public CustomerResponse getSelectedCustomer(String id) {
        if (customerDao.existsById(id)){
            return mapping.convertToCustomerDTO(customerDao.getReferenceById(id));
        }else {
            return new CustomerErrorResponse(0,"Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.convertCustomerToDTOList(customerDao.findAll());
    }
}
