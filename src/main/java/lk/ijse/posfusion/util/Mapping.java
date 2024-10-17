package lk.ijse.posfusion.util;

import lk.ijse.posfusion.dto.impl.CustomerDTO;
import lk.ijse.posfusion.dto.impl.ItemDTO;
import lk.ijse.posfusion.dto.impl.OrderDTO;
import lk.ijse.posfusion.dto.impl.OrderDetailDTO;
import lk.ijse.posfusion.entity.impl.CustomerEntity;
import lk.ijse.posfusion.entity.impl.ItemEntity;
import lk.ijse.posfusion.entity.impl.OrderDetailsEntity;
import lk.ijse.posfusion.entity.impl.OrderEntity;
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

    //Order matters mapping
    public OrderEntity convertToOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    public List<OrderDTO> convertToOrderDTO(List<OrderEntity> orderEntityList) {return modelMapper.map(orderEntityList, new TypeToken<List<OrderDTO>>() {}.getType());}

    public List<OrderDTO> convertOrderToDTOList(List<OrderEntity> orderEntities) {
        return modelMapper.map(orderEntities, new TypeToken<List<ItemDTO>>() {
        }.getType());
    }

    //matters of OrderDetailEntity and DTO
    public OrderDetailsEntity convertToOrderDetailEntity(OrderDetailDTO orderDetailDTO) {return modelMapper.map(orderDetailDTO, OrderDetailsEntity.class);}
}
