package com.cicero.deliveryservices;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.rmi.server.UID;
import java.util.UUID;

import org.apache.tomcat.util.buf.UDecoder;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.service.DeliveryOrderCacheService;
import com.cicero.deliveryservices.service.DeliveryOrderService;
import com.cicero.deliveryservices.util.OrderServiceConverter;

/**
 * Testes unitarios
 * 
 * @author cicero
 *
 */
@RunWith(SpringRunner.class)
public class DeliveryServicesApplicationTests {

    @Mock
    private DeliveryOrderService deliveryOrderService;

    @Mock
    private DeliveryOrderCacheService deliveryOrderCacheService;

    @Test
    public void shouldSaveDeliveryOrder() {

	DeliveryOrder deliveryOrder = new DeliveryOrderBuilder().sampleDeliveryOrderBuilder();

	DeliveryOrderForm deliveryOrderForm = OrderServiceConverter.convertFromDeliveryOrder(deliveryOrder);

	when(this.deliveryOrderService.createOrUpdateOrder(Matchers.any(DeliveryOrder.class)))
		.thenReturn(deliveryOrderForm);

	DeliveryOrderForm deliveryOrderFormActual = this.deliveryOrderService.createOrUpdateOrder(deliveryOrder);

	assertEquals(deliveryOrderForm, deliveryOrderFormActual);

    }

    @Test
    public void shouldFindOneDeliveryCache() {
	DeliveryOrder deliveryOrder = new DeliveryOrderBuilder().sampleDeliveryOrderBuilder();

	DeliveryOrderForm deliveryOrderForm = OrderServiceConverter.convertFromDeliveryOrder(deliveryOrder);
	
	when(this.deliveryOrderCacheService.findOne(Matchers.anyString()))
	.thenReturn(deliveryOrderForm);
	
	DeliveryOrderForm deliveryFormActual = deliveryOrderCacheService.findOne(UUID.randomUUID().toString());
	
	assertEquals(deliveryOrderForm, deliveryFormActual);
	
    }

}
