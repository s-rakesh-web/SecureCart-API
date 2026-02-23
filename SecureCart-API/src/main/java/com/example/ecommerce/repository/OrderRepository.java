package com.example.ecommerce.repository;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);

    @Query("select coalesce(sum(o.totalAmount),0) from Order o")
    Double getTotalRevenue();

    @Query("select oi.product.name from OrderItem oi group by oi.product.name order by sum(oi.quantity) desc")
    List<String> findTopProductNames();

    @Query("select count(o) from Order o")
    Long getTotalOrdersCount();

    default Optional<String> findTopProductName() {
        List<String> names = findTopProductNames();
        return names.isEmpty() ? Optional.empty() : Optional.of(names.get(0));
    }
}
