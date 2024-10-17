package lk.ijse.posfusion.service.impl;

import lk.ijse.posfusion.entity.impl.CustomerEntity;
import lk.ijse.posfusion.exception.ItemNotFoundException;
import lk.ijse.posfusion.repository.CustomerRepository;
import lk.ijse.posfusion.repository.ItemRepository;
import lk.ijse.posfusion.repository.OrderRepository;
import lk.ijse.posfusion.repository.OrderDetailRepository;
import lk.ijse.posfusion.dto.impl.ItemDTO;
import lk.ijse.posfusion.dto.impl.OrderDTO;
import lk.ijse.posfusion.dto.impl.OrderDetailDTO;
import lk.ijse.posfusion.embedded.OrderDetailPrimaryKey;
import lk.ijse.posfusion.entity.impl.ItemEntity;
import lk.ijse.posfusion.entity.impl.OrderDetailsEntity;
import lk.ijse.posfusion.entity.impl.OrderEntity;
import lk.ijse.posfusion.exception.DataPersistFailedException;
import lk.ijse.posfusion.service.OrderService;
import lk.ijse.posfusion.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private Mapping mapping;
    @Override
    @Transactional
    public void saveOrder(OrderDTO orderDTO) {
        // Ensure custId is present in OrderDTO
        if (orderDTO.getCustId() == null || orderDTO.getCustId().isBlank()) {
            throw new IllegalArgumentException("Customer ID cannot be null or blank");
        }

        // Fetch the CustomerEntity using the custId
        Optional<CustomerEntity> customerEntityOpt = customerRepository.findById(orderDTO.getCustId());
        if (!customerEntityOpt.isPresent()) {
            throw new IllegalArgumentException("Customer with ID " + orderDTO.getCustId() + " not found");
        }
        CustomerEntity customerEntity = customerEntityOpt.get();

        // Convert OrderDTO to OrderEntity
        OrderEntity orderEntity = mapping.convertToOrderEntity(orderDTO);

        // Set the CustomerEntity in OrderEntity
        orderEntity.setCustomer(customerEntity); // Set the CustomerEntity, not the ID

        // Save the OrderEntity
        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);

        // Check if the order was saved successfully
        if (savedOrderEntity == null || savedOrderEntity.getOrderId() == null) {
            throw new DataPersistFailedException("Cannot save order");
        }

        // Loop through each item in the OrderDTO
        for (ItemDTO itemDTO : orderDTO.getItemDTOList()) {
            Optional<ItemEntity> item = itemRepository.findById(itemDTO.getId());

            // Check if the item exists
            if (!item.isPresent()) {
                throw new ItemNotFoundException("Item with ID " + itemDTO.getId() + " not found");
            }

            // Create OrderDetailDTO and set properties
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setOrderId(savedOrderEntity.getOrderId());  // Use saved order ID
            orderDetailDTO.setQuantity(itemDTO.getQty());
            orderDetailDTO.setPrice(itemDTO.getPrice());
            orderDetailDTO.setItemId(itemDTO.getId());

            // Create primary key for OrderDetailsEntity
            OrderDetailPrimaryKey orderDetailPrimaryKey = new OrderDetailPrimaryKey(savedOrderEntity.getOrderId(), itemDTO.getId());
            OrderDetailsEntity orderDetailsEntity = mapping.convertToOrderDetailEntity(orderDetailDTO);
            orderDetailsEntity.setOrderDetailPrimaryKey(orderDetailPrimaryKey);

            // Save the OrderDetailsEntity
            OrderDetailsEntity savedOrderDetail = orderDetailRepository.save(orderDetailsEntity);
            if (savedOrderDetail == null || savedOrderDetail.getOrder() == null || savedOrderDetail.getOrder().getOrderId() == null) {
                throw new DataPersistFailedException("Cannot save order detail");
            }

            // Update item quantity
            ItemEntity existingItem = item.get();
            existingItem.setQty(existingItem.getQty() - itemDTO.getQty());
            itemRepository.save(existingItem);
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orderDTOList = mapping.convertToOrderDTO(orderRepository.findAll());
        return orderDTOList;
    }
}
