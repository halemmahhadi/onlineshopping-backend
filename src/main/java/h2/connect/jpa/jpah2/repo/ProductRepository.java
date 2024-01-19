package h2.connect.jpa.jpah2.repo;

import h2.connect.jpa.jpah2.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {
}
