package com.cfrs.shop.service.impl;

import com.cfrs.shop.domain.Order;
import com.cfrs.shop.domain.OrderItem;
import com.cfrs.shop.dto.sdi.ConfirmOrderItemSdi;
import com.cfrs.shop.dto.sdi.ConfirmOrderSdi;
import com.cfrs.shop.repository.OrderItemRepository;
import com.cfrs.shop.repository.OrderRepository;
import com.cfrs.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public void confirm(ConfirmOrderSdi request) {
        Long totalAmount = request.getProductItems()
                .stream()
                .mapToLong(item -> item.getPrice() * item.getQuantity())
                .sum();

        Order order = Order.builder()
                .userId(request.getUserId())
                .amount(totalAmount)
                .transTime(new Date())
                .status(1)
                .build();
        orderRepository.save(order);

        for (ConfirmOrderItemSdi item : request.getProductItems()) {
            OrderItem orderItem = OrderItem.builder()
                    .productName(item.getProductName())
                    .quantity(item.getQuantity())
                    .price(item.getPrice())
                    .orderId(order.getId())
                    .build();
            orderItemRepository.save(orderItem);
        }
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
