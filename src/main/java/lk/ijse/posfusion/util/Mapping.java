package lk.ijse.posfusion.util;

import lk.ijse.posfusion.dto.impl.CustomerDTO;
import lk.ijse.posfusion.dto.impl.ItemDTO;
import lk.ijse.posfusion.entity.CustomerEntity;
import lk.ijse.posfusion.entity.ItemEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //Customer matters mapping
    public CustomerEntity convertToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public CustomerDTO convertToCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public List<CustomerDTO> convertCustomerToDTOList(List<CustomerEntity> customerEntities) {
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    //Item matters mapping
    public ItemEntity convertToItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

    public ItemDTO convertToItemDTO(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    public List<ItemDTO> convertItemToDTOList(List<ItemEntity> itemEntities) {
        return modelMapper.map(itemEntities, new TypeToken<List<ItemDTO>>() {
        }.getType());
    }
}
