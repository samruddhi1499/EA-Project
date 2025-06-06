package com.example.demo;

import com.example.demo.Order;
import com.example.demo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.OrderService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderUIController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/form")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("user", new User());
        return "order"; 
    }

    @GetMapping("/list")
    public String listOrders(Model model) {
       
        List<Order> orders = orderService.getAllOrders().collectList().block(); 
        model.addAttribute("orders", orders);
        return "orderList";
    }

    
    @PostMapping("/submitOrder")
    public String submitOrder(
    		@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("typeOfUser") String typeOfUser,
            @RequestParam("userId") String userId,
            @RequestParam("stockName") String stockName,
            @RequestParam("quantity") int quantity,
            @RequestParam("price") double price,
            @RequestParam("orderType") String orderType,
            Model model) {

        try {
        	
        	LocalDateTime date = LocalDateTime.now();
           
            User user = new User(userId, username, password, typeOfUser);
            Order order = new Order(null, userId, stockName, quantity, price, "PLACED", orderType, date, user);

         
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            mapper.disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            File file = new File("target/order.json");
            mapper.writeValue(file, order);

            
            orderService.placeOrder(order).subscribe();

            model.addAttribute("message", "Order placed successfully by user: " + username);
            return "orderSuccess";

        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while placing the order: " + e.getMessage());
            return "error"; 
        }
    }


    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
        return "error"; 
    }
}
