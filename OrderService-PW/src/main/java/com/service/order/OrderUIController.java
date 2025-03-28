package com.service.order;


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
    public String showOrderForm() {
        return "order";
    }

    @PostMapping("/submitOrder")
    public String submitOrder(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String typeOfUser,
            @RequestParam String userId,
            @RequestParam String stockName,
            @RequestParam int quantity,
            @RequestParam double price,
            Model model) {

        // Create User object with form data
        User user = new User();
        user.setId(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setTypeOfUser(typeOfUser);

        // Create Order object with form data
        Order order = new Order(null, userId, stockName, quantity, price, "PLACED", user);

        // Save Order using Order Service
        orderService.placeOrder(order).subscribe();

        // Add confirmation message to the model
        model.addAttribute("message", "Order placed successfully by user: " + username);
        return "orderSuccess";
    }
}
