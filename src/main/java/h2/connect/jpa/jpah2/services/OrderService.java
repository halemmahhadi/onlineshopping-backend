package h2.connect.jpa.jpah2.services;

import h2.connect.jpa.jpah2.exception.DetialCartAlreadyAssignmentException;
import h2.connect.jpa.jpah2.exception.DetialOrderAlreadyAssignmentException;
import h2.connect.jpa.jpah2.exception.OrderNotFoundException;
import h2.connect.jpa.jpah2.model.CartDetails;
import h2.connect.jpa.jpah2.model.OrderDetail;
import h2.connect.jpa.jpah2.model.Orders;
import h2.connect.jpa.jpah2.model.ShoppingCart;
import h2.connect.jpa.jpah2.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetialService orderDetialService;
    @Autowired
    public OrderService(OrderRepository orderRepository, OrderDetialService orderDetialService) {
        this.orderRepository = orderRepository;
        this.orderDetialService = orderDetialService;
    }

    public Orders addOrder(Orders orders) {

        return orderRepository.save(orders);
    }



    public List<Orders> getOrders() {
        return StreamSupport
                .stream(orderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Orders getOrderById(long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(id));
    }

    public Orders deleteOrder(long id) {
        Orders orders = getOrderById(id);
        orderRepository.delete(orders);
        return orders;

    }

    @Transactional
    public Orders editOrder(long id, Orders orders) {
        Orders orderToEdit = getOrderById(id);
        orderToEdit.setCreated_date(orders.getCreated_date());
        orderToEdit.setTotal_price(orders.getTotal_price());
        orderToEdit.setTotal_quantity(orders.getTotal_quantity());
        return orderToEdit;


    }
    @Transactional

    public Orders addOrderDetailToOrder(long order_id, long orderD_id) {
        Orders orders = getOrderById(order_id);
        OrderDetail orderDetail = orderDetialService.getOrderDetailById(orderD_id);
        if(Objects.nonNull(orderDetail.getOrders())){
            throw new DetialOrderAlreadyAssignmentException(orderD_id,orderDetail.getOrders().getOrder_id());
        }
        orders.addOrderDetailToOrder(orderDetail);
        return orders;

    }

    @Transactional
    public Orders removeOrderDetailToOrder(long order_id, long orderD_id) {
        Orders orders = getOrderById(order_id);
        OrderDetail orderDetail = orderDetialService.getOrderDetailById(orderD_id);
        if(Objects.nonNull(orderDetail.getOrders())){
            throw new DetialCartAlreadyAssignmentException(orderD_id,orderDetail.getOrders().getOrder_id());
        }
        orders.removeOrderDetailFromOrder(orderDetail);
        return orders;

    }


}
