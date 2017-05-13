package com.cicero.deliveryservices.repository;

import org.springframework.data.repository.CrudRepository;

import com.cicero.deliveryservices.domain.DeliveryOrder;

public interface DeliveryOrderRepository extends CrudRepository<DeliveryOrder, Long> {

}
