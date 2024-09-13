package me.tomas.borquez.section4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Section4Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Section4Application.class, args);
        OrderService orderService = context.getBean(OrderService.class);

        Customer customer1 = createCustomer("John Doe", "john@example.com");
        Customer customer2 = createCustomer("Jane Smith", "jane@example.com");

        customer1 = orderService.saveCustomer(customer1);
        customer2 = orderService.saveCustomer(customer2);

        createOrder(orderService, customer1, 100.0);
        createOrder(orderService, customer1, 150.0);
        createOrder(orderService, customer2, 200.0);

        List<Order> customerOrders = orderService.getOrdersForCustomer(customer1.getId());
        System.out.println("Orders for customer 1: " + customerOrders.size());

        Double totalAmountSpent = orderService.getTotalAmountSpentByCustomer(customer1.getId());
        System.out.println("Total amount spent by customer 1: $" + totalAmountSpent);

        List<Order> customerOrders2 = orderService.getOrdersForCustomer(customer2.getId());
        System.out.println("Orders for customer 2: " + customerOrders2.size());

        Double totalAmountSpent2 = orderService.getTotalAmountSpentByCustomer(customer2.getId());
        System.out.println("Total amount spent by customer 2: $" + totalAmountSpent2);
    }

    private static Customer createCustomer(String name, String email) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        return customer;
    }

    private static void createOrder(OrderService orderService, Customer customer, Double amount) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(new Date());
        order.setTotalAmount(amount);
        orderService.saveOrder(order);
    }
}
