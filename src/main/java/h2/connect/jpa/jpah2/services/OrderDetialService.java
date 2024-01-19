package h2.connect.jpa.jpah2.services;
import h2.connect.jpa.jpah2.exception.OrderDetailNotFoundException;
import h2.connect.jpa.jpah2.model.OrderDetail;
import h2.connect.jpa.jpah2.repo.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderDetialService {
    private final OrderDetailRepository orderDetailRepository;

    @Autowired

    public OrderDetialService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public OrderDetail addOrderDetail(OrderDetail orderDetail) {

        return orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetail> getOrderDetails() {
        return StreamSupport
                .stream(orderDetailRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public OrderDetail getOrderDetailById(long id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(() ->
                        new OrderDetailNotFoundException(id));
    }

    public OrderDetail deleteOrderDetail(long id) {
        OrderDetail orderDetail = getOrderDetailById(id);
        orderDetailRepository.delete(orderDetail);
        return orderDetail;

    }

    @Transactional
    public OrderDetail editOrderDetail(long id, OrderDetail orderDetail) {
        OrderDetail orderDetailToEdit = getOrderDetailById(id);
        orderDetailToEdit.setPrice(orderDetail.getPrice());
        orderDetailToEdit.setCDquantity(orderDetail.getCDquantity());
        return orderDetailToEdit;


    }
}
