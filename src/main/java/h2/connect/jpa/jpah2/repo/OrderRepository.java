package h2.connect.jpa.jpah2.repo;

import h2.connect.jpa.jpah2.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
