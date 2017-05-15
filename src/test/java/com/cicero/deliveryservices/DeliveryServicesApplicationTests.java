package com.cicero.deliveryservices;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.service.DeliveryOrderRedisService;
import com.cicero.deliveryservices.service.DeliveryOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DeliveryServicesApplication.class)
@Ignore
public class DeliveryServicesApplicationTests {

	@Autowired
	private DeliveryOrderService deliveryOrderService;
	
	@Autowired
	private DeliveryOrderRedisService deliveryOrderRedisService;

	@Test
	public void shouldSaveDeliveryOrder() {

		DeliveryOrder deliveryOrder = new DeliveryOrderBuilder().sampleDeliveryOrderBuilder();

		DeliveryOrderForm deliveryOrderForm = this.deliveryOrderService.createOrUpdateOrder(deliveryOrder);

		assertNotNull(deliveryOrderForm);

	}
	
	@Test
	public void shouldSaveDeliveryRedis() {
		DeliveryOrderForm deliveryForm = deliveryOrderRedisService.findOne("abc");
		System.out.println(deliveryForm);
	}

}
