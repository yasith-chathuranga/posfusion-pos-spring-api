package lk.ijse.posfusion.repository;

import lk.ijse.posfusion.entity.impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
    List<OrderEntity> findAll(); // This should return a List<OrderEntity>
}
