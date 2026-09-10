package com.example.ecomorderservice.Controller;

import com.example.ecomorderservice.Service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class Ordercontroller {

    private final OrderService service;

    public Ordercontroller(OrderService service) {
        this.service = service;
    }


    @PostMapping("/{product_id}")
    public String placeOrder(@PathVariable long product_id) {
        return service.placeOrder(product_id);
    }
}
