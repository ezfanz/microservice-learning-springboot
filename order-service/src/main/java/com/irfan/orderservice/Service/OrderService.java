package com.irfan.orderservice.Service;

import java.util.List;
import java.util.UUID;

import com.irfan.orderservice.Repository.OrderRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.irfan.orderservice.Dto.OrderLineItemsDto;
import com.irfan.orderservice.Dto.OrderRequest;
import com.irfan.orderservice.Model.Order;
import com.irfan.orderservice.Model.OrderLineItems;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        log.info("Retrieved orders list:");
        for (Order order : orders) {
            log.info("Order Number: {}", order.getOrderNumber());
        }

        return orders;
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;

    }

}
