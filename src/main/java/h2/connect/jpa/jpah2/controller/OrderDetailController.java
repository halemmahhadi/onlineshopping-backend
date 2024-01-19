package h2.connect.jpa.jpah2.controller;

import h2.connect.jpa.jpah2.model.OrderDetail;
import h2.connect.jpa.jpah2.model.dto.OrderDetailDto;
import h2.connect.jpa.jpah2.services.OrderDetialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    private final OrderDetialService orderDetialService;

    @Autowired

    public OrderDetailController(OrderDetialService orderDetialService) {
        this.orderDetialService = orderDetialService;
    }

    @PostMapping
    public ResponseEntity<OrderDetailDto> addOrderDetail(@RequestBody final OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = orderDetialService.addOrderDetail(OrderDetail.from(orderDetailDto));
        return new ResponseEntity<>(OrderDetailDto.from(orderDetail), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<OrderDetailDto>> getOrderDetails() {
        List<OrderDetail> orderDetail = orderDetialService.getOrderDetails();
        List<OrderDetailDto> orderDetailDto = orderDetail.stream().map(OrderDetailDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(orderDetailDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OrderDetailDto> getCarDetailtById(@PathVariable final long id) {
        OrderDetail orderDetail = orderDetialService.getOrderDetailById(id);
        return new ResponseEntity<>(OrderDetailDto.from(orderDetail), HttpStatus.OK);

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<OrderDetailDto> deleteOrderDetail(@PathVariable final long id) {
        OrderDetail orderDetail = orderDetialService.deleteOrderDetail(id);
        return new ResponseEntity<>(OrderDetailDto.from(orderDetail ), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<OrderDetailDto> editOrderDetails(@PathVariable final long id, @RequestBody final OrderDetailDto orderDetailDto) {
        OrderDetail editOrderDetail = orderDetialService.editOrderDetail(id, OrderDetail.from(orderDetailDto));
        return new ResponseEntity<>(OrderDetailDto.from(editOrderDetail), HttpStatus.OK);
    }



}
