package h2.connect.jpa.jpah2.controller;

import h2.connect.jpa.jpah2.model.Orders;
import h2.connect.jpa.jpah2.model.ShoppingCart;
import h2.connect.jpa.jpah2.model.dto.CartDto;
import h2.connect.jpa.jpah2.model.dto.OrderDto;
import h2.connect.jpa.jpah2.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Order")
public class OrderController {



    private final OrderService orderService;
@Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody final OrderDto orderDto) {
        Orders orders = orderService.addOrder(Orders.from(orderDto));
        return new ResponseEntity<>(orderDto.from(orders), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<Orders> orders = orderService.getOrders();
        List<OrderDto> orderDto = orders.stream().map(OrderDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable final long id) {
        Orders orders = orderService.getOrderById(id);
        return new ResponseEntity<>(OrderDto.from(orders), HttpStatus.OK);

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<OrderDto> deleteOrder(@PathVariable final long id) {
        Orders orders = orderService.deleteOrder(id);
        return new ResponseEntity<>(OrderDto.from(orders), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<OrderDto> editOrder(@PathVariable final long id, @RequestBody final OrderDto orderDto) {
        Orders editedorder = orderService.editOrder(id, Orders.from(orderDto));
        return new ResponseEntity<>(OrderDto.from(editedorder), HttpStatus.OK);
    }

    @PostMapping(value = "{order_id)/orderDetail/{orderD_id}/add")
    public ResponseEntity<OrderDto> addOrderDetailToOrder(@PathVariable final long order_id,
                                                       @PathVariable final long orderD_id) {
        Orders orders = orderService.addOrderDetailToOrder(order_id, orderD_id);
        return new ResponseEntity<>(OrderDto.from(orders), HttpStatus.OK);
    }

    @DeleteMapping(value = "{order_id)/orderDetail/{orderD_id}/remove")
    public ResponseEntity<OrderDto> removeOrderDetailToOrder(@PathVariable final long order_id,
                                                            @PathVariable final long orderD_id) {
        Orders orders = orderService.removeOrderDetailToOrder(order_id, orderD_id);
        return new ResponseEntity<>(OrderDto.from(orders), HttpStatus.OK);
    }
}
