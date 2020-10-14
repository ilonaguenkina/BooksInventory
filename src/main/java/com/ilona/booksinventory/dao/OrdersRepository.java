package com.ilona.booksinventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilona.booksinventory.entities.Order;

public interface OrdersRepository extends JpaRepository<Order, Integer> {

}
