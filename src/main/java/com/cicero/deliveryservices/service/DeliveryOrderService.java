package com.cicero.deliveryservices.service;

import java.util.List;
import java.util.UUID;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.form.DeliveryOrderForm;

/**
 * Contrato para {@link DeliveryOrder}
 * @author cicero
 *
 */
public interface DeliveryOrderService {
    /**
     * Busca uma ordem de entrega pelo identificador
     * @param order identificador da ordem
     * @return {@link DeliveryOrderForm} ordem de entrega
     */
    DeliveryOrderForm findOrder(UUID order);

    /**
     * Busca todas ordem de entega
     * @return <code> List<DeliveryOrderForm></code> lista de ordem de entrega
     */
    List<DeliveryOrderForm> findAll();

    /**
     * Cria/atualiza uma ordem de entrega
     * @param order uma ordem de entrega
     * @return {@link DeliveryOrderForm} uma ordem de entrega
     */
    DeliveryOrderForm createOrUpdateOrder(DeliveryOrder order);
}
