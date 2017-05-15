package com.cicero.deliveryservices.service;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.sender.MessageResponse;

/**
 * Contrato para salvar/atualizar ordem de entregas de forma assincrona.
 * @author cicero
 *
 */
public interface DeliveryOrderServiceAsync {
    /**
     * Cria/Atualiza uma ordem de entrega de forma assincrona
     * @param order uma ordem de servico
     * @return {@link MessageResponse} resposta da requisicao
     */
    MessageResponse createOrUpdateOrder(DeliveryOrderForm order);
}
