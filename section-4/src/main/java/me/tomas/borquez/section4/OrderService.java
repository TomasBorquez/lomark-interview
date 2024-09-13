package me.tomas.borquez.section4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrderService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Order> getOrdersForCustomer(Long customerId) {
        String jpql = "SELECT o FROM Order o WHERE o.customer.id = :customerId";
        TypedQuery<Order> query = entityManager.createQuery(jpql, Order.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public Double getTotalAmountSpentByCustomer(Long customerId) {
        String jpql = "SELECT SUM(o.totalAmount) FROM Order o WHERE o.customer.id = :customerId";
        TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
        query.setParameter("customerId", customerId);
        Double result = query.getSingleResult();
        return result != null ? result : 0.0;
    }

    @Transactional
    public Customer saveCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Transactional
    public Order saveOrder(Order order) {
        entityManager.persist(order);
        return order;
    }
}
