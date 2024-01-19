package h2.connect.jpa.jpah2.repo;

import h2.connect.jpa.jpah2.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
