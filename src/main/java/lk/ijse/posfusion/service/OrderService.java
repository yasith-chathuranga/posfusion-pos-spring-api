package lk.ijse.posfusion.service;

import lk.ijse.posfusion.dto.impl.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
}
