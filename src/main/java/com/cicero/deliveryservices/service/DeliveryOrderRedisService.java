package com.cicero.deliveryservices.service;

import java.util.List;

import com.cicero.deliveryservices.form.DeliveryOrderForm;

/**
 * Contrato de servico para operacoe no Redis
 * @author cicero
 *
 */
public interface DeliveryOrderRedisService {
    /**
     * Retorna todas as ordem de entrega.
     * @return <code>List<DeliveryOrderForm></code> uma lista com as ordens de entrega.
     */
    List<DeliveryOrderForm> findAll();

    /**
     * Busca uma ordem de entrega pelo identificador.
     * @param orderId identificador da ordem de entrega.
     * @return {@link DeliveryOrderForm} uma ordem de entrega.
     */
    DeliveryOrderForm findOne(String orderId);

    /**
     * Salva uma ordem de entrega.
     * @param deliveryOrderForm ordem de entrega a ser salva.
     */
    void save(DeliveryOrderForm deliveryOrderForm);

}
