package com.cicero.deliveryservices.service;

import java.util.List;

import com.cicero.deliveryservices.form.DeliveryOrderForm;

/**
 * Contrato para servico de ordem de entrega
 * @author cicero
 *
 */
public interface DeliveryService {
    /**
     * Busca todas ordem de entega
     * @return <code> List<DeliveryOrderForm></code> lista de ordem de entrega
     */
    List<DeliveryOrderForm> findAll();

    /**
     * Busca uma ordem de entrega pelo identificador
     * @param orderId identificador da ordem
     * @return {@link DeliveryOrderForm} ordem de entrega
     */
    DeliveryOrderForm findOne(String orderId);
}
