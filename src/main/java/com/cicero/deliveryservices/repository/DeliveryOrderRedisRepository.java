package com.cicero.deliveryservices.repository;

import java.util.Map;

import com.cicero.deliveryservices.form.DeliveryOrderForm;

/**
 * Contrato para operacoes no Redis.
 * 
 * @author cicero
 *
 */
public interface DeliveryOrderRedisRepository {
    /**
     * Salva/Atualiza uma nova ordem de entrega.
     * 
     * @param deliveryOrderForm
     *            uma ordem de entrega.
     */
    void save(DeliveryOrderForm deliveryOrderForm);

    /**
     * Retorna todas as entregas
     * 
     * @return <code>Map<String, DeliveryOrderForm></code> um mapa chave/valor
     *         de ordem de entrega
     */
    Map<String, DeliveryOrderForm> findAll();

    /**
     * Retorna uma ordem de entrega pelo seu identificador.
     * @param orderId identificador da ordem de servico.
     * @return {@linkDeliveryOrderForm} uma ordem de entrega.
     */
    DeliveryOrderForm findOne(String orderId);
}
