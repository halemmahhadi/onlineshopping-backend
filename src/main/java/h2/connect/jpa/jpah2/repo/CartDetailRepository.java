package h2.connect.jpa.jpah2.repo;

import h2.connect.jpa.jpah2.model.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetails,Long> {
}
