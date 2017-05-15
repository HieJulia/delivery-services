package com.cicero.deliveryservices.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.cicero.deliveryservices.domain.DeliveryOrder;

/**
 * Contrato para salvar as ordem de entrega no banco de dados.
 * @author cicero
 *
 */
public interface DeliveryOrderRepository extends CrudRepository<DeliveryOrder, UUID> {

}
