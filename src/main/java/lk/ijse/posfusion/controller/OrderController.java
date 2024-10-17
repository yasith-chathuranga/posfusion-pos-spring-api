package lk.ijse.posfusion.controller;

import jakarta.validation.Valid;
import lk.ijse.posfusion.dto.impl.OrderDTO;
import lk.ijse.posfusion.exception.DataPersistFailedException;
import lk.ijse.posfusion.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@Valid @RequestBody OrderDTO orderDTO){
        try {
            orderService.saveOrder(orderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/allOrders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){return orderService.getAllOrders();}
}
