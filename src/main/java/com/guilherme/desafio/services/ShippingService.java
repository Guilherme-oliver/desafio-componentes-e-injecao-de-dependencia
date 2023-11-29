package com.guilherme.desafio.services;

import com.guilherme.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public Double shipment(Order order) {
        if (order.getBasic() < 100) {
            return 20.0;
        } else if (order.getBasic() >= 100 && order.getBasic() < 200) {
            return 12.0;
        } else if (order.getBasic() >= 200){
            return 0.0;
        } else {
            return Double.valueOf("Invalid");
        }
    }
}