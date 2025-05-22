package com.cfrs.shop.controller;


import com.cfrs.shop.domain.Order;
import com.cfrs.shop.dto.sdi.ConfirmOrderSdi;
import com.cfrs.shop.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping(value = "order")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/confirm")
    public ResponseEntity<?> confirm(@RequestBody ConfirmOrderSdi request) {
        orderService.confirm(request);
        return ResponseEntity.ok(Map.of("message", "Đặt hàng thành công."));
    }

    @GetMapping("/search")
    public List<Order> getAll() {
        return orderService.findAll();
    }
}
