package com.guilherme.desafio.services;

import com.guilherme.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        Double disc = order.getDiscount() / 100;
        return order.getBasic() - (order.getBasic() * disc) + shippingService.shipment(order);
    }

}