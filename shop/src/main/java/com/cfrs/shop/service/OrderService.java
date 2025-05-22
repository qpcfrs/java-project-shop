package com.cfrs.shop.service;

import com.cfrs.shop.domain.Order;
import com.cfrs.shop.dto.sdi.ConfirmOrderSdi;

import java.util.List;

public interface OrderService {
    void confirm(ConfirmOrderSdi request);
    List<Order> findAll();
}
